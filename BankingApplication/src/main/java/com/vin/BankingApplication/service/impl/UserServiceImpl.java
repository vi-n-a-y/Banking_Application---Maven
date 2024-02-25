package com.vin.BankingApplication.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
	public User CheckCredintials(String uname, String password) {
	
		return userRepository.findByUnameAndPassword(uname,password);
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
	
}


	
	


