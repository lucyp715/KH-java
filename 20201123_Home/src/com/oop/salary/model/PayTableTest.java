package com.oop.salary.model;

public class PayTableTest {

	public static void main(String[] args){
		PayTable pt  = new PayTable();
		pt.insertSalaryData(new Salary("소서노",750000,2,3));
		pt.insertSalaryData(new Salary("고주몽",800000,1,4));
		pt.insertSalaryData(new Salary("모팔모",650000,6,2));
		pt.insertSalaryData(new Salary("아보리",500000,2,10));
		pt.output();
		
		Calculate.incentive = 0.7f;
		pt.output();
	}
}
