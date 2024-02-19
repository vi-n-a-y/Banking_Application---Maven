package com.vin.BankingApplication.service;

import com.vin.BankingApplication.model.User;

public interface UserService {
	
	User saveBank(User user);

	User checkCredintials(String userName,String userPass);

}
