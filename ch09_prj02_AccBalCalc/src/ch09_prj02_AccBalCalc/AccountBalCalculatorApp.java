package ch09_prj02_AccBalCalc;

import java.text.NumberFormat;

public class AccountBalCalculatorApp {
	
	public static void main(String[] args) {

		System.out.println("Welcome");
		System.out.println();
		CheckingAccount ca1 = new CheckingAccount(1000.00, 1.00);
		SavingsAccount sa1 = new SavingsAccount(1000.00, .01);
		System.out.println("Account Balances:\n");
		printAccountsBal(ca1, sa1);
		String cont = "y";


		System.out.println("Enter transactions for the month:\n");
		while (cont.equalsIgnoreCase("y")) {
			String choice = Console.getString("Withdrawal/Deposit? w/d: ");
			double amount;
			if (choice.equalsIgnoreCase("d")) {
				String choice2 = Console.getString("Checking or savings? c/s: ");
				amount = Console.getDouble("How much?\n");
				if (choice2.equalsIgnoreCase("c")) {
					ca1.deposit(amount);
				} else {
					sa1.deposit(amount);
				}
			} else {
				String choice2 = Console.getString("Checking or savings? c/s: ");
				amount = Console.getDouble("How much?\n");
				if (choice2.equalsIgnoreCase("c")) {
					ca1.withdraw(amount);
				} else {
					sa1.withdraw(amount);
				}

			}
			cont = Console.getLine("Continue? y/n: ");

		}

		ca1.applyFee();
		sa1.addInterest();
		double interest = sa1.getInterestPaid();
		
		System.out.println();
		System.out.println("Monthly Payments and Fees:");
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		System.out.println("Checking Fee: "+cf.format(ca1.getFee()));
		System.out.println("Savings Interest Payment: "+cf.format(interest));
		System.out.println();
		System.out.println("Total Balances:");
		printAccountsBal(ca1, sa1);
		
	}

	private static void printAccountsBal(CheckingAccount ca1, SavingsAccount sa1) {
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		System.out.println("Checking Account: " + cf.format(ca1.getBalance()));
		System.out.println("Savings Account: " + cf.format(sa1.getBalance()));
	}

}
