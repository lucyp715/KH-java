package kh.java.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		ArrayListTest a = new ArrayListTest();
//		a.test0();
//		a.test1();
//		a.test2();
//		a.test3();
//		a.test4();
		a.test5();
	}

	private void test5() {
		List<Student> list = new ArrayList<>();
				
		//학생선언
		list.add(new Student(1, "홍길동"));
		list.add(new Student(2, "신사임당"));
		list.add(new Student(3, "장영실")); 
		System.out.println(list);
		
		//학생삽입 앞
		list.add(new Student(4, "세종대왕"));
		list.add(new Student(5, "장봉준"));
		System.out.println(list);
		
		//신사임당 학생이 전학을 갔다. 학생삭제
		list.remove(1);
		
		System.out.println(list);
		
		//학생요소를 하나씩 앞당기는 작업
		
		//학생 한 명 추가
		list.add(1, new Student(2, "박소연"));;
		
		//확인
		System.out.println(list);
		
		
		
		
		
	}

	/**
	 * iterator / 이터래이터
	 * 모든 요소를 열람하는 방법 / 목록화를 시켜두고 순차적으로 접근한다
	 * 
	 */
	
	private void test4() {
		
		//제네릭 타입은 두번째에서는 생략 가능
		//유추할수있는때만 가능
//		List<String> list = new ArrayList<>(); //이것도 됨
		List<String> list = new ArrayList<String>();
		
		list.add("honggd");
		list.add("sinsa");
		list.add("sejong");
		
		//iterator 모든 요소에 접근하고 나면 더 이상 사용 불가하다.
		//순차접근할수있도록목록화 iterator 일회성
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext()) { // 이 이터레이터 다음요소가 존재하냐?
			String s = iter.next();
			System.out.println(s);
		}
		
	}


	/**
	 * ArrayList 사용법
	 */
	private void test3() {
		List<Integer> list = new ArrayList<Integer>();
		//new List라고 못쓴다. List는 인터페이스이기 때문에 객체화 할수 없다.
		
		//저장된 순서를 유지
		list.add(3);
		list.add(2);
		list.add(1);

		
		//중복을 허용
		list.add(2);
		list.add(3);
		
		//만약 0번지 데이터가 삭제되었다면, 1번이 0으로, 2번이 1로..등 앞으로 당겨주어야겠지?
		//삭제 : 다음 번지수를 하나씩 앞당겨 재배치
		list.remove(0);
		//2123 아까 맨앞 3이었는데 0번지를 지우고 자동으로 전1번지가 현0번지로
		list.remove(new Integer(2)); 
		//(처음 만난)동일한 요소를 제거해줌 -> 32123 중에서 32 날리고 123만출력
		System.out.println(list);
//		System.out.println(list.get(0));
		
		//수정 : 특정 인덱스의 요소를 변경할 수 있다.
		list.set(0, 300); // 0번지에 있던 애를 300으로 변경한다. 위에서 삭제해서 0번자리 2였는데
        //set으로 수정 해서 2를 300 으로 ->300 1 2 3
		
		
		//삽입(맨 마지막에 넣는 저장이 아니라 중간에 끼워넣는)
		list.add(1, 200);
		
		
		//다른 리스트의 요소를 통째로 추가
		List<Integer> another = new ArrayList<Integer>();
		another.add(999);
		another.add(99);
		another.add(9);
		
		list.addAll(another);  //listALL 을쓰면 아까 처음 썻던것에 추가로 쓸수있다.
		
		//특정요소 포함여부 boolean
		boolean bool = list.contains(99);
		bool = list.contains(9999);
		System.out.println(bool); 
		
		//특정요소 포함여부 index(int)
		int index = list.indexOf(99);
		index = list.indexOf(999999); // true -> 99가 list에 있기 떄문에
//		없는 값이 있는지 물어보면 마이너스 값을 리턴합니다.(번지수로 -1이 있을 리 없음)
		
//		indexOf는 두가지다, indexOf면 처음 번지수부터, lastIndexOf하면 끝 번지수부터
//		조사만 index로 하고 실제로는 그 자리 수를 반환합니다.
		
		list.add(5, 200);
		index = list.indexOf(200); // 앞에서부터 5번지
		System.out.println(index); //99를 찍으면 6번기가 출력 -> 번지 수로 알려준다
		index = list.lastIndexOf(200); // 뒤에서 5번쨰 번짓수
		System.out.println(index);
		
		//요소 전체 삭제
//		list.clear();
		
		//리스트에 요소가 없는가?
		bool = list.isEmpty();
//		System.out.println(bool);
		
		System.out.println(list);
		
		
	}

	/**
	 * Generic 타입변수
	 * 기본형을 사용할 수 없다.
	 */
	
	private void test2() {
		
		List<String> list = new ArrayList<String>();
//		이 꺽새 안<>이 제네릭
//		요소를 추가할 때 타입 체크 가능 , String만 추가가능
//		실수로 지정하지 않은 타입을 추가했을 때 바로 알 수 있어서 이렇게 지정해두는 게 좋다.
//		런타임보다 컴파일 오류가 되게끔 하는 게 좋다.
		
		list.add("안녕");
		list.add(new String("Hello"));
//		list.add(new Date());
		//String만 추가가능이라 오류
		//<>에 String을 썼다는것이 string만 받겠다는 의미
		//runtime 아니고 comfile 단위로 틀린부분 바로바로 체크가능
		
		
		//요소를 가져올 때 형변환을 할 필요가 없다.
		String s = list.get(0);
		
		for(String str : list) {
			System.out.println(str);
		}
		
//		List<int> numList = new ArrayList<>();
//		       이게 안됨
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(1); //제공된것은 int 정수다 자동변환
		//auto boxing이 일어난것 1 -> new Integer(1);
		numList.add(2); // 2 -> new Integer(2);
		
		System.out.println(numList.get(0) + numList.get(1));
		//자동으로 꺼내져서 계산이된다.
				//Integer + integer -> 1+ 2 auto-unboxing
		System.out.println(numList.get(0).getClass().getName());
		
		/**
		 * 래퍼 클래스란(Wrapper Class)? 
		 * 
			자바의 자료형은 크게 기본 타입(primitive type)과 참조 타입(reference type)으로 나누어집니다. 
			대표적으로 기본 타입은 char, int, float, double, boolean 등이 있고 
			참조 타입은 class, interface 등이 있는데 프로그래밍을 하다 보면 기본 타입의 데이터를 
			객체로 표현해야 하는 경우가 종종 있습니다. 
			이럴 때에 기본 자료타입(primitive type)을 객체로 다루기 위해서 
			사용하는 클래스들을 래퍼 클래스(wrapper class)라고 합니다. 
			자바는 모든 기본타입(primitive type)은 값을 갖는 객체를 생성할 수 있습니다. 
			이런 객체를 포장 객체라고도 하는데 그 이유는 기본 타입의 값을 내부에 두고 포장하기 때문입니다. 
			래퍼 클래스로 감싸고 있는 기본 타입 값은 외부에서 변경할 수 없습니다. 
			만약 값을 변경하고 싶다면 새로운 포장 객체를 만들어야 합니다.
		 */
	}



	private void test1() {
		ArrayList list1 = new ArrayList();
		List<Object> list2 = new ArrayList();
//		가장 선호되는 게 바로 이 2번임
		Collection list3 = new ArrayList();
		
		String str = "-----------------------------";
		
		list1.add("apple");
		list1.add(new Student());
		list1.add(123);
		list1.add(123);
		list1.add(new Date());
		
		System.out.println(str);
//		순서를 서로 바꾸면 순서를 유지해준다.
//		중복값도 허용해준다.
		
		System.out.println(list1);
//		요소들을 담을 수 있도록 오버라이딩이 되어있다.
		
		System.out.println(str);
		
		//특정요소 : 인덱스로 접근
		System.out.println(list1.get(0));
		System.out.println(list1.get(3));
		
		System.out.println(str);
		
		//요소개수 확인
		System.out.println(list1.size());
		
		System.out.println(str);
		
		//반복문 활용
		for(int i = 0; i < list1.size(); i++)
			System.out.println(list1.get(i));
		
		System.out.println(str);
		
		for(Object o : list1) {
			System.out.println(o);
		}
		
//		제네릭이 뭐야? Generic
//		특정 타입만 요소로 받겠어!
		
	}

	/**
	 * 배열의 한계
	 */
	private void test0() {
		
		Student[] arr = new Student[3];
		
		arr[0] = new Student(1, "홍길동");
		arr[1] = new Student(2, "신사임당");
		arr[2] = new Student(3, "장영실");
	
		//학생 추가
		Student[] arr1 = new Student[10];
		//학생 2명 추가
		//위에 new student는 사용못해서 새로 배열 만들어야한다
		//10개 다 안써도 미리 좀 여유롭게 공간 만들어놔도 ㄱㅊ
		System.arraycopy(arr, 0, arr1, 0, arr.length);
		arr1[3] = new Student(4, "세종대왕"); 
		arr1[4] = new Student(5, "윤봉준");
		
		//신사임당 학생이 전학을 가버렸다면?
		
//		다음요소를 하나씩 앞당기는 작업
		arr1[1] = null;
		arr1[1] = arr1[2];
		arr1[2] = arr1[3];
		arr1[3] = arr1[4];
		arr1[4] = null;
		
//		arr 1번지에 null을 대입시킨다.
//		하지만 이렇게 중간을 빈 상태로 관리할 수는 없으므로 앞당기는 작업을 해야 하겠지?
		
		//학생1명추가 : 중간에 삽입
		arr1[4] = arr1[3]; // 바로 유관순 추가하면 현2번이 삭제되므로 또 뒤로 한번씩 미뤄줘야함
		arr1[3] = arr1[2];
		arr1[2] = arr1[1];
		
		arr1[1] = new Student(2, "유관순");
		
		//확인
		
		for(Student s : arr1)
			System.out.println(s); // 제외자는 null로 출력된다
		
	}	

}
