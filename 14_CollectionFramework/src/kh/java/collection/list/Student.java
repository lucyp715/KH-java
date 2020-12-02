package kh.java.collection.list;

import java.util.Arrays;
import java.util.Objects;

public class Student implements Comparable<Student>{ //<student>는 generic인데 다향성
	
	private int no;
	private String name;
	
	public Student() {
		super();
	}
	
	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + "]";
	}
	/**
	 * stuendt 누르면 add 어찌고 뜸 그거 누르면 됨
	 * 
	 * 기본정렬 기준
	 * no 오름차순
	 */

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.no - o.no;  // 양수음수를 리턴하게되면 자리바꿈이 일어나게된다
		//this.no 현재 student 객체를 나타냄
		//위에 student o로 정의가되어있어서 외부에서 받은 student의 넘버에요
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(no, name);
//		return Arrays.hashCode(values);
		
	}
	/**
	 * no, name 필드값이 동일하면 같은 객체라고 간주. -> test4에서 홍길동 두번인것을 하나로 하고싶다
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o) //전달받은 애가 같다 true
			return true;
		
		if(o == null) // 전달받은 애가 null
			return false;
		
		if(!(o instanceof Student)) //전달받은 애가 student 타입이 아니라면?
			return false;
		
		Student other = (Student)o; //위에 istrnad가 true기 때문에 여기까지 내려온거
		if(no != other.no) // name 문자열이라서 형변환 , null일수가 없다.
			return false;
		
		if(name == null) {
			if(other.name != null) { // name null, other name null이 아니다
				return false;
			}
		}
		else {
			if(name.contentEquals(other.name)) //넘버랑 네임필드가 같은객체면 간주하자
				return false;
			
		}
		
		
		return true;
	}

}
