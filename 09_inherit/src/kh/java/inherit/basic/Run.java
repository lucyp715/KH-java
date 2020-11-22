package kh.java.inherit.basic;

/**
 * 상속
 * 부모클래스의 멤버(필드, 메소드)를 자식클래스에서 가져다 쓸수 있는 것.
 * 
 * 1.부모멤버는 자식클래스에서 선언없이 사용가능.
 *    - 물려받은 메소드는 오버라이딩(물려받은 메소드 다시쓰기) 가능
 * 2.모든 클래스는 object클래스의 후손클래스
 *    - object의 모든 메소드를 후손클래스에서 사용가능
 * 3. 부모클래스의 초기화블럭, 생성자는 상속불가
 *    - 자식클래스 객체 생성시 ,super(); 부모생성자를 먼저 호출
 * 4. 부모클래스의 private 멤버는 상속은 되지만, 같은 클래스가 아니므로 접근불가
 *    - public메소드를 이용해 우회접근.(setter/getter)
 *    -값대입시에 부모생성자super를 이용해 처리 가능
 * 
 *
 */
public class Run {

	public static void main(String[] args) {
		
		Parent p = new Parent();
		p.name ="고길동";
		p.age = 30;
		p.say(); //자기 say
//		p.doGame(); // parent가 child꺼를 쓸수는 없다. child만 parent꺼를 쓸수있다.
		
		Child c = new Child();
		c.name = "둘리";
		c.age = 300;
		c.printInfo(); // [둘리,300] ->public class Child extends Parent  이것만 child class해줬을대도 나옴
		c.say(); //안녕하세요, 애비입니다.
		c.doGame();
		
		Child2 c2 = new Child2();
		c2.name = "도우너";
		c2.age = 40;
		c2.say();  //새로안했기 때문에 애비꺼가 나옴 -> 하지만 다시 say를 해서 옃집자식으로나옴
		c2.printInfo(); 
//		c2.doGame(); //형제고 난발이고 그런거 없음
		
		GrandChild gc = new GrandChild();
		gc.name = "둘리 아들";
		gc.age = 3;
		gc.say(); // child를 덮어써서 child 출력문으로 그대로 나옴.
		gc.printInfo();
		gc.doGame(); // child를 extends했기 떄문에 child가 받은 것을 그대로 물려받음
		

	}

}
