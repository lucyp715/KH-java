package com.exception.charcheck;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {

		Run r = new Run();
		r.test1();
}
	
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		CharacterProcess cp = new CharacterProcess();
		
		try {
			System.out.println("문자열을 입력하세요  >> ");
			String input = sc.nextLine();
			System.out.println("영문자는  "+ cp.countAlpha(input) + "입니다.");
			
		} catch(CharCheckException e) {
			e.printStackTrace();
		}
		
	}
}
