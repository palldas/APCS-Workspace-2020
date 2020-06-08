import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FileZip {

	public static final String fileSeparator = System.getProperty("file.separator");
	public static final String lineSeparator = System.getProperty("line.separator");

	// This method takes a file name as an argument.
	// It then returns the data contained in the file as a String.
	public String readFile(String inputFile) {
		FileReader reader;
		Scanner in = null;
		String out = "";

		try {
			reader = new FileReader(inputFile);
			in = new Scanner(reader);

			while (in.hasNextLine()) {
				String input = in.nextLine();
				out += input + lineSeparator;
			}
			return out;

		} catch (IOException iox) {
			iox.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}
		return null;
	}

	// This method takes a file name and a data String as arguments.
	// A file is written to the disk using the filename given and containing the
	// data String.
	public void writeFile(String data, String outputFile) {
		FileWriter writer = null;

		try {
			writer = new FileWriter(outputFile);
			writer.write(data);

		} catch (IOException iox) {
			iox.printStackTrace();

		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException iox) {
				iox.printStackTrace();
			}
		}
	}

//	public void writeFile(ArrayList<String> data, String outputFile) {
//		PrintWriter out = null;
//		try {
//			out = new PrintWriter(outputFile);
//
//			for (String x : data)
//				out.print(x);
//
//		} catch (IOException iox) {
//			iox.printStackTrace();
//		}
//		out.close();
//	}

	// This method takes two file names as arguments.
	// The input file is converted into an output file that will take up less space
	// on the disk.
	public void zip(String inputFile, String outputFile) {
		String data = readFile(inputFile);

		String[] a = data.split("\n");
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < a.length - 1; i++) {
			String[] b = a[i].split(" ");
			for (String x : b) {
				list.add(x);
			}
		}
		Collections.sort(list); // sort

		int length = 0;
		int value = 0;
		String key = "";

		// finding most common word (key)
		int counter = 0;
		for (int i = 0; i < (list.size() - 3); i++) {
			if (list.get(i).equals(list.get(i + 1)) && list.get(i) != " ") {
				counter++;
				int newLength = list.get(i).length() * counter;
				if (counter > 1 && newLength > length && list.get(i).length() > 1) {
					key = list.get(i);
					value = counter;
					length = newLength;
					if (!(list.get(i + 1).equals(list.get(i + 2))))
						value += 1;
					counter = 0;
				} else if ((counter == 1 && value < counter && value != 0)
						|| (!(list.get(i + 1).equals(list.get(i + 2))))) {
					counter = 0;
				}
			}
		}

		// finding first unique symbol
		String unique = "";
		for (int i = 128; i <= 255; i++) {
			if (list.indexOf((char) i) < 0) {
				unique = Character.toString((char) i);
				break;
			}
		}
		System.out.println("\n" + "unique: " + unique + "\n" + "key: " + key + "\n");

		data = data.replace(key, unique); // replace
		data = unique + " " + key + "\n" + data; // add in the front

		writeFile(data, outputFile);

	}

	// This method takes two file names as arguments.
	// The input file is converted from its smaller �zipped� form back to its
	// original version.
	public void unzip(String inputFile, String outputFile) {
		String data = readFile(inputFile);

		String[] text = data.split(lineSeparator, 2);
		String[] keyAndUnique = text[0].split(" ");
		System.out.println(Arrays.toString(keyAndUnique));
		String key = keyAndUnique[1];
		String unique = keyAndUnique[0];
		data = text[1];
		// System.out.println(data);
		data = data.replace(unique, key);

		writeFile(data, outputFile);

//		String[] a = data.split("\n");
//		ArrayList<String> list = new ArrayList<String>();
//		for (int i = 0; i < a.length - 1; i++) {
//			a[i] += "\n";
//			String[] b = a[i].split(" ");
//			for (String x : b) {
//				list.add(x + " ");
//			}
//
//		}
//
//		String unique = list.get(0);
//		String key = list.get(1);
//		System.out.println("\n" +"unique: "+ unique + "\n" + "key: "+key + "\n");
//
//		list.remove(0);
//		list.remove(0);
//
//		for (int i = 0; i < (list.size() - 1); i++) {
//			if (list.get(i).equals(unique)) {
//				list.set(i, key);
//			}
//		}
//
//		System.out.println();
//		writeFile(list, outputFile);

	}

}
