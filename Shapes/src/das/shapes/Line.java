package das.shapes;
import java.awt.geom.Point2D;


import java.awt.geom.Point2D.Double;

import processing.core.PApplet;

/**
 * This class models a Line. It can detect when another line is intersecting it
 * as well a drawing a representation of the line to a Processing PApplet
 * 
 * @author Pallavi Das
 * @version 10/9/19
 */
public class Line extends Shape{
	private double x2;
	private double y2;
	
	private double xIntersect;
	private double yIntersect;
	
	
	

	public Line() {
		super(0, 0);
		this.x2 =0;
		this.y2 = 0;
	}
	
/**
 * Creates a new instance of a Line object from (getX(), getY()) to (x2, y2)
 * 
 * @param x1 x-coordinate of the first point/end of the line
 * @param y1 y-coordinate of the first point/end of the line
 * @param x2 x-coordinate of the second point/end of the line
 * @param y2 y-coordinate of the second point/end of the line
 */
	public Line(double x1, double y1, double x2, double y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
		
	}
	
	public Line(double x1, double y1, double angle, int length) {
		super(x1, y1);
		double width = length*Math.cos(angle);
		double height = length*Math.sin(angle);
		this.x2 = x1+width;
		this.y2 = y1+height;
	}

/** 
 * 
 * Draws a new instance of a line object with the x and y coordinates of 2 endpoints
 *     
 * @param drawer the PApplet to be used to draw the line
 * @pre drawer must not be null, and appropriate settings should have been selected (color, fill, etc)
 * @post the drawer will have its line drawn using both points
 */
	public void draw(PApplet drawer) {
		drawer.line((float)getX(),(float) getY(), (float)x2, (float)y2);
	}
	
/**
 * Sets the line's second point (x2, y2) to a new coordinate
 * 
 * @param x2 x-coordinate of the new end of the line
 * @param y2 y-coordinate of the new end of the line
 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Returns the coordinate of the second point
	 * 
	 * @return the x and y coordinate of the second point of the line
	 */
	public Double getPoint2() {
		return new Point2D.Double( this.x2, this.y2 );
	}


/**
 * Returns true if this line segment and the segment other intersect each other.
 * Returns false if they do not intersect.
 * 
 * @param other the other line that the current line is being compared to for intersection
 * @return true, if the lines intersect each other
 */
	public boolean intersects(Line other) {
		
		System.out.println("x1: " + this.getX());
		System.out.println("y1: " + this.getY());
		System.out.println("x2: " + this.x2);
		System.out.println("y2: " + this.y2);
		System.out.println("x3: " + other.getX());
		System.out.println("y3: " + other.getY());
		System.out.println("x4: " + other.x2);
		System.out.println("y4: " + other.y2);

		float denominator = (float) ((this.getX() - this.x2) * (other.getY() - other.y2) - (this.getY() - this.y2) * (other.getX() - other.x2));

		if (denominator == 0) {
			System.out.println("parallel");
			return false;
		}

		xIntersect = (float) ((((this.getX() * this.y2) - (this.getY() * this.x2)) * (other.getX() - other.x2)
				- (this.getX() - this.x2) * ((other.getX() * other.y2) - (other.getY() * other.x2))) / (denominator));

		yIntersect = (float) ((((this.getX() * this.y2) - (this.getY() * this.x2)) * (other.getY() - other.y2)
				- (this.getY() - this.y2) * ((other.getX() * other.y2) - (other.getY() * other.x2))) / (denominator));

		if ( ( ( (this.getX() <= xIntersect && xIntersect <= this.x2)
				|| (this.x2 <= xIntersect && xIntersect <= this.getX()) )
				&& ( (this.getY() <= yIntersect && yIntersect <= this.y2)
				|| (this.y2 <= yIntersect && yIntersect <= this.getY()) ) )
				&& ( ( (other.getX() <= xIntersect && xIntersect <= other.x2)
				|| (other.x2 <= xIntersect && xIntersect <= other.getX()) )
				&& ( (other.getY() <= yIntersect && yIntersect <= other.y2)
				|| (other.y2 <= yIntersect && yIntersect <= other.getY()) ) ) ) {

			return true;
		}
			
		else {
			return false;
		}
	}

	public double getWidth() {
		return Math.abs(x2-getX());
	}

	public double getHeight() {
		return Math.abs(y2-getY());
	}


	public Double getCenter() {
		return new Point2D.Double( ((this.getX()+this.x2)/2), ((this.getY()+this.y2)/2) );
	}
	
	
	public double calcArea() {
		return 0;
	}
	
	public Rectangle getBoundingRectangle() {
		return new Rectangle(getX(), getY(), Math.abs(getX()- x2), Math.abs(getY()- y2));
	}
	
	public double calcPerimeter() {
		double width = Math.abs(this.getX()-this.x2);
		double height = Math.abs(this.getY()- this.y2);
		return Math.sqrt((width*width)+(height*height));
	}

	public boolean isPointInside(double x, double y) {
		Line point = new Line(x, y, x, y);
		return this.intersects(point);

	}

}