package com.api.calendar;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		CalendarTest c = new CalendarTest();
		c.test1();
	
	}
	

	public void test1() {
		Calendar cal = Calendar.getInstance();
		
		int yy = cal.get(Calendar.YEAR)-9;
		int MM = cal.get(Calendar.MONTH)-7;
		int dd = cal.get(Calendar.DATE)-3;
		int hh = cal.get(Calendar.HOUR);
		int mm = cal.get(Calendar.MINUTE);
		int ss = cal.get(Calendar.SECOND);
		
		String []day = {"일", "월", "화", "수", "목", "금", "토"};
	    
		int dow = cal.get(Calendar.DAY_OF_WEEK)-1;
		
		String today = day[dow];
		
	      System.out.println(yy + "년" + MM +"월"
	    		  + dd +"일" + today + "요일" 
	    		  + hh + ":" + mm + ":" + ss);
	}

}
		
