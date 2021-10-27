package Project1.ver05;
import java.util.Scanner;
/*
 기존 프로그램은 메뉴입력을 할 때 이름이 부여된 상수가 아닌 정수로 처리되고 있다.
때문에 Ver05 에서는 interface 기반의 상수표현에 의한 처리를 해보도록 한다. 이를 통하여 코드는 보다 명확해 질 것이다.

	1.데이터입력
	2.데이터검색
	3.데이터삭제
	4.출력
	5.프로그램종료

	1.일반
	2.학교동창
	3.회사동료
 */


public class PhoneBookManager {

Scanner sc = new Scanner(System.in);
	
	PhoneInfo[] per; 
	
	int numOfPerson = 0;
	
	
	public PhoneBookManager(int num) {
		per = new PhoneInfo[num];
	}


	public void dataInput() {
		
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.printf("선택>>");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		 case Manager.NORMAL:
			System.out.print("이름: "); 
			String name = sc.nextLine();
			System.out.print("전화번호: ");
			String phoneNumber= sc.nextLine();
				
			per[numOfPerson++] = new PhoneInfo(name,phoneNumber);
			System.out.println("데이터입력이 완료되었습니다.");
			break;
		 
		 case Manager.SCHOOLMATE:
			 System.out.print("이름: "); 
			 String name2 = sc.nextLine();
			 System.out.print("전화번호: ");
			 String phoneNum2= sc.nextLine();
			 System.out.print("전공: ");
			 String major = sc.nextLine();
			 System.out.print("학년: ");
			 int grade= sc.nextInt();
			 per[numOfPerson++] = new PhoneSchoolInfo(name2,phoneNum2,major,grade);
			 System.out.println("데이터입력이 완료되었습니다.");
			 break;
		 
		 case Manager.COMPANY:
			 System.out.print("이름: "); 
			 String name3 = sc.nextLine();
			 System.out.print("전화번호: ");
			 String phoneNum3= sc.nextLine();
			 System.out.print("회사: ");
			 String companyName = sc.nextLine();
			 per[numOfPerson++] = new PhoneCompanyInfo(name3,phoneNum3,companyName);
			 System.out.println("데이터입력이 완료되었습니다.");
			 break;
		 
		 default:
			 System.out.println("잘못입력하셨습니다.");
			 return;
		 
		}	
	}
	
	public void dataSearch() {
		System.out.printf("검색할 이름을 입력하세요: ");
		String findName = sc.nextLine();
		sc.nextLine();
		boolean isFind = false;
		for(int i = 0; i<numOfPerson;i++) {
			if(findName.equals(per[i].name)) {
				per[i].showInfo();
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
		sc.nextLine();
		int deleteIndex = -1;
		
		for(int i = 0; i< numOfPerson; i++) {
			if(findName.equals(per[i].name)) {
				per[i] = null;
				deleteIndex = i;
				numOfPerson--;
			}
		}
		if(deleteIndex == -1) {
			System.out.println("삭제할 정보가 없습니다.");
		}
		else {
			for(int i = deleteIndex; i<numOfPerson;i++) {
				per[i] = per[i+1];
			}
			System.out.println("데이터 "+ deleteIndex +"가 삭제되었습니다.");
		}
	}
	
	public void dataAllshow() {
		
		for(int i = 0; i <numOfPerson;i++) {
			per[i].showInfo();
		}
		System.out.println("==전체 정보가 출력되었습니다==");
	}
	
	public void programEnd() {
		System.out.println("프로그램이 종료됩니다.");
	}
}
