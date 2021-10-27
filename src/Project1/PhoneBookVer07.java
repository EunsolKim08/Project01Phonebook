package Project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import Project1.ver07.PhoneBookManager;

class MenuSelectException2 extends Exception {
	public MenuSelectException2() {
		super("메뉴선택 오류.\n1~5사이의 정수를 다시 선택하세요.");
	}
}

public class PhoneBookVer07 {

	public static void printMenu() {
		System.out.println("메뉴를 선택하세요");
		System.out.println("1.주소록입력");
		System.out.println("2.검색");
		System.out.println("3.삭제");
		System.out.println("4.출력");
		System.out.println("5.프로그램종료");
	}

	public static void main(String[] args) throws MenuSelectException2 {
		
		PhoneBookManager mg = new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			printMenu();
			
			try {
				System.out.printf("선택: ");
				choice = sc.nextInt();
				sc.nextLine();
				
				if(choice ==1){
					mg. dataInput();
				}
				else if(choice == 2) {
					mg.dataSearch();
				}
				else if(choice == 3){
					mg.dataDelete();
				}
				else if(choice== 4) {
					mg.dataAllshow();
				}
				else if(choice == 5) {
					mg.programEnd();
				}
				else {
					MenuSelectException2 ex = new MenuSelectException2();
					throw ex;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("숫자로만 입력해야 합니다.");
				e.printStackTrace();
				System.exit(0);
			}
			catch(MenuSelectException2 e) {
				e.printStackTrace();
			}
			catch(NullPointerException e) {
				System.out.println("검색결과가 없습니다.");
				e.printStackTrace();
				System.exit(0);
			}
			catch(Exception e) {
				System.out.println("예외가 발생하였습니다.");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
