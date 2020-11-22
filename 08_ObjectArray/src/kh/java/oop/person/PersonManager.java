package kh.java.oop.person;

public class PersonManager {
	public static final int MAX = 3;
	Person[] personArr =new Person[MAX];
	int personIndex = 0;
	
	public void inserPerson(Person p) {
		personArr[personIndex++] = p; 
	}
	
	public void printPerson() {
		for(int i = 0; i <personIndex; i++)
			personArr[i].printPersonInfo();
	}

}
 