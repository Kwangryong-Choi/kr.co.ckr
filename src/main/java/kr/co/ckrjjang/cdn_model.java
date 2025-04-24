package kr.co.ckrjjang;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;

@Repository("cdn_model")
public class cdn_model {
	// FTO 정보를 외부에서 수정되지 않도록 설정
	final String user = "testuser";
	final String pass = "a10041004!";
	final int port = 21;
	FTPClient fc = null;
	FTPClientConfig fcc = null;
	
	boolean result = false;	// FTP 전송 결과 true (업로드 정상), false (오류 발생)
	
	@Autowired
	private cdn_service cs;
	
	@Resource(name = "file_DTO")
	file_DTO file_DTO;
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	// paging
	
	// cdn Server로 해당 파일을 전송하는 역할을 담당한 model
	public boolean cdn_ftp(MultipartFile files, String url) throws Exception {
		try {
			String new_file = rename_file(files.getOriginalFilename());
			this.fc = new FTPClient();
			this.fc.setControlEncoding("utf-8");
			this.fcc = new FTPClientConfig();
			
			this.fc.configure(fcc);
			this.fc.connect(url, this.port);	// FTP 연결
			if(this.fc.login(this.user, this.pass)) {	// FTP 로그인
				// BINARY_FILE_TYPE : 이미지, 동영상, PDF, ZIP 등
				// TXT, html : 아스키(소스파일)
				this.fc.setFileType(FTP.BINARY_FILE_TYPE);
				
				// FTP 디렉토리 경로를 설정 후 해당 파일을 Byte로 전송
				this.result = this.fc.storeFile("/ckr/"+new_file, files.getInputStream());
				
				// DB 저장
				this.file_DTO.setFILE_BIN(files.getBytes());
				
				
//				System.out.println(this.file_DTO.getFILE_URL());
				this.file_DTO.setORI_FILE(files.getOriginalFilename());
				this.file_DTO.setNEW_FILE(new_file);
				
				// 202504155.png
				String api_nm[] = new_file.split("[.]");
				this.file_DTO.setAPI_FILE(api_nm[0]);
				
				String api_url = "http://"+url+"/ckr/"+new_file;
				this.file_DTO.setFILE_URL(api_url);
				
				int result = this.cs.cdn_insert(this.file_DTO);
				
				// Database에 insert 부분에 문제가 발생했을 경우, false로 변경하여 Controller로 이관
				if(result == 0) {
					this.result = true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			this.fc.disconnect();
		}
		
		return this.result;
	}
	
	// 실제 파일명을 개발자가 원하는 이름으로 변경하는 메소드
	public String rename_file(String ori_file) {
		// 오늘 날짜 + 시분초
		Date today = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		String day = sf.format(today);
		
		// 숫자 하나를 임의로 셋팅  =>  중복 방지
		int no = (int)Math.ceil(Math.random()*10);
		
		// 파일의 속성명만 출력
		String type = ori_file.substring(ori_file.lastIndexOf("."));
		
		// 개발자가 원하는 파일명으로 변경
		String new_file = day + no + type;
		
		return new_file;
	}
	
	
	// CDN Server에 있는 해당 파일을 삭제하는 역할 model
	public boolean cdn_ftpdel(String newfiles, String idx) throws Exception{
		this.fc = new FTPClient();
		this.fcc = new FTPClientConfig();
		this.fc.configure(this.fcc);
		this.fc.connect("kbsn.or.kr", this.port);
		// deleteFile : FTP에 접속된 서버에서 해당 경로에 있는 파일을 삭제하는 class
		if(this.fc.login(this.user, this.pass)) {
			// FTP 서버에서 파일 삭제
			this.fc.deleteFile("/ckr/"+newfiles);
			if(this.result == true) {	// 정상적으로 FTP 파일을 삭제한 후
				int r = this.cs.cdn_delete(idx);	// 고유값으로 
			}
		}
		return this.result;
	}
}
