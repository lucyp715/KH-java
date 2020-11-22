package com.oop.person.model.vo;

public class Person {

	private String name;
	private int age;
	private double height;
	private double weight;
	private long money;
	
	public Person() {}
	public Person(String name, int age, double height,double weight,long money) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.money = money;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public String information(){
		return name+", "+age+", "+height+", "+weight+", "+money;
	}
	
}
