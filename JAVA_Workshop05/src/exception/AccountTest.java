package exception;

public class AccountTest {

	public static void main(String[] args) {
		Account a = new Account("441-0290-1203", 500000, 7.3);
		
		System.out.println("계좌번호: " + a.getAccount() 
						+ " 잔액: " + a.getBalance()
						+ " 이율: " + a.getInterestRate());

		// account 에 -10원 입금 – Exception 처리
		try {
			a.deposit(-10);
		} catch (Exception e) {
			System.out.println(e.getMessage());		
		}

		// account 에 600000원 출금 – Exception 처리
		try {
			a.withdraw(600000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 이자 출력 – 현재 잔고를 기준으로 고객에게 줄 이자 금액을 출력 한다
		System.out.println(a.calculateInterest());
	}
}