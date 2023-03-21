package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//문제) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가ㅣ
//제일 긴 별명을 출력하시오
//(단, 각 별명의 길이는 같을 수 있다.)

public class ArrayListTest04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			list.add(sc.nextLine());
		}
		
		int temp = 0;

		for(int i=0; i<5; i++) {
			if(list.get(i).length() > temp) {			
				temp = list.get(i).length();
				
			}			
		}
		
		for(int i=0; i<5; i++) {
			if(list.get(i).length()== temp) {
				System.out.println("가장 긴 별명 = "+list.get(i));		
		}
		}
		
		System.out.println("가장 긴 별명의 길이 = "+temp);
		
	}

}
