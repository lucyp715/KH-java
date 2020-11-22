package kh.java.oop.field;

/**
 * KH 학생정보를 관리
 * -교육원명 -공유
 * -교육원전화번호 -공유
 * -학생명- 객체마다 달라
 * -강의장명 -객체마다 다라
 * -학생전화번호 -객체마다 달라
 * 
 *pritnInfo : 모든 정보를 출력하기
 */

public class KHStudent {
	
	public static final String ACADEMY = "KH정보교육원";
	public static final String ACADEMY_PHONE_NUMBER = "021234567";
	private String name;
	private char className;
	private String phoneNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getClassName() {
		return className;
	}
	public void setClassName(char className) {
		this.className = className;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void printInfo() {
		System.out.printf("%s(%s) : %s(%c) %s%n", 
						  ACADEMY, 
						  ACADEMY_PHONE_NUMBER, 
						  name, 
						  className, 
						  phoneNumber);
	}
}
