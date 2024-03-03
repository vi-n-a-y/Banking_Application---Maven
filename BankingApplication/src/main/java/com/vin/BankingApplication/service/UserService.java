package com.vin.BankingApplication.service;

import java.util.List;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.User;

public interface UserService {
	User saveUser(User user);

	//User getUserById(int user_id);

//	boolean isValidCredentials(String username,String password);

	List<Account> getUserAccounts(Long userId);

	List<User> getUserDataByUsername(String username);

//	User createUserWithAccounts(User user);

	//User saveUserWithAccounts(User user);

	User addAccountsToUser(Long userId, List<Account> accounts);

//	List<User> getAllUsers();

}
