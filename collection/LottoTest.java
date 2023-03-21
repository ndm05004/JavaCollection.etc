package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		

		
		
		while(true) {
			System.out.println("==========================");
			System.out.println("Lotto 프로그램");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			int select = sc.nextInt();
			System.out.println("==========================");
			System.out.print("메뉴선택: ");
			
			if(select == 1) {
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.println("금액 입력 : ");
				int money = sc.nextInt();
				if(money<1000) {
					System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
				}
				
				int turn = money /1000;
				
				for (int i = 0; i <turn; i++) {
				
					Set<Integer> lottoNum = new HashSet<>(); 
					
					while(lottoNum.size()<6) {
						lottoNum.add(rand.nextInt(45)+1);
					}
					
					List<Integer> lottoNum2 = new ArrayList<>(lottoNum);
					Collections.sort(lottoNum2);
					
					System.out.println("행운의 로또번호는 아래와 같습니다.");
					System.out.print("로또번호"+ (i+1) +" : ");
					for (int j = 0; j < 6; j++) {
						System.out.print(lottoNum2.get(j)+" ");
					}
					System.out.println("");
							
				}
				System.out.println("받은 금액은 "+money+"이고 거스름돈은"+money%1000+"입니다.");
				
				
			}else if(select==2) {
				System.out.println("감사합니다.");
				break;
			}
			
			
			
		}
		


	}

}
