package kh.java.nested.loop;

import java.util.Scanner;

/**
 * 
 * 중첩반복문을 사용하면, ㄷ ㅏ차원적인 데이터를 처리할 수 있다.
 * 
 * - 행/ 열로 이루어진 테이블 표현이 가능
 * 
 *
 */
public class NestedLoopTest {

	public static void main(String[] args) {
		NestedLoopTest n = new NestedLoopTest();
//		n.test1();
//		n.test2();
//		n.test3();
		n.test4();
//		n.test5();
//		n.test6();
//		n.test7(); //실습문제
//		n.test8(); //실습문제
	}
	/*
	 *♥
	 *♥♥
	 *♥♥♥
	 *♥♥
	 *♥ 
	 */
	public void test8() {
		int total = 5;//5행, 5*
		int space = 4;//공백
		int mid = total/2;//가운데기준으로 i와 mid의 값을 비교해 space값을 변경한다.
		
		//i : 0 1 2 3 4 
		for(int i=0; i<total; i++) {
			//j : 0 1 2 3 4
			for(int j=0; j<total; j++) {
				System.out.print(j<space?" ":"*");
			}
			
			//space : 4 - 2 - 0 - 2 - 4
			if(i < mid) space -= 2;
			else space += 2;
			
			System.out.println();
				
			}
		}
		
	
	/**
	 * ♥♥♥♥♥
	 * ♥♥♥♥
	 * ♥♥♥
	 * ♥♥
	 * ♥
	 */
	public void test7() {
	
//		int total = 5;
//		for (int i = 0; i < total; i++) {			
//			for (int j = 0; j < total-i; j++) {
//				System.out.print("*");				
//			}
//			System.out.println("");
//}
		for(int i = 0; i <5; i++) {
			for(int j = 0; j <5; j++) {
				if(j >= i)
				System.out.print("♥");
				
			}
			System.out.println();
		}
		
	}
	/**
	 * 구구단 출력
	 * 
	 * ---2단 ----
	 * 2* 1 = 2
	 * 2* 2 = 4
	 * ...
	 * ----3단----
	 * ...4
	 * ----9딘----
	 * 9 * 9 =81
	 * 
	 */
	public void test6() {
		
		for(int i = 2; i <10; i++) {
			System.out.println("-------" + i + "단" + "--------");
			for(int j = 1; j <10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
			System.out.println();
		}
	}
	
	/*
	 *0 ooo
	 *1 o -> i가 홀수라면 하나만 찍자
	 *2 ooo
	 *3 o
	 *4 ooo
	 */
	public void test5() {
		
		for(int i = 0; i <5; i++) {
			for(int j = 0; j <3; j++) {
				System.out.print("★");
				if(i % 2 != 0)
					break;
			}
			System.out.println();
		}
	}
	
	/**
	 * ★
	 * ★★
	 * ★★★
	 *  ★★★★
	 *   ★★★★★
	 *   
	 *   continue
	 *   이하코드를 실행하지 않고
	 *   -for문 증감식
	 *   -while문 존건식으로 이동
	 */
	public void test4() {
		
//		for(int i =0; i < 5; i++) {
//			
//			for(int j = 0; j <= i; j++) {
//				System.out.print("★");
//			}
//			System.out.println();
//		}
		
		//라벨을 사용한 break
		outer:
		for(int i =0; ; i++) {
			
			for(int j =0; j <=i; j++) {
			
				if(i >= 5)
					break outer; //break만 사용시 안에for문만 먹혀서 무한계속진행
								//outer같이 사용시 밖for문진행시켜서 멈춘다
				System.out.print("★");
			}
			System.out.println();
		}
	
	//라벨을 사용한  continue
//		outer:
//	for(int i = 0; i < 5; i++) {
		
//		for(int j= 0; j < 5; j++) {
//			System.out.print("★");
//			if( i == j) {
//				System.out.println();
//				continue outer;
	//	}
//		}
//		System.out.println();
//	}
}
	
	/**
	 * @실습문제: 사용자가 원하는 크기의 별박스 출력
	 * 행 : 3
	 * 열 : 4
	 * -------
	 * ★★★★
	 * ★★★★
	 * ★★★★
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("행을 입력하세요");
		int a = sc.nextInt();
		System.out.print("열을 입력하세요");
		int b = sc.nextInt();
		
		for(int i = 0; i < a; i ++) {
			for(int j =0; j < b; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
			

	}
	/**
	 * 
	 * @실습문제 : 
	 * (0,0)(0,1)(0,2)(0,3-)(0,4)
        (1,0)(1,1)(1,2)~(1.4)
        (@,0)(2,1)~(2.4)
	 */
	public void test2() {
		//4행 3열로 변경하려면?
		//행 ->바깥반복문
		//열 -> 안쪽반복문
	
		for(int i = 0; i <3; i++) { // 3행 5열을 파악해서 3 x 5
			
			for(int j =0; j<5; j++) {
				System.out.print("★");
					//System.out.print("(" + i + "," + j + ")");
				}
				System.out.println();
			}
			
	}
	public void test1() {
		
		//outer
		for(int i = 0; i < 2; i++) {
			System.out.print(i + " : ");
			
			//inner
			for(int j = 0; j <3; j++) { // j 무조건 0부터 다시시작
				System.out.print(j + " ");
			}
			System.out.println(); //개행처리
		}
		
		for(int i = 0; i < 2; i++) {
			
			for(int j= 0; j < 3; j++) {
			System.out.print("(" + i + "," + j + ")");
			}
			System.out.println();
		}
		
	}

}
