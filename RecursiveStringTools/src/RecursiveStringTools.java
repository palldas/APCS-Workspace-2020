import java.util.Scanner;

/**
*
*  Check out this website for extra recursion reading and the "example" methods: http://chortle.ccsu.edu/Java5/Notes/chap75/ch75_1.html
*
*/
public class RecursiveStringTools {
	
	// Example
	public static int length(String in) {
		return 0;
	}
	
	

	// Example
	public static boolean equals(String in1, String in2) {
		return false;
	}
	

	
	// Exercise #1
	public static boolean matches(String in1, String in2) {
		return false;
	}
	
	

	// Exercise #2
	public static boolean isPalindrome(String in) {
		return true;
	}
	
	

	// Exercise #3
	public static void printPermutations(String in) {

	}
	
	
	
	public static String piglatinate(String in) {
		return "";
	}
	
	
	
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String s = kboard.nextLine();
	
		String out = RecursiveStringTools.length(s) + "";
		System.out.print("\n\nThe result is --> " + out + "\n\n");
	}
}
