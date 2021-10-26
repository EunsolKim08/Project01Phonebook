package Project1;

import Project1.ver01.PhoneInfo;

public class PhonebookVer01 {

	public static void main(String[] args) 
	{
		PhoneInfo pi1= new PhoneInfo("유비", "010-1234-4567","1980-10-31");
		pi1.showPhoneInfo();
		PhoneInfo pi2 = new PhoneInfo("손오공", "010-2222-2222");
		pi2.showPhoneInfo();
	}

}
