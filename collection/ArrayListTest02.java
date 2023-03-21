package kr.or.ddit.basic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * (문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에 
 * 이 Arraylist에 저장된 이름들 중 '김'씨 성의 이름을 찾아 모두 출력하시오.
 * (단, 입력은 Scanner객체를 이용한다.)
 */


public class ArrayListTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		List<String> list = new ArrayList<>(); 
		
		for (int i = 0; i < 5; i++) {
			list.add(sc.nextLine());
		}
		
		
		for (int i = 0; i < 5; i++) {
			String str=list.get(i);
			if(str.charAt(0) == '김') {
				System.out.println(list.get(i));
			}
			
			if(list.get(i).indexOf("김")==0) {
				System.out.println(list.get(i));
			}
			
			if(list.get(i).startsWith("김")) {
				System.out.println(list.get(i));
			}
			
		}
		
		

		

	}

}