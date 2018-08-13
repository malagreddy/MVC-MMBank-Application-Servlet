package com.moneymoney.app.model.factory;

import java.time.LocalDate;
import java.util.Map;

import com.moneymoney.app.model.account.pojo.MMCurrentAccount;
import com.moneymoney.app.model.account.pojo.MMCustomer;
import com.moneymoney.app.model.account.pojo.MMSavingsAccount;
import com.moneymoney.framework.account.pojo.CurrentAccount;
import com.moneymoney.framework.account.pojo.SavingsAccount;
import com.moneymoney.framework.factory.BankFactory;

public class MMBankFactory extends BankFactory {

	@Override
	public CurrentAccount createNewCurrentAccount(Map<String, Object> arg0) {
		System.out.println("L2.1");
		return new MMCurrentAccount(
				(new MMCustomer((String) arg0.get("accountHolderName"), (long) arg0.get("contactNo"),
						(LocalDate) arg0.get("dateOfBirth"), (String) arg0.get("address"), (String) arg0.get("nationality"),
						(String) arg0.get("gender"),(String)arg0.get("email"))),
				(double) arg0.get("accountBalance"), (double) arg0.get("overdraft"));
	}

	@Override
	public SavingsAccount createNewSavingsAccount(Map<String, Object> arg0) {
	System.out.println("L2.2");
	System.out.println(arg0.get("salary"));
		return new MMSavingsAccount((new MMCustomer((String) arg0.get("accountHolderName"), (long) arg0.get("contactNo"),
						(LocalDate) arg0.get("dateOfBirth"), (String) arg0.get("address"), (String) arg0.get("nationality"),
						(String) arg0.get("gender"),(String)arg0.get("email"))),
				(double) arg0.get("accountBalance"), (boolean)arg0.get("salary"));
	}

}
