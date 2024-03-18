package com.vin.BankingApplication.service.impl;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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
	public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
		super();
		this.transactionRepository = transactionRepository;
		this.accountRepository = accountRepository;
	}

	public Account addAmountToAcc(Long id, Double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));

		double totalAmount = account.getCurrBalance() + amount;
		account.setCurrBalance(totalAmount);
		Account savedAccount = accountRepository.save(account);
		return savedAccount;
	}

	public Account sendMoney(Long id, Long id1, Double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
		Account account1 = accountRepository.findById(id1)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id1));
		if (account.getCurrBalance() < amount) {
			throw new RuntimeException("Insufficient balance , before sending amout add amount to your account");
		}
		double senderBal = account.getCurrBalance() - amount;
		double receiveBal = account1.getCurrBalance() + amount;
		System.out.println("the available balance in sender bank is :" + senderBal);
		System.out.println("the available balance in receiver bank is :" + receiveBal);
		account.setCurrBalance(senderBal);
		account1.setCurrBalance(receiveBal);
		Account senderAccount = accountRepository.save(account);
		Account receiveAccount = accountRepository.save(account1);
		return senderAccount;
	}

	@Transactional
	public Transaction setUserTransaction(Account fromAccount, Account toAccount, double amount, String description) {

		System.out.println(fromAccount.getCurrBalance());
		Transaction transaction = new Transaction();

		long senderId = fromAccount.getId();
		long receiverId = toAccount.getId();
		if (sendMoney(senderId, receiverId, amount) != null) {

			transaction.setTrxnDate(LocalDate.now());
			transaction.setFromAccount(fromAccount);
			transaction.setToAccount(toAccount);
			transaction.setTransactionType("Send");
			transaction.setDescription(description);
			transaction.setTrxnAmount(amount);
			transaction.setBalance(fromAccount.getCurrBalance());
			System.out.println("the balance is the sender account is : " + fromAccount.getCurrBalance());
		}
		System.out.println(fromAccount.getId());
		transactionRepository.save(transaction);
		return transaction;
	}

	@Override
	public Transaction setAddTransaction(Account fromAccount, double amount) {
		long accountId = fromAccount.getId();
		Transaction transaction = new Transaction();
		if (addAmountToAcc(accountId, amount) != null) {
			transaction.setTrxnDate(LocalDate.now());
			transaction.setFromAccount(fromAccount);
			transaction.setToAccount(fromAccount);
			transaction.setTransactionType("Add");
			transaction.setDescription("Self");
			transaction.setTrxnAmount(amount);
			transaction.setBalance(fromAccount.getCurrBalance());
		}
		transactionRepository.save(transaction);
		return transaction;
	}

	@Override
	public List<Transaction> generateStatement(Account account, String startDate, String endDate) {
		System.out.println("the start date is : " + startDate);
		System.out.println("the end date is : " + endDate);
		LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
		LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);
		System.out.println("After parse the start date is : " + start);
		System.out.println("After parse the end date is : " + end);
		List<Transaction> transactionList = transactionRepository.findAll().stream()
				.filter(transaction -> transaction.getFromAccount().equals(account)).filter(transaction -> {
					LocalDate trxnDate = transaction.getTrxnDate();
					return trxnDate != null && !trxnDate.isBefore(start) && !trxnDate.isAfter(end);
				}).collect(Collectors.toList());
		return transactionList;
	}
}
