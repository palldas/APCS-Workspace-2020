import java.util.Scanner;

public class Hanoi {

	public static void printHanoiSolution(int numberOfDisks) {
		// Call your private Hanoi method
	}

	// Create a recursive private method

	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Enter # of disks: ");
		int disks = kboard.nextInt();
		System.out.println("Finding Hanoi solution...");
		printHanoiSolution(disks, 1, 3, 2);
		System.out.println("This took " + steps + " steps");
	}

	public static int steps = 0;


	public static void printHanoiSolution(int disks, int start, int end, int other) {
		steps++;
		if (disks <= 1) {
			System.out.println("Move disk 1 from " + start + " to " + end);
		} else {
			printHanoiSolution(disks - 1, start, other, end);
			System.out.println("Move disk " + disks + " from " + start + " to " + end);
			printHanoiSolution(disks - 1, other, end, start);
		}
	}

}
