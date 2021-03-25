package kh.java.exception;

import java.util.Scanner;

public class AdultGame {

	public static void main(String[] args) {
		new AdultGame().start(); // 변수따로 안만들고 둘 합쳐버림
		
		System.out.println("----이용해 주셔서 감사합니다.---");

	}
	public void start() {
		//1. 성인인증
		try {
			checkAge();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		//2. 게임시작
		System.out.println("뚜루뜨루루루,,,,,,,,,,,");
	}
	
	public void checkAge() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		//20미만이면 예외를 던짐
		if(age < 20)
			throw new UnderAgeException("미송년자 입니다: " + age);
	}                //내가 직접 커스텀한 exception으로 
	                 //자바jdk UnderAgeException이라는거 원래 없다
	
	
	
	public void start_() {
		//1. 성인인증
		boolean isAdult = chkeckAge_();
		if(!isAdult){
			System.out.println("성인만 이용가능합니다.");
			return;
		}
		//2.게임시작
		System.out.println("----게임을 시작합니다----");
	}
	public boolean chkeckAge_() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		return age >= 20 ? true : false;
	}
}
