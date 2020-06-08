import processing.core.PApplet;

public class BanachFractal {

	private float level, radius;

	public BanachFractal(float level, float radius) {
		this.level = level;
		this.radius = radius;
	}

	public void draw(PApplet marker) {
		marker.ellipse(marker.width/2, marker.height/2, 3, 3);
		drawBanachFractal(marker, level, radius, marker.width/2, marker.height/2);
	}

	public void drawBanachFractal(PApplet marker, float level, float radius, float x, float y) {
		marker.noFill();
		if (level < 1) {
			marker.ellipse(x, y, radius, radius);
		} else {
			//drawBanachFractal(marker, level-1, radius, x, y);
			radius /= 1.5;
			drawBanachFractal(marker, level-1, radius, x, y);
		}
	}

}
