package das.shapes;
import java.awt.geom.Point2D;

import processing.core.PApplet;



/**
 * This class models a Circle. It can calculate the the area and circumference
 * as well a drawing a representation of the circle to a Processing PApplet
 * 
 * @author Pallavi Das
 * @version 10/9/19
 * 
 */
public class Circle extends Shape{

	private double radius;
	private double scale;

/**
 * Creates a default instance of a Circle object with all dimensions set to zero
 */
    public Circle() {
    	super(0,0);
    	this.radius = 0;
    	this.scale= 1;
    }
/** 
 * Creates a new instance of a Circle object with the with the center (at x,y)
 * // the width and height would be radius*2
 * 
 * @param x x-coordinate of the center of the circle
 * @param y y-coordinate of the center of the circle
 * @param radius radius of the circle
 */    
    public Circle(double x, double y, double radius) {
    	super(x, y);
    	this.radius = radius;
    	this.scale = 1;
    }
    
/** 
 * Draws a new instance of a Circle object with (x,y) as the center of the circle
 * // The width and height of the circle is radius*2
 *     
 * @param drawer the PApplet to be used to draw the circle
 * @pre drawer must not be null, and appropriate settings should have been selected (color, fill, etc)
 * @post the drawer will have its circle mode modified to PApplet.CENTER 
 */
    public void draw(PApplet drawer) {
    	drawer.noFill();
    	drawer.scale((float)this.scale, (float) this.scale);
    	drawer.ellipse((float)getX(),(float) getY(),(float) radius*2, (float) radius*2);
    }
    
/** 
 * Calculates and returns the circumference of the circle
 * 
 * @pre radius must be &gt; 0
 * @return the circumference of the circle
 */
    public double calcPerimeter() {
    	double circumference = Math.PI*(2*radius);
    	return circumference;
    }
    
/** 
 * Calculates and returns the area of the circle
 * 
 * @pre radius must be &gt; 0
 * @return the area of the circle
 */
    public double calcArea() {
    	double area = Math.PI*(radius*radius);
    	return area;
    }

    public boolean isPointInside(double x, double y) {
    	double rSquared = Math.pow(x, 2)+ Math.pow(y, 2);
    	if(rSquared> (radius*radius)) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    

	public double getWidth() {
		return radius*2;
	}

	public double getHeight() {
		return radius*2;
	}

	public Rectangle getBoundingRectangle() {
		return new Rectangle (this.getX()-radius, this.getY()-radius, 2*radius, 2*radius);
	}

	public Point2D.Double getCenter() {
		return new Point2D.Double(getX(), getY());
	}
}
