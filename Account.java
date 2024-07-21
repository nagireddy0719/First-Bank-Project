package com.bankproject;

import java.util.Scanner;

public class Account {
		int balance;
		int previousTransaction;
		String customerName;
		String customerId;
		
		//class Constructor
		Account(String cname, String cid){
			customerName=cname;
			customerId=cid;
			
		}

        //Function for Depositing Money
		void deposit(int amount) {
			if (amount !=0) {
				balance=balance+amount;
				previousTransaction = amount;
			}
		}
		//Function for Withdrawing Money
		void withdraw(int amount) {
			if (amount !=0) {
				balance=balance-amount;
				previousTransaction = -amount;
		    }
		}
		//Function for previuosTransaction
				void getPreviousTransaction() {
					if (previousTransaction > 0) {
						System.out.println("Deposited :"+previousTransaction);
					}else if (previousTransaction < 0) {
						System.out.println("Withdrawn:"+Math.abs(previousTransaction));
					}
					else {
						System.out.println("No Transaction Occurred");
					}
				}
		//Function for calculate Intrest
				void calculateIntrest(int years) {
					double intrestRate=0.177;
					double newBalance=(balance * intrestRate * years)+balance;
					System.out.println("The current intrest rate is"+(100*intrestRate));
					System.out.println("After"+years+"years, your balance will be:"+newBalance);
				}
		//Function for showing the main Menu
				void showMenu() {
					char option='\0';
					Scanner sc=new Scanner(System.in);
					System.out.println("Welcome"+customerName);
					System.out.println("Your ID is "+customerId);
					System.out.println();
					System.out.println("What would you like to do");
					System.out.println();
					System.out.println("A. Check your Balance");
					System.out.println("B. Make a Deposit");
					System.out.println("C. Make a Withdraw");
					System.out.println("D. View Previous Transaction");
					System.out.println("E. Calculate Intrest");
					System.out.println("F. Exit");
					
					do {
						System.out.println("Enter an option:");
						char option1=sc.next().charAt(0);
						option =Character.toUpperCase(option1);
						
						switch(option) {
						
						case 'A':
							System.out.println("Your Balance is" + balance);
							break;
						case 'B':
							System.out.println("Please Enter an amount to Deposit");
							int amount=sc.nextInt();
							deposit(amount);
							break;
						case 'C':
							System.out.println("Please Enter an amount to withdraw");
							int amount2=sc.nextInt();
							withdraw(amount2);
							break;
						case 'D':
							getPreviousTransaction();
							break;
						case 'E':
							System.out.println("Please Enter how many years of accrued intrest");
							int years=sc.nextInt();
							calculateIntrest(years);
							break;
						case 'F':
							System.out.println("Exited");
							break;
						default:
							System.out.println("Error: invalid option . Please enter A,B,C,D,E,F");
							break;
						}
					}while(option !='F');
						System.out.println("Thank you for Banking with us");
				}
}