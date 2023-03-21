//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//
///*
//   10마리의 말들이 경주하는 프로그램을 작성하기
//   말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
//   이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
//   그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준을 갖고 있다.
//   (Comparable인터페이스 구현)
//   
//    경기 구간은 1 ~ 50구간으로 되어 있다.
//    경기가 끝나면 등수 순으로 출력한다.
//    
//    경기 중간 중간에 각 말들의 위치를 아래와 같이 출력한다.
//    예시) (-)이 구간
//    말이름01: -->--------------------------------------- 
//    말이름02: ----->------------------------------------ 
//    말이름03: ---->------------------------------------- 
//    ...
//    말이름10: ---------->------------------------------- 
//    
//    말들이 달리는 각자의 위치를 표현하는 것도 쓰레드로 표현해야함 현재위치값을 이용해서 출력
//   
// */
//public class ThreadTest13 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		List<Horse> horse = new ArrayList<>();
//		
//		for (int i = 1; i < 12; i++) {
//			horse.add(new Horse(i+"번마"));
//		}
////		
////		Thread location = new LocationPrint(horse);
//
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		for (Horse horse2 : horse) {
//			horse2.start();
//		}
//		
////		location.start();
//		
//		for (Horse horse2 : horse) {
//			try {
//				horse2.join();
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
//		}
//		
//		try {
//			Thread.sleep(3500);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		System.out.println();
//		System.out.println("-- 경기 결과 --");
//		Collections.sort(horse);
//				
//		for (Horse horse2 : horse) {
//			System.out.println(horse2);
//		}
//		
//
//	}
//
//}
//
//
////class LocationPrint extends Thread{
////	
////	private List horse;
////
////	public LocationPrint(List horse) {
////		this.horse = horse;
////	}
////
////
////
////	@Override
////	public void run() {
////		int count=0;
////		
////		
////		
////		try {
////			for(int i=0; i<location; i++) {
////				
////				count++;
////				if(location==0) {
////					return;
////				}
////				System.out.print('-');
////				if(count==location) {
////					System.out.print('>');
////					for (int j = 0; j <  40-location; j++) {
////						System.out.print('-');
////					}
////				}
////				
////			}
////			System.out.println();
////		} catch (Exception e) {
////			// TODO: handle exception
////		}
////	}
////}
//
//class Horse extends Thread implements Comparable<Horse>{
//	
//	private String horseName;
//	private static int rank=1;
//	private int location;
//	private int resultRank;
//	
//	public Horse(String horseName) {
//		this.horseName = horseName;
//	}
//
//	@Override
//	public void run() {
//		Random rnd = new Random();
////		LocationPrint locationPrint=null;
////		
//		for(int i=0; i<40; i++) {
//			try {
//				Thread.sleep(rnd.nextInt(2000));
//				location++;
//			
//			} catch (InterruptedException e) {
//				// TODO: handle exception
//			}
//		}
//		setResultRank(rank++);
//	}
//
//	
//	
//	public String getHorseName() {
//		return horseName;
//	}
//
//	public void setHorseName(String horseName) {
//		this.horseName = horseName;
//	}
//
//	public int getLocation() {
//		return location;
//	}
//
//	public void setLocation(int location) {
//		this.location = location;
//	}
//
//	public int getResultRank() {
//		return resultRank;
//	}
//
//	public void setResultRank(int resultRank) {
//		this.resultRank = resultRank;
//	}
//
//	@Override
//	public int compareTo(Horse o) {
//		return Integer.compare(this.getResultRank(), o.getResultRank());
//	}
//
//	@Override
//	public String toString() {
//		return horseName +"는"+ resultRank + "등 입니다.";
//	}
//	
//	
//}



