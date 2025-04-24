package kr.co.ckrjjang.thymeleaf;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import lombok.Data;

// Database와 간가 없이 
@Data
@Repository("all_dto")
public class all_dto {
	ArrayList<String> menus;
	String mid, mpass, memail;
}
