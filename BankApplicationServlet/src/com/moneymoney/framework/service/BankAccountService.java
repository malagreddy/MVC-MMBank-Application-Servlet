package com.moneymoney.framework.service;

import java.util.Collection;
import java.util.Map;


import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;

public abstract class BankAccountService {

	
	public abstract void createNewSavingsAccount(Map<String, Object> account);

	public abstract void createNewCurrentAccount(Map<String, Object> account);
	
	public double getCurrrentBalance(BankAccount bankAccount) {
		return bankAccount.getAccountBalance();
	}
	
	public int getNextAccountNumber() {
		return BankAccount.getNextAccountNumber();
	}
	
	public abstract Collection<BankAccount> getAllAccounts();
	
	public abstract Collection<Customer> getAllCustomers();
	
	public abstract BankAccount getAccountById(int id);
	
	public abstract int withdraw(int accNo,double amount);
	
	public abstract int fundTransfer(int accNoSender,int accNoReciever,double amount);
}
