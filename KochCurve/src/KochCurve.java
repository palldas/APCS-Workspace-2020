import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 * 
 * 
 * @author Pallavi Das
 * @version 2/23/20
 */
public class KochCurve {

	// TO DO
	private float level, length;

	public KochCurve(float level, float length) {
		this.level = level;
		this.length = length;
	}

	public void draw(PApplet marker) {
//		drawKochCurve(marker, this.level, marker.width / 5, marker.height / 2, this.length, 0);
		drawKochCurve(marker, this.level, marker.width/2-length/2, marker.height/2-length/2, this.length, 0);
	}

	private void drawKochCurve(PApplet marker, float level, float x, float y, float length, float angle) {
		if (level < 1) {
			float newX = (float) (x + (Math.cos(angle) * length));
			float newY = (float) (y + (Math.sin(angle) * length));
			marker.line(x, y, newX, newY);
		} 
		
		else {
			length /= 3;
			level-=1;
			drawKochCurve(marker, level, x, y, length, angle);

			float x2 = (float) (x + (Math.cos(angle) * length));
			float y2 = (float) (y + (Math.sin(angle) * length));
			angle -= Math.PI / 3;
			drawKochCurve(marker, level, x2, y2, length, angle);

			float x3 = (float) (x2 + Math.cos(angle) * length);
			float y3 = (float) (y2 + Math.sin(angle) * length);
			angle += 2 * Math.PI / 3;
			drawKochCurve(marker, level, x3, y3, length, angle);

			float x4 = (float) (x3 + Math.cos(angle) * length);
			float y4 = (float) (y3 + Math.sin(angle) * length);
			angle -= Math.PI / 3;
			drawKochCurve(marker, level, x4, y4, length, angle);
		}
		
		/* TO DO
		 * if level < 1 then Draw a straight line of the current length
		 * 
		 * else Draw a k-1 level Koch curve of 1/3 the current length
		 * 
		 * Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the
		 * current length, at an angle of 60 degrees with respect to the current angle
		 * 
		 * Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the
		 * current length, at an angle of -60 degrees with respect to the current angle
		 * 
		 * Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the
		 * current length
		 * 
		 */
	}

}
