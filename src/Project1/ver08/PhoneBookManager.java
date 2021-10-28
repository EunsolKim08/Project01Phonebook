package Project1.ver08;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
/*
 쓰레드를 통해  주소록이 텍스트 형식으로 자동저장 될 수 있도록 기능을 추가한다. 
 메인메뉴에 ‘5.저장옵션’ 을 추가한다. 
 저장옵션의 서브메뉴로 1.자동저장On, 2.자동저장Off 를 추가한다. 
 1번을 선택시 쓰레드가 시작된다. -> start()
 2번을 선택시 쓰레드가 중지된다. -> interrupt()
 만약 이미 자동저장이 실행중인데 다시 1번을 선택하면 ‘이미 자동저장이 실행중입니다’ 라고 경고메세지를 띄워준다.
 자동저장은 5초에 한번씩 이루어진다.
 해당 쓰레드는 프로그램 종료시 같이 종료되는 데몬쓰레드로 생성한다. 
 저장될파일명 : AutoSaveBook.txt
 쓰레드로 정의할 클래스명 : AutoSaverT.java

 */
public class PhoneBookManager{

Scanner sc = new Scanner(System.in);
	HashSet<PhoneInfo> hashSet = new HashSet<PhoneInfo>(); 

	int numOfPerson = 0;
	
	PhoneInfo per;
	
	public PhoneBookManager() {
		readInfo();
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
			 String name = sc.nextLine();
			 System.out.print("전화번호: ");
			 String phoneNumber= sc.nextLine();	
			 per = new PhoneInfo(name,phoneNumber);
			boolean j =  hashSet.add(per);
			 
			if(j == false) {
				System.out.println("덮어쓸까요1? Y(y) M(n)");
				String ans = sc.nextLine();
				
				if(ans.equals("y") || ans.equals("Y")) {
					hashSet.remove(per);
					hashSet.add(per);
				}
			}
			 
			System.out.println("데이터입력이 완료되었습니다.");
			 break;
		 }
		 case Manager.SCHOOLMATE:{
			 System.out.print("이름: "); 
			 String name = sc.nextLine();
			 System.out.print("전화번호: ");
			 String phoneNumber= sc.nextLine();	
			 System.out.print("전공: ");
			 String major = sc.nextLine();
			 System.out.print("학년: ");
			 int grade = sc.nextInt();
			 per = new PhoneScoolIn(name, phoneNumber, major, grade);
			boolean j =  hashSet.add(per);
			 
			if(j == false) {
				System.out.println("덮어쓸까요2? Y(y) M(n)");
				String ans = sc.nextLine();
				sc.nextLine();
				
				if(ans.equals("y") || ans.equals("Y")) {
					hashSet.remove(per);
					hashSet.add(per);
				}
			}
			 
			System.out.println("데이터입력이 완료되었습니다.");
			 break;
		 }
			 
		 
		 
		 case Manager.COMPANY:
			 System.out.print("이름: "); 
			 String name3 = sc.nextLine();
			 System.out.print("전화번호: ");
			 String phoneNumber3= sc.nextLine();
			 System.out.print("회사: ");
			 String companyName = sc.nextLine();
			 per = new PhoneCompanyInfo(name3,phoneNumber3,companyName);
			  
			if(hashSet.add(per) == false) {
				System.out.println("덮어쓸까요3? Y(y) M(n)");
				String ans2 = sc.nextLine();
				
				if(ans2.equals("y") || ans2.equals("Y")) {
					hashSet.remove(per);
					hashSet.add(per);
				}
			}
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
	public void saveInfo() {
		try{
			ObjectOutputStream out = new ObjectOutputStream
					(new FileOutputStream("src/Project1/PhoneBook2.obj"));
			
			for(PhoneInfo phi1 : hashSet) {
				out.writeObject(phi1);
			}
			System.out.println("out write실행중");
		}
		catch(Exception e) {
			System.out.println("휴대폰 정보 직렬화시 예외발생");
		}
	}
	public void readInfo() {
		try {
			ObjectInputStream in = new ObjectInputStream
					(new FileInputStream("src/Project1.ver08/PhoneBook.obj"));
			
			while(true) {
				PhoneInfo phil = (PhoneInfo)in.readObject();
				hashSet.add(phil);
				if(phil == null )break;
			}
		}
		catch(Exception e) {
			System.out.println("더 이상 읽을 객체가 없습니다.");
		}
		System.out.println("친구 정보가 복원되었습니다.");
	}
	
	public void dataSave() {
		AutoSaverT dt = null;
		System.out.println("저장옵션을 선택하세요. ");
		System.out.println("1. 자동저장On 2.자동저장Off");
		System.out.printf("선택: ");
		int ch = sc.nextInt();
		System.out.println("자동저장을 시작합니다.");
		
		if(ch == 1) {
			
			if(dt== null && dt.isAlive() == false) {
				dt= new AutoSaverT ();
				dt.run();
			}
			
			else if(dt.isAlive() == true) {
				System.out.println("자동저장이 이미 실행중입니다.");
			}
			
			
		}
		if(ch == 2) {
			dt.interrupt();
			System.out.println("자동저장을 종료합니다.");
		}
	}

	public void programEnd() {
		System.out.println("프로그램이 종료됩니다.");
	}
}

