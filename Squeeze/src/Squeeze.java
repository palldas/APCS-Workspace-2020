
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Squeeze {
	private File file;
	private Scanner in;
	private ArrayList<String> output;

	public Squeeze(String filename) {
		this.file = new File(filename);
		output = new ArrayList<String>();
	}

	public void squeeze() {
		output = new ArrayList<String>();

		try {
			in = new Scanner(file);

			while (in.hasNextLine()) {
				String line = in.nextLine();
				int spaces = 0;

				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == ' ')
						spaces++;
					else
						break;
				}

				line = spaces + " " + line.substring(spaces);
				output.add(line);
			}
			in.close();
		} catch (IOException iox) {
			System.out.println("Error - File not found");
		}
	}

	public void reverse() {
		output = new ArrayList<String>();

		try {
			in = new Scanner(file);

			while (in.hasNextLine()) {
				String line = in.nextLine();
				int num = Integer.parseInt(line.charAt(0) + "");
				String result = "";

				for (int i = 0; i < num; i++)
					result += " ";

				result += line.substring(2);
				output.add(result);
			}
			in.close();
		} catch (IOException iox) {
			System.out.println("Error - File not found");
		}
	}

	public void writeFile() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(file);

			for (String x : output)
				out.println(x);

		} catch (IOException iox) {
			iox.printStackTrace();
		}
		out.close();
	}
}
