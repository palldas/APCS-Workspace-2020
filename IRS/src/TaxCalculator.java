/*
 * Good things: 
 * - Very well written class(good variable names, good methods)
 * - Has good/less cohesion
 * - Does an efficient job of calculating the tax
 * 
 * IRS Feedback: 
 * a. 12
 * b. 10
 * c. 4
 * d. 6
 *
 */
public class TaxCalculator {
	private String answer;
	private double income;

	public TaxCalculator(String status, double income) {
		this.answer = status;
		this.income = income;
	}

	public double calculateTax() {
		if(answer.equals("single")) {
			if (income > 0 && income <= 9525) 
				return income*0.1;
			
			else if (income > 9525 && income <= 38700) 
				return 952.50+ 0.12*(income - 9525);
			
			else if (income > 38700 && income <= 82500) 
				return 4453.50+ 0.22*(income - 38700);
	
			else if (income > 82500 && income <= 157500) 
				return 14089.50+ 0.24*(income - 82500);
			
			else if (income > 157500 && income <= 200000) 
				return 32089.50+ 0.32*(income - 157500);
			
			else if (income > 200000 && income <= 500000) 
				return 45689.50+ 0.35*(income - 200000);
			
			else if (income > 500000) 
				return 150689.50+ 0.37*(income - 500000);
		}
		else if (answer.equals("married")) {
			if (income > 0 && income <= 19050) 
				return income*0.1;
			
			else if (income > 19050 && income <= 77400) 
				return 1905+ 0.12*(income - 19050);
			
			else if (income > 77400 && income <= 165000) 
				return 8907+ 0.22*(income - 77400);
			
			else if (income > 165000 && income <= 315000) 
				return 28179+ 0.24*(income - 165000);
			
			else if (income > 315000 && income <= 400000) 
				return 64179+ 0.32*(income - 315000);
			
			else if (income > 400000 && income <= 600000) 
				return 91379+ 0.35*(income - 400000);
			
			else if (income > 600000) 
				return 161379+ 0.37*(income - 600000);
		}
		System.out.println("Please try again, must enter single or married");
		return 0;
	}
}
