package com.vin.BankingApplication.service;

import java.util.List;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.Transaction;


public interface AccountService {
	
	
	
	Account addAccountDetails(Account account);

	Account createAccount(Account account);



	Account addAmountToAcc(Long id, Double amount);

	Account sendMoney(Long id, Double amount);

	Account getAccountById(Long id);

	List<Transaction> getUserTransaction(Long id);

	Account setUserTransaction(Long id, List<Transaction> transactions); 
	
	//Account getAccountDetails(Long id);
	//Account getAccountDetails(String accNmbr);

}
