package ncs.test6;

public class Data {
	private int value;
	private boolean isEmpty = true;
	
	public int getValue() throws EmptyException{
		
		//현재 Data객체를 Thread-Safe상태로 만든다. 
		//isEmpty값이 서로 다른 쓰레드에 의해 간섭받지 않게 하기 위함.
		 synchronized(this){
			//최초 입력값이 없는 경우(value는 jvm이 정한 기본값 0이다.)
			if(value==0){
				//exception을 발생시키고, 이번턴은 종료된다.
				throw new EmptyException("현재 입력된 값이 없습니다. 기다리십시오.");			
			}
		
			//value는 0이 아닌 값이 담겨있지만, isEmpty가 true이므로 현재 value에는 이미 가져간 값이 담겨있다.
			//쓰레드 waiting모드 전환, 락 반납.
			if(isEmpty == true){
				try {
					wait();
					System.out.println("Customer 대기중...");
				} catch (InterruptedException e) {
					//타쓰레드의 notifyAll()로 인해 InterruptedException이 발생하면서, 다시 runnable모드 전환.
					e.printStackTrace();
				}
			}
			
			//담겨진 값을 가져가면서 isEmpty를 다시 true로 변환하고, waiting모드의 타쓰레드를 깨운다. 일어나, 일해, 자식아.
			isEmpty = true;
			notifyAll();
			System.out.printf("get value : %d%n값을 꺼냈습니다. value가 비었습니다.%n", value);
			System.out.println("-----------------------------------------------------");
			return value;			
		}
			
	}

	/**
	 * 동기화처리
	 * 1. synchronized 메소드
	 * 2. synchronized block사용
	 * 
	 * data 해당객체를 임계영역으로 설정하는 것.
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		
		synchronized(this){
			//초기값일때인 true를 포함해 한턴마다 값을 매개변수값을 value필드에 새로 대입 한다.
			//단, 아직 타쓰레드가 값을 가져가지 않았다면, waiting모드로 전환함.
			if(isEmpty == true){
				this.value = value;
				isEmpty = false;
				notifyAll();	//waiting모드의 타쓰레드를 깨움.
				System.out.printf("put value : %d%n값이 입력되었습니다.%n", value);
			}
			
			try {
				//타쓰레드가 깨울때까지 좀 쉬겠음.
				//현재 쓰레드를 대기상태로 만듬
				wait();
				System.out.println("Provider 대기중...");
			} catch (InterruptedException e) {
				//타쓰레드의 notifyAll()로 인해 InterruptedException이 발생하면서, 다시 runnable모드 전환.
				//즉, 이번턴을 종료하고, 다음턴에 setValue메소드 호출.
				e.printStackTrace();
			}

		}
	}
	
	
}
