package Project1;
import java.util.InputMismatchException;
import java.util.Scanner;
import Project1.ver06.PhoneBookManager;
/*
-예외처리1 : 메뉴를 입력할 때 1~5이외의 정수를 입력했을경우 MenuSelectException(개발자정의) 예외를 발생시키고 이를 적절히 처리해보자.

-예외처리2 : 메뉴를 선택할 때 정수대신 문자열을 입력하면 InputMismatchException 예외가 발생될것이다. 이를 적절히 예외처리 해보자.
-예외처리3 : 이클립스에서는 검색결과가 없을때 NullPointerException이 발생한다. 이를 적절히 처리해보자.(테스트시 발생여부가 확인되지 않는다면 그냥 넘어간다)

조건
- 메뉴입력은 nextInt(); 를 사용한다.
- 예외가 발생할 경우 메시지를 띄워주고 메뉴를 재선택 하도록 처리한다. 즉 프로그램이 종료되지 않도록 한다.

*/

class MenuSelectException extends Exception {
	public MenuSelectException() {
		super("메뉴선택 오류.\n1~5사이의 정수를 다시 선택하세요.");
	}
}

public class PhoneBookVer06 {

	public static void printMenu() {
		System.out.println("선택하세요..");
		System.out.println("1.데이터입력");
		System.out.println("2.데이터검색");
		System.out.println("3.데이터삭제");
		System.out.println("4.주소록출력");
		System.out.println("5.프로그램종료");
	}

	public static void main(String[] args) throws MenuSelectException {
		
		PhoneBookManager mg = new PhoneBookManager(100);
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
					MenuSelectException ex = new MenuSelectException();
					throw ex;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("숫자로만 입력해야 합니다.");
				e.printStackTrace();
				System.exit(0);
			}
			catch(MenuSelectException e) {
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
