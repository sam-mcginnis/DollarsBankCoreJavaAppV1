package com.dollarsbank.model;

public class BankAccount {
	private float deposit;
	private int accountNumber;
	
	public BankAccount() {
		super();
	}
	
	public BankAccount(float deposit, int accountNumber) {
		super();
		this.deposit = deposit;
		this.accountNumber = accountNumber;
	}

	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "BankAccount [deposit=" + deposit + ", accountNumber=" + accountNumber + "]";
	}
	
	
}
