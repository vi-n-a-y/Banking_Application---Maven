package com.vin.BankingApplication.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
//@Table(name="banti")
@Table(name = "samplee")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	
	@Column(unique = true)
	private String accountNumber;
	@Column
	private String ifscCode;
	@Column
	private String bankName;
	@Column
	private String acctType;
	@Column
	private double currBalance;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="user_id" )
	private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public double getCurrBalance() {
		return currBalance;
	}
	public void setCurrBalance(double currBalance) {
		this.currBalance = currBalance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Account() {
		super();
		
	}
	public Account(Long id, List<Transaction> transactions, String accountNumber, String ifscCode, String bankName,
			String acctType, double currBalance, User user) {
		super();
		this.id = id;
		this.transactions = transactions;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.acctType = acctType;
		this.currBalance = currBalance;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", transactions=" + transactions + ", accountNumber=" + accountNumber
				+ ", ifscCode=" + ifscCode + ", bankName=" + bankName + ", acctType=" + acctType + ", currBalance="
				+ currBalance + ", user=" + user + "]";
	}
	

	
	
	
	


	
	
	

	
	
}
