package kh.java.oop.encapsulation;

public class AccountMain {

	public static void main(String[] args) {
			//계좌 객체
		Account acc = new Account();
//		acc.name = "홍길동";
//		acc.balance = 1_000_000;
		
		//account class에서 새터를 새로 해줌
		acc.setName("홍길동");
		acc.setBalance(1_000_000);
		//입금
//		acc.balance += 500_000; //직접 접근
//		System.out.printf("%s 님의 계좌 잔액은 %d원 입니다.%n",
//				          acc.name, acc.balance);
		acc.deposit(500_000);
		System.out.printf("%s 님의 계좌 잔액은 %d원 입니다.%n",
		                  acc.getName(), acc.getBalance());
		
		//출금
//		acc.balance -=700_000;
//		System.out.printf("%s 님의 계좌 잔액은 %d원 입니다.%n",
//		          acc.name, acc.balance);
		//마이너스가 되기도 하므로 직접접근으로는 오류가 나타날수도 있따.
		//기본적인 통장에 마이너스라는 개념은 없다
		acc.withdraw(700_000);
		acc.withdraw(1_700_000);
		System.out.printf("%s 님의 계좌 잔액은 %d원 입니다.%n",
                acc.getName(), acc.getBalance());
	}
	
	
	
}
