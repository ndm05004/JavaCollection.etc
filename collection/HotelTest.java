package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTest {
	
	private Map<Integer, Room> hotelTestMap;
	private Scanner sc;
	
	public HotelTest() {
		// TODO Auto-generated constructor stub
		
		hotelTestMap = new HashMap<>();
		sc = new Scanner(System.in);
		

		for(int i=201; i<210; i++) {
			hotelTestMap.put(i, new Room(i, "싱글룸"));
		}
		
		for(int i=301; i<310; i++) {
			hotelTestMap.put(i, new Room(i, "더블룸"));
		}
		
		for(int i=401; i<410; i++) {
			hotelTestMap.put(i, new Room(i, "스위트룸"));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new HotelTest().hotelStart();
		
	}
	
	public void hotelStart() {
		


		
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		
		
		while(true) {
			
			int select = viewMenu();
			
			switch (select) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				status();
				break;
			case 4:
				exit();
				return;

			default:
				break;
			}
			
		}
	}
	
	
	
	private void exit() {
		// TODO Auto-generated method stub
		System.out.println("*********************************************");
		System.out.println("       호텔문을 닫았습니다.");
		System.out.println("*********************************************");
		
	}
	private void status() {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호\t방 종류\t투숙객 이름");
		System.out.println("----------------------------------------------");
		
		Set<Integer> keySet = hotelTestMap.keySet();
		List<Integer> keySet2 = new ArrayList<>(keySet);
		Collections.sort(keySet2);
		
		for (Integer rNum : keySet2) {
			System.out.println(hotelTestMap.get(rNum).toString());
		}
		
	}
	private void checkOut() {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------");
		System.out.println("                 체크아웃 작업");
		System.out.println("----------------------------------------------");
		
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println("방번호 입력 >> ");
		int rNum = sc.nextInt();
		
		if(!hotelTestMap.containsKey(rNum)) {
			System.out.println(rNum + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		if(hotelTestMap.get(rNum).getName().equals("-")) {
			System.out.println(rNum + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}
		
		System.out.println(rNum+"호 객실의 "+hotelTestMap.get(rNum).getName() +"님 체크아웃을 완료하였습니다.");
		hotelTestMap.remove(rNum);
		
		
	}
	private void checkIn() {
		// TODO Auto-generated method stub
		
		System.out.println("----------------------------------------------");
		System.out.println("                   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println("              * 201~209 : 싱글룸");
		System.out.println("              * 301~309 : 더블룸");
		System.out.println("              * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		
		System.out.print("방 번호 입력 >>");
		int rnum = sc.nextInt();
		
		if(!hotelTestMap.containsKey(rnum)) {
			System.out.println(rnum + "객실은 존재하지 않습니다.");
			return;
		}
		
		if(hotelTestMap.get(rnum).getName() != "-") {
			System.out.println(rnum + "호 객실은 이미 손님이 있습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String name = sc.next();
		hotelTestMap.put(rnum, new Room(rnum, hotelTestMap.get(rnum).getRoolType(), name));
		
		System.out.println("체크인이 완료되었습니다.");
	}
	

	public int viewMenu() {
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>> ");
		
		
		return sc.nextInt();
	}
	
	

}
