package Project1.ver02;

import java.util.Scanner;

	public class PhoneInfo {
	Scanner scanner = new Scanner(System.in);

	String name; //이름
	String phoneNumber; //전화번호
	String birthday;//생년원일
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	//3개의 매개변수를 가진 생성자.
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public void showPhoneInfo(String name, String phoneNumber, String birthday)
	{
		System.out.println("입력된 정보출력...");
		System.out.println("이름:" + name);
		System.out.println("전화번호:" + phoneNumber);
		System.out.println("생년월일:" + birthday);
		
	}
}
