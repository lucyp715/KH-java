package com.exception.charcheck;

public class CharCheckException extends Exception{

	public CharCheckException() {
	}

	public CharCheckException(String message, Throwable cause) {
		super(message, cause);
	}

	public CharCheckException(String message) {
		super(message);
	}

	public CharCheckException(Throwable cause) {
		super(cause);
	}
	
}
