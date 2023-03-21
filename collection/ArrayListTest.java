package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List list1 = new ArrayList();
		
		
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add("true");
		list1.add(123.45);
		
		System.out.println("list => " + list1);
		System.out.println("size ==> " + list1.size());
		System.out.println();
		
		System.out.println("1번째 자료" + list1.get(1));
	}	

}
