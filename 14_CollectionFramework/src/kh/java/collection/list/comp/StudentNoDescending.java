package kh.java.collection.list.comp;

import java.util.Comparator;

import kh.java.collection.list.Student;

public class StudentNoDescending implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		return s2.getNo() - s1.getNo(); 
		// students 내부가 아니기 때문에 getter을 이용해서 가져와야한다
		// 내림차순이면 s1-s2였던것에서 s2-s1으로 바꿔주면된다
	}

}
