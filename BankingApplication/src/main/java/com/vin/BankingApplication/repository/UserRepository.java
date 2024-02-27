package com.vin.BankingApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vin.BankingApplication.model.User;

//dont need to add @AddRepository because spring jpa will implicity add the annotation
public interface UserRepository extends JpaRepository<User,Long> {

	

	 User findByUnameAndPassword(String username, String password);

	List<User> findByUname(String username);
}
