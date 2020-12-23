package controller;

import io.CheckID;
import io.GeneratingAccount;
import model.vo.User;

public class AccountController {
	private CheckID checkId = new CheckID();
	private GeneratingAccount generatingAccount = new GeneratingAccount();
	
	public void generate(User user) {
		generatingAccount.generate(user);
	}
	
}
