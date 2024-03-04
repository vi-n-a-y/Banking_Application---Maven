package com.vin.BankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.BankingApplication.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
