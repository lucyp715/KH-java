package kh.java.polymorphsim.animal;

public class Tiger extends Animal{
	
	public void punch() {
		System.out.println("호랑이 펀치를 날립니다.");
	}

	@Override
	public void say() {
		System.out.println("안녕하세요, 호랑이입니다");
	}
}
