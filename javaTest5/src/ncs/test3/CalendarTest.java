package ncs.test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int year =0;
		int month = 0;
		int day = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy년 MM월 dd일 E요일");
		
		System.out.println("날짜를 입력하시오.");
		
		System.out.print("년 : ");
		year = sc.nextInt();

		System.out.print("월 : ");
		month = sc.nextInt();
		
		System.out.print("일 : ");
		day = sc.nextInt();
		
		Calendar cal = new GregorianCalendar(year, month-1, day);

		
		System.out.println("\n입력된 날짜에 대한 정보는 아래와 같습니다.");
		System.out.println(sdf.format(cal.getTimeInMillis()));
		
		
		if((year % 4 == 0 && year % 100 !=0) || (year % 400 ==0)){
			System.out.println(year + "년은 윤년이다");

		}
	}

}
