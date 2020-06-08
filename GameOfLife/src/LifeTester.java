public class LifeTester {

	public static void main(String[] args) {
		Life grid = new Life("griddata/life100.txt");
		
		int gen=0;
		for(int i =0; i<5; i++) {
			grid.step();
			gen++;
		}
		
		System.out.println("Generations: "+gen);
		System.out.println(grid);
		
		System.out.println("Number in Row 10 -----> " + grid.countRow(10));
		System.out.println("Number in Column 10 -----> " + grid.countColumn(10));
		System.out.println("Number of living organisms -----> " + grid.countLivingCells());
		
	}

}