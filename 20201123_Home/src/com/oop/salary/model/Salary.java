package com.oop.salary.model;

public class Salary extends Calculate implements Output {
	
	private String name;
	private long basePay;
	private long familyPay;
	private long overtimePay;
	private long incentivePay;
	private long tax;
	private long totalPay;
	private int family;
	private int overtime;
	
	public static int count = 0;
	
	public Salary() {}
	
	public Salary(String name, long basePay, int family, int overtime) {
		this.name = name;
		this.basePay = basePay;
		this.family = family;
		this.overtime = overtime;
		
		
		count++;
	}
	@Override
	public void calc() {
		this.familyPay = family > 3 ?3600 :family*2000;
		overtimePay = overtime*5000;
		tax = (long)(basePay*0.1);
		incentivePay =  (long)(incentive*basePay);
		totalPay = basePay+familyPay+incentivePay+overtimePay-tax;
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBasePay() {
		return basePay;
	}

	public void setBasePay(long basePay) {
		this.basePay = basePay;
	}

	public long getFamilyPay() {
		return familyPay;
	}

	public void setFamilyPay(long familyPay) {
		this.familyPay = familyPay;
	}

	public long getOvertimePay() {
		return overtimePay;
	}

	public void setOvertimePay(long overtimePay) {
		this.overtimePay = overtimePay;
	}

	public long getIncentivePay() {
		return incentivePay;
	}

	public void setIncentivePay(long incentivePay) {
		this.incentivePay = incentivePay;
	}

	public long getTax() {
		return tax;
	}

	public void setTax(long tax) {
		this.tax = tax;
	}

	public long getTotalPay() {
		return totalPay;
	}

	public void setTotalPay(long totalPay) {
		this.totalPay = totalPay;
	}

	public int getFamily() {
		return family;
	}

	public void setFamily(int family) {
		this.family = family;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	
	

}
