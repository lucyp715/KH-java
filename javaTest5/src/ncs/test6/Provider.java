package ncs.test6;

public class Provider extends Thread {

	private Data data;
	
	public Provider(Data data) {
		this.data = data;
	}
	
		@Override
		public void run() {
			
			for(int i = 0; i < 100; i++) {
				int num = (int)(Math.random() * 100)+1;
				System.out.println("값이 입력되었습니다.");
				System.out.println("put value :" + num);
				
				data.setValue(num);
				//현재 쓰레드를 1초 중지
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
}
