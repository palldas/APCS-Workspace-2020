import java.awt.Point;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

public class Life {

	private boolean [][] grid;

	// Constructs an empty grid
	public Life() {
		grid = new boolean [20][20];
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
		grid = new boolean [20][20];
		readData(filename, grid);
	}

	// Runs a single turn of the Game Of Life
	public void step() {
		boolean[][] c = new boolean[2][];
		for (int y = 0; y < grid.length; y++) {
			c[1] = new boolean[grid[y].length];
			for (int x = 0; x < grid[y].length; x++) {
				c[1][x] = getNeighborCount(y, x);
			}
			if (c[0] != null) {
				grid[y - 1] = c[0];
			}
			c[0] = c[1];
		}
		grid[grid.length - 1] = c[0];
	}	

	private boolean getNeighborCount(int y, int x) {
		int n = 0;
		
		if(x > 0 && y > 0 && grid[y - 1][x - 1]) 
			n+=1;
		
		if(x > 0 && grid[y][x - 1]) 
			n+=1;
		
		if(x > 0 && y < (grid.length - 1) && grid[y + 1][x - 1]) 
			n+=1;
		
		if(y > 0 && grid[y - 1][x])
			n+=1;

		if(y < (grid.length - 1) && grid[y + 1][x]) 
			n+=1;
		
		if(x < (grid[y].length - 1) && y > 0 && grid[y - 1][x + 1]) 
			n+=1;
	
		if(x < (grid[y].length - 1) && grid[y][x + 1]) 
			n+=1;
		
		if(x < (grid[y].length - 1) && y < (grid.length - 1) && grid[y + 1][x + 1])
			n+=1;

		if (n <= 1 || n >= 4) 
			return false;
		
		else if (n == 3) 
			return true;
		 
		else  // (n==2)
			return grid[y][x];
		
	}
	

	// Runs n turns of the Game Of Life
	public void step(int n) {
		for(int i =0; i<n; i++) 
			step();
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String cell = " ";

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if(grid[j][i]) 
					cell = cell + "*";

				else 
					cell = cell + " ";
			}
			cell = cell + "\n";
		}
		return cell;
	}

	//Calculates the number of live cells in specified row r
	public int countRow (int r) {
		r--;
		int n = 0;
		for (int j = 0; j < grid.length; j++) {
			if (grid[r][j]) {
				n++;
			}
		}
		return n;
	}

	//Calculates the number of live cells in specified column c
	public int countColumn (int c) {
		c--;
		int n = 0;
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][c]) {
				n++;
			}
		}
		return n;
	}

	//Calculates the number of living organisms
	public int countLivingCells () {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j]) 
					count++;
			}
		}
		return count;
	}

	// Reads in array data from a simple text file containing asterisks (*)
	public void readData (String filename, boolean[][] gameData) {
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
					for(int i = 0; i < line.length(); i++)
						if (count < gameData.length && i < gameData[count].length && line.charAt(i)=='*')
							gameData[count][i] = true;

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





	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		marker.pushStyle();

		float cellHeight = height/grid.length;
		float cellWidth = width/grid[0].length;

		marker.stroke(0);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if(grid[j][i]) 
					marker.fill(225, 225, 0);

				else 
					marker.fill(169,169,169);

				marker.rect( (x + (j*cellWidth)), (y + (i*cellHeight)), cellWidth, cellHeight );
			}
		}
		marker.popStyle();	
	}

	/**
	 * Optionally, complete this method to determine which element of the grid matches with a
	 * particular pixel coordinate.
	 * 
	 * @param p A Point object representing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		float cellWidth = width/grid[0].length;
		float cellHeight = height/grid.length;

		int i = (int) ((p.y-y)/cellHeight);
		int j = (int) ((p.x-x)/cellWidth);


		if (i < 0 || i >= grid.length)
			return null;

		if (j < 0 || j >= grid[0].length) 
			return null;


		Point coord = new Point(j, i);

		return coord;
	}

	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 * 
	 * @param i The x coordinate of the cell in the grid.
	 * @param j The y coordinate of the cell in the grid.
	 */
	public void toggleCell(int i, int j) {
		grid[i][j] = !grid[i][j];
	}
}