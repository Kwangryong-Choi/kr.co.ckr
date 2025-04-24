package aop;

public class Exam implements ex_interface{
	
	public static void main(String[] args) {
		new Exam().avg();
			
	}
	
	@Override
	public float avg() {
		float result = total() / 4.0f;
		return result;
	}

	
	@Override
	public int total() {
//		long start = System.currentTimeMillis();
		int result = 100 + 200 + 300;
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}
		/*
		long end = System.currentTimeMillis();
		
		String message = (end-start) + "ms 시간이 걸림";
		System.out.println(message);
		*/
		return result;
	}
}
