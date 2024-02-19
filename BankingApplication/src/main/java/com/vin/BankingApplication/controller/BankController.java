package com.vin.BankingApplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vin.BankingApplication.model.User;
import com.vin.BankingApplication.service.UserService;

@RestController
@RequestMapping("/api/bank")
public class BankController {
	private UserService userService;

	public BankController(UserService userService) {
		super();
		this.userService = userService;
	}
	
//Register	
	@PostMapping()
	public ResponseEntity<User> saveBank(@RequestBody User user){
		
		return new ResponseEntity<User>(userService.saveBank(user),HttpStatus.CREATED);
	}

	
//	@GetMapping
//	public ResponseEntity<Bank> checkCredintials@RequestParam(name="name") String user_name,@RequestParam(name="pass") String user_pass){
//		return new ResponseEntity<Bank>(bankService.checkCredintials(user_name,user_pass), HttpStatus.OK);
//	}
	
	
	
	@GetMapping
	public User checkCredintials(@RequestParam(name="name") String userName,@RequestParam(name="pass") String userPass) {
		return userService.checkCredintials(userName, userPass);
		
	}
	

}
