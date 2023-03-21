package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortTest2 {

	public static void main(String[] args) {
		
		
		List<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(9, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));
		
		System.out.println("정렬 전...");
		
		for(Member mem : memList) {
			System.out.println(mem);
		}
		
		System.out.println("-----------------------------------");
		
	    // Collections.sort(memList); // 내부 정렬이 있어야만 sort를 바로 사용할 수 있음, 내부 정렬을 만들어줘야 함
		
		Collections.sort(memList);
		
		
		System.out.println("정렬 후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		
		// 회원번호를 기준으로 내림차순 정렬하여 출력하시오.
		// => 외부 정렬 기준 클래스를 작성하여 처리한다. (클래스 이름: SortNumDesc)
		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("회원번호로 내림차순 정렬 후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}	
		
	}

}


// Member클래스의 '회원이름'을 기준으로 오름차순이 되도록 내부 정렬 기준을 추가하기
// ==> Comparable인터페이스 구현

class Member implements Comparable<Member> {
	private int num; // 회원번호
	private String name; // 회원이름
	private String tel; // 전화번호
	
	
	// 생성자
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}


	@Override
	public int compareTo(Member mem) {
		// 회원이름의 오름차순
		return this.getName().compareTo(mem.getName());
	}
}

// 회원번호로 내림차순하는 방법들
class SortNumDesc implements Comparator<Member> {
	
	@Override
	public int compare(Member o1, Member o2) {
		if(o1.getNum()>o2.getNum()) {
			return -1;
		}else if(o1.getNum()<o2.getNum()){
			return 1;
		}else {
			return 0;			
		}
	//}	
		
		// 다른 방법
		// return o2.getNum() - o1.getNum();	// 숫자가 무조건 양수일때 사용할 수 있는 방법	
		
		// *-1을 하는 이유는 결과값이 양수로 나오기 때문에 내림차순으로 하기 위해 -1을 곱함
	
		// Wrapper 클래스를 이용하는 방법1
		//return new Integer(o1.getNum()).compareTo(o2.getNum()) * -1;
	
		// Wrapper 클래스를 이용하는 방법2
		// return Integer.compare(o1.getNum(), o2.getNum())*-1;
	}

}








