package com.vin.BankingApplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.BankingApplication.exception.ResourceNotFoundException;
import com.vin.BankingApplication.model.Bank;
import com.vin.BankingApplication.repository.BankRepository;
import com.vin.BankingApplication.service.BankService;


@Service
public class BankServiceImpl implements BankService {

	private BankRepository bankRepository;
	
	@Autowired
	public BankServiceImpl(BankRepository bankRepository) {
		super();
		this.bankRepository = bankRepository;
	}

	@Override
	public Bank saveBank(Bank bank) {
	
		return bankRepository.save(bank);
	}



	public Bank getBankById(int user_id) {
//Optional<Employee> employee = employeeRepository.findById(id);
//if(employee.isPresent()) {
//	return employee.get();
//}else {
//	throw new ResourceNotFoundException("Employee", "Id", id);
//}
return bankRepository.findById(user_id).orElseThrow(() -> 
				new ResourceNotFoundException("Bank", "Id", user_id));

}
	
	

}
