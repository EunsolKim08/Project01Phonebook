package Project1.ver08;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneInfo implements Serializable  {
	String name;
	String phoneNumber;
	Scanner sc = new Scanner(System.in);
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
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
	

	public void showInfo() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phoneNumber);
	}
	/*
	 hashCode(): 객체가 가진 고유한 주소값을 정수형으로 반환해준다.
	 */
	@Override
	public int hashCode() {
		//학번으로 해쉬코드의 값을 비교한다.
		int nameHashCode = name.hashCode();
		//System.out.println("nameHashCode = " + nameHashCode);
		return nameHashCode;
	}
	
	/*
	 equals(): 객체가 가진 멤버변수의 값을 비교한다.
	 */
	@Override
	public boolean equals(Object obj) {
		
		PhoneInfo pi = (PhoneInfo)obj;
		
		if(pi.name.equals(this.name)) {
			return true;
		}
		else
			return false;
	}
}
