package com.api.token;

import java.util.StringTokenizer;

public class TokenTest {

	public static void main(String[] args) {
		String data = "J a v a P r o g r a m ";
		//토큰 처리전 글자 출력
		System.out.println(data);
		//전 글자갯수 출력
		System.out.println(data.length());
		
		//토큰 처리 후 글자갯수 출력 확인
		StringTokenizer tokenizer = new StringTokenizer(data, " ");
		System.out.println(tokenizer.countTokens());
		
		//char[] 값 출력
		int idx = 0;
		char[] arr = new char[data.length()];
		while(tokenizer.hasMoreTokens()) {
			arr[idx] = tokenizer.nextToken().charAt(0);
			idx++;
		}
		
		for(int i = 0; i < idx; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
		System.out.println(String.valueOf(arr).toUpperCase());

			
		}
	
		
}
