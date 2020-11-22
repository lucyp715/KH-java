package kh.java.oop.field;

public class IPhoneMain {
	
	/**
	 * 클래스변수 IPhone.WIDTH : 프로그램 시작시(해당클래스가 최초사용시) ~ 프로그램 종료시
	 * 인스턴스변수 owner : 객체생성시 ~ 객체소멸시(가비지컬렉터에 의한 삭제)
	 * 지역변수 sum : 메소드호출시 ~ 메소드 종료시
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		IPhone hong = new IPhone();
		hong.setOwner("홍길동");
		hong.setPhoneNumber("01012341234");
		
		IPhone sin = new IPhone();
		sin.setOwner("신사임당");
		sin.setPhoneNumber("01056785678");
		
		System.out.printf("%s : %s%n", hong.getOwner(), hong.getPhoneNumber());
		System.out.printf("%s : %s%n", sin.getOwner(), sin.getPhoneNumber());
		
		
		//static
//		hong.width = 15; // 객체가 같기떄문에 
//		System.out.println(hong.width); //15
//		System.out.println(sin.width); //15
		System.out.println(IPhone.WIDTH); //공유 하려면 static 사용, class로 사용해서 
		System.out.println(IPhone.HEIGHT);
//		IPhone.WIDTH = 13; // 상수이므로 값변경 불가
		
		hong.heySiri(3, 10);  
		sin.heySiri(3, 5); // 바로 생성됬다가 바로 사라짐.
		
		//홍 아이폰 객체삭제
		hong = null; //이 코드가 나오기 전에는 살아있음. (숨만 쉬고 있는 상태)
		
	}

}
