package kr.co.ckrjjang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
 * OOP : 객체 지향 언어
 * AOP (Aspect-Orient Programming) : 관점 지향 언어
 */

// AOP를 적용할 class
public class java_aop {
	
	public static void main(String[] args) {
		/*
		 * interface를 로드 후 해당 interface를 사용한 class를 호출하는 방식
		 *  
		exampleinterface ex = new exam();
		int result = ex.total();
		System.out.println(result);
		 */
		
		
		// AOP (Proxy) => newProxyInstance => 기존 메소드 + 신규코드 return
		/*
		 * Proxy.newProxyInstance : 동적 프록시 ClassLoad 역할
		 * Class : 프록시 클래스가 구현할 인터페이스 목록(배열)
		 */
		
		exampleinterface ex = new exam();
		// AOP 사용
		exampleinterface aops = (exampleinterface)Proxy.newProxyInstance(exampleinterface.class.getClassLoader(), new Class[] {exampleinterface.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				/*
				String user[] = {"hong", "kim"};
				List<String> all = new ArrayList<>();
				int ww = 0;
				while(ww < user.length) {
					all.add(user[ww]);
					ww++;
				}
				*/
				// 해당 본 코드의 메소드를 실행시킨 결과값을 가져오는 역할
				Object result = method.invoke(ex, args);
				Integer total2 = Integer.parseInt(result.toString()) + 100;
				return total2;
			}
		});
		int result = ex.total();
		System.out.println("본 코드에서 실행된 결과값 : " + result);
		int result_aop = aops.total();
		System.out.println("AOP에서 실행된 결과값 : " + result_aop);
		int result_aop2 = aops.avg();
		System.out.println("AOP에서 실행된 결과값 : " + result_aop2);
	}
}
