import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;


public class IntCalcApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Interest Calculator!");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			
			System.out.print("Enter loan amount: ");
		//	BigDecimal loanAmt = sc.nextBigDecimal();
			double loanAmt = sc.nextDouble();
			
			System.out.print("Enter interest rate: ");
			double interestRate = sc.nextDouble();
			
			sc.nextLine();
			
			BigDecimal loanAmtBD = new BigDecimal(loanAmt);
			BigDecimal interestRateBD = new BigDecimal(interestRate);
			
			double interest = loanAmtBD.multiply(interestRateBD).doubleValue();
			
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			
			currency.setMaximumFractionDigits(2);
			percent.setMaximumFractionDigits(3);
			
			String loanAmtString = currency.format(loanAmt);
			String interestRateString = percent.format(interestRate);
			String interestString = currency.format(interest);
			
			System.out.println("Loan amount:\t\t\t" + loanAmtString);
			System.out.println("Interest rate:\t\t\t" + interestRateString);
			System.out.println("Interest:\t\t\t" + interestString);
			
			System.out.print("Continue? y/n: ");
			choice = sc.nextLine();
		}

		System.out.println("Thank you, Goodbye!");
		sc.close();
		
	}

}
