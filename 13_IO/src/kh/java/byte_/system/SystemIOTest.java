package kh.java.byte_.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SystemIOTest {

	public static void main(String[] args) {
		SystemIOTest s = new SystemIOTest();
//		s.test1();
		s.test2();

	}
	/**
	 * Scanner(jdk1.5)이전에는
	 * -Ststem.in 1byte
	 * -InputStreamReader byte to char : 브릿지스트림
	 * -BufferedReader 2byte : 라인단위로 처리가 가능한 readLine()메소드 제공
	 *                         엔터친 문자 통쨰로 가능
	 * 
	 * 주스트림객체를 보조스트림객체에 전달
	 * 보조스트림객체를 제어한다.
	 * 보조스트림만 반납하면, 주스트림도 함께 반납된다.
	 */
	
	private void test2() {
//		InputStreamReader isr= new InputStreamReader(System.in);
		//보조스트림에 또 보조스트림껴서 사용가능 
//		BufferedReader br = new BufferedReader(isr);
		
		//위에 두줄과 아래 한줄은 동일하다. 어짜피 만들어놓고 안쓰기때문에 아래처럼 많이사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = " "; //번수 선언 line 단위로 이루어지기 떄문
		
		try {
			int sum = 0;
			//읽어온 값이 없다면 null을 리턴
			while((line = br.readLine()) != null) {
				if("quit".contentEquals(line)) // if~break는 안되서 한번써본건
					break;                    // 안해도 댐
				System.out.println("입력값 : " + line);
				sum += Integer.parseInt(line);
			}
			System.out.println("종합 : " + sum); // ctrl+z를 눌러야지 이제 끝났다고해서
			                                   //종합 : 00 이 나오게 된다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * System.in -> System의 클래스변수 in
	 * System.out -> System의 클래스변수 out
	 */
	public void test1() {
		//사용자의 키보드에서 입력을 하면 -> 입력버퍼에 저장 ->그다음 JVM으로 넘어간다
		//입력값이 없다면 read메소드는 -1을 리턴
		//종료 단축키(윈도우: Ctrl + c, 이클립스: Ctrl + z) 사용시에도 -1리턴
		int data = 0;
		try {
//			Scanner sc = new Scanner(System.in);
//			sc.next();
//			sc.close(); //java.io.IOException: Stream closed 오류남
			//닫으라는 문구가 나와도 닫으면 안됌
		while((data = System.in.read()) != -1) {
			//data에 System.in.read()를 먼저 읽어온 다음에 데이터에 담아라. 
			//그리고 이 데이터가 -1이 아니라면  이 반복문을 반복해라
			System.out.println(data);
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		//에외적으로 표준입출력은 닫지 않는다.
//		System.in.close();
//		System.out.close();
	}
 }
}
