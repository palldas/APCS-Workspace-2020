import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*

	Represents a 2D maze.

	Coded by: Pallavi Das
	Modified on: 3/9/20

*/

public class Maze {

	private static final int rows = 20;
	private static final int cols = 20;

	private char[][] grid;

	// Constructs an empty grid
	public Maze() {
		grid = new char[rows][cols];
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
		grid = new char[rows][cols];
		readData(filename, grid);
	}

	// Attempts to find a path through the maze and returns whether a path was found
	// or not
	public boolean solve() {
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				if (grid[x][y] == 'C') {
					return solve(x, y);
				}
			}
		}
		return false;
	}

	// Private recursive version of solve()
	private boolean solve(int x, int y) {
		if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[x].length - 1)
			return false;

		if (grid[x][y] == 'X')
			return true;

		if (grid[x][y] == '#')
			return false;

		if (grid[x][y] == '!')
			return false;
		else {
			grid[x][y] = '!';
			if (solve(x, y - 1))
				return true;
			else if (solve(x - 1, y))
				return true;
			else if (solve(x + 1, y))
				return true;
			else if (solve(x, y + 1))
				return true;
			else
				return false;
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