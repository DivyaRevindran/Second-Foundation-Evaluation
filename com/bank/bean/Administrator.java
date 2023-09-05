package com.bank.bean;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Administrator implements AdminMethods {

	ArrayList<CustomerData> cst;

	Scanner scan = new Scanner(System.in);
	

	public Administrator() {
		
	}

	public Administrator(ArrayList<CustomerData> cst) {
		super();
		this.cst = cst;
	}

	public void MenuList() {

		int opt;
		do {
			System.out.println("Choose your option:");
			System.out.println("1.Adding a new Customer");
			System.out.println("2.Updating Customer Details");
			System.out.println("3.Deleting a customer");
			System.out.println("4.List the details of customers");
			System.out.println("5.Search a customer");
			System.out.println("6.Exit");
			opt = scan.nextInt();
			switch (opt) {
			case 1:
				addNewCustomer();
				break;
			case 2:
				updateCustomer();
				break;
			case 3:
				deleteCustomer();
				break;
			case 4:
				listCustomers();
				break;
			case 5:
				search();
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid option!!Try again");
			}
		} while (opt != 6);
	}

	@Override
	public void addNewCustomer() {
		char ch;
		Administrator admin = new Administrator();
		do {
			CustomerData customer = new CustomerData();
			System.out.print("Enter the name : ");
			customer.setCustomerName(admin.checkName(scan.next()));
			System.out.print("Choose the account type:-->1.Savings --->2.Current ");
			int n = scan.nextInt();
			if (n == 1) {
				customer.setAccountType("Savings");
			}
			if (n == 2) {
				customer.setAccountType("Current");
			}
			
			System.out.println("Enter the amount to be deposited:(Minimum balance should be 1000)");
			customer.setMinimumBalance(1000);
			customer.setBalance(scan.nextDouble());

			System.out.print("Enter the Mobile Number : ");
			customer.setMobNumber(checkMobileNumber(scan.next()));
			System.out.print("Enter the Email ID: ");
			customer.setEmailId(scan.next());
			customer.setAccountNo(Integer.toString(generateAccountNumber()));
			customer.setAtmPin(generateAtmPin());
			cst.add(customer);
			System.out.print("Do you want to add another customer details?(y/n) : ");
			ch = scan.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

	}

	@Override
	public void updateCustomer() {
		System.out.println("Enter the account number:");
		String acNo = checkAccNumber(scan.next());
		for (int i = 0; i < cst.size(); i++) {
			if (cst.get(i).getAccountNo().equals(acNo)) {
				System.out.println("Enter new mobile number:");
				cst.get(i).setMobNumber(checkMobileNumber(scan.next()));
				System.out.println("Enter new Email id:");
				cst.get(i).setEmailId(scan.next());

				return;
			}
		}
		System.out.println("No customer with this account number");

	}

	@Override
	public void deleteCustomer() {
		System.out.print("Enter the Account Number: ");
		String acNo = checkAccNumber(scan.next());
		for (int i = 0; i < cst.size(); i++) {
			if (cst.get(i).getAccountNo().equals(acNo)) {
				cst.remove(i);
				System.out.println("Deleted the details of customer successfully.");
				return;
			}
		}
		System.out.println("Account number not found!");

	}

	@Override
	public void listCustomers() {
		System.out.println("Details of all the customers in the bank");
		for (int i = 0; i < cst.size(); i++)
			System.out.println(cst.get(i).toString());

	}

	@Override
	public void search() {
		System.out.print("Enter the Account Number : ");
		String acNo = scan.next();
		for (int i = 0; i < cst.size(); i++) {
			if (cst.get(i).getAccountNo().equals(acNo)) {
				System.out.println(cst.get(i).toString());
				return;
			}
		}
		System.out.println("Account number not found!");

	}

	private int generateAccountNumber() {
		Random random = new Random();
		return 100000000 + random.nextInt(900000000);
	}

	private int generateAtmPin() {
		Random random = new Random();
		return 1000 + random.nextInt(9000);
	}

	public String checkName(String name) {
	
		try {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Pattern pattern = Pattern.compile("[^A-Za-z ]");
			do {
				
				Matcher matcher = pattern.matcher(name);
				boolean finder = matcher.find();
				if (finder) {
					System.out.println("Invalid entry of name!-->It must contain only alphabets please re-enter!");
					name = br.readLine();
				} else if (name.length() > 30) {
					System.out.println("Please re-enter Name!-->It must not be longer than 30 letters");
					name = br.readLine();
				} else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println(e);
		}
		return name;
	}

	public static String checkAccNumber(String accNo) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Pattern pattern = Pattern.compile("[^0-9]");
			do {
				Matcher matcher = pattern.matcher(accNo);
				boolean finder = matcher.find();
				if (finder) {
					System.out.println("Please re-enter the account number!-->Account Number must contain only digits");
					accNo = br.readLine();
				} else if (accNo.length() > 9) {
					System.out.println(" please re-enter the account number!-->Account number must not be longer than 9 digits");
					accNo = br.readLine();
				} else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println(e);
		}
		return accNo;
	}
	
	public static String checkMobileNumber(String mob) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Pattern pattern = Pattern.compile("[^0-9]");
			do {
				Matcher matcher = pattern.matcher(mob);
				boolean finder = matcher.find();
				if (finder) {
					System.out.println(" please re-enter the mobile number!-->Mobile Number must contain only digits");
					mob = br.readLine();
				}
				else if(mob.length()!=10)
				{
					System.out.println("please re-enter the mobile number!-->Mobile Number must be 10 digits long");
					mob = br.readLine();
				}
				 else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println(e);
		}
		return mob;
	}

	

}
