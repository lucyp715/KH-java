package kh.java.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * Exception을 try~catch구문을 이용해서 처리
 * - > 프로그램 비정상 종료를 방지
 * @author soyeo
 *
 */

public class ExceptionTest {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionTest e = new ExceptionTest();
//		e.test1();
//		e.test2();
//		e.test3();
//		e.test4();
//		e.test5();
		e.test6();
		
		System.out.println("===프로그램 정상 종료===");

	}
	/**
	 * CheckedException
	 * 예외처리 강제화
	 */
	public void test6() {
		String fileName = "test.txt";
		
		try {
			FileReader fr = new FileReader(fileName);
			//FileReader는 file을읽어오는 자바
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}//java.io.FileNotFoundException: test.txt (지정된 파일을 찾을 수 없습니다)
		}
	/**
	 * @실습문제 : 사용자에게 두 정수를 입력받고,
	 * 두수의 합, 차, 곱, 나머지를 출력
	 * 이를 반복제공할 것.
	 * 
	 * 정수1: 7
	 * 정수2: 3
	 * -> 합: 10, 차:4, 곱:21, 몫:2, 나머지:1
	 * -> 계속하시겠습니가?(y/n):y
	 */
	public void test5() {
		
		while(true)
		try {
			System.out.println("정수 1 입력: ");
			int num1 = sc.nextInt();
			System.out.println("정수 2 입력: ");
			int num2 = sc.nextInt();
			
			System.out.printf("합: %d, 차:%d, 곱%d, 몫:%d, 나머지:%d%n",num1 + num2,
					num1 - num2,num1 * num2,num1 / num2, num1 % num2);
			
			System.out.println("계속 하시겠습니까? (y/n) : ");
			char yn = sc.next().toLowerCase().charAt(0);
			
			if(yn == 'n')  
				break;
		
		} catch(InputMismatchException e ) {
				System.out.println("올바른 정수를 입력하세요 ");
				sc.next();//잘못입력값 버 퍼에서 지우기
		} catch(Exception e ) {
				System.out.println("처리중 오류가 발생.다시 시작 ");
				}
		
	}
	
	/**
	 * try~ catch블럭에서 변수선언
	 */
	public void test4() {
		int x = 0; 
		//밖에다가 선언하면 전부 사용가능 블럭블럭 마다 각자 사용하기때문
		 
		while(true) {
			try {
			System.out.println("정수 입력 : ");
			 x = sc.nextInt();
			break;
			} catch(Exception e ) {
				System.out.println("유효한 정수를 입력해주세요."); 
				//전부 다른 블럭 try 와 catch 전부
	//			e.printStackTrace(); //에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다.
				
				//버퍼비우기용
				sc.next();
			}
			 
		
		if( x % 2 == 0) //블럭안에서 선언한 int는 밖에서 사용할 수 없다 전부 다른 블럭
			System.out.println("짝수 입니다.");
		else
			System.out.println("홀수 입니다.");
	}
	}
	

	/**
	 * finally
	 * 예외가 발생하든 안하든 무조건 실행되는 구문.
	 * 사용한 자원 반납용도로 사용
	 * try절안에서 return(조기리턴)사용시에도 실행된다.
	 */
	public void test3() {
		System.out.println(1);
		try {
			System.out.println(2);
			
			String s = null;
	//	System.out.println(s.length());
			
			if(true)
				return;//조기리턴
			
			System.out.println(3);
		}catch(Exception e) { // 예외 전부포함
			System.out.println(4);
			
		} finally{
			//예외가 발생하든 안하든 무조건 실행되는 구문.
			System.out.println("finally");
		}
		System.out.println(5);
	}
	/**
	 * 
	 * catch절 작성요렁
	 * 1. 상속관계가 없다면 순서는 상관없다.
	 * 2. 상속관계가 있따면, 자식-부모클래스 순으로 작성
	 * 3. 다형성이 적용되므로, 부모예외 클래스 catch절에서 자식에외객체를 처리할 수있다.
	 */
	public void test2() {
		System.out.println(1);
		try {
			System.out.println(2);
			
			String s = null;
			System.out.println(s.length());
			
			int[] arr = new int[3];
			System.out.println(arr[3]);
			
			System.out.println(3);
		} catch(NullPointerException e) {
			System.out.println(4);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(5);
		} catch(RuntimeException e) {
			
		} catch(Exception e) {
			
//		} catch(RuntimeException e) {
					
		} catch(Throwable e) {
			
		}
		
		System.out.println(6);
	}
	
	public void test1() {

	try {
		//예외가 발생할 수 있는 코드작성
		System.out.println("정수 1 입력: ");
		int num1 = sc.nextInt();
		System.out.println("정수 2 입력: ");
		int num2 = sc.nextInt();
		
		System.out.printf("%d / %d => %d%n",num1,num2,num1/num2);
		
	
	}catch(ArithmeticException e) {
		//해당예외가 발생했을 경우 처리구문 -> try안에서 예외가 발생하면 출력 발생하지않으면 안나옴
		System.out.println("ArithmeticException이 발생!");
		System.out.println("정수 2는 0일 수 없습니다");
		System.out.println("유효한 정수를 입력하셔야합니다 "+ e. getMessage());
		// 출력 ->정수 2는 0일 수 없습니다/ by zero          원래 빨간 줄 오류처럼 가능
		System.out.println();
		
		
	}catch(InputMismatchException e) {
		//해당예외가 발생했을 경우 처리구문 -> try가 해당예외 발생시 뒤 건너뛰고 해당예외 catch를 출력
		System.out.println("유효한 정수를 입력하셔야합니다 "+ e. getMessage()); 
		//출력 ->유효한 정수를 입력하셔야합니다 null
		//e. getMessage() 어떤에러메세지인지 알려줌
		// java.lang.ArithmeticException: / by zero 0으로 나눌수없다는 오류메세지
	}

	}

}
