package com.dollarsbank.model;

public class BankAccount {
	private float balance;
	private String accountNumber;
	private String accountType;
	
	public BankAccount() {
		super();
	}
	public BankAccount(float initalDeposit, String accountNumber, String accountType) {
		super();
		balance = initalDeposit;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	public float getBalance() {
		return balance;
	}
	public void Deposit(float deposit) {
		balance += deposit;
		System.out.println("Deposit succefully made!\nBALANCE- $" + balance);

	}
	public void Withdrawl(float withdrawl) {
		if(withdrawl > balance) {
			System.out.println("You dont now have enough to withdrawl " + withdrawl 
					+ "\nBALANCE- $" + balance);
		}
		else {
			this.balance -=  balance;
			System.out.println("Withdrawl succefully made!\nBALANCE- $" + balance);
		}
		
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ "]";
	}
		
}
