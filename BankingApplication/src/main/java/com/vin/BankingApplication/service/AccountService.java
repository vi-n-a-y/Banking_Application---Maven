package com.vin.BankingApplication.service;

import com.vin.BankingApplication.model.Bank;

public interface BankService {
	Bank saveBank(Bank bank);

	Bank getBankById(int user_id);
	
	
	

}
