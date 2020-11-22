package com.kh.edu;

import java.util.Date;

public class TestJavaApi {

	public static void main(String[] args) {
		TestJavaApi t = new TestJavaApi();
		t.test();
	}

	
	private void test() {
		//Date메소드 : Deprecated 메소드는 더이상 사용해서는 안된다. 
		Date d = new Date();
		System.out.println(
				(d.getYear() + 1900) + "/" + 
				(d.getMonth() + 1) + "/" + 
				d.getDate()
			);

	}

}

