package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class PhoneBookTest {
   
   private Scanner sc = new Scanner(System.in);
   Map<String, Phone> phoneBook = new HashMap<>();
   
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      new PhoneBookTest().phoneBookstart();

   }
   
   public int displayMenu() {
	   
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
   
   public void phoneBookstart() {
             
      while(true) {
         
         int select = displayMenu();
         
         switch (select) {
         case 1:
        	 createPhonNum();
             break;
            
         case 2:
        	 updatePhonNum();
             break;
            
         case 3:
            deletePhonNum();
            break;
            
         case 4:
        	 searchPhonNum();
            break;
            
         case 5:
        	 printPhonNum();
            break;
            
         case 6:
            System.out.println("프로그램을 종료합니다..");
            return;

         default:
            break;
         }
         
         
      }
      
      
   }
   
   private void printPhonNum() {
	// TODO Auto-generated method stub
	   
	   Set<String> keySet = phoneBook.keySet();
	   int count=0;
	   System.out.println("번호   이름   주소   전화번호");
	   for (String name : keySet) {
		   count++;
		   System.out.println(count+"  "+phoneBook.get(name));
	}
		
	
	
}

private void searchPhonNum() {
	// TODO Auto-generated method stub
	   System.out.println("검색할 사람의 이름을 입력하세요");
	   String name = sc.next();
	   
	   if(phoneBook.get(name) != null) {
		   Phone phoneSearch = phoneBook.get(name);
		   System.out.println(phoneSearch);
	   }else {
		   System.out.println("없는 사람입니다.");
	   }
	   System.out.println("--------------------------------");

	
}

	private void deletePhonNum() {
		// TODO Auto-generated method stub
		
		System.out.println("검색할 사람의 이름을 입력하세요");
		String name = sc.next();
		   
		if(phoneBook.get(name) != null) {
			phoneBook.remove(name);
		}else {
			System.out.println("없는 사람입니다.");
		}
	}
	
	

	private void updatePhonNum() {
	   System.out.println("수정할 사람의 이름을 입력하세요");
	   String name = sc.next();
	   
	   if(phoneBook.get(name) != null) {
		   System.out.print("전화번호 >> ");
		   String phoneNum = sc.next();
		      
		   System.out.print("주소 >> ");
		   String addr = sc.next();
		   
		   phoneBook.put(name, new Phone(name, phoneNum, addr));
		   
		   
	   }else {
		   System.out.println("없는 사람입니다.");
	   }
	
	   System.out.println("--------------------------------");

}

   public void createPhonNum() {
	  
      String name;
      String phoneNum;
      String addr;
      
      System.out.print("이름입력 >> ");
      name = sc.next();
      
      System.out.print("전화번호 >> ");
      phoneNum = sc.next();
      
      System.out.print("주소 >> ");
      addr = sc.next();
      
      if(phoneBook.get(name) == null) {
    	  phoneBook.put(name, new Phone(name, phoneNum, addr));
		  System.out.println(name + "씨의 전화번호가 등록되었습니다.");
      }else {
    	  System.out.println(name + "씨는 이미 등록된 사람입니다.");
      }       
   }
   
   
   

}
