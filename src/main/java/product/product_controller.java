package product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// package를 생성 시 기존에 사용한 패키지명 + 신규 이름 적용하여 Controller를 생성해야 함

@Controller
public class product_controller {
	@GetMapping("/product.do")
	public String product(Model m) {
		String product = "냉장고";
		m.addAttribute("product",product);
		
		return null;
	}
}
