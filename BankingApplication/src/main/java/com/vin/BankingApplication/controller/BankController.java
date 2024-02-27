package com.vin.BankingApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
//Register	
	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
//	@PostMapping()
//	public User saveUser(@RequestBody User user) {
//		return userService.saveUser(user);
//	}
	

//	public ResponseEntity<String> CheckCredintials(@RequestBody User user) {
//		String username=user.getUname();
//		String password=user.getPassword();	
//		
//		if (userService.isValidCredentials(username, password)) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//		
//	}
	@CrossOrigin
	@PostMapping("/get")
	public ResponseEntity<List<User>> CheckCredintials(@RequestBody User user) {
	    String username = user.getUname();
	    String password = user.getPassword();    
	    
	    List<User> users = userService.getUserDataByUsernameAndPassword(username,password); // Assuming this method retrieves all users from the database
	    
	    userService.isValidCredentials(username, password);
	        return ResponseEntity.ok(users); // Return all users
	   
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
	
	  @GetMapping("/get/accs")
	    public ResponseEntity<List<Account>> getUserAccounts(@RequestParam Long userId) {
	        List<Account> accounts = userService.getUserAccounts(userId);
	        return ResponseEntity.ok(accounts);
	    }
//	  
//	    @PostMapping("/accoun")
//	    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
//	        // Call the service method to create the account
//	        Account createdAccount = accountService.createAccount(account);
//
//	        // Return response with created account details
//	        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
//	    }
	//  @PostMapping("/accounts")
	   
//	    public ResponseEntity<User> createUserWithAccounts(@RequestBody User user) {
//	        User savedUser = userService.saveUserWithAccounts(user);
//	        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//	    }
	  
	  @PostMapping("/{userId}/accounts")
	    public ResponseEntity<User> addAccountsToUser(@PathVariable Long userId, @RequestBody List<Account> accounts) {
	        User updatedUser = userService.addAccountsToUser(userId, accounts);
	        return ResponseEntity.ok(updatedUser);
	    }
	  
}
