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
public class AccountServiceImpl implements AccountService {

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

	public Account createAccount(Account account) {
		// Set the user for the account
		User user = account.getUser(); // Assuming getUser method in Account returns User
		account.setUser(user);

		// Save the account
		return accountRepository.save(account);
	}

	@Override
	public Account getAccountById(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cannot find the given Account"));
		return account;
	}

	@Override
	public List<Transaction> getUserTransaction(Long id) {
		Account account = accountRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("transactions is not found withe the accountId : " + id));
		if (account != null) {
			return account.getTransactions();
		}
		return Collections.emptyList();
	}
}
