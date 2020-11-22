package kh.java.args;

/**
 * 
 * 매개변수 parameter : 변수(공간) 메소드 선언부 작성한 변수
 * 매개인자/인수 arguments : 값 메소드 호출부에서 전달한 값
 *
 */

public class ArgumentsTest {
	
	
	/**
	 * JVM이 프로그램의 main메소드를 호출할떄, String[]을 전달한다.
	 * 
	 * 프로그램 시작시  사용자가 프로그램 전달한 문자열을 공백기준으로 잘라서,
	 * 문자열배열로 전달한다.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		ArgumentsTest a = new ArgumentsTest();
//		a.test1(3);
		
//		for(int i =0;  i < args.length; i++) {
//			System.out.println(i + " : " + args[i]);
			
//		}
	a.adder(args);
	}
	/**
	 * 1 2 3 4 5 6 7 8 9 10
	 * 
	 * 
	 * @param args
	 */
	public void adder(String[] args) {
		int sum = 0;
		for(int i = 0; i < args.length; i++)  {
			//문자열 -> 정수 형변환
			//(int)는 숫자로 차용 가능한 걸 변환할 떄 사용하는것
			//아래는 String 값을 꺼내왔으므로 따로 형변환을 해야한다.
			sum += Integer.parseInt(args[i]);
		}
		//run configuratons →JaggedArrayTeset → Argument →program argument->1~10입력
		System.out.println(sum); // 55
	}

	public void test1(int num) {
		
	}
}
