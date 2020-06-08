import processing.core.PApplet;

public class BoxFractal {

	private float level, length;

	public BoxFractal(float level, float length) {
		this.level = level;
		this.length = length;
	}

	public void draw(PApplet marker) {
		marker.noFill();
		drawBoxFractal(marker, level, length, marker.width / 2 - length / 2, marker.height / 2 - length / 2);
	}

	public void drawBoxFractal(PApplet marker, float level, float length, float x, float y) {
		if (level < 1) {
			marker.rect(x, y, length, length);
		} else {
			length /= 3;
			level -= 1;
			drawBoxFractal(marker, level, length, x, y);
			drawBoxFractal(marker, level, length, x + (2 * length), y);
			drawBoxFractal(marker, level, length, x, y+(2 * length));
			drawBoxFractal(marker, level, length, x+(2 * length), y+(2 * length));
			drawBoxFractal(marker, level, length, x+ length, y+length);

		}
	}
}
