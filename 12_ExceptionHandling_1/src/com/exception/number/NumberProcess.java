package com.exception.number;

public class NumberProcess {

	public NumberProcess() {
		
	}
	public boolean checkDouble(int a, int b) throws NumberRangeException{
		if(!(1 <= a && a <= 100 && 1 <= b && b <100))
			throw new NumberRangeException("1부터 100사이의 값이 아닙니다.");
		else if(a%b == 0) {
			return  true;
		}else {
			return false;
		}

	}
}
