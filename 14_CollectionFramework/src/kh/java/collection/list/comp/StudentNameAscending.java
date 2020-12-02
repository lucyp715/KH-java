package kh.java.collection.list.comp;

import java.util.Comparator;

import kh.java.collection.list.Student;

public class StudentNameAscending implements Comparator<Student>{
	
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
		// s1.getName().compareTo(s2.getName() 가나다 순
		// s2.getName().compareTo(s1.getName() 가나다 역순
		
	}

}
