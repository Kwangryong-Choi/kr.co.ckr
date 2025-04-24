package kr.co.ckrjjang.thymeleaf;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


// Thymeleaf + Spring.boot  =>  Model(extends or implements or AOP)
@Controller
public class thymeleaf_controller {
	
	@Resource(name = "all_dto")
	all_dto all_inject;
	
	@GetMapping("/shop.do")
	public String shop() {	// 실제 메인 페이지
		return "/main.html";
	}
	
	// 작업용 파일
	@GetMapping("/indextest.do")
	public String indextest() {
		return "/index.html";
	}
	
	
	/*
	 * 1. 기본 return null 사용 시 => webapp에서 찾음
	 * 2. return "aaa"			=> webapp에서 aaa.jsp 찾음
	 * 3. return "/aaa"			=> templates에서 aaa.jsp 찾음
	 * 4. return "/aaa.html"	=> templates에서 aaa.html 찾음
	 */
	
	@GetMapping("/sample2.do")
	public String sample2(Model m) {
		String menu = "관리자 등록";
		String copy = "Copyright 2025 WEB By Design.";
		m.addAttribute("menu", menu);
		
		return "/subpage.html";
	}
	
	
	// Thymeleaf View에 Model로 생성 후 html에 값을 전달
	@GetMapping("/sample.do")
	public String sample(Model m) {
		String product = "냉장고";
		m.addAttribute("product", product);
		
		return "/sample.html";
	}
	
	
	@GetMapping("/shop_login.do")
	public String shop_login() {
		
		
		return "/login.html";
	}
	
	
	@GetMapping("/thymeleaf.do")
	public String thymelead(Model m, HttpServletRequest req) {
		String code = "관리자 리스트 <br> <b>일반 관리자</b>";
		m.addAttribute("code", code);
		
		// 키 배열
		Map<String, Object> all = new HashMap<>();
		all.put("mid", "hong");
		all.put("mage", 35);
		
		// 검색어
		String search = "수원 1창고";
		m.addAttribute("search", search);
		
		// URL
		String page = "http://naver.com";
		m.addAttribute("page", page);
		
		// Session
		HttpSession session = req.getSession();
		session.setAttribute("muser", "홍길동");
		
		// 조건값
		String result = "ok";
		m.addAttribute("result", result);
		
		m.addAttribute("all", all);
		
		return "/thymeleaf.html";
	}
	
	
	@GetMapping("/thymeleaf2.do")
	public String thymelead2(Model m, HttpServletRequest req) {
		int paymethod = 1;
		m.addAttribute("paymethod", paymethod);
		
		// 클래스 배열로 생성하여 View 전달
		ArrayList<String> alldata = new ArrayList<>();
		alldata.add("검정");
		alldata.add("핑크");
		alldata.add("레드");
		alldata.add("옐로우");
		alldata.add("그린");
		
		m.addAttribute("alldata", alldata);
		
		
		// radio, checkbox 핸들링
		String agree = "Y";
		m.addAttribute("agree", agree);
		
		String level = "일반";
		m.addAttribute("level", level);
		
		// PC 시간을 말합니다.
		LocalDateTime today = LocalDateTime.now();
		// PC에 있는 값을 View로 전달 시 Thymeleaf에서는 문자로 변환하지 않고, 클래스 결과를 보냄
		m.addAttribute("today", LocalDateTime.now());
		
		Date today2 = new Date();
		m.addAttribute("today2", today2);
		
		Random rd = new Random();
		int no = rd.nextInt();
		
		return "/thymeleaf2.html";
	}
	
	
	@GetMapping("/thymeleaf3.do")
	public String thymelead3(Model m, HttpServletRequest req) {
		
		/* 데이터값을 출력하는 역할
		List<String> a = new ArrayList<>();
		a.add("aa");
		a.add("bb");
		a.add("cc");
		a.add("dd");
		*/
		
		Map<String, Object> a = new HashMap<>();
		a.put("aa", a);
		
		m.addAttribute("result", this.all_inject);
		m.addAttribute("act_url", "./thymeleaf4.do");
		m.addAttribute("money", 90000);
		m.addAttribute("money2", 22.52);
		
		return "/thymeleaf3.html";
	}
}
