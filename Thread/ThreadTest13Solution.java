import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ThreadTest13Solution {
	public static void main(String[] args) {
		
		Horse[] horseArr = new Horse[] {
			new Horse("01번말"),	
			new Horse("02번말"),	
			new Horse("03번말"),	
			new Horse("04번말"),	
			new Horse("05번말"),	
			new Horse("06번말"),	
			new Horse("07번말"),	
			new Horse("08번말"),	
			new Horse("09번말"),	
			new Horse("10번말")
		};
		
		GameState gs = new GameState(horseArr);
		
		for(Horse h : horseArr) {
			h.start();
		}
		
		gs.start();
		
		for(Horse h : horseArr) {
			try {
				h.join();
			}catch (InterruptedException e) {
				// TODO: handle exception
			}	
		}
		
		for(Horse h : horseArr) {
			try {
				gs.join();
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
	
	}
		
		System.out.println();
		System.out.println("경기 끝...");
		System.out.println();
		
		// 등수의 오름차순으로 정렬하기
		Arrays.sort(horseArr);
		
		for(Horse h : horseArr) {
			System.out.println(h);
		}
		
}
}


class GameState extends Thread{
	
	private Horse[] horseArr;

	public GameState(Horse[] horseArr) {
		this.horseArr = horseArr;
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			if(Horse.currentRank==horseArr.length) {
				break;
			}
			
			for(int i=1; i<=10; i++) {
				System.out.println();
			}
			
			for(int i=0; i<horseArr.length; i++) {
				System.out.print(horseArr[i].getHorsename() + " : ");
				
				for (int j = 0; j <=50; j++) {
					if(horseArr[i].getLocation()==j) { // 말의 현재위치 찾기
						System.out.print(">");						
					}else {
						System.out.print("-");						
					}
				}
				System.out.println();
			}
			
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		
		
	}
	
}



class Horse extends Thread implements Comparable<Horse>{
	
	private String horsename;
	private int rank;
	private int location;
	static int currentRank = 0;
	
	public Horse(String horsename) {
		// TODO Auto-generated constructor stub
		this.horsename = horsename;
	}
	
	public String getHorsename() {
		return horsename;
	}

	public void setHorsename(String horsename) {
		this.horsename = horsename;
	}


	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}


	@Override
	public void run() {
		
		Random rnd = new Random();
		
		for(int i=1; i<=50; i++) {
			this.location = i; // 말의 현재위치 저장
			try {
				Thread.sleep(rnd.nextInt(1000));
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		// 한 마리의 말 경주가 끝나면 현재의 등수를 구해서 저장한다.
		currentRank++;
		this.rank = currentRank;
		
	}

	
	@Override
	public String toString() {
		return "경주마" + horsename + "는(은) " + rank + "등 입니다.";
	}


	@Override
	public int compareTo(Horse o) {
		// TODO Auto-generated method stub		
		return Integer.compare(this.rank, o.getRank());
	}
}
	