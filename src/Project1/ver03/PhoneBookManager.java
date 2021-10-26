package Project1.ver03;

import java.util.Scanner;
import Project1.ver03.PhoneInfo;

public class PhoneBookManager{
	Scanner sc = new Scanner(System.in);
	
	PhoneInfo[] person; 
	
	int numOfPerson = 0;
	
	
	public PhoneBookManager(int num) {
		person = new PhoneInfo[num];
	}

	public void dataInput() {
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름: "); 
		String name = sc.nextLine();
		System.out.print("전화번호: ");
		String phoneNumber= sc.nextLine();
		System.out.print("생년월일: "); 
		String birthday= sc.nextLine();
	
	person[numOfPerson++] = new PhoneInfo(name,phoneNumber,birthday);
		
	}
	public void dataSearch() {
		System.out.printf("검색할 이름을 입력하세요: ");
		String findName = sc.nextLine();
		boolean isFind = false;
		for(int i = 0; i<numOfPerson;i++) {
			if(findName.equals(person[i].name)) {
				person[i].showInfo();
				isFind = true;
				System.out.println("데이터 검색이 완료되었습니다.");
			}
		}
		if(isFind == false) {
			System.out.println("찾는 데이터가 없습니다.");
		}
		
	}
	public void dataDelete() {
		System.out.println("삭제할 이름을 입력하세요: ");
		String findName = sc.nextLine();
		int deleteIndex = -1;
		
		for(int i = 0; i< numOfPerson; i++) {
			if(findName.equals(person[i].name)) {
				person[i] = null;
				deleteIndex = i;
				numOfPerson--;
			}
		}
		if(deleteIndex == -1) {
			System.out.println("삭제할 정보가 없습니다.");
		}
		else {
			for(int i = deleteIndex; i<numOfPerson;i++) {
				person[i] = person[i+1];
			}
			System.out.println("데이터 "+ deleteIndex +"가 삭제되었습니다.");
		}
	}
	public void dataAllshow() {
		
		for(int i = 0; i <numOfPerson;i++) {
			person[i].showInfo();
		}
		System.out.println("==전체 정보가 출력되었습니다==");
	}
}
