package kh.java.multi.dimentional.array;

import java.util.Random;
import java.util.Scanner;

public class TestTest {
	
	public static void main(String[] args) {
		JaggedArrayTest j = new JaggedArrayTest(); 
		
		
	
		j.test2();

	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][];
		//1. 2차원 배열 할당
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i + "행의 열개수 입력 : ");
			int col = sc.nextInt();
			arr[i] = new int[col];
		}
		//2. 요소에 정수 대입
		Random rnd = new Random();
		boolean flag = false; //5의 배수가 존재하는가?
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = rnd.nextInt(100) + 1;
				//5의  배수여부 검사
				if(arr[i][j] % 5 == 0) {
					flag = true;
					System.out.print(arr[i][j] + " ");
				}
			}
		}
		if(!flag) 
			System.out.print("5의 배수가 존재하지 않습니다.");
		System.out.println("\n-------------------------");
		//출력
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
