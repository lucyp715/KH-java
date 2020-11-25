package com.exception.number;

import java.util.Scanner;

public class Run {
	
		public static void main(String[] args) {
		
				Run r = new Run();
				r.test();
}
		public  void test() {
			NumberProcess np = new NumberProcess();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("첫번쨰 정수를 입력하세요 >> ");
			int num1 = sc.nextInt();
			System.out.print("두번째 정수를 입력하세요 >> ");
			int num2 = sc.nextInt();
			
			try{
				if(np.checkDouble(num1,num2)) {
					System.out.println(num1 + "는" + num2 + "의 배수이다.");
				}
				else {
					System.out.println(num1 + "는" + num2 + "의 배수가 아니다.");
				}
			}catch (NumberRangeException e) {
				e.printStackTrace();
		}
	}
}
