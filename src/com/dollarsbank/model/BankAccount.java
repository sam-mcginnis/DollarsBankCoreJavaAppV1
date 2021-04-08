package com.dollarsbank.model;

public class BankAccount {
	private float deposit;
	private String accountNumber;
	private String accountType;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(float deposit, String accountNumber, String accountType) {
		super();
		this.deposit = deposit;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "BankAccount [deposit=" + deposit + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ "]";
	}
		
}
