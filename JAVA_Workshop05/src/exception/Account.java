package exception;

public class Account {

	private String account;
	private double balance;
	private double interestRate;
	
	public Account() {}

	public Account(String account, double balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double calculateInterest(){
		// 이자계산 : 현재잔고 * 이자율
		return balance * interestRate/100;
		}
	
		public void deposit(double money)throws Exception{
		// 입금 처리 및 예외상황 처리
		//입금 금액이 0보다 적을 때 “입금 금액이 0보다 적습니다.”라고 출력
			if(money < 0) {
				throw new Exception("입금 금액이 0보다 적습니다.");
		}
		
			this.balance += money;			
		}
		public void withdraw(double money)throws Exception{
		// 출금 처리 및 예외상황 처리
			if(money <0 || money > balance) {
				throw new Exception("출금 금액이 0보다 적거나 현재 잔액보다 많습니다");
			}
			this.balance -=money;
	
		}
	
}
