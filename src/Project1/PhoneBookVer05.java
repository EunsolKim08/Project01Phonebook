package Project1;

import java.util.Scanner;

import Project1.ver05.PhoneBookManager;

public class PhoneBookVer05 {

	public static void printMenu() {
		System.out.println("선택하세요..");
		System.out.println("1.데이터입력");
		System.out.println("2.데이터검색");
		System.out.println("3.데이터삭제");
		System.out.println("4.주소록출력");
		System.out.println("5.프로그램종료");
	}

	public static void main(String[] args) {
		
		PhoneBookManager mg = new PhoneBookManager(100);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			printMenu();
			
			System.out.printf("선택: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:{
				mg. dataInput();
				break;
			}
			case 2:{
				mg.dataSearch();
				break;
			}
			case 3: {
				mg.dataDelete();
				break;
			}
			case 4: {
				mg.dataAllshow();
				break;
			}
			default:
				mg.programEnd();
				return;
			}
		}
		
	}

}
