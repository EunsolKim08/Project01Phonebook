package Project1.ver06;

class PhoneSchoolInfo extends PhoneInfo{
	String major;
	int grade;
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	@Override
	public void showInfo() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phoneNumber);
		System.out.println("전공: " + major);
		System.out.println("학년: "+grade);
		
	}
}
class PhoneCompanyInfo extends PhoneInfo{

	String companyName;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	@Override
	public void showInfo() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phoneNumber);
		System.out.println("회사: "+ companyName);
	}
	
}

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
