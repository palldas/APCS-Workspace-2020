import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter marital status: (enter single or married)");
		String answer = scan.nextLine();
		System.out.println("Enter taxable income: (don't use $ or ,)");
		double income = scan.nextInt();
		TaxCalculator t = new TaxCalculator(answer, income);
		System.out.println("Your Federal tax = $"+t.calculateTax());
	}

}
