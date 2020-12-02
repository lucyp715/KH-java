package com.collection.set.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {

	public static void main(String[] args) {
		Lotto l = new Lotto();
		l.lottoDisplay();
		
		
	}
/**
 * @실습문제: 중복없고 오름차순 정렬을 해주는 컬렉션
	중복없고 오름차순 정렬을 해주는 Set 계열 컬렉션클래스와 Random 사용
 - 클래스명 : com.collection.set.lotto.Lotto.java
    >> main() 메소드 포함
 - 메소드 추가 : public static void lottoDisplay(){}
    >> 구현내용
    1. 1 ~ 45 사이의 정수를 중복되지 않게, 6개 발생시켜
    2. 자동 오름차순정렬되게 처리하는 Set 계열에 보관하고 
    3. Integer[]로 바꾸어 출력함. (toArray(T[]) 사용할 것)
 * 
 */
	public static void lottoDisplay() {
		Set lottoset = new HashSet<>();
		// 로또 번호 6개 랜덤으로 받는 set 설정
		
		int Num;
		//1~45받는 변수
		
		while(lottoset.size() != 6) {
			//set은 중복없다
			//lottoset의 크기가 6일때까지 랜덤
			Num =(int)(Math.random()*45+1);
			//lottoset 랜덤수 저장
			lottoset.add(Num);
			
		}
		
		
		ArrayList<Integer> lottoArr = new ArrayList<Integer>(lottoset);
		 
		Collections.sort(lottoArr);
		//ArrayList 오름차순 정렬
		System.out.println("금주의 로또번호는 : ");
		
		//로또 출력
		for(Object list : lottoArr)
			System.out.println(list + " ");
		
	}

}
