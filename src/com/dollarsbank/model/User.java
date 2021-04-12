package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class User {
	private String name;
	private String address;
	private String phoneNumber;
	private String id;
	private String password;
	private List<BankAccount> accounts;
	private Queue<String> que;
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
		que = new LinkedList<>();
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
	public List<BankAccount> getAccounts() {
		return accounts;
	}
	public void addAccount(BankAccount account) {
		accounts.add(account);
	}
	public void addQue(String transaction) {
		
		if(que.size() >= 5) {
			que.remove();
			que.add(transaction);
		}
		else {
			que.add(transaction);
		}
	}
	public void showQue() {
		System.out.println("+----------------------+");
		System.out.println("| Transaction History! |");
		System.out.println("+----------------------+\n");
		if(que.isEmpty()) {
			System.out.println("You have no transaction history!");
		}
		else {
			que.forEach(System.out::println);
		}
	}
	@Override
	public String toString() {
		return "Username- " + name + "\nAddress- " + address + "\nPhone Number- " + phoneNumber + "\nUser Id- " + id
				+ "\nPassword- " + password + "\nAccounts- " + accounts;
	}
	
	
}