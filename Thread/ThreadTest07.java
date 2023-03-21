import java.util.Random;

import javax.swing.JOptionPane;

/*
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 	
 	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고
 	사용자의 가위 바위 보는 showInputDialog()메서드를 이용하여 입력 받는다.
 	
 	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 	5초 안에 입력이 없으면 게임에 진것으로 처리한다.
 	
 	5초 안에 입력이 완료되면 승패를 구해서 출력한다.
 	
 	결과 예시)
 	1) 5초 안에 입력하지 못했을 경우
 	   --- 결 과 ---
 	   시간초과로 당신은 졌습니다.
 	2) 5초 안에 입력했을 경우
 	   --- 결 과---
 	   컴퓨터: 가위
 	   사용자: 바위
 	   결과 : 당신이 이겼습니다.
 	
 */


public class ThreadTest07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread th1 = new DataInput();
		Thread th2 = new Count();
		
		th1.start();
		th2.start();
		
	}
}

class DataInput extends Thread {
	
	Random rand = new Random();
	
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("사용자 가위바위보를 입력하세요...");
		
		inputCheck = true;
		
		System.out.println("사용자 : " + str );
		
		int com = rand.nextInt(3)+1;
		
		switch (com) {
		case 1:
			System.out.println("컴퓨터 : 가위");
			break;
		case 2:
			System.out.println("컴퓨터 : 바위");
			break;
		case 3:
			System.out.println("컴퓨터 : 보");
			break;

		default:
			break;
		}
		
		if(str.equals("가위") && com == 1 || str.equals("바위") && com == 2 || str.equals("보") && com == 3) {
			System.out.println("비겼습니다.");
		}else if(str.equals("가위") && com == 2 || str.equals("바위") && com == 3||
				str.equals("보") && com == 1) {
			System.out.println("당신이 졌습니다.");	
		}else{
			System.out.println("당신이 이겼습니다.");
		}
		
		
		
		
	}	
	
}

class Count extends Thread {
	
	@Override
	public void run() {
		System.out.println("--- 결 과 ---");
		for(int i=5; i>0; i--) {
			if(DataInput.inputCheck == true) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("시간초과로 당신은 졌습니다.");
		System.exit(0);
		
	}
}







