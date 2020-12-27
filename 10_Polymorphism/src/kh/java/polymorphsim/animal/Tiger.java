package kh.java.polymorphsim.animal;

public class Tiger extends Animal implements Barkable, Runnable{
	
	public void punch() {
		System.out.println("호랑이 펀치를 날립니다.");
	}

	@Override
	public void say() {
		System.out.println("안녕하세요, 호랑이입니다");
	}
	@Override
	public void run() {
		System.out.println("호랑이가" + NUM_OF_LEGS + "다리로 빠르게 달립니다");
	}
	
	@Override
	public void bark() {
		System.out.println("호랑이가 어흥");
	}
}
