import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		double dim1 = Double.parseDouble(JOptionPane.showInputDialog("What is the first dimension?"));
		double dim2 = Double.parseDouble(JOptionPane.showInputDialog("What is the second dimension?"));
		double dim3 = Double.parseDouble(JOptionPane.showInputDialog("What is the third dimension?"));
		double weight = Double.parseDouble(JOptionPane.showInputDialog("What is the weight?"));
		
		Package p = new Package(dim1, dim2, dim3, weight);
		p.checkStatus();
	}

}
