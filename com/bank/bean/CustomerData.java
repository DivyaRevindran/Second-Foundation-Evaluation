package com.bank.bean;

public class CustomerData {
	private String accountNo;
	private String customerName;
	private String accountType="Savings";
	private double balance;
	private double minimumBalance=1000;
	private String mobNumber;
	private String emailId;
	private int atmPin;
	public CustomerData() {
	
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public String getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAtmPin() {
		return atmPin;
	}
	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}
	@Override
	public String toString() {
		return "Customer Data [account No=" + accountNo + ", customer Name=" + customerName + ", account Type="
				+ accountType + ", balance=" + balance + ", minimum Balance=" + minimumBalance + ", mobile Number="
				+ mobNumber + ", email Id=" + emailId + ", ATM Pin=" + atmPin + "]";
	}
	
	

}
