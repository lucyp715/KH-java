package ncs.test6;

public class Customer extends Thread {
	private Data data;
	
	public Customer(){
		
	}
	
	public Customer(Data data){
		this.data = data;
	}
	
	@Override
	public void run(){
		for(int i=0; i<10; i++){
			try {
				int num = data.getValue();
			} catch (EmptyException e) {
				System.out.println(e.getMessage());
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
