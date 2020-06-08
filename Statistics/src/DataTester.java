
public class DataTester {
	public static void main (String [] args) {
		
		DataSet data1 = new DataSet();
		data1.readData("data/numbers.txt");
		data1.printData();
	}
}
