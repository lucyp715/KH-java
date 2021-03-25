package com.exception.number;

public class NumberProcess {
	
	 public boolean checkDouble(int a, int b) throws NumberRangeException{
		 //이 메소드를 실행하는 곳에 throw하겠
		 if(!((a>0&&a<=100)&&(b>0&&b<=100)))
				throw new NumberRangeException("1부터 100사이의 값이 아닙니다.");
			
			if(a%b == 0)
				return true;
			else
				return false;
			
	 }
}
