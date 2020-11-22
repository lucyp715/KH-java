package kh.java.polymorphsim.animal;

public class Lion extends Animal {
	
	public void kick() {
		System.out.println("라이언 킥을 날립니다.");
	}
	@Override
	public void say() {
		System.out.println("안녕하세요, 라이언입니다");
	}




}
