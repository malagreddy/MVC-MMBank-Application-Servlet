package com.moneymoney.app.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.moneymoney.app.model.dao.MMBankCollection;
import com.moneymoney.app.model.factory.MMBankFactory;
import com.moneymoney.framework.account.dao.BankAccountCollection;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;
import com.moneymoney.framework.service.BankAccountService;
//service layer for web app...This class acts as a bridge between the controller and the dao
//and performs some important functions for the controller
public class MMBankAccountService extends BankAccountService {

	BankAccountCollection collection;

	public MMBankAccountService() {
		super();
		collection = new MMBankCollection();
	}

	@Override

	public void createNewSavingsAccount(Map<String, Object> account) {

		collection.addBankAccount(new MMBankFactory().createNewSavingsAccount(account));
	}

	@Override
	public void createNewCurrentAccount(Map<String, Object> account) {
		collection.addBankAccount(new MMBankFactory().createNewCurrentAccount(account));
	}

	@Override
	public Collection<BankAccount> getAllAccounts() {
		return collection.viewAll();
		// return null;
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> listOfCustomer = new ArrayList<>();
		(collection.viewAll()).stream().forEach((element) -> listOfCustomer.add(element.getAccountHolder()));
		return listOfCustomer;
	}

	@Override
	public BankAccount getAccountById(int id) {
		for (BankAccount account : collection.viewAll()) {
			if (account.getAccountNumber() == id)
				return account;
		}
		return null;

	}

	public int withdraw(int accNo, double amount) {
		BankAccount account = getAccountById(accNo);
		double amountBefore = account.getAccountBalance();
		account.withdraw(amount);

		if (amountBefore == account.getAccountBalance())
			return -1;
		else
			return 1;
	}

	@Override
	public int fundTransfer(int accNoSender, int accNoReciever, double amount) {
		/*System.out.println(this.getCurrrentBalance(this.getAccountById(accNoSender)));
		
		if (this.withdraw(accNoReciever, amount) == 1) {
			System.out.println(this.getCurrrentBalance(this.getAccountById(accNoSender)));
			this.getAccountById(accNoReciever).deposit(amount);
			System.out.println(this.getCurrrentBalance(this.getAccountById(accNoReciever)));
			return 1;
		}
		return -1;*/
		
		BankAccount account = getAccountById(accNoSender);
		double amountBefore = account.getAccountBalance();
		account.withdraw(amount);
		if (amountBefore == account.getAccountBalance())
			return -1;
		else
		{
			account = getAccountById(accNoReciever);
			account.deposit(amount);
			return 1;
		}
		
	}
}
