package kh.java.loop;

/*
 * 초기식
 * while(조건식){
 * 		//반복실행구문
 * 		증감식
 * }
 * 
 */
public class WhileLoopTest {
	
	public static void main(String[] args) {
		WhileLoopTest w = new WhileLoopTest();
		w.test1();
	}
	
	public void test1() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i); //-> 1~10까지 출력
		}
//		System.out.println(i); // i는 for문 안에 선언되었으므로 외부접근 불가
		System.out.println("----------------------------");
		
		int j = 1;
		while(j <= 10) {
			System.out.println(j);
			j++;
		}
		
		System.out.println("----------------------------");
		// 10 9  8
		int a = 10;
		while( a >= 1) {
			System.out.println(a);
			a--;
		}
		System.out.println("----------------------------");
		
		// 1 3 5 7 9 11 15 17 19
		int b =1;
		while( b <= 19) {
			System.out.println(b);
			b+=2;
		}
		System.out.println("----------------------------");
		//20 18 16 14 12 
		int c =20;
		while( c >=2) {
			System.out.println(c);
			c-=2;
	}
		
		

	}
}
