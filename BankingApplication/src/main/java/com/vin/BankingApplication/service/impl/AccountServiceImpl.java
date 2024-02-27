package com.vin.BankingApplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.User;
import com.vin.BankingApplication.repository.AccountRepository;
import com.vin.BankingApplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	
	
	private AccountRepository accountRepository;

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	
	
	
	@Override
	public Account addAccountDetails(Account account) {
	  return accountRepository.save(account);	
		
	}
	
//	@Override
//	public Account getAccountDetails(Long id) {
//		return accountRepository.findByUser(id);
//	}

//	@Override
//	public Account getAccountDetails(String accNmbr) {
//		return accountRepository.findByAccountNumber(accNmbr);
//	}
	
	 public Account createAccount(Account account) {
	        // Set the user for the account
	        User user = account.getUser(); // Assuming getUser method in Account returns User
	        account.setUser(user);

	        // Save the account
	        return accountRepository.save(account);
	    }

}
