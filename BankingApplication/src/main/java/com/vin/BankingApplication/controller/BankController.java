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
import com.vin.BankingApplication.model.Transaction;
import com.vin.BankingApplication.model.User;
import com.vin.BankingApplication.service.AccountService;
import com.vin.BankingApplication.service.TransactionService;
import com.vin.BankingApplication.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/bank")
public class BankController {
	private  UserService userService;
	private AccountService accountService;
	private TransactionService transactionService;
	
//	@Autowired
	public BankController(UserService userService, AccountService accountService,TransactionService transactionService) {
		super();
		this.userService = userService;
		this.accountService = accountService;
		this.transactionService=transactionService;
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
    @PutMapping("/addAmt/{id}")
    public ResponseEntity<Account> addAmountToAcc(@PathVariable Long id ,@RequestBody Map<String , Double> request){
        Double amount = request.get("amount"); //storing the input
        Account account = accountService.addAmountToAcc(id , amount);
        return ResponseEntity.ok(account);
    }
	
    
    @PutMapping("/sendMoney/{id}")
    public ResponseEntity<Account> sendMoney(@PathVariable Long id ,@RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        Account account = accountService.sendMoney(id, amount);
        return ResponseEntity.ok(account);
    }
	
    @GetMapping("/trxns/{Id}")
	public ResponseEntity<List<Transaction>> getUserTransaction(@PathVariable Long Id) {
    	List<Transaction> transactions = accountService.getUserTransaction(Id);
		return ResponseEntity.ok(transactions);
	}

    @PostMapping("/trxn/{id}/{fromAcc}/{toAcc}")
	public ResponseEntity<Account> setUserTransaction(@PathVariable Long id,@PathVariable String fromAcc,@PathVariable String toAcc , @RequestBody List<Transaction> transactions) {
		Account account = accountService.setUserTransaction(id,fromAcc,toAcc, transactions);
		return ResponseEntity.ok(account);
	}



	    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transferMoney(@RequestParam("fromAccountNumber") String fromAccountNumber,
            @RequestParam("toAccountNumber") String toAccountNumber,
            @RequestParam("amount") double amount,
            @RequestParam("accType") String accType,
            @RequestParam("description") String description) {
// Fetch accounts from database
    	System.out.println("my account number is "+ fromAccountNumber);
    	System.out.println("receiver account number is "+ toAccountNumber);
    	Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
//    	fromAccount.getId();
          Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);
          Transaction transaction=new Transaction();
          
        	  System.out.println("in if condition");
            
        	  transaction=transactionService.setUserTransaction(fromAccount, toAccount,accType, amount, description);
        	 
          
          return ResponseEntity.ok(transaction);

}

    @PostMapping("/addMoney")
    public ResponseEntity<Transaction> setAddTransaction(@RequestParam("fromAccountNumber")String fromAccountNumber,
    													 @RequestParam("amount") double amount ) {
// Fetch accounts from database
    	System.out.println("my account number is "+ fromAccountNumber);
    	
    	Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber)
    			.orElseThrow(()-> new ResourceNotFoundException("Account not found with Account Number : "+fromAccountNumber));
    		      

            
        	 Transaction transaction=transactionService.setAddTransaction(fromAccount,  amount );
        	 
          
          return ResponseEntity.ok(transaction);

}
    
    @GetMapping("/statement")
    public List<Transaction> generateStatement(@RequestParam String accountNumber, 
                                               @RequestParam String startDate,
                                               @RequestParam String endDate) {
    	Account account = accountRepository.findByAccountNumber(accountNumber)
    			.orElseThrow(()-> new ResourceNotFoundException("Account not found with Account Number : "+accountNumber));
    		   
    	
    	
    	 List<Transaction> transaction=transactionService.generateStatement(account, startDate, endDate);
    	 return transaction;
    }
    

}
