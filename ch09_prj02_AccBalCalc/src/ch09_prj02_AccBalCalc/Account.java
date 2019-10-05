package ch09_prj02_AccBalCalc;

public class Account implements Depositable, Withdrawalable, Balanceable {

	protected double balance;

	public Account(double balance) {
		this.balance=balance;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double amount) {
		balance=amount;

	}

	@Override
	public void withdraw(double amount) {
		balance-=amount;

	}

	@Override
	public void deposit(double amount) {
		balance+=amount;

	}

}
