package ncs.test6;

public class Data {

	private int value;
	private boolean isEmpty = true;
	
	public Data() {
	}
	public synchronized void setValue(int value) {
		if(isEmpty) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
		

	public synchronized int getValue() throws EmptyException{
		if(isEmpty) {	
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("현재 입력된 값이 없습니다. 기다리십시오...");
			}
		}
		return value;
	}
}



