import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/*

	Coded by: Pallavi Das
	Modified on: 3/10/20

*/

public class Labyrinth {

	private static final int rows = 20;
	private static final int cols = 20;
	private char[][] data;
	private boolean invisible;

	// Constructs an empty grid
	public Labyrinth() {
		data = new char[rows][cols];
	}

	// Constructs the grid defined in the file specified
	public Labyrinth(String filename) {
		data = new char[rows][cols];
		readData(filename, data);
	}

	// Finds a path through the maze and modifies data to show the path
	public int findPath() {
		for (int x = 0; x < data.length; x++) {
			for (int y = 0; y < data.length; y++) {
				if (data[x][y] == 'C') {
					return solve(x, y);
				}
			}
		}
		return -1;
	}

	// Private recursive version of findPath()
	private int solve(int x, int y) {
		if (data[x][y] == '@')
			invisible = true;
		if (data[x][y] == '#')
			return -1;
		if (data[x][y] == 'X')
			return 0;
		if (data[x][y] == '!' && invisible)
			return -1;
		if (data[x][y] == 'A' && !invisible)
			return -1;
		else {
			data[x][y] = '!';
			char temp = data[x][y];
			int up = 0, down = 0, right = 0, left = 0;
			if (data[x][y - 1] != '!')
				up = solve(x, y - 1);
			if (data[x][y + 1] != '!')
				down = solve(x, y + 1);
			if (data[x + 1][y] != '!')
				right = solve(x + 1, y);
			if (data[x - 1][y] != '!')
				left = solve(x - 1, y);
			return findMin(new int[] { up, down, right, left });
		}
	}

	public int findMin(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					this.swap(j, j + 1, numbers);
				}
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
		System.out.println();
		return numbers[0];
	}

	private void swap(int index1, int index2, int[] numbers) {
		if (index1 < numbers.length && index2 < numbers.length) {
			int temp = numbers[index1];
			numbers[index1] = numbers[index2];
			numbers[index2] = temp;
		} else {
			throw new IllegalArgumentException("Invalid index");
		}
	}

	// Formats this grid as a String to be printed (one call to this method returns
	// the whole multi-line grid)
	public String toString() {
		String cell = "";

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				cell += data[j][i];
			}
			cell += '\n';
		}
		return cell;
	}

	public void readData(String filename, char[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++)
						if (i < gameData.length && count < gameData[i].length)
							gameData[i][count] = line.charAt(i);

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}

}