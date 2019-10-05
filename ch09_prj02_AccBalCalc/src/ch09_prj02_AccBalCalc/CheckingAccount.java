package ch09_prj02_AccBalCalc;

public class CheckingAccount extends Account {
	
	private double fee;

	public CheckingAccount(double balance,double fee) {
		super(balance);
		this.fee=fee;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public double applyFee() {
		balance-=fee;
		return balance;
	}
}
