package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTestSolution {

	private Map<String, Phone> phoneBookMap;
	private Scanner sc;
	
	public PhoneBookTestSolution() {
		// TODO Auto-generated constructor stub
		phoneBookMap = new HashMap<>();
		sc = new Scanner(System.in);
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new PhoneBookTestSolution().phoneBookStart();

	}
	
	public void phoneBookStart() {
		System.out.println("************************************");
		System.out.println("     전 화 번 호 관 리 프 로 그 램");
		System.out.println("************************************");
		System.out.println();
		
		while(true) {
			
			int choice = displayMenu();
			
			  switch (choice) {
		         case 1:  // 등록
		        	 insert();
		             break;
		            
		         case 2: // 수정
		        	 update();
		             break;
		            
		         case 3: //삭제
		        	delete();
		            break;
		            
		         case 4: //검색
		        	search();
		            break;
		            
		         case 5: //전체출력
		        	dispalyAll();
		            break;
		            
		         case 6:
		            System.out.println("프로그램을 종료합니다..");
		            return;

		         default:
		        	 System.out.println("번호를 잘못 입력했습니다. 다시 선택하세요...");
		            break;
		         }
		         
			
		}
	
	
	}
	
	private void search() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요...");
		System.out.println("이 름 >> ");
		String name = sc.next();
		
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨는 전화번호 정보가 등록되지 않은 사람입니다.....");
			return;
		}
		
		Phone p = phoneBookMap.get(name);
		System.out.println(name+ "씨의 전화번호 정보");
		System.out.println("-------------------------");
		System.out.println("이 름 : " + p.getName());
		System.out.println("전 화 : " + p.getTel());
		System.out.println("주 소 : " + p.getAddr());
		System.out.println("-------------------------");
		System.out.println();
		
	}
	
	
	private void delete() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("이름 >>");
		String name = sc.next();
		
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨는 전화번호 정보가 등록되지 않은 사람입니다.....");
			return;
		}
		phoneBookMap.remove(name);
		System.out.println(name + "씨의 전화번호 정보가 삭제되었습니다..");
		
	}
	
	
	private void update() {
		// TODO Auto-generated method stub
		
		System.out.println("이 름 >> ");
		String name = sc.next();
		
		// 수정할 대상이 없으면 수정 작업 x
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨는 전화번호 정보가 등록되지 않은 사람입니다.....");
			return;
		}
		
		System.out.println("새로운 전화번호 >> ");
		String tel = sc.next();
		
		sc.nextLine(); // 버퍼를 비워주는 역할
		System.out.println("새로운 주소 >> ");
		String addr = sc.nextLine();
		
		// 같은 키 값에 새로운 데이터가 들어가면 갱신됨
		
		phoneBookMap.put(name, new Phone(name, tel, addr));
		System.out.println("변경완료");	
	}
	
	
	private void dispalyAll() {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------");
		System.out.println("번호\t이 름\t전화번호\t주소");
		System.out.println("----------------------------------------");
		
		Set<String> phoneKeySet = phoneBookMap.keySet();
		
		if(phoneKeySet.size()==0) {
			System.out.println("  등록된 전화번호 정보가 하나도 없습니다.");
		}else {
			int num =0;
			for(String name: phoneKeySet) {
				num++;
				Phone p = phoneBookMap.get(name);
				System.out.println(num + "\t" + p.getName()+ "\t" +p.getTel()+"\t"+
				p.getAddr());
			}
		}
		System.out.println("-------------------------------");
		System.out.println("출력 끝...");
		
	}
	
	/*
	    Scanner의 next(), nextInt(), nextDouble()등...
	         ==> 사이띄기, Tab키 Enter키를 구분 문자로 분리해서 분리된 자료만 읽어간다.
	         
	    Scanner의 nexLine()
	        ==> 한 줄 단위로 입력한다.
	            자료를 입력하고 Enter키를 누르면 Enter키까지 읽어가서 Enter키를 뺀 나머지를 반환한다.
	    - 컴퓨터의 입력 작업은 입력된 데이터를 입력 버퍼에 저장하고 이것을 차례로 꺼내가는
	      방법으로 처리된다.
	      그래서 next(), nextInt()등과 같은 메서드를 실행한 후에  nextLine()을 사용할 때는
	      입력 버퍼를 비워줘야 한다. (방법 : nextLine()을 한번 더 사용한)
	 */
	
	private void insert() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		
		System.out.println("이 름 >> ");
		String name = sc.next();
		
		// 이미 등록된 사람인지 여부 검사
		if(phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}
		
		System.out.println("전화번호 >> ");
		String tel = sc.next();
		
		sc.nextLine(); // 버퍼를 비워주는 역할
		System.out.println("주소 >> ");
		String addr = sc.nextLine();
		
		// Phone p = new Phone(name, tel, addr);
		phoneBookMap.put(name, new Phone(name,tel,addr));
		
		System.out.println(name + "씨 전화번호 정보 등록 완료");
		
		
	}
	
	
	private int displayMenu() {
	       System.out.println("--------------------------");
		   System.out.println("1. 전화번호 등록");
	       System.out.println("2. 전화번호 수정");
	       System.out.println("3. 전화번호 삭제");
	       System.out.println("4. 전화번호 검색");
	       System.out.println("5. 전화번호 전체 출력");
	       System.out.println("6. 프로그램 종료");
	       System.out.println("--------------------------");
	       System.out.println("번호 입력>> ");
	       return sc.nextInt();
	}
	
	
}