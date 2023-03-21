package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/*
   문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
        (컴퓨터의 숫자는 난수를 이용하여 구한다. (1~9사이의 값 3개)
        (스트라이크는 S, 볼은 B로 나타낸다.))
        
   예시) 
        컴퓨터 난수 ==> 9 5 7
   실행예시)
    숫자입력 >> 3 5 6
   출력예시)
    3 5 6 => 1S 0B
    맞출때 까지 반복
    
 */



public class BaseBallTest {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		Set<Integer> comNum = new HashSet<>(); 
			
		while(comNum.size()<3) {
			comNum.add(rand.nextInt(9)+1);
		}
		
		List<Integer> comNum2 = new ArrayList<>(comNum);

		Collections.shuffle(comNum2);
		
		System.out.println(comNum2);
		
		int count=0;
	
		while(true) {
			count++;
			List<Integer> userNum = new ArrayList<>();
			System.out.print("숫자입력 >>");
			for(int i=0; i<3; i++) {
				userNum.add(i, sc.nextInt());
			}
			
			
			int s =0;
			int b =0;
				
			
			for (int i = 0; i < 3; i++) {
				if(comNum2.get(i)==userNum.get(i)) {
					s++;
				}
				for (int j = 0; j < 3; j++) {
					if(comNum2.get(i)==userNum.get(j) && comNum2.indexOf(comNum2.get(i))!=j ){
						b++;
					}
				}
			}
			
			
			System.out.print(userNum+" ");
			System.out.println(s+"S "+b+"B ");
			
			if(s==3) {
				System.out.println("축하합니다 당신은"+count+"번째 만에 맞췄습니다..");
				break;
			}		
	}
	
  }
	
}

