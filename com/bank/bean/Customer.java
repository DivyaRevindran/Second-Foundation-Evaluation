package com.bank.bean;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements CustomerMethods {
	 ArrayList<CustomerData> cst;
	 CustomerData customer = new CustomerData();
	 Administrator admin = new Administrator();
	public Customer(ArrayList<CustomerData> cst) {
		super();
		this.cst = cst;
	}
	Scanner scan = new Scanner(System.in);
	public void MenuList() {
		
		int opt;
		do {
			System.out.println("Choose your option:");
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Show Balance");
			System.out.println("4.Transfer Money");
			System.out.println("5.Exit");
			opt = scan.nextInt();
			switch (opt) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				balance();
				break;
			case 4:
				transferMoney();
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid option!!Try again");
			}
		} while (opt != 5);
	}

	@Override
	public void deposit() {
		System.out.println("Enter the account number:");
		String acNo = Administrator.checkAccNumber(scan.next());
		for (int i = 0; i < cst.size(); i++) {
			if (cst.get(i).getAccountNo().equals(acNo)) {
				System.out.println("Enter the amount to be deposited:");
				double amount = scan.nextDouble();
				if(amount>50000)
				{
					System.out.println("Enter the pancard number:");
					long pancard=scan.nextLong();
					cst.get(i).setBalance(cst.get(i).getBalance()+amount);
				}
				else
				{
					cst.get(i).setBalance(cst.get(i).getBalance()+amount);
				}
				return;
			}
		}
		System.out.println("Account number not found!");

	}

	@Override
	public void withdraw() {
		System.out.println("Enter the account number:");
		String acNo =  Administrator.checkAccNumber(scan.next());
		for (int i = 0; i < cst.size(); i++) {
			if (cst.get(i).getAccountNo().equals(acNo)) {
				System.out.println("Enter the amount to be withdraw:");
				double amount = scan.nextDouble();
				double availableBalance = cst.get(i).getBalance()-cst.get(i).getMinimumBalance();
				if(amount<availableBalance ) {
					if(amount>50000) {
						System.out.println("Enter the pancard number:");
						long pancard=scan.nextLong();
						cst.get(i).setBalance(cst.get(i).getBalance()-amount);
					}
					else {
						cst.get(i).setBalance(cst.get(i).getBalance()-amount);
					}
				}
				else
				{
					System.out.println("Insufficient balance");
				}
				return;
			}
		}
		System.out.println("Account number not found!");

	}

	@Override
	public void balance() {
		System.out.println("Enter the account number:");
		String acNo = Administrator.checkAccNumber(scan.next());
		for (int i = 0; i < cst.size(); i++) {
			if (cst.get(i).getAccountNo().equals(acNo)) {
				
				System.out.println(cst.get(i).getBalance());
				return;
			}
		}
		System.out.println("Account number not found!");

	}

	@Override
	public void transferMoney() {
		System.out.println("Enter the account number:");
		String acNo =  Administrator.checkAccNumber(scan.next());
		for (int i = 0; i < cst.size(); i++) {
			if (cst.get(i).getAccountNo().equals(acNo)) {
				System.out.println("Enter the amount to transfer:");
				double amount = scan.nextDouble();
				double availableBalance = cst.get(i).getBalance()-cst.get(i).getMinimumBalance();
				if(amount<availableBalance) {
				cst.get(i).setBalance(cst.get(i).getBalance()-amount);
				System.out.println("Transferred amount successfully");
				}
				else {
					System.out.println("Insufficient balance");
				}
				return;
			}
		}
		System.out.println("Account number not found!");
		
	}
}