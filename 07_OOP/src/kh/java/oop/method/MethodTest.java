package kh.java.oop.method;

/**
 * 
 * method
 * -클래스메소드 static
 * -인스턴스메소드 non-static
 * 
 * *static자원(field,method)은 non-static자원(field, method)를 참조할 수 없다.
 *
 */
public class MethodTest {
	static int sno =99;
	int num = 100;
	
	public static void main(String[] args) {
		MethodTest m = new MethodTest();
//		m.instanceMethod();
		
		MethodTest.classMethod();
		
	}
	
	public static void classMethod() {
		System.out.println(sno);	//99
		//System.out.println(num); //인스턴스변수 사용불가 
		//instanceMethod();
	}
	/**
	 * instance메소드에서는 static /non-static자원 모든 사용가능
	 * 
	 */
	public void instanceMethod() {
	System.out.println(sno);	//99
	System.out.println(num);	// 100
	}

}