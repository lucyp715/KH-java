package com.io.test4.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.io.test4.model.vo.Book;

public class BookManager {

	Scanner sc = new Scanner(System.in);

	
	public void fileSave() {
		Book[] b = new Book[5];
		b[0] = new Book("Harry Potter1","J. K. 롤링",12000,new GregorianCalendar(2001,12,14),0.5);
		b[1] = new Book("Harry Potter2","J. K. 롤링",12000,new GregorianCalendar(2002,12,13),0.5);
		b[2] = new Book("Harry Potter3","J. K. 롤링",12000,new GregorianCalendar(2004,07,16),0.5);
		b[3] = new Book("Harry Potter4","J. K. 롤링",12000,new GregorianCalendar(2005,12,01),0.5);
		b[4] = new Book("Harry Potter5","J. K. 롤링",12000,new GregorianCalendar(2007,07,11),0.5);
		
		File f = new File("books.dat");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			
			oos.writeObject(b);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("books.dat 에 저장 완료!");
		
		
	}
	
	public void fileRead() {
		
		Book[] b = new Book[10];
		
		File f = new File("books.dat");
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			
			b = (Book[]) ois.readObject();
			
			for(int i=0; i<b.length; i++) {
				System.out.println(b[i]);
			}
			
		}catch(IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
	}
}