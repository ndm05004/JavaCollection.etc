package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoTestSolution {
	
	
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new LottoTestSolution().lottoStrat();
	}
	
	public void lottoStrat() {
		while(true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				buylotto();
				break;
				
			case 2:
				System.out.println();
				System.out.println("감사합니다...");
				return;
				
			default: 
				System.out.println("번호를 잘못 입력했습니다."); 
				System.out.println("1또는 2를 입력하세요...");
				break;
			}
		}
	}
	
	// 로또 판매를 처리하는 메서드
	private void buylotto() {
		System.out.println();
		System.out.println(" Lotto 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.println("금액 입력 : ");
		
		int money = sc.nextInt();
		if(money<1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
			return;
		}else if(money>=101000) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
			return;
		}
		
		// 로또 번호 만들기
		Set<Integer> lottoSet = new HashSet<>();
		Random rnd = new Random();
		
		// 구매할 매수 계산
		int count = money / 1000;
		
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int i=1; i<=count; i++) {
			while(lottoSet.size() < 6) {
				lottoSet.add(rnd.nextInt(45)+1);
			}
			List<Integer> lottoList = new ArrayList<>(lottoSet);
			Collections.sort(lottoList);
			
			System.out.println("로또번호 : "+ i +" : ");
			
			for(int j=0; j<lottoList.size(); j++) {
				if(j>0) System.out.println(", ");
				
				System.out.println(lottoList.get(j));
			}
			
			lottoSet.clear();
			
		}
		System.out.println("받은 금액은 "+money+"이고 거스름돈은"+money%1000+"입니다.");		
	}

	// 메뉴를 출력하고 사용자가 입력한 값을 반환하는 메서드
	private int displayMenu() {
		System.out.println("==========================");
		System.out.println("Lotto 프로그램");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴선택>> ");
		
		return sc.nextInt();
	}
	
	

}
