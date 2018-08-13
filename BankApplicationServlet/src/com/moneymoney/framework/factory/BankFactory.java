package com.moneymoney.framework.factory;

import java.util.Map;

import com.moneymoney.framework.account.pojo.CurrentAccount;
import com.moneymoney.framework.account.pojo.SavingsAccount;

/**
 * 
 * 
 * 
 * For creating the account objects
 *
 */
public abstract class BankFactory {
	
	public abstract SavingsAccount createNewSavingsAccount(Map<String, Object> account);
	
	public abstract CurrentAccount createNewCurrentAccount(Map<String, Object> account);
	
	
}
