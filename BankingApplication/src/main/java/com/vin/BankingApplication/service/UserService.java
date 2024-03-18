package com.vin.BankingApplication.service;

import java.util.List;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.User;

public interface UserService {
	User saveUser(User user);

	List<Account> getUserAccounts(Long userId);

	List<User> getUserDataByUsername(String username);

	User addAccountsToUser(Long userId, List<Account> accounts);

}
