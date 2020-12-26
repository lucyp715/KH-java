package kh.java.oop.encapsulation;

public class Account {

	//필드/메소드의 접근제한자는 public protected default private
	//private 해당 클래스 안에서만 접근 가능
	private String name; // private 단독으로 사용못해서 public을 사용해서 지금 사용할 수 잇게됨
	private long balance;
	
	
	/**
	 * setter(private 있음 무조건 void)
	 * 필드값 대입 -> 가까운게 있으면 가까운거부터 사용
	 */
//	public void setName(String name_) {
//   	name = name_;
		//this는 현재객체를 가리키는 참조변수 ->위에있는 name을 저장했다가
	// 다기 String name쪽으로 가져오기 떄문에 동일함. name_ 에서 _제거
	
	public void setName(String name) {
		//this는 현재객체를 가리키는 참조변수
		this.name = name; // 앞의 name 은 private name 을 
		                 //뒤는 public void setName(String name)의 name을 이용
	}
	
	public void setBalance(long balance_) {
		this.balance = balance_;
	}
	
	/**
	 * getter(private 없음. 반드시 return값이음)
	 * 필드값 가져오기
	 * 
	 * 해당의 필드의 자료형과 getter리턴타입은 동일하다.(void될수없음)
	 */
	public String getName() {
		return name;
	}
	
	public long getBalance() {
		return balance;
	}
	/**
	 * 입금메소드
	 * 
	 * public 모든 패키지, 모든 클래스에서 접근 가능
	 */
	//public 이 붙으면 언제 어디서든 사용가능하다
	public void deposit(int money) {
		
		if(money > 0) {
			balance += money;
			System.out.printf("%s 님 계좌에 %d 원 입금완료!%n", name, money);
			System.out.printf("%s 님 계좌좐액은 %d 원 입금완료!%n", name, balance);
			
		}
		else {
			System.out.println("유효한 금액을 입려가세요.");
		}
		
	}
	/**
	 * 출금 메소드
	 */
	public void withdraw(int money) {
		
		if(money <= balance) {
			balance -= money;
			System.out.printf("%s 님 계좌에 %d 원 입금완료!%n", name, money);
			System.out.printf("%s 님 계좌좐액은 %d 원 입금완료!%n", name, balance);
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
	}
}
