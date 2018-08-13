package com.moneymoney.app.model.account.pojo;

import java.time.LocalDate;


import com.moneymoney.framework.account.pojo.Customer;

public class MMCustomer extends Customer {

	public MMCustomer(String customerName, long contactNumber, LocalDate dateOfBirth, String address,
			String nationality, String gender,String email) {
		super(customerName, contactNumber, dateOfBirth, address, nationality, gender,email);
	}

}
