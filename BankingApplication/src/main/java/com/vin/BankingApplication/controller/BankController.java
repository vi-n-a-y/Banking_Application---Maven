package com.vin.BankingApplication.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.User;
import com.vin.BankingApplication.service.AccountService;
import com.vin.BankingApplication.service.UserService;

@RestController
@RequestMapping("/api/bank")
public class BankController {
	private  UserService userService;
	private AccountService accountService;
	
//	@Autowired
	public BankController(UserService userService , AccountService accountService) {
		super();
		this.userService = userService;
		this.accountService=accountService;
	}
	
////Register	
//	@PostMapping()
//	public ResponseEntity<User> saveUser(@RequestBody User user){
//		
//		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
//	}
	
	@PostMapping()
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PostMapping("/get")
	public User CheckCredintials(@RequestParam String uname,@RequestParam String password) {
		return userService.CheckCredintials(uname, password);
		
	}
	
	@PostMapping("/add/acc")
	public Account addAccountDetails(@RequestBody Account acc) {
		return accountService.addAccountDetails(acc);
		
	}
	
//	@PostMapping("/get/acc")
//	public Account getAccountDetails(@RequestParam  Long id) {
//		return accountService.getAccountDetails(id);
//	}
	
//	@PostMapping("/get/acc")
//	public Account getAccountDetails(@RequestParam  String accNmbr) {
//		return accountService.getAccountDetails(accNmbr);
//	}
	
	  @GetMapping("/users/{userId}/accounts")
	    public ResponseEntity<List<Account>> getUserAccounts(@PathVariable Long userId) {
	        List<Account> accounts = userService.getUserAccounts(userId);
	        return ResponseEntity.ok(accounts);
	    }



	


}
