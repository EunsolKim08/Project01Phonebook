package Project1.ver06;

public class PhoneCompanyInfo extends PhoneInfo{

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