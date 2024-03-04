package com.vin.BankingApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.Transaction;
import com.vin.BankingApplication.repository.TransactionRepository;
import com.vin.BankingApplication.service.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService {
	
		private TransactionRepository transactionRepository;
		
		
	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository=transactionRepository;
	}


	
}
