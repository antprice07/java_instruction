import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;


public class TipCalcApp {

	public static void main(String[] args) {
		BigDecimal meal;
		String cont = "y";
		Scanner sc = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		System.out.println("Tip Calculator");
		
		while(cont.equalsIgnoreCase("y")) {
			System.out.print("Enter the cost of your meal: ");
			meal = sc.nextBigDecimal();
			sc.nextLine();
			BigDecimal tip1;
			tip1 = meal.multiply(new BigDecimal(.15));
			BigDecimal tip2 = meal.multiply(new BigDecimal(.2));
			BigDecimal tip3 = meal.multiply(new BigDecimal(.25));
			
			System.out.println("15%\n Tip amount\t" + currency.format(tip1) + "\nTotal Amount\t" + currency.format(tip1.add(meal)));
			System.out.println("20%\n Tip amount\t" + currency.format(tip2) + "\nTotal Amount\t" + currency.format(tip2.add(meal)));
			System.out.println("25%\n Tip amount\t" + currency.format(tip3) + "\nTotal Amount\t" + currency.format(tip3.add(meal)));
			
			System.out.print("Continue? y/n: ");
			cont = sc.nextLine();
			
		}
		sc.close();
		System.out.println("Bye!");
	}

}
