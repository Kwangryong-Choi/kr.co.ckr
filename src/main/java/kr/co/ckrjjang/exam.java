package kr.co.ckrjjang;

// Controller, Service 역할
public class exam implements exampleinterface {
	public static void main(String[] args) {
		int result = new exam().total();
		System.out.println(result);
	}
	@Override
	public int total() {
		int data[] = {10,20,30};
		int w = 0;
		int sum = 0;
		while(w < data.length) {
			sum += data[w];
			w++;
		}
		return sum;
	}
	@Override
	public int avg() {
		int avgs = 500;
		return avgs;
	}
}
