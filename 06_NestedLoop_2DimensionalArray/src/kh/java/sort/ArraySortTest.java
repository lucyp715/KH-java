package kh.java.sort;

import java.util.Arrays;

/**
 * 배열 정렬
 * 2 4 3 5 1 -.5 4 3 2 1
 * 
 * 정렬 알고리즘 종류
 * -순차정렬
 * -선택정력
 * -버블정렬
 * -삽입정렬
 * -퀵정렬
 * -합별정렬
 * ...
 * 
 *
 */
public class ArraySortTest {

	public static void main(String[] args) {
		ArraySortTest a = new ArraySortTest();
//		a.test1();
		a.test2();
//		a.test3();

	}
	/**
	 * @실습문제 : 로또 숫자 생성하기
	 * 
	 * 1~45 사이의 난 수 6개
	 * 중복없음.
	 * 
	 * 오름차순정렬
	 * 
	 */
	public void test3() {
		
		int[] lotto = new int[6];
		
		int idx = 0;
		outer:
		for(;;) {
			int num =(int)(Math.random() * 45 +1);
			
			//중복제거
			for(int i = 0; i < idx; i++) {
				if(lotto[i] == num)
					continue outer;
			}
			
			lotto[idx++] = num;
			
			if(idx == 6)
				break;
		}
		System.out.println(Arrays.toString(lotto));
	}
	
	/**
	 * 순차정렬
	 * Sequential Sort
	 * 
	 * 한 회차에 해당하는 인데스에 적합한 수를 찾는다.
	 * 
	 */
	public void test2() {
		int [] arr = {4, 3, 0, 2, 1}; //{1, 2, 3, 4,}
		
		//i : 0 1 2 3
		for(int i =0; i < arr.length -1; i++) {
			
			//j : i ->j= 1 2 3 4
			//j : i ->j= 2 3 4 
			//j : i ->j= 3 4
			//j : i ->j= 4
			for(int j = i+1; j < arr.length; j++) {
				System.out.printf("%d : %s%n", i, Arrays.toString(arr));
				//오름차순 > , 오름차순 <
				if(arr[i] > arr[j])
					swap(arr, i, j);
			}

		}
		System.out.println("-----------------");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 값교환
	 */
	public void test1() {
		int num1 = 10;
		int num2 = 20;
		
		int temp = num1; //temp에 복사 해놓음
		num1 = num2;
		num2 = temp;
		
		
		System.out.println(num1); //20
		System.out.println(num2); //10
		
		int[] arr = {2, 1, 3};
		
//		temp = arr[0];
//		arr[0] = arr[1];
//		arr[1] = temp;
		
		swap(arr, 0 ,1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
