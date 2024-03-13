package com.vin.BankingApplication.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "j")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trxnId;

	@Column(name = "trxn_date")
	private LocalDate trxnDate;

	@JsonBackReference(value = "user-trxn")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "from_account", referencedColumnName = "accountNumber")
	private Account fromAccount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "to_account", referencedColumnName = "accountNumber")
	private Account toAccount;
	@Column
	private String description;
	@Column
	private String transactionType;
	@Column
	private double trxnAmount;
	@Column
	private double balance;

	public Long getTrxnId() {
		return trxnId;
	}

	public void setTrxnId(Long trxnId) {
		this.trxnId = trxnId;
	}

	public LocalDate getTrxnDate() {
		return trxnDate;
	}

	public void setTrxnDate(LocalDate trxnDate) {
		this.trxnDate = trxnDate;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
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

	public Transaction() {
		super();

	}

	public Transaction(Long trxnId, LocalDate trxnDate, Account fromAccount, Account toAccount, String description,
			String transactionType, double trxnAmount, double balance) {
		super();
		this.trxnId = trxnId;
		this.trxnDate = trxnDate;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.description = description;
		this.transactionType = transactionType;
		this.trxnAmount = trxnAmount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [trxnId=" + trxnId + ", trxnDate=" + trxnDate + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", description=" + description + ", transactionType=" + transactionType
				+ ", trxnAmount=" + trxnAmount + ", balance=" + balance + "]";
	}
}
