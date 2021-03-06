package Project1.ver03;

import java.util.Scanner;

/*
객체배열을 이용해서, 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경하시오.
다음과 같은 기능을 추가로 삽입한다.
저장 : 이름, 전화번호, 생년월일 정보를 대상으로 저장의 과정을 진행한다.
검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 출력한다.
삭제 : 이름을 기준으로 데이터를 찾아서 삭제의 과정을 진행한다. 단 배열의 중간에 저장된 데이터를 삭제할경우 해당 요소의 뒤에 저장된 요소들을 한칸씩 앞으로 이동시키는 형태로 삭제를 진행한다.
[1,2,3,4,5] 좌측배열에서 인덱스 3을 지웠다면 [1,2,4,5] 처럼 되어야 한다.

끝으로 저장, 검색, 삭제의 기능을 담당하는 PhoneBookManager클래스를 정의해서 프로그램을 완성하자.

멤버메소드명 
메뉴출력 : printMenu() -- Okay
입력 : dataInput() -- Okay
검색 : dataSearch() -- Okay.

삭제 : dataDelete()
주소록전체출력 : dataAllShow()  -- Okay

*/
public class PhoneInfo {
	String name;
	String phoneNumber;
	String birthday;
	
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public void showInfo() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phoneNumber);
		System.out.println("생년월일: "+ birthday);
	}

}
