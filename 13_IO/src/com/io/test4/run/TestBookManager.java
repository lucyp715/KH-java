package com.io.test4.run;

import com.io.test4.controller.BookManager;

public class TestBookManager {

	public static void main(String[] args) {
		
		BookManager b = new BookManager();
		
		b.fileSave();
		b.fileRead();

	}

}