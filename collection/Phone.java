package kr.or.ddit.basic;

public class Phone {
	
	private String name;
	private String addr;
	private String tel;
	
	public Phone() {}
	
	public Phone(String name, String addr, String phonNum) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = phonNum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "이름 " + name + ", 주소 " + addr + ", 전화번호" + tel + "]";
	}
	
	

}
