package kh.java.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kh.java.collection.list.comp.StudentNameAscending;
import kh.java.collection.list.comp.StudentNameDscending;
import kh.java.collection.list.comp.StudentNoDescending;

public class SortTest {

	public static void main(String[] args) {
		SortTest s = new SortTest();
//		s.test1();
		s.test2();

	}

	/**
	 * 커스텀클래스의 정렬
	 */
	private void test2() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(2,"신사임당"));
		list.add(new Student(1,"홍길동"));
		list.add(new Student(4,"유관순"));
		list.add(new Student(5,"윤봉길"));
		list.add(new Student(3,"세종대왕"));
		System.out.println(list); // 지정한대로 21453순으로 출력
		
		//번호 오름
		Collections.sort(list); //알아서 할수 없는애라서 콕집어서 말해줘여한다.
		System.out.println(list); //1~5으로 순서대로 출력됨 student에서 override를 헀기때문
		
		//번호 내림차순
		Comparator<Student> comp = new StudentNoDescending();
		Collections.sort(list, comp);
		System.out.println(list); //StudentNoDescending으로 override 한 후 출 역순으로
		
		//이름 오름차순
		comp = new StudentNameAscending();
		
		Collections.sort(list, comp);
		System.out.println(list); //현재 가나다 역순으로 
		
		//이름 내림차순
		comp = new StudentNameDscending();
		Collections.sort(list, comp);
		System.out.println(list);
		
	}

	/**
	 * 오름차순 - 사전등재순
	 * 내림차순 - 사전등재 역순
	 * 객체가 들어있는 리스트 정렬이 복잡함
	 * collection의 정렬
	 * 
	 * - Comparable : 기본정렬(딱한가지)
	 * - Comparator : 여러 정렬기준(클래스당 하나)
	 * 
	 * 
	 */
	private void test1() {
		List<Integer> list = new ArrayList<>();
		//   요소에 해당하는 이것엣 comparable 해주면됨.
		list.add(3);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(1);
		System.out.println(list); //[3, 2, 4, 5, 1]
		
		//정렬 Integer 기본정렬 Comparable구현 -->오름차순구현
//		Collections.sort(list);
		list.sort(null);
		// 기본정렬하고싶으면 null값
		//제네릭타입<? super 하위타입> : 와일드카드의 범위를 특정 객체의 상위 클래스만 올 수 있습니다
		
		System.out.println(list); // [1, 2, 3, 4, 5]
		//public final class Integer extends Number implements Comparable<Integer>
		//sort를 호출하면 저장순서가 날라감. 저장순서가 중요하면 복사를 진행후에 처리하는것을 추천
		
		
		//기본정렬외에 정렬기준을 제시하고 싶다면 comparator객체이용
		//역순은 많이사용해서 미리 만들어둠
		Comparator<Integer> comp = Collections.reverseOrder();
//		Collections.sort(list, comp);
		list.sort(comp);
		System.out.println(list); //[5, 4, 3, 2, 1]
		
		List<String> strList = new ArrayList<>();
		strList.add("ghi");
		strList.add("jkl");
		strList.add("abc");
		strList.add("mno");
		strList.add("def");
		System.out.println(strList); //내가 list한 순서대로 출력
		
//		Collections.sort(strList);
		strList.sort(null);
		System.out.println(strList); //사전에 등재된순서로 출력[abc, def, ghi, jkl, mno]
		//strList.sort(null);를 작성해 줌으로 써[abc, def, ghi, jkl, mno] 다시 오름차순으로
		
		Comparator<String> strComp = Collections.reverseOrder();
//		Collections.sort(strList, strComp);
		System.out.println(strList); //[mno, jkl, ghi, def, abc]
	}

}
