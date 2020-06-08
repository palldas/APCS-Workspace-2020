import javax.swing.JOptionPane;

public class Package {

	private double dim1, dim2, dim3, weight;
	private double lar, girth;

	public Package(double dim1, double dim2, double dim3, double weight) {
		this.dim1 = dim1;
		this.dim2 = dim2;
		this.dim3 = dim3;
		this.weight = weight;
	}

	public void checkStatus() {
		if (dim1 > dim2 && dim1 > dim3) {
			lar = dim1;
			girth = 2 * dim2 + 2 * dim3;
		} else if (dim2 > dim1 && dim2 > dim3) {
			lar = dim2;
			girth = 2 * dim1 + 2 * dim2;
		} else if (dim3 > dim1 && dim3 > dim1) {
			lar = dim3;
			girth = 2 * dim1 + 2 * dim2;
		}

		if (lar + girth > 100) {
			if (weight > 70)
				JOptionPane.showMessageDialog(null, "Package is too heavy and too big");

			else {
				if (lar + girth > 100)
					JOptionPane.showMessageDialog(null, "Package is too big");

				else {
					if (weight > 70)
						JOptionPane.showMessageDialog(null, "Package is too heavy");

					else {
						if (lar < 0 && girth < 0 && weight < 0)
							JOptionPane.showMessageDialog(null, "Package is invalid");

						else
							JOptionPane.showMessageDialog(null, "Package is acceptable");
					}
				}
			}
		} else {
			if (weight > 70)
				JOptionPane.showMessageDialog(null, "Package is too heavy");

			else {
				if (lar < 0 && girth < 0 && weight < 0)
					JOptionPane.showMessageDialog(null, "Package is invalid");

				else
					JOptionPane.showMessageDialog(null, "Package is acceptable");
			}
		}
	}
}
