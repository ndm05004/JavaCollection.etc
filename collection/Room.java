package kr.or.ddit.basic;

public class Room {
	
	private int roomNum;
	private String roolType;
	private String name;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Room(int roomNum, String roolType) {
		super();
		this.roomNum = roomNum;
		this.roolType = roolType;
		this.name = "-";
	}


	public Room(int roomNum, String roolType, String name) {
		super();
		this.roomNum = roomNum;
		this.roolType = roolType;
		this.name = name;
	}
	
	
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getRoolType() {
		return roolType;
	}
	public void setRoolType(String roolType) {
		this.roolType = roolType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return roomNum + "\t" + roolType + "\t" + name;
	}
	
	
}
