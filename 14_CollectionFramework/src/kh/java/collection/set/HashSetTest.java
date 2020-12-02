package kh.java.collection.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import kh.java.collection.list.Student;

public class HashSetTest {

	public static void main(String[] args) {
		HashSetTest h = new HashSetTest();
//		h.test1();
//		h.test2();
//		h.test3();
//		h.test4();
		h.test5();
		
	}
	/**
	 * LinkedHashSet : 저장순서 유지
	 * TreeSet : 오름차순 정렬
	 */
	private void test5() {
		LinkedHashSet<String> set1 = new LinkedHashSet<>();
		set1.add("c");
		set1.add("b");
		set1.add("a");
		set1.add("b");
		set1.add("a");
		System.out.println(set1); // 중복제거됨 [c, b, a]
		
		/**
		 * 기본정렬 기준으로 요소 관리
		 */
		TreeSet<Integer> set2 = new TreeSet<>();
		set2.add(2);
		System.out.println(set2); //[2]
		set2.add(5);
		System.out.println(set2); //[2, 5]
		set2.add(4);
		System.out.println(set2); //[2, 4, 5]
		set2.add(3);
		System.out.println(set2); //[2, 3, 4, 5]
		set2.add(1);
		System.out.println(set2); //[1, 2, 3, 4, 5]

		
	}
	/**
	 * 커스텀클래스의 중복제거
	 * Student의 equals, haschCode 오버라이드 꼭세트로 해야함
	 */
	private void test4() {
		Set<Student> set = new HashSet<>();
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신사임당"));
		set.add(new Student(1, "홍길동"));
		System.out.println(set);
	}
	/**
	 * List ~ set
	 * 1. list -> set : 중복제거
	 * 2. set -> list : 순서
	 */

	private void test3() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(3);
		System.out.println(list); //[1, 2, 3, 1, 3]
		
		//list -> set
		Set<Integer> set = new HashSet<>(list); //지금 integer가지고
		System.out.println(set); // 중복제거됨 [1, 2, 3]
		
		//set -> list
		List<Integer> list2 = new ArrayList<Integer>(set);
		System.out.println(list2); //결과 적으로 똑같아보이지만 list의 [1, 2, 3] 다
		System.out.println(list2.get(0)); // 1
		list2.sort(Collections.reverseOrder());
		System.out.println(list2); // [3, 2, 1]
		
	}

	private void test2() {
		Set<String> set = new HashSet<>();
		set.add("abc");
		set.add("가나다");
		set.add("Hello World");
//		set.add(new Student()); // 사용할 수 없다고 오류매세지가 뜸 왜?
		
		//1.iterator
//		Iterator<String> iter = set.iterator();
//		while(iter.hasNext()) {
//			String s = iter.next(); // <string>으로 정해놨기 때문에 무조건 string으로 나옴
//			System.out.println(s);
//		}
		
		//2. forEach
		for(String s : set) {
			System.out.println(s);
		}
		
		//요소 포함여부
		System.out.println(set.contains("abc")); //true
		System.out.println(set.contains("123")); //false
		
	}

	private void test1() {
		HashSet set1 = new HashSet(); //generic 이용하는 애라서 오류 경고 난다
		Set set2 = new HashSet();
		Collection set3 = new HashSet(); //collections 랑 헷갈리면 안된다 한번더보기
		
		set1.add(123);
		set1.add("hello");
		set1.add(new Student(1, "홍길동"));
		set1.add(new Date());
		
		//System.out.println(set1); 
		//출력 [Tue Dec 01 12:47:48 KST 2020, Student [no=1, name=홍길동], 123, hello]
		//순서 상관없이 출력되기때문에 
		
		//중복을 허용하지않는다
		set1.add(123);
		set1.add("hello"); // 중복이 있어도 1번만 출력
		set1.add(new Student(1, "홍길동")); 
		set1.add(new Date());
		//new 할때마다 다른객체가 생성되는거기때문에
		//다르다고 판단하여 출력된다
		set1.add(new Date()); // 이거는 중복에 포함되지않고 size에도 포함안됌.
		
		//삭제
		set1.remove(123);
		
		//전체요소 삭제
		set1.clear();
		
		//요소가 존재하지 않는가?
		System.out.println(set1.isEmpty());
		System.out.println(set1.size()); // 중복을 허용하지않는다
		System.out.println(set1);
	
	}

}
