package Project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
 동명이인이 있다고 가정했을때 3단계에서 진행한 배열을 이용해서는 구조적으로 중복을 막을수 없다. 
 이번에는 중복 저장을 허용하지 않는 HashSet<E> 클래스를 대상으로 저장이 되도록 해보자. 
 “이름이 같으면 다른 정보가 달라도 동일한 객체(인스턴스)로 간주한다”
 즉 동일한 이름을 입력하는 경우라면 덮어쓸지 여부를 물어본후 처리한다.

 */
class PhoneSchoolInfo extends PhoneInfo{
	String major;
	int grade;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	@Override
	public void showInfo() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phoneNumber);
		System.out.println("전공: " + major);
		System.out.println("학년: "+grade);
		
	}
}
class PhoneCompanyInfo extends PhoneInfo{

	String companyName;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	@Override
	public void showInfo() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phoneNumber);
		System.out.println("회사: "+ companyName);
	}
	
}

public class PhoneInfo  {
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
		HashSet<PhoneInfo> hashSet = new HashSet<PhoneInfo>(); 
		
		if(pi.name.equals(this.name)) 
			return true;
		
		return false;
		
		
		
	}
}
