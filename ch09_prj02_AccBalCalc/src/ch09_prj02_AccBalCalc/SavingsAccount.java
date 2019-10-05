package ch09_prj02_AccBalCalc;

public class SavingsAccount extends Account {
	private double interestRate;
	private double interestPaid;
	
	public SavingsAccount(double balance,double interestRate) {
		super(balance);
		this.interestRate=interestRate;
		}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	

	public double getInterestPaid() {
		return interestPaid;
	}
	
	public void addInterest() {
		interestPaid = balance * interestRate;
		balance+=interestPaid;
		
	}
}
