package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*문제) 학번, 이름 국어점수, 영어점수, 수학점수, 총점, 등수를 갖는 Student 클래스를 만든다.
       이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 인수로 받아서
       초기화 처리를 한다.
	   
	   이 Student객체는 List에 저장하여 관리한다.
	   
	   List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
	   총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준도
	   구현하여 정렬된 결과를 출력하시오
	   (등수는 List에 전체 데이터가 추가된 후에 구해서 저장한다.)
*/

public class StudentTest {
	
	// 등수 구하는 메서드
	public void setRanking(List<Student> studentList) {
		
		for(Student std1: studentList) { // 등수를 구할 기준 데이터를 구하기 위한 반복문
			int rank =1; // 처음에는 1등으로 초기화하고 시작
			
			// 기준값보다 큰 값을 만나면 rank 변수값을 증가 시킨다.
			for(Student std2: studentList) { // 비교 대상을 나타내는 반복문
				if(std1.getTotal() < std2.getTotal()) {
					rank++;
				}
			}
			// 반복문이 끝나면 등수는 구해짐, 구해진 등수를 Student객체의 rank 변수에 저장
			std1.setRank(rank);
		}
	}

	public static void main(String[] args) {
		
		StudentTest test = new StudentTest();
		
		
		List<Student> st = new ArrayList<>();
		
		
		
		st.add(new Student(17681011,"박승우", 50,60,70));
		st.add(new Student(17681010,"김승우", 52,62,72));
		st.add(new Student(17681001,"이승우", 50,60,70));
		st.add(new Student(17681002,"최승우", 51,62,70));
		st.add(new Student(17681005,"허승우", 59,63,70));
		st.add(new Student(17681054,"배승우", 90,20,71));

		test.setRanking(st);
		System.out.println("정렬전...");
		
		for (Student student : st) {
			System.out.println(student);
		}
		
		System.out.println();
		System.out.println("학번 오름차순 정렬");
		
		Collections.sort(st);
		
		for (Student student : st) {
			System.out.println(student);
		}
		
		System.out.println();
		
		System.out.println("총점의 역순 정렬");
		
		Collections.sort(st, new SortByTotal());
		for (Student student : st) {
			System.out.println(student);
		}
		System.out.println();
		
//		int rank =1;
//		
//		for (int i = st.size()-1; i >= 0; i--) {
//			st.get(i).setRank(rank);
//			rank++;
//		}
//		
//		System.out.println("등수기입");
//		for (Student student : st) {
//			System.out.println(student);
//		}
	}

}


class SortByTotal implements Comparator<Student>{
	
	@Override
	public int compare(Student o1, Student o2) {
		
		if(o1.getTotal() > o2.getTotal()) {
			return 1;
		}else if(o1.getTotal() < o2.getTotal()) {
			return -1;
		}else if(o1.getTotal() == o2.getTotal()){
			if(o1.getName().compareTo(o2.getName()) >0 ) {
				return 1;
			}else if(o1.getName().compareTo(o2.getName()) <0) {
				return -1;
			}else {
				return 0;
			}
		}else {
			return 0;			
		}
		
//		if(o1.getTotal() == o2.getTotal()) {
//			return o1.getName().compareTo(o2.getName());
//		}else if(){
//			
//		}
	}
}
