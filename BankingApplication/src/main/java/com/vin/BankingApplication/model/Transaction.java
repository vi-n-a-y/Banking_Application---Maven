package com.vin.BankingApplication.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity

@Table(name = "samp")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trxnId;
	@Column
	@CreationTimestamp
	private Date trxnDate;
	@JoinColumn(name="fromAccount" )
	private Account fromAccount;
	@JoinColumn(name="toAccount" )
	private Account toAccount;
	@Column
	private String description;
	@Column
	private String transactionType;
	@Column
	private double trxnAmount;
	@Column
	private double balance;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id" )
	private Account account;
	
	
	

	public Long getTrxnId() {
		return trxnId;
	}

	public void setTrxnId(Long trxnId) {
		this.trxnId = trxnId;
	}

	public Date getTrxnDate() {
		return trxnDate;
	}

	public void setTrxnDate(Date trxnDate) {
		this.trxnDate = trxnDate;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTrxnAmount() {
		return trxnAmount;
	}

	public void setTrxnAmount(double trxnAmount) {
		this.trxnAmount = trxnAmount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Transaction(Long trxnId, Date trxnDate, String fromAccount, String toAccount, String description,
			String transactionType, double trxnAmount, double balance, Account account) {
		super();
		this.trxnId = trxnId;
		this.trxnDate = trxnDate;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.description = description;
		this.transactionType = transactionType;
		this.trxnAmount = trxnAmount;
		this.balance = balance;
		this.account = account;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Transaction [trxnId=" + trxnId + ", trxnDate=" + trxnDate + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", description=" + description + ", transactionType=" + transactionType
				+ ", trxnAmount=" + trxnAmount + ", balance=" + balance + ", account=" + account + "]";
	}
	
	
}
