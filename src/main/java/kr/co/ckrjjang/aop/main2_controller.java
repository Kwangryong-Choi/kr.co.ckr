package kr.co.ckrjjang.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class main2_controller {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "user_dto")
	user_dto user_dto;
	
	@GetMapping("/tesaop.do")
	public String testaop(Model m) {
		String mid = "hong";
		String mname = "홍길동";
		
		
		if(mid.equals("hong")) {
			this.log.info("아이디를 확인하였습니다.");
		}
		
		m.addAttribute("mname", mname);
		return null;
	}
	
	@GetMapping("/testaop_logout.do")
	public String testaop2(Model m, 
			@SessionAttribute(name = "userid", required = false)String userid, 
			HttpServletRequest req) {
		this.log.info(userid);
		
		return null;
	}
}
