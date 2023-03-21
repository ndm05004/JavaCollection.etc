import java.util.Random;

import javax.swing.JOptionPane;

public class ThreadTest07Solution {
	
	public static boolean inputCheck;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameTimer g = new GameTimer();
		
		// 난수를 이용하여 컴퓨터의 가위 바위 보 정하기
		
		String[] data = {"가위", "바위", "보"};
		
		Random rnd = new Random();
		
		int index = rnd.nextInt(3); //0~2사이의 난수 만들기
		
		String com = data[index];
		
		// 사용자의 가위 바위 보 입력 받기.
		
		g.start(); // 카운트 다운 시작
		
		String man = null; 
		do {
			man = JOptionPane.showInputDialog("가위 바위 보 입력하세요...");
//		} while (!("가위".equals(man) || "바위".equals(man) || "보".equals(man)));
		} while (!"가위".equals(man) && !"바위".equals(man) && !"보".equals(man));
		
		inputCheck = true;
		
		
		// 결과
		String result = "";
		if(man.equals(com)) {
			result = "비겼습니다";
		}else if(man.equals("가위") && com.equals("보") ||
				man.equals("보") && com.equals("바위") ||
				man.equals("바위") && com.equals("가위")) {
			result = "이겼습니다";
		}else {
			result = "졌습니다";
		}
		
		System.out.println("--- 결과 ---");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + man);
		System.out.println("결 과 : " + result);
	}

}






class GameTimer extends Thread{
	
	@Override
	public void run() {
		System.out.println("카운트 다운 시작...");
		for(int i=1; i<6; i++) {
			
			if(ThreadTest07Solution.inputCheck==true) {
				return;
			}
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		} // for문 끝...
		System.out.println("--- 결 과 ---");
		System.out.println("시간 초과로 당신이 졌습니다.");
		System.exit(0);
	}
	
}