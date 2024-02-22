package com.vin.BankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.BankingApplication.model.Account;

public interface AccountRepository  extends JpaRepository<Account , Long> {
//	Account getById(Long id);

//	Account findByUserId(Long id);
//
//	Account findByUserID(Long id);
//	Account findByAccountNumber(String accNmbr);
//Account findByUser(Long id);	

}
