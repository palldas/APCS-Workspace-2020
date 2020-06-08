import processing.core.PApplet;

public class KochSnowflake {

	private int level;
	private int length, x, y, angle;

	public KochSnowflake(int x, int y, int level, int length, int angle) {
		this.level = level;
		this.length = length;
		this.angle = angle;
		this.x = x;
		this.y = y;
	}
	
	public void draw(PApplet marker) {
		drawKochSnowflake(marker, level, marker.width/2-length/2, marker.height/2-length/2, length, angle);
	}
	
	private void drawKochSnowflake(PApplet marker, float level, float x, float y, float length, float angle) {

	}
}
