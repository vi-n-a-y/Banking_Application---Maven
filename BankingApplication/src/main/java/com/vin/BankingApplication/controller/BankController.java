package com.vin.BankingApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.User;
import com.vin.BankingApplication.service.AccountService;
import com.vin.BankingApplication.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/bank")
public class BankController {
	private  UserService userService;
	private AccountService accountService;
	
//	@Autowired
	public BankController(UserService userService, AccountService accountService) {
		super();
		this.userService = userService;
		this.accountService = accountService;
	}

//Register	
	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/{username}")
	public ResponseEntity<List<User>> CheckCredintials(@PathVariable String username) {
//	    String username = user.getUname();

		List<User> users = userService.getUserDataByUsername(username); // Assuming this method retrieves all users from
																		// the database
		return ResponseEntity.ok(users);
//	    userService.isValidCredentials(username, password);
		// Return all users

	}

	// after entring the particular userId the method fetch all the accounts belong
	// to the user.
	@GetMapping("/{userId}")
	public ResponseEntity<List<Account>> getUserAccounts(@PathVariable Long userId) {
		List<Account> accounts = userService.getUserAccounts(userId);
		return ResponseEntity.ok(accounts);
	}
	
    @GetMapping("/acc/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Account account =accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

	// its add account the user and get all account details and user details
	@PostMapping("/set/{userId}")
	public ResponseEntity<User> addAccountsToUser(@PathVariable Long userId, @RequestBody List<Account> accounts) {
		User updatedUser = userService.addAccountsToUser(userId, accounts);
		return ResponseEntity.ok(updatedUser);
	}
	//add money to the specfic account
    @PutMapping("/addAmt/{accNmbr}")
    public ResponseEntity<Account> addAmountToAcc(@PathVariable String accNmbr ,@RequestBody Map<String , Double> request){
        Double amount = request.get("amount"); //storing the input
        Account account = accountService.addAmountToAcc(accNmbr , amount);
        return ResponseEntity.ok(account);
    }
	
    
    @PutMapping("/sendMoney/{accNmbr}")
    public ResponseEntity<Account> sendMoney(@PathVariable String accNmbr,@RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        Account account = accountService.sendMoney(accNmbr, amount);
        return ResponseEntity.ok(account);
    }
	
	
	
	
	
	

}



//public ResponseEntity<String> CheckCredintials(@RequestBody User user) {
//	String username=user.getUname();
//	String password=user.getPassword();	
//	
//	if (userService.isValidCredentials(username, password)) {
//        return ResponseEntity.ok("Login successful");
//    } else {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//    }
//	
//}

//
//@PostMapping("/add/acc")
//public Account addAccountDetails(@RequestBody Account acc) {
//	return accountService.addAccountDetails(acc);
//	
//} 

