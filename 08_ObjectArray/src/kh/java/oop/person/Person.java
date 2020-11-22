package kh.java.oop.person;

public class Person {
	private String name;
	
	public Person() {}
	
	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printPersonInfo() {
		System.out.println("Person(" + name + ")");
	}

}
