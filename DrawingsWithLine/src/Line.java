import processing.core.PApplet;

public class Line {
	private float x1;
	private float y1;
	private float x2;
	private float y2;
	
	private float xIntersect;
	private float yIntersect;


	// Constructs a line from (x1, y1) to (x2, y2)
	public Line(float x1, float y1, float x2, float y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	// Sets this line second point (x2, y2) to a new coordinate
	public void setPoint2(float x2, float y2) {
		this.x2 = x2;
		this.y2 = y2;
	}

	// Draws this line using the PApplet passed as an argument
	public void draw(PApplet drawer) {

		drawer.line(x1, y1, x2, y2);

	}

	public float getIntX() {
		return xIntersect;
	}
	
	public float getIntY() {
		return yIntersect;
	}

	// Returns true if this line segment and the segment other intersect each other.
	// Returns false if they do not intersect.
	public boolean intersects(Line other) {
		
		System.out.println("x1: " + this.x1);
		System.out.println("y1: " + this.y1);
		System.out.println("x2: " + this.x2);
		System.out.println("y2: " + this.y2);
		System.out.println("x3: " + other.x1);
		System.out.println("y3: " + other.y1);
		System.out.println("x4: " + other.x2);
		System.out.println("y4: " + other.y2);

		float denominator = ((this.x1 - this.x2) * (other.y1 - other.y2) - (this.y1 - this.y2) * (other.x1 - other.x2));

		if (denominator == 0) {
			System.out.println("parallel");
			return false;
		}

		xIntersect = ((((this.x1 * this.y2) - (this.y1 * this.x2)) * (other.x1 - other.x2)
				- (this.x1 - this.x2) * ((other.x1 * other.y2) - (other.y1 * other.x2))) / (denominator));

		yIntersect = ((((this.x1 * this.y2) - (this.y1 * this.x2)) * (other.y1 - other.y2)
				- (this.y1 - this.y2) * ((other.x1 * other.y2) - (other.y1 * other.x2))) / (denominator));

		if ( ( ( (this.x1 <= xIntersect && xIntersect <= this.x2)
				|| (this.x2 <= xIntersect && xIntersect <= this.x1) )
				&& ( (this.y1 <= yIntersect && yIntersect <= this.y2)
				|| (this.y2 <= yIntersect && yIntersect <= this.y1) ) )
				&& ( ( (other.x1 <= xIntersect && xIntersect <= other.x2)
				|| (other.x2 <= xIntersect && xIntersect <= other.x1) )
				&& ( (other.y1 <= yIntersect && yIntersect <= other.y2)
				|| (other.y2 <= yIntersect && yIntersect <= other.y1) ) ) ) {
			
				
			System.out.println("intersecting");
			return true;
		}
			
		else {
			System.out.println("not intersecting");
			return false;
		}
	}
}