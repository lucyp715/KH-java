package com.oop.person.controller;

import java.util.Scanner;

import com.oop.person.model.vo.Person;

public class PersonController {

	Scanner sc = new Scanner(System.in);
	final int MAX = 5;
	Person[] person5 = new Person[MAX];
	
	//입력메소드
	
	public void insertPersoneData() {
		System.out.println("-----개인정보를 입력하세요-------");
		for(int i = 0; i < person5.length; i++) {
			
			Person p = new Person();
			System.out.println("이름을 입력하세요 : ");
			p.setName(sc.next());
			System.out.println("나이를 입력하세요 : ");
			p.setAge(sc.nextInt());
			System.out.println("키를 입력하세요 : ");
			p.setHeight(sc.nextDouble());
			System.out.println("몸무게를 입력하세요 : ");
			p.setWeight(sc.nextDouble());
			System.out.println("재산을 입력하세요 : ");
			p.setMoney(sc.nextLong());
			
			person5[i] = p;
		}
	}
	//출력매소드
	public void printPersonData() {
		for(int i = 0; i < person5.length; i++) 
			System.out.println(person5[i].information());
		}
	//평균 구하는 메소드
	//평균 = 합 / 갯수
	public void getPersonAvg() {
		System.out.println("--------평균 출력------");
		double[] sumArr = new double[4];
		//0나이 1키 2몸무게 3재산
		for(int i = 0; i < person5.length; i++) {
			Person p = person5[i];
			sumArr[0] += p.getAge();
			sumArr[1] += p.getHeight();
			sumArr[2] += p.getWeight();
			sumArr[3] += p.getMoney();
			
		}
		
		System.out.println("평균 나이 : " + (sumArr[0] / person5.length));
		System.out.println("평균 키 : " + (sumArr[1] / person5.length));
		System.out.println("평균 몸무게 : " + (sumArr[2] / person5.length));
		System.out.println("평균 재산 : " + (sumArr[3] / person5.length));
	}
	}
		
