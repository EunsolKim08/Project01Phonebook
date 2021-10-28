package Project1.ver08;

public class AutoSaverT extends Thread{

	@Override
	public void run() {
		while(true) {
			System.out.println("쓰레드 실행 시작");
			try {
				sleep(3000);
				System.out.println("3초마다 자동저장!!");
			}catch(InterruptedException e) {
				System.out.println("자동 저장시 오류발생");
				e.printStackTrace();
			}
		}
	}
}
