package com.vin.BankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.BankingApplication.model.Bank;

//dont need to add @AddRepository because spring jpa will implicity add the annotation
public interface BankRepository extends JpaRepository<Bank,Integer> {

	//Bank getUserId(int bankId);

	//Bank checkCredentials(String username, String password);
}
