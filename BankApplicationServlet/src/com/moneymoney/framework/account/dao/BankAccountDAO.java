package com.moneymoney.framework.account.dao;

import java.util.Set;

import com.moneymoney.framework.account.pojo.BankAccount;

public interface BankAccountDAO {

	/**
	 * @param bankAccount
	 * 
	 * This method takes account object and adds it in the database
	 */
	void addBankAccount(BankAccount bankAccount);

	/**
	 * @return Set of Accounts
	 * 
	 * This method is responsible for returning all the active accounts
	 */
	Set<BankAccount> viewAll();

}