package kh.java.loop;

import java.util.Scanner;

/**
 * while 초기식 -> 조건식 ->  (반복실행구문 -> 증감식).....
 * do..whiel 초기식 -> (반복실행구문 -> 증감식) -> 조건식
 *
 */

public class DoWhileLoopTeset {

	public static void main(String[] args) {
		DoWhileLoopTeset d = new DoWhileLoopTeset();
//		d.test1();
//		d.test2();
//		d.test3();
		d.test4();
		
	}
	/**
	 * @실습문제:
	 * 사용자에게 단수를 입력받아 해당 단의 구구단 출력
	 * 계쏙 여부를 입력 진행할 것
	 * 
	 * 출력할 구구단입력 ( 2~9) : 3
	 * 3 * 1 =3
	 * 3* 2 =6
	 * ...
	 * 3 * 9 = 27
	 * 계속 하시겠습니까?9y.n) : y
	 * 
	 * 출력할 구구단 입력( 2~ 9 ) :
	 * 
	 * 계속 하시겠습니가?(y/n) : n
	 * 이용해 주셔서 감사합니다.
	 * 
	 */
	
	
	public void test4() {
		Scanner sc = new Scanner(System.in);
		char yn = 'y'; //계속 여부를 묻는것
		
		do {
			System.out.println("구구단수 입력(2~9) : ");
			int dan = sc.nextInt();
			int i = 0;
		
			while(i < 10) { 
			System.out.println(dan + " * " + i + " = " + (i * dan));
			i++;
			}
			System.out.println("계속 하시겠습니다까(Y/N) : ");
			yn = sc.next().toLowerCase().charAt(0); // YN - > yn
			
	}while(yn == 'y');
		
		System.out.println("이용해주셔서 감사합니다.");
		
	}
		
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		String menu = "==========\n"
				+ "1. 참치김밥(3000원)\n"
				+ "2. 멸치김밥(2500원)\n"
				+ "3. 라뽁기(3,500)\n"
				+ "-----------------\n"
				+ "선택 : ";
				
		char yn = 'n'; //추가주문
		int choice = 0; //사용자 메뉴 선택 
		int sum = 0; // 누적합
		
		do {
			System.out.println(menu);
			choice = sc.nextInt();
			System.out.println(choice);
			
			//누적합 계산
			switch(choice) {
			case 1: sum += 3000; break;
			case 2: sum += 2500; break;
			case 3: sum += 3500; break;
			default: System.out.println("잘못 입력하셨습니다.");
			}
			
			//추가주문 여부
			System.out.println("더 주문하시겠습니다?(y/n) :");
			yn = sc.next().charAt(0);
			
		}while(yn == 'y');
		
		//최종금액 출력
		System.out.println("결제금액 : " + sum + "원");
		System.out.println("----이용해 주셔서 감사합니다.---");
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		char yn = 'y'; //do~while 조건식에 사용될 변수는 블럭 바깥에 선언 할 것
		
		do {
			System.out.println("----게임 시작----");
			System.out.println("얍~ 뺙~ 쿵~ 와~");
			System.out.println("----게임 오버---");
			System.out.println("한판 더 하시겠습니다? (y/n) : ");
			yn = sc.next().charAt(0);
			
		} while(yn == 'y');
		
		System.out.println("=== 이용해 주셔서 감사합니다. ===");

		
	}
	
	public void test1() {
		int i = 0;
		do {
			System.out.println("안녕");
			i--;
		} while(i > 0); 
		System.out.println("----끝----");
	}
}
