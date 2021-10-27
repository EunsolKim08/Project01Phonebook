package Project1.ver04;
/*
 -PhoneInfo 클래스에서 생일과 관련된 멤버변수와 코드를 삭제한다.
 -다음 2개의 클래스를 추가한다.
 #  Class PhoneSchoolInfo extends PhoneInfo{
 String 전공;
 Int 학년;
 }
 #  Class PhoneCompanyInfo extends PhoneInfo {
 String 회사명;
 }
 -프로그램의 흐름을 담당하는  PhoneBookManager 클래스를 정의한다.
 -나머지는 실행결과를 보고 확인하도록 한다.

 */
import java.util.Scanner;

public class PhoneInfo  {
	String name;
	String phoneNumber;

	
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

}
