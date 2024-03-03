package com.vin.BankingApplication.service;

import com.vin.BankingApplication.model.Account;


public interface AccountService {
	
	
	
	Account addAccountDetails(Account account);

	Account createAccount(Account account);



	Account addAmountToAcc(String accNmbr, Double amount);

	Account sendMoney(String accNmbr, Double amount); 
	
	//Account getAccountDetails(Long id);
	//Account getAccountDetails(String accNmbr);

}
