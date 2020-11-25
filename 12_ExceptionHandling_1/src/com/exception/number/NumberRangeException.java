package com.exception.number;

public class NumberRangeException extends Exception{

	public NumberRangeException() {
		
	}

	public NumberRangeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NumberRangeException(String message) {
		super(message);
	}

	public NumberRangeException(Throwable cause) {
		super(cause);
	}
	
}
