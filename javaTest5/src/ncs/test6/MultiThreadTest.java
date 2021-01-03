package ncs.test6;

public class MultiThreadTest {

	public static void main(String[] args) {
		
		Data data = new Data();
	
		Thread putThread;
		Thread getThread;
		 
	
		putThread = new Thread(new Provider(data));
		getThread = new Thread(new Customer(data));
	
		 
		putThread.start();
		 
		getThread.start();


	}

}
