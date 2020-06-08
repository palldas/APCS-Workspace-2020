
public class MainMaze {

	public static void main(String[] args) {
		Maze data = new Maze("mazeData/test5.txt");
		boolean sol = data.solve();
		System.out.println(sol);
		if (sol)
			System.out.println(data);

	}

}
