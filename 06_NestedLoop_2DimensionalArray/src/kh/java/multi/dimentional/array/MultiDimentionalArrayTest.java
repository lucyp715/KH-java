package kh.java.multi.dimentional.array;


/**
 * 2차원배열
 * - 참조의 참조형태로 2차원배열을 생성할 수 있다.
 * 
 * @author soyeo
 *
 */
public class MultiDimentionalArrayTest {

	public static void main(String[] args) {
		
		MultiDimentionalArrayTest m = new MultiDimentionalArrayTest();
//		m.test1();
//		m.test2(); //실습
//		m.test3(); 
//		m.test4();
//		m.test5();
		m.test6();
 
	}
	
	public void test6() {
		
	}
	/**
	 * 2차원 배열 구조
	 * 
	 */
	public void test5() {
		int[][] arr =new int[2][3];
		
		
	}
	/**
	 * 1 2 3 4
	 * 5 6 7 8
	 * 9 10 11 12
	 * 
	 * 2 4 6 8
	 * 10 12 14 16
	 * 18 20 22 24
	 *  
	 */
	public void test4() {
		
//		int [][] arr = new int[3][4];
//		int k = 2;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[0].length; j++) {
				//값대입
//				arr[i][j] = k;
//				k+=2;
				
				//값출력
//				System.out.print(arr[i][j] + " ");
	//		}
//			System.out.println();
			
//		int [][] arr = new int[3][4];
//		int k = 1;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[0].length; j++) {
				//값대입
//				arr[i][j] = k;
//				k++;
				
				//값출력
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
			
			
			//2차원배열 2 * 26
			//A B C D ...Z
			//a b c d ...z
			char[][] alpha = new char[2][26];
			char ch = 'a';
			for(int i = 0; i < alpha.length; i++) {
				for(int j = 0; j < alpha[0].length; j++) {
					if(i == 0)
						alpha[i][j] = (char)('A' + j);
					else
						alpha[i][j] = (char)('a' + j);
					
					System.out.print(alpha[i][j] + " ");
						
				}
				System.out.println();
			}
					
		}

	
	/**
	 * 2 * 5
	 * 
	 * A B C D E
	 * a b c d e
	 * 
	 */
	public void test3() {
		char[][] alphabet = {
			{'A', 'B', 'C', 'D', 'E'}, 
			{'a', 'b', 'c', 'd', 'e'}
		};
		
		for(int i =0; i < alphabet.length; i++) {
			for(int j =0; j < alphabet[0].length; j++) {
				System.out.println(alphabet[i][j]);
			}
		}
	}
	
	public void test2() {
		String [][] arr = new String[5][6];
		
		arr[0][0] = "이원빈";
		arr[0][1] = "김동현";
		arr[0][2] = "유영국";
		arr[0][3] = "강준혁";
		arr[0][4] = "정인식";
		arr[0][5] = "권송현";
		
		arr[1][0] = "김진하";
		arr[1][1] = "주진홍";
		arr[1][2] = "유선아";
		arr[1][3] = "정다미";
		arr[1][4] = "김지헌";
		arr[1][5] = "김지홍";
		
		arr[2][0] = "한광희";
		arr[2][1] = "정다솜";
		arr[2][2] = "이상원";
		arr[2][3] = "이제환";
		arr[2][4] = "황현준";
		arr[2][5] = "정다빈";
		
		arr[3][0] = "황수빈";
		arr[3][1] = "김지수";
		arr[3][2] = "김자경";
		arr[3][3] = "박소연";
		arr[3][4] = "서강석";
		arr[3][5] = "유리";
		
		arr[4][0] = "정소희";
		arr[4][1] = "사영리";
		arr[4][2] = "강송이";
		arr[4][3] = "강유정";
		arr[4][4] = "이효정";
		arr[4][5] = "이수연";
		
//		System.out.println(arr.length);
//		System.out.println(arr[0].length);
		

		for(int i = 0; i <arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {// [0]length는 1부터
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public void test1() {
		
		
		//1. 배열 선언
		//int[][] 타입
		int[][] arr;
		
		//2. 할당
		arr = new int[2][3]; //2행3열로 보면 쉽다
		
//		int[][] arr = new int[2][3];
		
		//3. 요소에 값대입
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		
//	 	System.out.println(arr[0][0]);
//	 	System.out.println(arr[0][1]);
//	  	System.out.println(arr[0][2]);
//		System.out.println(arr[1][0]);
//	  	System.out.println(arr[1][1]);
//	 	System.out.println(arr[1][2]);
	 	for(int i = 0; i < 2; i++) {
			
			for(int j = 0; j < 3; j++) {
//	 			System.out.println(i + ", " + j); // 행과 열이 출력
				System.out.println(arr[i][j]); // 대입값으로 출력
			}
		}
	}

}
