import java.util.ArrayList;

public class DataSet {

	private int[] data;
	private int length;
	private int realLength;
	public static final int MAX_POSSIBLE_VALS= 10000;

	public DataSet() {
		data = new int[MAX_POSSIBLE_VALS];
	}

	public double calcAverage() {
		double sum = 0;
		for (int i : data) {
			sum += i;
		}
		double avg = sum/length;
		return avg;
	}

	public int getLength() {
		return length;
	}
	
	public double calcSD() {
		double avg = calcAverage();
		int sum = 0;
		for (int i = 0; i < length; i++) 
			sum += Math.pow((data[i] - avg), 2);
		
		double sd = Math.sqrt(sum / length);
		return sd;
	}

	public ArrayList<Integer> calcMode() {
		int maxCount = 0;
		ArrayList<Integer> maxValue = new ArrayList<Integer>();

		for (int i = 0; i < length; ++i) {
			int count = 0;
			for (int j = 0; j < length; ++j) {
				if (data[j] == data[i])
					++count;
			}

			if (count >= maxCount && !maxValue.contains(data[i])) {
				if(count > maxCount) {
					maxValue.clear();
				}
				maxCount = count;
				maxValue.add(data[i]);
			}
		}
		return maxValue;
	}

	public void readData(String filename) {
		ArrayReader reader = new ArrayReader(filename);
		this.realLength = reader.fillArray(data);
		System.out.println("real length = "+ this.realLength);
		System.out.println("length = "+ data.length);

		this.length = realLength;

		reader.fillArray(data);
		String file ="";
		for (int i = 0; i<filename.length(); i++) {
			file = file +filename.charAt(i);
		}
		System.out.println(file);
	}

	public void printData() {
		System.out.println("Average: "+calcAverage());
		System.out.println("Standard Deviation: "+calcSD());
		System.out.println("Modes: "+calcMode());
	}
}
