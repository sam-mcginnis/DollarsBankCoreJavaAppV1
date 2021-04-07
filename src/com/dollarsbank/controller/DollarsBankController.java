package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()�[{}]:;',?/*~$^+=<>]).{8,20}$";
  
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
		System.out.println("Customer Name:");
		String name = scan.nextLine();
		System.out.println("Customer Address:");
		String address = scan.nextLine();
		System.out.println("Customer Phone Number:");
		String phoneNumber = scan.nextLine();
		System.out.println("User Id :");
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
			
			System.out.println("User Id :");
			String id = scan.nextLine();
			System.out.println("Password :");
			String password = scan.nextLine();
			
			for(User user: users) {
				if(user.getId().equals(id) && user.getPassword().equals(password)) {
					return user;
				}
			}
			System.out.println("Invalid Credentials. Try Again!");
		}
	}
	public void CustomerHomePage(User user) {
		System.out.println("+-------------------+");
		System.out.println("| WELCOME Customer! |");
		System.out.println("+-------------------+");
		System.out.println("1. Open New Account");
		System.out.println("2. Access Account");
		
		int input = scan.nextInt();
		
	}
}
