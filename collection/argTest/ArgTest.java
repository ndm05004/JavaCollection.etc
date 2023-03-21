package kr.or.ddit.basic.argTest;

public class ArgTest {

	 //메서드 만들기
	public int sumArr(int[] data) {
		
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		
		return sum;
	}
	
	//가변형 인수 ==> 메서드의 인수 개수가 호출할 때마다 다를 때 사용
	// - 가변형 인수는 메서드 안에서 배열로 처리된다.
	// - 가변형 인수는 한가지 자료형만 사용할 수 있다.
	// - 가변형 인수와 일반적인 인수를 같이 사용할 경우에는
	//   가변형 인수를 제일 뒤쪽에 배치해야 한다.
	
	public int sumArg(int... data) {
		
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		
		return sum;
	}
	
	public String sumArg2(String name, int... data) {
		// 일반적으로 가변형변수와 일반변수를 함께 사용하려면 일반변수를 앞으로, 가변형변수를 뒤쪽에 위치함		
		int sum = 0;
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		
		return name + "씨 점수 : " + sum;
	}
	
	public void myMethod(int a) {
		
	}
	
	
	public static void main(String[] args) {
		ArgTest test = new ArgTest();
		
		int[] nums = {100, 200, 300};
		System.out.println(test.sumArr(nums));
		System.out.println(test.sumArr(new int[] {1,2,3,4,5}));
		
//		int b = 100;
//		test.myMethod(b);		
//		test.myMethod(200);
		
		System.out.println(test.sumArg(100,200,300));
		System.out.println(test.sumArg(1,2,3,4,5));
		
		System.out.println(test.sumArg2("박승우", 12,34,56,78,90));
		
		
	}
}