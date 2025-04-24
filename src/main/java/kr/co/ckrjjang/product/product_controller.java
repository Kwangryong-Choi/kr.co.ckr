package kr.co.ckrjjang.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//package를 생성시 기존에 사용한 패키지명 + 신규 이름 적용하여 Controller 생성

@Controller
public class product_controller {
	
	@GetMapping("/product.do")
	public String product(Model m) {
		String product = "냉장고";
		m.addAttribute("product",product);
		return null;
	}
	
}
