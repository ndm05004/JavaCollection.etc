

/*
 * 1 ~ 20억까지의 합계를 구하는 프로그램을 하나의 쓰레드가 처리될 때와
 * 여러개의 쓰레드가 협력해서 처리할 때의 경과 시간을 비교해보자
 * 
 */


public class ThreadTest04 {
	
	public static long sumAll = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 단독으로 처리할 쓰레드
		SumThread sm = new SumThread(1L, 2_000_000_000L);
		
		
		// 협력해서 처리할 쓰레드
		SumThread[] smArr = new SumThread[] {
				new SumThread(1L, 500000000L),
				new SumThread(500000001L, 1000000000L),
				new SumThread(1000000001L, 1500000000L),
				new SumThread(1500000001L, 2000000000L)
				
		};
		
		long startTime = System.currentTimeMillis();
		
		sm.start();
		
		try {
			sm.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독으로 처리했을 때 경과 시간 : " + (endTime - startTime));
		
		System.out.println();
		System.out.println();
		
		// 여러 쓰레드가 협력해서 처리하기
		ThreadTest04.sumAll = 0L;
		
		startTime = System.currentTimeMillis();
		
		for(int i=0; i<smArr.length; i++) {
			smArr[i].start();
		}
		
		for(SumThread s : smArr) {
			try {
				s.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("총합 : " + ThreadTest04.sumAll);
		System.out.println("여러개의 쓰레드가 협력해서 처리한 경과시간 : " + (endTime - startTime));
	}

}

class SumThread extends Thread {
	
	// 합계를 구할 영역의 시작값과 끝값이 저장될 변수 선언
	private long start;
	private long end; 
	
	// 생성자
	public SumThread(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		long sum = 0L;
		for (long i = start; i <=end; i++) {
			sum += i;
		}
		ThreadTest04.sumAll += sum;
		System.out.println(start + "부터 " + end + "까지의 합계 : " + sum);
	}
	
	
}

