package com.vin.BankingApplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vin.BankingApplication.model.Bank;
import com.vin.BankingApplication.service.BankService;

@RestController
@RequestMapping("/api/bank")
public class BankController {
	private BankService bankService;

	public BankController(BankService bankService) {
		super();
		this.bankService = bankService;
	}
	
//Register	
	@PostMapping()
	public ResponseEntity<Bank> saveBank(@RequestBody Bank bank){
		
		return new ResponseEntity<Bank>(bankService.saveBank(bank),HttpStatus.CREATED);
	}
	
//	@GetMapping
//	public Bank checkUserNameAndPassword(@RequestParam String username,@RequestParam String password) {
//		return bankService.checkUserNameAndPassword(username, password);
//		
//	}
	
	@GetMapping("{id}")
	public ResponseEntity<Bank> getBankById(@PathVariable("id") int user_id){
		return new ResponseEntity<Bank>(bankService.getBankById(user_id), HttpStatus.OK);
	}

}
