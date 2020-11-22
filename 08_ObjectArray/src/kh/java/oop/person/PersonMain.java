package kh.java.oop.person;

public class PersonMain {

	public static void main(String[] args) {
/**
 * 3개다 동일한 출력
 * Person(홍길동)
   Person(신사임당)
   Person(세종대왕)

 * 		
 */
//		PersonManager pm = new PersonManager();
//		pm.inserPerson(new Person("홍길동"));
//		pm.inserPerson(new Person("신사임당"));
//		pm.inserPerson(new Person("세종대왕"));
		
//		pm.printPerson();
		
		
//		Person[] arr =new Person[3];
		
//		arr[0] = new Person("홍길동");
//		arr[1] = new Person("신사임당");
//		arr[2] = new Person("세종대왕");
		
		//벼열초기화식 : 배열할당 + 배열요소할당 - 위에 4줄과 동일함.
		Person[] arr = {
				new Person("홍길동"),
				new Person("신사임당"),
				new Person("세종대왕")
		};
		
		
		for(int i =0; i < arr.length; i++) 
			arr[i].printPersonInfo();

	}
}
