package kr.co.ckrjjang;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("file_DTO")
public class file_DTO {
	// Table : API_IMG
	int AIDX;
	String ORI_FILE, NEW_FILE, API_FILE, FILE_URL, FILE_DATE;
	byte[] FILE_BIN;	//BLOB, CLOB  =>  다운로드
	
	// Table : API_IMG View
	String FILE_DOWN;
	int LIST_VIEW;
	
	// 검색관련 get, set
	String word;
	ArrayList<String> alldata;
}
