package com.vin.BankingApplication.service;

import com.vin.BankingApplication.model.Account;


public interface AccountService {
	
	
	
	Account addAccountDetails(Account account);

	Account createAccount(Account account); 
	
	//Account getAccountDetails(Long id);
	//Account getAccountDetails(String accNmbr);

}
