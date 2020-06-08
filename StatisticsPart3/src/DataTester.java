import java.util.Arrays;

public class DataTester {
	public static void main (String [] args) {
		
		DataSet compdata2 = new DataSet();
		compdata2.readData("data/numbers2.txt");
		System.out.println(Arrays.toString(compdata2.compact(0)));
		compdata2.printData();

		System.out.println();
		
		DataSet compdata3 = new DataSet();
		compdata3.readData("data/numbers3.txt");
		System.out.println(Arrays.toString(compdata3.compact(0)));
		compdata3.printData();

				
	}
}
