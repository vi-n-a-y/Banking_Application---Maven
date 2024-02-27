package com.vin.BankingApplication.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vin.BankingApplication.exception.ResourceNotFoundException;
import com.vin.BankingApplication.model.Account;
import com.vin.BankingApplication.model.User;
import com.vin.BankingApplication.repository.UserRepository;
import com.vin.BankingApplication.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	private  UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
	
		return userRepository.save(user);
	}



//	public User getUserById(int user_id) {
//return userRepository.findById(user_id).orElseThrow(() -> 
//				new ResourceNotFoundException("User", "Id", user_id));
//
//}

	   public boolean isValidCredentials(String username, String password) {
	        User user = userRepository.findByUnameAndPassword(username, password);
	        return user != null; // If user is found, credentials are valid
	    }

	
	public List<Account> getUserAccounts(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.getAccounts();
        }
        return Collections.emptyList();
    }


	
//	public List<Account> getUserAccounts(Long userId) {
//        User user = userRepository.findById(userId).orElse(null);
//     
//    }
//	
    public List<User> getUserDataByUsernameAndPassword(String username, String password) {
        // Check if the credentials are valid
        if (!isValidCredentials(username, password)) {
            throw new ResourceNotFoundException("Invalid username or password");
        }
        
        // If credentials are valid, retrieve user data based on the username
        List<User> users = userRepository.findByUname(username);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("User not found"); // Handle case where user with the provided username doesn't exist
        }
        
        return users;
    }
    
//    public User saveUserWithAccounts(User user) {
//        List<Account> accounts = user.getAccounts();
//        if (accounts != null) {
//            for (Account account : accounts) {
//                account.setUser(user);
//            }
//        }
//        return userRepository.save(user);
//    }
    
    
    public User addAccountsToUser(Long userId, List<Account> accounts) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        // Set user reference for each account
        for (Account account : accounts) {
            account.setUser(user);
        }
        
        // Add accounts to the user and save
        user.getAccounts().addAll(accounts);
        userRepository.save(user);

        return user;
    }


	
	
}


	
	


