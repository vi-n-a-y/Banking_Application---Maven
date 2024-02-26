package com.vin.BankingApplication.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//import lombok.Data ;

@Entity
@Table(name = "babu")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	 @JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Account> accounts;

	@Column(unique = true)
	private String uname;
	@Column
	private String password;
	@Column
	private String fullName;
	@Column
	private String email;
	@Column
	private String phno;
	@Column
	private String address;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;

	}

	public User() {
		super();
	}

	public User(Long userId, List<Account> accounts, String uname, String password, String fullName, String email,
			String phno, String address) {
		super();
		this.userId = userId;
		this.accounts = accounts;
		this.uname = uname;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phno = phno;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", accounts=" + accounts + ", uname=" + uname + ", password=" + password
				+ ", fullName=" + fullName + ", email=" + email + ", phno=" + phno + ", address=" + address + "]";
	}
	
	
	

}
