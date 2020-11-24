package com.api.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalcDday {

	public static void main(String[] args) {
		CalcDday c = new CalcDday();
		c.test1();
	}
	public void test1() {
			Scanner sc = new Scanner(System.in);
			System.out.println("년을 입력 >> ");
			int yy = sc.nextInt();
			System.out.println("월을 입력 >> ");
			int MM = sc.nextInt();
			System.out.println("일을 입력 >> ");
			int dd = sc.nextInt();
			
		Calendar day = new GregorianCalendar(yy,MM-1,dd); 
			Calendar now = new GregorianCalendar();
			
			long future = day.getTimeInMillis(); 
			long past = now.getTimeInMillis();
			double diff = (future - past) / 1000.0 / 60 / 60 / 24;

			if(diff > 0)
				System.out.println("d -" + ((int)diff + 1)+ "일 남았습니다");
			else if(diff > -1)
				System.out.println("d -day 입니다");
			else {
				System.out.println("d +" + ((int)diff - 1)+ "일 지났습니다");
					
	}
	}

}
