
public class DataTester {
	public static void main (String [] args) {
		
		DataSet data1 = new DataSet();
		data1.readData("data/numbers.txt");
		data1.printData();
		System.out.println();

		DataSet data2 = new DataSet();
		data2.readData("data/numbers2.txt");
		data2.printData();
		System.out.println();
		
		DataSet data3 = new DataSet();
		data3.readData("data/numbers3.txt");
		data3.printData();
		System.out.println();
		
		DataSet data4 = new DataSet();
		data4.readData("data/numbers4.txt");
		data4.printData();

	}
}
