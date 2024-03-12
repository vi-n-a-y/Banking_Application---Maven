package com.vin.BankingApplication.service;

import java.util.List;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.Transaction;

public interface AccountService {

	Account addAccountDetails(Account account);

	Account createAccount(Account account);

	Account getAccountById(Long id);

	List<Transaction> getUserTransaction(Long id);

}
