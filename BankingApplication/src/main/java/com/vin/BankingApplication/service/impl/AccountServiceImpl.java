package com.vin.BankingApplication.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.BankingApplication.exception.ResourceNotFoundException;
import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.Transaction;
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




	




	
	
	public Account addAmountToAcc(Long id , Double amount) {
	    Account account = accountRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id)); // if doesnt exists in the database then throw exception
	    double totalAmount = account.getCurrBalance() + amount;
	    account.setCurrBalance(totalAmount);
	    Account savedAccount = accountRepository.save(account);
	    return savedAccount;
	    }




	
	public Account sendMoney(Long id, Double amount) {
		 Account account = accountRepository.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id)); 
		if(account.getCurrBalance()<amount) {
			throw new RuntimeException("Insufficient balance , before sending amout add amount to your account");
		}
		double avaliBalance=account.getCurrBalance()-amount;
		account.setCurrBalance(avaliBalance);
		Account savedAccount=accountRepository.save(account);
		return savedAccount;
		 
		
	}




	@Override
	public Account getAccountById(Long id) {
	    Account account = accountRepository
	            .findById(id)
	            .orElseThrow(()-> new RuntimeException("Cannot find the given Account"));
	    return account;
	    }
	
	@Override
	public List<Transaction> getUserTransaction(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("transactions is not found withe the accountId : "+id));
		if (account != null) {
            return account.getTransactions();
        }
        return Collections.emptyList();
    }




	@Override
	public Account setUserTransaction(Long id, List<Transaction> transactions) {
		Account account =accountRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("transactions not created with accountId : "+id));
				
		  for (Transaction transaction : transactions) {
	           transaction.setAccount(account);
	        }
	        
	        // Add accounts to the user and save
	        account.getTransactions().addAll(transactions);
	        accountRepository.save(account);
	        return account;
	    }
		
		
	}
		
	
	
	
	
	
	




