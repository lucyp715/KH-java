package kh.java.type;
/**
 * 변수란? 메모리(RAM)에 하나의 값을 기록하기 위한 물리적 공간
 * 
 *자료형
 *1.기본형 Primitive Type
 * - 실제 데이터, 값(Literal)을 저장
 * - 크기가 각각 다른 8가지 타입(논리형, 문자형, 정수형, 실수형)
 *
 *2.참조형 Reference Type
 * - 8가지 기본형을 제외한 나머지
 * - 주소값을 저장
 * - 4byte
 *
 */
public class PrimitiveType {

	public static void main(String[] args) {
		
			PrimitiveType p = new PrimitiveType();
			p.test1();
			p.test2();
			p.test3();
			p.test4();
			p.test5();
	}
	
	/**
	 * Date Overflow
	 * 지정한 타입의 범위를 넘어선 값이 오게되면, 최소값으로 다시 돌아간다. 
	 */
	public void test5() {
		int iNum = Integer.MAX_VALUE;
		iNum  = iNum + 1;
		System.out.println("iNum = " + iNum);
		
	}
	/**
	 * 상수 constant
	 * 한번 값이 정해짐녀 변경 불가
	 * 
	 */
	public void test4() {
		final int NUM = 100;
//		NUM = 200;  final을 쓰면 바꿀수 없다. 변경되면안돼는 것에 쓴다
		
		
		final int AGE_LIMIT = 20;
		int tomAge = 18;
		int janeAge = 24;
		boolean tomAllowed = tomAge > AGE_LIMIT;
		boolean jandAllowed = janeAge > AGE_LIMIT;
		
		//jdk정수형의 표현 범위
		System.out.println("byte : " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		System.out.println("short : " + Short.MIN_VALUE + " ~ " +Short.MAX_VALUE);
		System.out.println("int : " + Integer.MIN_VALUE + " ~ " +Integer.MAX_VALUE);
		System.out.println("long : " + Long.MIN_VALUE + " ~ " +Long.MAX_VALUE);
	}
	/**
	 * 초기화
	 * 변수의 선언과 값대입 동시에 하는 것.
	 * 
	 */
	public void test3() {
		double dNum = 123.456;
		System.out.println("dNum = " + dNum);
		
		//여러분의 이름 마지막글자를 last 변수에 초기화
		char last = '연';
		System.out.println("last = " + last);
		
		//올해를 표현할 변수 
		int year = 2020;
		System.out.println("year = " + year);
	}
	
	public void test2() {
		//같은 자료형은 한줄에 동시 선언
//		int a, b, c;		
		int a;
		int b;
		int c;
		
		a = 10;
		b = 20;
		c = a + b;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		
		
		boolean bool;
		bool = a < b; //a가 b보다 작은가? b가 a보다 큰가?(x)
		bool = a > b; //a는 b보다 큰가?
		bool = a >= b; //a는 b보다 크거나 같은가?
		bool = a <= b; //a는 b보다 작거나 같은가?
		bool = a == b; //a는 b와 같은가?
		bool = a != b; //a는 b와 같지 않은가? 같지않으면 true
		bool = !false; //반전
		bool = !(a == b);
		System.out.println("bool = " + bool);
	}
	/**
	 * 1bit
	 * 
	 * 1byte : 8bit
	 * 1kb : 1024byte
	 * 1mb : 1024kb
	 * 1gb : 1024mb
	 * 1tb : 1024gb
	 * 1peta
	 * 1exa
	 * 1zetta
	 * 1yotta
	 * 
	 * 기본형의 종류
	 * 1. 문자형 
	 * 		char 2byte 0 ~ 65535 'a' '가' '馬' '3'
	 * 
	 * 2. 정수형
	 * 		byte  1byte -128 ~127
	 * 		short 2byte -32768 ~32767
	 * 		int(기본형)   4byte -21억 ~21억
	 * 		long  8byte -922경 ~ 922경
	 * 
	 * 3. 실수형
	 * 		float  4byte 정밀도 소수점이하 7자리
	 * 		double(기본형) 8byte 정밀도 소수점이하 16자리
	 * 		
	 * 4. 논리형
	 * 		boolean 1byte true/false
	 * 
	 * 
	 * 변수명명규칙
	 * 1. 대소문자구분 abc Abc
	 * 2. 길이제한 없음
	 * 3. 자바예약어는 사용할 수 없다.
	 * 4. 숫자로 시작할 수 없다. name1 1name(x)
	 * 5. 특수문자 _ $만 가능.
	 * 
	 * 6. 여러단어가 조합된 경우, 단어 첫글자는 대문자로 시작 CamelCasing
	 * 7. 한글사용가능하지만, 사용하지 말것.
	 * 8. 직관적인 변수명을 사용하자
	 * 
	 * userName
	 * userAmile
	 * 
	 * 
	 * 

	 * 
	 * 
	 * 
	 */
	public void test1() {
		// 1. 변수선언
		// 2. 변수 값대입
		// 3. 변수 사용(출력)
		byte bNum;
		byte bNum12;
		short sNum;
		int iNum;
		long lNum;
		
		//대입연산자 : 우항의 값을 좌항에 대입하라
		bNum = 100;
		bNum = -100;
		bNum = 50;
//		bNum = 200; // -128 ~127까지만 표현 가능
		
		//정수는 기본적으로 int형으로 취급된다.
		//int범위를 넘어선 정수 리터럴은 L 접미어를 사용해 long타입 명시
		sNum = 32767;
		iNum = 12345678;
		lNum = 1_000__000_000_000L; //long타입을 접미어 L, l로 명시
		
		System.out.println("bNum = " + bNum);
		System.out.println("sNum = " + sNum);
		System.out.println("iNum = " + iNum);
		System.out.println("lNum = " + lNum);
		
		//실수리터럴은 기본적으로 double로 취급됨.
		//F,f접미어로 float임을 명시
		float fNum;
		fNum = 0.123f;
		fNum = 0.1234567890f;
		
		double dNum;
		dNum = 0.1234567;
		dNum = 0.12345678901234567890;
		
		System.out.println("fNum = " + fNum); //0.1234567~소수점 아래 7번쨰까지만 정확 그 뒤는 부정확
		System.out.println("dNum = " + dNum); //0.1234567890123456~소수점 아래 16번째까지만 정확
		
		char ch;
		ch = 'a';
		ch = '김';
		System.out.println("ch = " + ch);
		
		
		boolean bool;
		bool = true;
		bool = false;
		System.out.println("bool = " + bool);
	}
}
