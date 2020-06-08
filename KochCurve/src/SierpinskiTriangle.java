import processing.core.PApplet;

public class SierpinskiTriangle {

	private float level, length;

	public SierpinskiTriangle(float level, float length) {
		this.level = level;
		this.length = length;
	}

	public void draw(PApplet marker) {
		drawSierpinskiTriangle(marker, level, length, marker.width / 2 - length / 2, marker.height / 2 - length / 2);
	}

	public void drawSierpinskiTriangle(PApplet marker, float level, float length, float x, float y) {
		if (level < 1) {
			marker.triangle(x, y, (float) (x+(Math.cos(60) * length)), (float) (y-(Math.sin(60) * length)), x + length, y);
		}
	}

}
