package ncs.test6;

public class Provider extends Thread{
	private Data data;
	
	public Provider(Data data){
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			int rnum = (int)(Math.random()*100)+1;
			data.setValue(rnum);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
