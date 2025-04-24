package kr.co.ckrjjang;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface cdn_mapper {
	int cdn_insert(file_DTO dto);
	public List<file_DTO> cdn_select(Map<String, Object> map);
	// cdn에 파라미터값을 대입하여 해당 이미지에 대한 실제 경로를 로드하는 mapper
	public List<file_DTO> cdn_images(String APINO);
	
	// Database 데이터 삭제
	int cdn_delete(String AIDX);
	
	
	// AOP 로그 저장 테이블
	int log_table(String mid);
}
