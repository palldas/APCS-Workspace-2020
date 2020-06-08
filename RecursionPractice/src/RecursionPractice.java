
public class RecursionPractice {

	public static int triangleNumber(int n) {
		if (n == 1)
			return 1;
		else
			return n + triangleNumber(n - 1);
	}

	public static int squareNumber(int n) {
		if (n == 1)
			return 1;
		else
			return squareNumber(n - 1) + (2 * n) - 1;
	}

	public static int logBase2(int n) {
		if (n == 1)
			return 0;
		else
			return 1 + logBase2(n / 2);
	}

	public static int pow(int n) {
		if (n == 0)
			return 1;
		else
			return 2 * pow(n - 1);
	}

	public static int pentagonalNumber(int n) {
		if (n == 1)
			return 1;
		else
			return pentagonalNumber(n - 1) + (3 * (n - 1)) + 1; // or 4n-3
	}
	
	
	public static int  iterations = 0;

	public static int fibonacciRecursion(int n) {
		iterations++;
		
		if (n == 1 || n == 0)
			return n;
		else
			return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
		
	}

	public static int fibonnaciLoop(int n) {
		if (n == 0)
			return 0;

		int first = 0;
		int second = 1;

		for (int i = 0; i < n - 2; i++) {
			iterations++;
			int temp = second;
			second += first;
			first = temp;
		}
		return first + second;
	}

	
	
	
	public static void main(String[] args) {
		/* int n = 5;
		int test = triangleNumber(n);
		System.out.println("The " + n + "th triangular number is " + test);
		System.out.println();

		int n3 = 5;
		int test3 = squareNumber(n3);
		System.out.println("The square number of " + n3 + " is " + test3);
		System.out.println();

		int n4 = 32;
		int test4 = logBase2(n4);
		System.out.println("Log base 2 of " + n4 + " is " + test4);
		System.out.println();

		int n5 = 6;
		int test5 = pow(n5);
		System.out.println("Pow base 2 of " + n5 + " is " + test5);
		System.out.println();

		int n6 = 4;
		int test6 = pentagonalNumber(n6);
		System.out.println("The pentagonal number of " + n6 + " is " + test6);
		System.out.println();

		int n7 = 7;
		System.out.println(fibonacciRecursion(n7));
		System.out.println();
		System.out.println(fibonnaciLoop(n7)); */
		
		long start = System.nanoTime();
		int test  = fibonacciRecursion(6);
		long end  = System.nanoTime();
		System.out.println("Out: "+ test +" Time: "+ (end-start));
		System.out.println("Iterations: "+iterations);
	}

}