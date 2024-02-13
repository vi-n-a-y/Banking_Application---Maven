package mvcproject.controllers.entity;



public class AccountDTO {
	
	private int id;

	private String accountNumber;
	private String ifscCode;
	private String bankName;
	private String acctType;
	private double currBalance;
	private int userId;
	

	public AccountDTO(String accountNumber, String ifscCode, String bankName, String acctType, double currBalance,
			int userId) {
		super();
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.acctType = acctType;
		this.currBalance = currBalance;
		this.userId = userId;
	}
	public AccountDTO(int id, String accountNumber, String ifscCode, String bankName, String acctType,
			double currBalance, int userId) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.acctType = acctType;
		this.currBalance = currBalance;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
