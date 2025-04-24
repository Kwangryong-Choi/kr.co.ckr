package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// AOP를 사용하는 형태는 기본 작동되고 있는 메소드에서 추가 코드 및 옵션이 발생했을 때 사용하는 기준
// 절대 적용하지 않는 사항은 interface에 추가, 실제 class에 코드 및 변수를 추가하지 않음
public class aop_exam {

	public static void main(String[] args) {
		
		ex_interface exam = new Exam();
		
		ex_interface proxy = (ex_interface)Proxy.newProxyInstance(ex_interface.class.getClassLoader(), 
				new Class[] {ex_interface.class}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// 시작시간
						long start = System.currentTimeMillis();
						
						
						// invoke(클래스명, 결과값을 가지고 있는 변수) : 해당 클래스에서 메소드를 실행
						
						// 본 코드에서 작동되고 있는 사항을 실행
//						Object result2 = method.invoke(exam, aaa);	// 해당 클래스에 모든 메소드 호출
						Object result2 = method.invoke(exam.total(), args);		// total 이라는 메소드만 호출
						// 본 코드에서 사용하는 변수와 동일한 변수를 사용하더라도 다른 변수로 인식을 하게됨
						int result = 0;
						
						// 종료시간
						long end = System.currentTimeMillis();
						
						String message = (end-start) + "ms 시간이 걸림";
						System.out.println(message);
						
						return result2;
					}
				});
		System.out.println("total : " + proxy.total());
		System.out.println("total2 : " + proxy.avg());
	}
}
