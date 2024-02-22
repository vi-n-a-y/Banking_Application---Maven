package com.vin.BankingApplication.service;

import java.util.List;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.User;

public interface UserService {
	User saveUser(User user);

	//User getUserById(int user_id);

	User CheckCredintials(String uname, String password);

	List<Account> getUserAccounts(Long userId);

}
