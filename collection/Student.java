package kr.or.ddit.basic;

/*문제) 학번, 이름 국어점수, 영어점수, 수학점수, 총점, 등수를 갖는 Student 클래스를 만든다.
이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 인수로 받아서
초기화 처리를 한다.

이 Student객체는 List에 저장하여 관리한다.

List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준도
구현하여 정렬된 결과를 출력하시오
(등수는 List에 전체 데이터가 추가된 후에 구해서 저장한다.)
*/

public class Student implements Comparable<Student>{
	
	private int num;
	private String name;
	private int koreanScore;
	private int englishScore;
	private int mathScore;
	private int total;
	private int rank;
	
	public Student(int num, String name, int koreanScore, int englishScore, int mathScore) {
		super();
		this.num = num;
		this.name = name;
		this.koreanScore = koreanScore;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
		this.total = koreanScore + englishScore + mathScore;

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

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return " [학번=" + num + ", 이름=" + name + ", 국어=" + koreanScore + ", 영어="
				+ englishScore + ", 수학=" + mathScore + ", 총점=" + total + ", 등수=" + rank + "]";
	}

	//List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고
	
	@Override
	public int compareTo(Student o) {
		return Integer.compare(this.num, o.getNum());
	}
	
	// 내부 정렬 기준 compare
//	@Override
//	public int compare(Student std1, Student std2){
//		return Integer.compare(std1.getNum(), std2.getNum())
//	}
}
