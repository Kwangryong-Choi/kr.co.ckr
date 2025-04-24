package kr.co.ckrjjang.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@Aspect		// AOP
@Component	// main2_aop 를 무조건 실행되도록 함
public class main2_aop {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	// Controller에서 setter값을 입력받은 사항을 AOP getter로 받아서 추가 코드를 작성하게 함
	// 단 일반적인 @Resource 처럼 new 클래스를 가져오는 형태가 아님
	@Resource(name = "user_dto")
	user_dto dto;

	
	
	
	/*
	 * @After() : 해당 Controller가 작동된 후 실행되는 AOP
	 * @Before() : 해당 Controller가 작동되기 전 실행되는 AOP
	 * execution : 해당 패키지에 있는 controller 및 Mapping 메소드를 실행하는 명령어
	 */
	
	@After("execution(* kr.co.lee.aop.main2_controller.testaop(...))")
	public void testaop_a() throws Throwable {
		try {
//			this.log.info("aop에서 실행되는 로그인");
			this.log.info(this.dto.getMid());
			HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpSession se = req.getSession();
			se.setAttribute("userid", this.dto.getMid());
			se.setAttribute("useremail", "hong@nate.com");
			/*
			int result = this.cs.log_table(this.dto.getMid());
			if(result > 0) {
				this.log.info("올바르게 로그기록을 저장하였습니다.");
			}
			*/
		} catch (Throwable e) {		// Exception 보다 상위 Throwable 예외처리 부분
			e.printStackTrace();
		}
		
	}
	
	// 로그아웃 되고나서 언제 로그아웃 했는지를 DB에 insert 하도록 코드를 AOP로 작성하십시오.
	@Before("execution(* kr.co.lee.aop.main2_controller.testaop2(...))")
	public void testaop_b() {
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession se = req.getSession();
		String userid = req.getAttribute("userid").toString();
		/*
		int result = this.cs.log_table(userid);
		if(result > 0) {
			this.log.info("올바르게 로그기록을 저장하였습니다.");
		*/
		}
		
}
