import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*

	This program erases objects (connected stars) from a 2D grid. 

	Coded by: Pallavi Das
	Modified on: 3/7/20

*/

public class Erase {

	private static final int rows = 20;
	private static final int cols = 20;
	private char[][] grid;

	// Constructs an empty grid
	public Erase() {
		grid = new char[rows][cols];
	}

	// Constructs the grid defined in the file specified
	public Erase(String filename) {
		grid = new char[rows][cols];
		readData(filename, grid);
	}

	// Erases an object beginning at x,y
	public void eraseObject(int x, int y) {
		if (!(x >= 0 && x < 20 && y >= 0 && y < 20)) {
			System.out.println("Invalid x or y value");
		}

		else if (grid[x][y] == '*') {
			grid[x][y] = ' ';
			if (x < grid.length - 1 && y < grid.length)
				eraseObject(x + 1, y);
			if (x < grid.length && y < grid.length - 1)
				eraseObject(x, y + 1);
			if (x > 0 && y < grid.length)
				eraseObject(x - 1, y);
			if (x < grid.length && y > 0)
				eraseObject(x, y - 1);
		}

	}

	// Formats this grid as a String to be printed (one call to this method returns
	// the whole multi-line grid)
	public String toString() {
		String cell = "";

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				cell += grid[j][i];
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