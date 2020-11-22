package kh.java.math;

public class MathTest {

	public static void main(String[] args) {
		
		MathTest m = new MathTest();
//		m.test1();
		m.test2();
		
	}
	/**
	 * 반올림
	 * 정수형 long을 리턴
	 * 
	 */
	public void test2() {
		double num = 94.53;
		long result = Math.round(num);
		System.out.println(result); //95
		
		
		//94.53 * 10 -> 945.3 -> 945 / 10 -> 94.5 
		//정수 나누기 정수는 무조건 정수 / 실수 나누기 실수는 무조건 실수
		double dResult = Math.round(num * 10) / 10.0;
		System.out.println(dResult); //->94.5
		
		//@실습문제 " 123.456 -> 반올림처리해서 소수점이하 둘쨰자리까지
		//123.46
		num = 123.456;
		dResult = Math.round(num * 100) /100.0;
		System.out.println(dResult); // ->123.46
		
		
	}
	/**
	 * 올림 / 버림
	 */
	public void test1() {
		double num = 7.8;
		double result = Math.ceil(num);
		System.out.println(result); // 8.0
		
		result = Math.floor(num);
		System.out.println(result); // 7.0
		
		//부동소수점 방식처리
		num = 4.567; //4.6
		//4.567 * 10 -> 45.67 -> 46.0 / 10 -> 4.6
		result = Math.ceil(num * 10) / 10;
		System.out.println(result);
		
		//버림 소수점이하 둘쨰자리까지 표현 4.56
		result = Math.floor(num * 100) / 100;
		System.out.println(result);
		
	}
}
