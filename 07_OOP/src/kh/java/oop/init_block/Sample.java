package kh.java.oop.init_block;

import java.util.Random;

/**
 * 인스턴스변수 초기화 과정
 * 1. 타입별 기본값이 세팅 int num
 * 2. 초기값 int num = 100;
 * 3. 초기화블럭에서 대입한 값 int num=100; 아래에 {}
 * 4. 생성자(객체생성시 호출되는 메소드)에서 대입한 값
 * 
 * 클래스 변수 초기화 과정
 * 1. 타입별 기본값
 * 2. 초기화
 * 3. 초기화블럭에서 대입한 값
 * 
 */



public class Sample {
	
//	static int sno = 111;
//	static {
//		System.out.println("static 초기화 블럭시작 : " + sno);
//		sno = 333;
//		System.out.println("static 초기화 블럭끝 : " + sno);
//	}
	
	
	
	
	int num = 100;
	//인스턴스변수의 초기화블럭
	{
		System.out.println("초기화블럭 시작 : " + num);
		Random rnd = new Random();
		num = rnd.nextInt();
		
		System.out.println("초기화블럭 끝 : " + num);
	}
	
	//생성자 : 리턴값없고, 클래스명과 메소드명이 동일
	public Sample() {
		System.out.println("생성자 시작 : " + num);
		num = 300;
		System.out.println("생성자 끝 : " + num);
		
	}

}
