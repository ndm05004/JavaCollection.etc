package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HotelTestSolution {
	
	private Map<Integer, Room> hotelMap;
	private Scanner sc;

	public HotelTestSolution() {
		// TODO Auto-generated constructor stub
		hotelMap = new HashMap<>();
		sc = new Scanner(System.in);
		
		for(int i=2; i<=4; i++) {
			String roomType = null;
			
			switch (i) {
			case 2:
				roomType = "싱글룸";
				break;
			case 3:
				roomType = "더블룸";
				break;
			case 4:
				roomType = "스위트룸";
				break;

			default:
				break;
			}
			
			for(int j=1; j<=9; j++) {
				int roomNum = i * 100+j;
				hotelMap.put(roomNum, new Room(roomNum, roomType));
			}
		}
	}
	
	public static void main(String[] args) {
		new HotelTestSolution().hotelStart();
	}
	
	public void hotelStart() {
		
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		System.out.println();
		
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
				printRoomState();
				break;
			case 4:
				exit();
				return;
		
			default: System.out.println("작업 번호를 잘못 입력했습니다. 다시 입력하세요....");
			}
		}
	}

	
	private void printRoomState() {
		// TODO Auto-generated method stub
		
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호\t방 종류\t투숙객 이름");
		System.out.println("----------------------------------------------");
		
		Set<Integer> keySet = hotelMap.keySet();
		List<Integer> keySet2 = new ArrayList<>(keySet);
		Collections.sort(keySet2);
		
		for (Integer rNum : keySet2) {
			System.out.println(hotelMap.get(rNum).toString());
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
		
		if(hotelMap.get(rNum).getName()==null) {
			System.out.println(rNum + "호 객실은 체크인한 손님이 없습니다..");
			return;
		}
		
		String name = hotelMap.get(rNum).getName();
		
		hotelMap.get(rNum).setName(null);
		System.out.println(rNum + "호 객실의" + name + "님이 체크하웃하셨습니다....");
		
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
		
		// 입력한 방이 존재하는지 여부 검사(map의 key값이 방번호이므로 해당 방번호가 key값에 존재하는지 여부 검사)
		if(!hotelMap.containsKey(rnum)) {
			System.out.println(rnum + "호 객실은 존재하지 않습니다...");
			return;
		}
		
		if(hotelMap.get(rnum).getName()!=null){
			System.out.println(rnum+"호 객실에 이미 손님이 있습니다...");
		}
		
		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 >> ");
		String name = sc.next();
		
		hotelMap.get(rnum).setName(name);
		
		System.out.println(rnum + "호 객실에 " + name + "씨의 체크인이 완료되었습니다.");
		
	}

	private void exit() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("       호텔문을 닫았습니다.");
		System.out.println("*********************************************");
		System.out.println();
		
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
