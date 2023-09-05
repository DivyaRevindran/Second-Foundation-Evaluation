package com.bank.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.bean.Administrator;
import com.bank.bean.Customer;
import com.bank.bean.CustomerData;


public class BankMain {
	static ArrayList<CustomerData> cst = new ArrayList<CustomerData>();

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int opt=1;
		Administrator admin = new Administrator(cst);
		Customer cust = new Customer(cst);
		System.out.println("WELCOME TO SBI");
		System.out.println("Choose one of the options below:");
		
		do {
			try {
		System.out.println("1.Login as Administrator");
		System.out.println("2.Login as Customer");
		System.out.println("3.Exit");
		opt = Integer.parseInt(scan.nextLine());
		
		if (opt == 1) {
			admin.MenuList();
		}
		else if (opt == 2) {
			cust.MenuList();
		}
		else
		{
			System.out.println("Invalid option");
		}
			}
			catch(Exception e) 
			{
				System.out.println("Enter the valid option!");
			}
		
		}while(true);
		
		

	}

}
