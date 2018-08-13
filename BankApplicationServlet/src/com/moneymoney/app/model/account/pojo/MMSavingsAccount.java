package com.moneymoney.app.model.account.pojo;

import com.moneymoney.framework.account.pojo.Customer;
import com.moneymoney.framework.account.pojo.SavingsAccount;

public class MMSavingsAccount extends SavingsAccount {

	public MMSavingsAccount(Customer accountHolder, boolean salary) {
		super(accountHolder, salary);
		// TODO Auto-generated constructor stub
	}

	public MMSavingsAccount(Customer accountHolder, double accountBalance, boolean salary) {
		super(accountHolder, accountBalance, salary);
		// TODO Auto-generated constructor stub
	}

	
}
