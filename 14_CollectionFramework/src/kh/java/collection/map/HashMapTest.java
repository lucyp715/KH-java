package kh.java.collection.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import kh.java.collection.list.Student;

/**
 * 
 * Map
 * -key, value를 한쌍으로 요소를 저장
 * -key는 중복을 허용하지 않는다
 * -동일한 key를 이용해서 요소를 저장하면, value가 덮어써진다
 *
 */
public class HashMapTest {

	public static void main(String[] args) {
		HashMapTest h =  new HashMapTest();
//		h.test1();
//		h.test2();
		h.test3();
	}
	/**
	 * VO객체 맵으로 관리하기
	 * - key : vo갹채의 고유필드
	 * -value : vo객체 
	 */
	private void test3() {
		Map<Integer, Student> map = new HashMap<>();
		map.put(1,  new Student(1,"홍길동"));
		map.put(2,  new Student(2,"신사임당"));
		map.put(3,  new Student(3,"세종"));
		System.out.println(map);
		
		//학생검색
		//containsKey - 이맴에 학생이 있는지 검사
		Boolean bool = map.containsKey(1); //위에서 1번이 있는가 있다 -> true
		System.out.println(bool);
		
		//containsValue :equals % hashcode override필수
		// -contains에 위에 값을 직접 넣어줘여한다
		bool = map.containsValue(new Student(3, "세종")); //있으면 true
	}

	/**
	 * 전체요소 열람 -map은 iterator을 사용못함
	 * 1.keySet() : key로만 set으로 구성
	 * 2.entrySet() : key,value로 set을 구성
	 */
	private void test2() {
		Map<String, Integer>map = new HashMap<>();
		map.put("홍길동", 90);
		map.put("신사임당", 97);
		map.put("세종", 88);
		map.put("장영실", 79);
		map.put("유관순", 99);
		
//		//keyset
//		Set<String> keySet = map.keySet(); // 이제부터 set을 제어하는것임
//		//1-1 forEach
//		for(String key : keySet) {
//			System.out.println(key + " = " + map.get(key));
//		}
//		
//		//1-2 iterator
//		Iterator<String> iter = keySet.iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			System.out.println(key + " = " + map.get(key));
//		}
		
		//2.entrySet
		//내부클래스
		//key value을 하나묶은것을 node객체로 관리 하고 그것을 관리하는 상위타입
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		//2-1 forEach
		//제너릭타입은           key     value 타입에따라 바뀔수 있다
		for(Map.Entry<String, Integer> entry : entrySet) {
			//System.out.println(entry);
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " = " + value);
		}
		
		//2-2  Iterator
		Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}

	private void test1() {
		HashMap<Object, Object> map1 = new HashMap<>();
		Map<String, Object> map2 = new HashMap();
		
		//요소추가
		//중복된 요소가 없다면 null리턴 -> vlaue값은 상관ㄴ key값만
		map2.put("honggd", "홍길동");
		map2.put("today", new Date());
		map2.put("점수", 99.9);
		map2.put("123", 456);
		//중복 저장되지 않는다
		Object removed = map2.put("123",789);
		System.out.println(removed); //아래와 같이 중복한것이있을때 중복되서 사라진걸보여준다
		//map2.put("123", 789); //동일한 key를 사용해서 앞서 사용한 456은 사라지고 789출력
		//중복된 key값이 있다면, 삭제된 value값 리턴
		
		
		//toString
		System.out.println(map2); //좌항 kwy 우항 value
		
		//get(Sting key) : Object 요소 하나만 가져오고싶다
		System.out.println(map2.get("today"));
		
		//size()
		System.out.println(map2.size());
		
		//remove(key)
		System.out.println(map2.remove("today"));
	
		
	}
	

}
