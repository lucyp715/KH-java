package ncs.test6;

public class MultiThreadTest {

	public static void main(String[] args) {
		//data를 공유하는 Provider와 Customer객체 생성  : Thread객체 생성함.
		Data data  = new Data();
		Thread putThread  = new Provider(data);
		Thread getThread  = new Customer(data);
		
		//쓰레드 구동
		putThread.start();
		getThread.start();
		
	}

}
