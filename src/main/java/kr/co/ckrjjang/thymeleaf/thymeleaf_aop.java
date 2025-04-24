package kr.co.ckrjjang.thymeleaf;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import jakarta.annotation.Resource;

@Aspect
@Component
public class thymeleaf_aop {
	
	@Resource(name = "all_dto")
	all_dto all_inject;
	
	@Before("execution(* kr.co.lee.thymeleaf.thymeleaf_controller.*(..))")
	public void top_menu(Model m) {
		
	}
}
