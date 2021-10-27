package Project1.ver07;
import java.util.Scanner;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class PhoneBookManager{

Scanner sc = new Scanner(System.in);
	HashSet<PhoneInfo> hashSet = new HashSet<PhoneInfo>(); 
	
	int numOfPerson = 0;
	
	PhoneInfo per;
	
	public PhoneBookManager() {
		
	}
	
	
	public void dataInput() {
		int choice;
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.printf("선택>>");
		choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		 case Manager.NORMAL:{
			 System.out.print("이름: "); 
			 String name1 = sc.nextLine();
			 System.out.print("전화번호: ");
			 String phoneNumber= sc.nextLine();	
			 
			  per = new PhoneInfo(name1,phoneNumber);
			 
			  hashSet.add(per);
			 
			System.out.println("데이터입력이 완료되었습니다.");
			 break;
		 }
		 case Manager.SCHOOLMATE:
			 System.out.print("이름: "); 
			 String name2 = sc.nextLine();
			 System.out.print("전화번호: ");
			 String phoneNumber= sc.nextLine();
			 System.out.print("전공: ");
			 String major = sc.nextLine();
			 System.out.print("학년: ");
			 int grade= sc.nextInt();
			 
			 
			 per = new PhoneSchoolInfo(name2,phoneNumber,major,grade);
			 
			 hashSet.add(per);
			 System.out.println("데이터입력이 완료되었습니다.");
			 break;
		 
		 case Manager.COMPANY:
			 System.out.print("이름: "); 
			 String name3 = sc.nextLine();
			 System.out.print("전화번호: ");
			 String phoneNumber3= sc.nextLine();
			 System.out.print("회사: ");
			 String companyName = sc.nextLine();
			
			 
			 per = new PhoneCompanyInfo(name3,phoneNumber3,companyName);
			 hashSet.add(per);
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
		
		Iterator<PhoneInfo>it = hashSet.iterator();

		while(it.hasNext()){
			PhoneInfo pi = it.next();
			if(findName.equals(pi.name)) {
				pi.showInfo();
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
		Iterator<PhoneInfo>it = hashSet.iterator();
		
		while(it.hasNext()) {
			PhoneInfo pi = it.next();
			if(findName.equals(pi.name)) {
				hashSet.remove(pi);
				System.out.println("삭제되었습니다..");
				deleteIndex =1;
			}
		}
		
		
		if(deleteIndex == -1) {
			System.out.println("삭제할 정보가 없습니다.");
		}
		
	}

	public void dataAllshow() {	
		Iterator<PhoneInfo>it = hashSet.iterator();

		while(it.hasNext()){
			PhoneInfo pi = it.next();
			pi.showInfo();
		}
	}

	public void programEnd() {
		System.out.println("프로그램이 종료됩니다.");
	}
}

