package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String address;
	private String phoneNumber;
	private String id;
	private String password;
	private List<BankAccount> accounts;
	public User() {
		super();
	}
	public User(String name, String address, String phoneNumber, String id, String password) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.password = password;
		accounts = new ArrayList<BankAccount>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List getAccounts() {
		return accounts;
	}
	public void setAccounts(List accounts) {
		this.accounts = accounts;
	}
	public void addAccount(BankAccount account) {
		accounts.add(account);
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", id=" + id
				+ ", password=" + password + ", accounts=" + accounts + "]";
	}
	
	
}