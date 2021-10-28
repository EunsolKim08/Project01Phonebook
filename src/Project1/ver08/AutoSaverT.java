package Project1.ver08;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class AutoSaverT extends Thread {
	HashSet<PhoneInfo> hashset = new HashSet<PhoneInfo>(); 
	
	public AutoSaverT() throws Exception {
		
		
		
	
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("쓰레드 실행 시작");
			try {
				PrintWriter out = new PrintWriter(
						new FileWriter("src/Project1/ver08/AutoSaveBook.txt"));
				sleep(3000);
				System.out.println("3초마다 자동저장!!");
				
			}catch(InterruptedException e) {
				System.out.println("자동 저장시 오류발생");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
