package Project1;

import java.util.Scanner;
import Project1.ver02.PhoneInfo;

public class PhonebookVer02 {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice ;
		
		System.out.println("선택하세요..");
		System.out.println("1.데이터입력");
		System.out.println("2.프로그램 종료");
		System.out.printf("선택: ");
		choice = sc.nextInt();
		
		while(choice == 1) {
			if(choice == 1) {
				System.out.printf("이름: ");  
				String name = sc.nextLine();
				sc.nextLine();//버퍼 삭제하려고 했더니 이름이 인식이 안됨
		
				System.out.printf("전화번호: ");
				String phoneNumber = sc.nextLine();
		
				System.out.printf("생년월일: ");
				String birthday = sc.nextLine();
				
				PhoneInfo pi2 = new PhoneInfo(name,phoneNumber,birthday);
				pi2.showPhoneInfo(name, phoneNumber, birthday);
				
				System.out.printf("선택: ");
				choice = sc.nextInt();
			}
		}
		
		System.out.println("프로그램이 종료되었습니다.");
		
		
		
		
		
	}

}
