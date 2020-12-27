package kh.java.polymorphsim.animal;

public class Lion extends Animal implements Barkable, Runnable{
	
	public void kick() {
		System.out.println("라이언 킥을 날립니다.");
	}
	
	@Override
	public void say() {
		System.out.println("안녕하세요, 라이언입니다.");
	}
	@Override
	public void run() {
		System.out.println("사자가" + NUM_OF_LEGS + "다리로 엄청 빠르게 달립니다");
	}
	
	@Override
	public void bark() {
		System.out.println("사자가 크아아악!!");
	}
}


