package com.dollarsbank.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.BankAccount;
import com.dollarsbank.model.User;

public class BankRunner {
	
	
	
	public BankRunner() {
		super();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<User>users = new ArrayList<User>();
		DollarsBankController DBC = new DollarsBankController(scan);
		
		while(true) {

			System.out.println("+---------------------------+");
			System.out.println("| DOLLARSBANK Welcomes You! |");
			System.out.println("+---------------------------+");
			System.out.println("1. Create New Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Enter Choice (1,2, or 3) : ");
			
			int input = scan.nextInt();
			if(input == 1) {
				scan.nextLine();
				User user = DBC.CreateUser();
				boolean duplicateAccount = users.stream().anyMatch(s -> s.getId().equals(user.getId()));
				if(!duplicateAccount) {
					System.out.println("Account succesfully created!!!\n\n\n");
					users.add(user);
				}
				else {
					System.out.println("The account with user id-" + user.getId() + " already exists!\nPlease login!\n\n");
				}
				
			}
			else if(input == 2) {
				scan.nextLine();
				User user = DBC.Login(users);
				BankAccount account = DBC.CustomerHomePage(user);
				DBC.AccountActions(user, account);
			}
			else if(input == 3) {
				scan.close();
				System.out.println("Exiting program....");
				System.exit(0);
			}
			else {
				System.out.println("Not a valid choice");
			}
		}
	}

	

}
