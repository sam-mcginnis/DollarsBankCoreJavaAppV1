package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dollarsbank.model.BankAccount;
import com.dollarsbank.model.User;

public class DollarsBankController {
	private Scanner scan;
	
	//private List<User>users;


	public DollarsBankController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DollarsBankController(Scanner scan) {
		super();
		this.scan = scan;
		//users = new ArrayList<User>();
	}
	public static boolean isValidPassword(String password)
    {
  
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
  
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
  
        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }
  
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);
  
        // Return if the password
        // matched the ReGex
        return m.matches();
    }
	public User CreateUser() {
		String password;
		
		System.out.println("+--------------------------------+");
		System.out.println("| Enter Details For New Account! |");
		System.out.println("+--------------------------------+");
		System.out.print("Customer Name: ");
		String name = scan.nextLine();
		System.out.print("Customer Address: ");
		String address = scan.nextLine();
		System.out.print("Customer Phone Number: ");
		String phoneNumber = scan.nextLine();
		System.out.print("User Id: ");
		String id = scan.nextLine();
		System.out.println("Password: 8 Characters With Lower, Upper & Special");

		while (true) {
			password = scan.nextLine();
			if(isValidPassword(password)) {
				break;
			}
			else {
				System.out.println("Password must havev 8 characters with lower, upper & special \nTry Again!");
			}
		}

		User user = new User(name, address, phoneNumber, id, password);
		return user;
	}
	public User Login(List<User> users) {
		while(true) {
			System.out.println("+----------------------+");
			System.out.println("| Enter Login Details! |");
			System.out.println("+----------------------+");
			
			System.out.print("User Id: ");
			String id = scan.nextLine();
			System.out.print("Password: ");
			String password = scan.nextLine();
			
			for(User user: users) {
				if(user.getId().equals(id) && user.getPassword().equals(password)) {
					return user;
				}
			}
			System.out.println("Invalid Credentials. Try Again!");
		}
	}
	public BankAccount CustomerHomePage(User user) {
		while(true) {
			System.out.println("+-------------------+");
			System.out.println("| WELCOME Customer! |");
			System.out.println("+-------------------+");
			System.out.println("1. Open New Account");
			System.out.println("2. Access Account");
			System.out.println("3. Sign Out");
			
			int input = scan.nextInt();
			if(input == 1) {
				scan.nextLine();
				System.out.print("Enter New Acount ID: ");
				String accNum = scan.nextLine();
				System.out.println("What type of Account would you like to open?\n1.Checkings\n2.Savings");
				int accType = scan.nextInt();
				System.out.println("Initial Deposit Amount:");
				float accDeposit = scan.nextFloat();
				
				if(accType == 1) {
					BankAccount account = new BankAccount(accDeposit, accNum, "CHECKINGS");
					user.addAccount(account);
					System.out.println("Checkings Account Succefully Created!");
				}
				else if(accType == 2) {
					BankAccount account = new BankAccount(accDeposit, accNum, "SAVINGS");
					user.addAccount(account);
					System.out.println("Savings Account Succefully Created!");
				}
				
			}
			else if(input == 2) {
				scan.nextLine();
				System.out.println("Your Accounts");
				System.out.println("-------------");
				List <BankAccount> accs = user.getAccounts();		
				if(accs.isEmpty()) {
					System.out.println("You have no bank accounts");
					return null;
				}
				else {
					while(true) {
						accs.stream().forEach(s -> System.out.println(s.getAccountNumber()));
						
						System.out.print("\nPlease Enter Account ID: ");
						String accNum = scan.nextLine();
						for(BankAccount acc: accs) {
							if(acc.getAccountNumber().equals(accNum)) {
								return acc;
							}
						}
						System.out.println("This Account doesn't exist!\nPlease make an account or try again.");
					}
				}
			}
			else if(input == 3) {
				break;
			}
			else {
				System.out.println("Not a valid choice, try again!");
			}
		}
		return null;
	}
	public void AccountActions(User user, BankAccount account) {
		while(true) {
			System.out.println("+-------------------+");
			System.out.println("| WELCOME Customer! |");
			System.out.println("+-------------------+\n");
			System.out.println(account.getAccountType() + " Account- " + account.getAccountNumber());
			System.out.println("\n1. Deposit Amount");
			System.out.println("2. Withdraw Amount");
			System.out.println("3. Funds Transfer");
			System.out.println("4. View 5 Recent Transactions");
			System.out.println("5. Display Customer Information");
			System.out.println("6. Sign Into Other Account");
			
			int input = scan.nextInt();
			if(input == 1) {
				System.out.print("Enter deposit amount: ");
				float deposit = scan.nextFloat();
				account.Deposit(deposit);
			}
			else if(input == 2) {
				System.out.print("Enter withdrawl amount: ");
				float withdrawl = scan.nextFloat();
				account.Withdrawl(withdrawl);
			}
			else if(input == 3) {
				scan.nextLine();
				System.out.println("What account would you like to send funds too\n");
				
				List <BankAccount> accs = user.getAccounts();			
				accs.stream().forEach(s -> System.out.println(s.getAccountNumber()));
				
				System.out.print("\nEnter Account- ");
				String accNumber = scan.nextLine();
				
				for(BankAccount acc: accs) {
					if(acc.getAccountNumber().equals(accNumber)) {

						System.out.print("How much would you like to transer from " + account.getAccountType() + 
								" " + account.getAccountNumber() + " to " + acc.getAccountType() + " " + acc.getAccountNumber());
						float transferAmount = scan.nextFloat();
						if(account.Withdrawl(transferAmount)) {
							acc.Deposit(transferAmount);
							break;
						}
					}
				}
				System.out.println("This Account doesn't exist!\nPlease make an account or try again.");
				
			}
			else if(input == 4) {
				//start transaction
				
			}
			else if(input == 5) {
				System.out.println("+-----------------------+");
				System.out.println("| Customer Information! |");
				System.out.println("+-----------------------+\n");
				System.out.println(user.toString());
			}
			else if(input == 6) {
				CustomerHomePage(user);
			}
			else {
				System.out.println("Not a valid choice, Try Again!");
			}


		}		
	}
}
