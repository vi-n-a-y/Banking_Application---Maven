package com.vin.BankingApplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.BankingApplication.exception.ResourceNotFoundException;
import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.Transaction;
import com.vin.BankingApplication.repository.AccountRepository;
import com.vin.BankingApplication.repository.TransactionRepository;
import com.vin.BankingApplication.service.TransactionService;

import jakarta.transaction.Transactional;


@Service
public class TransactionServiceImpl implements TransactionService {
	
		private TransactionRepository transactionRepository;
		 private AccountRepository accountRepository;
		
	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository ,AccountRepository accountRepository) {
		super();
		this.transactionRepository=transactionRepository;
		this.accountRepository=accountRepository;
	}
	


	


    @Transactional
    public Transaction setUserTransaction(Account fromAccount, Account toAccount,String accType, double amount, String description) {
        // Deduct amount from the sender's account

    	
    	System.out.println(fromAccount);
    	
    	Transaction transaction = new Transaction();
    	fromAccount.getId();    	
    	if(accType.equals("send")) {
        fromAccount.setCurrBalance(fromAccount.getCurrBalance() - amount);
        accountRepository.save(fromAccount);

        // Add amount to the receiver's account
        toAccount.setCurrBalance(toAccount.getCurrBalance() + amount);
        accountRepository.save(toAccount);

        // Create a transaction record
        
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setTransactionType(accType);
        transaction.setDescription(description);
        transaction.setTrxnAmount(amount);
    	}
    	else {
//    		 fromAccount.setCurrBalance(fromAccount.getCurrBalance() + amount);
    		 accountRepository.save(fromAccount); 
    		 transaction.setFromAccount(fromAccount);
    	        transaction.setToAccount(fromAccount);
    	        transaction.setTransactionType(accType);
    	        transaction.setTrxnAmount(amount);
    	        
    		
    	}
        // Set other transaction properties as needed
        transactionRepository.save(transaction);
        return transaction;
    }
	
	
	
//	@Transactional
//    public void performTransaction(Account fromAccount, Account toAccount, double amount, String description) {
//        // Deduct amount from the sender's account
//        fromAccount.setCurrBalance(fromAccount.getCurrBalance() - amount);
//        accountRepository.save(fromAccount);
//
//        // Add amount to the receiver's account
//        toAccount.setCurrBalance(toAccount.getCurrBalance() + amount);
//        accountRepository.save(toAccount);
//
//        // Create a transaction record
//        Transaction transaction = new Transaction();
//        transaction.setFromAccount(fromAccount);
//        transaction.setToAccount(toAccount);
//        transaction.setDescription(description);
//        transaction.setTrxnAmount(amount);
//        // Set other transaction properties as needed
//        transactionRepository.save(transaction);
//    }
}
