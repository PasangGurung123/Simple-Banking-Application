package bank1;

import java.util.Scanner;

public class Account {
	//class variables 
	
	private int balance;
	private int previousTransaction;
	private String customerName;
	private String customerId;
//	class constructor
	
	public Account(String customerName, String customerId) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
	}
	
	
//	method for depositing money
	
	void deposit(int amount) {
		if(amount != 0 ) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
//	method for withdrawing money
	
	void withdraw(int amount) {
		if(amount !=0 ) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
//	method for showing the previous transactions
	
	void getPreviousTransactions() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else {
			System.out.println("No transactions were occured");
		}
	}
	
//	method for calculating interests of current funds after a number of years
	
	void calculateInterest(int years) {
		double interestRate = 0.0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate) + "%");
		System.out.println("After " + years + " years, your balance will be: " + newBalance);
	}
	
//	method for showing the main menu
	
	void showMenu() {
		char option = '\0';
		/*
		 * The character constant '\0' represents the character with value zero, 
		 * the null character. '\0' is often written instead of 0 to emphasize the character nature of some expression,
		 *  but the numeric value is just 0.
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerId);
		System.out.println();
		System.out.println("Hey man! What would you like to today?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a Deposit");
		System.out.println("C. Make a Withdrawal");
		System.out.println("D. View  a PreviousTransaction");
		System.out.println("E. Calculate an interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
//			case 'A' allows the user to check their account balance
			
			case 'A': 
				System.out.println("====================================");
				System.out.println("Balance = Rs. " + balance);
				System.out.println("====================================");
				System.out.println();
				break;
//				case 'B' allows user to deposit into their account using the 'deposit' function
			case 'B': 
				System.out.println("Enter an amount to be deposited: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println(amount + " is deposited into " + customerName + " with " + customerId );
				System.out.println("Your current balance = Rs. " + balance);
				System.out.println();
				break;
//				case 'C' allows the user to withdraw money from their account using the 'withdraw' function 
			case 'C':
				System.out.println("Enter the amount to withdraw: ");
				int amount1 = scanner.nextInt();
				withdraw(amount1);
				System.out.println(amount1 + " is withdrawn from your " + customerName + " with " + customerId );
				System.out.println("Your current balance = Rs. " + balance);
				System.out.println();
				break;
//				case 'D' allows the users to view their most recent transaction using 'getPreviousTransactions' method
			case 'D' :
				System.out.println("====================================");
				getPreviousTransactions();
				System.out.println();
				break;
//				case 'E' calculates the accrued interest on the account after a number of years specified by the user
			case 'E' :
				System.out.println("Enter how many years of accrued interest: ");
				int years = scanner.nextInt();
				calculateInterest(years);
				break;
//				case 'F' exits the user from their account
			case 'F' :
				System.out.println("Exited");
				System.out.println("====================================");
				break;
			}
		}while(option != 'F');
		System.out.println("Thank you for banking with us!");
		scanner.close();
	}
}
