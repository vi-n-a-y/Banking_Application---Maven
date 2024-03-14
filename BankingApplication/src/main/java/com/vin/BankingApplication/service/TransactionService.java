package com.vin.BankingApplication.service;

import java.util.List;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.Transaction;

public interface TransactionService {

	Transaction setUserTransaction(Account fromAccount, Account toAccount, double amount,String description);

	Account addAmountToAcc(Long id, Double amount);

	Account sendMoney(Long id, long id1, Double amount);

	Transaction setAddTransaction(Account fromAccount, double amount);

	List<Transaction> generateStatement(Account account, String startDate, String endDate);

}
}
