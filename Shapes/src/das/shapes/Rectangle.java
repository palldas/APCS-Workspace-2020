package das.shapes;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import processing.core.PApplet;

/**
 * This class models a Rectangle. It can perform common calculations
 * as well as drawing a representation of the rectangle to a Processing PApplet.
 * 
 * @author Pallavi Das
 * @version 10/9/19
 */
public class Rectangle extends Shape{
	private double width;
	private double height;
	private double scale;

/**
 * Creates a default instance of a Rectangle object with all dimensions set to zero
 */
    public Rectangle() {
    	super(0,0);
    	this.width = 0;
    	this.height= 0;
    	this.scale = 1;
    }
  
/** 
 * Creates a new instance of a Rectangle object with the left and right
 * edges of the rectangle at x and x + width. The top and bottom edges
 * are at y and y + height.
 * 
 * @param x x-coordinate of the upper left corner of the rectangle
 * @param y y-coordinate of the upper left corner of the rectangle
 * @param width width of the rectangle
 * @param height height of the rectangle
 */
    public Rectangle(double x, double y, double width, double height) {
    	super(x, y);
    	this.width = width;
    	this.height = height;
    	this.scale = 1;
    }

/** 
 * Draws a new instance of a Rectangle object with the left and right
 * edges of the rectangle at getX() and getX() + getWidth(). The top and bottom edges
 * are at getY() and getY() + getHeight().
 * 
 * @param drawer the PApplet to be used to draw the rectangle
 * @pre drawer must not be null, and appropriate settings should have been selected (color, fill, etc)
 * @post the drawer will have its rectangle mode modified to PApplet.CORNER 
 */
    public void draw(PApplet drawer) {
    	drawer.noFill();
    	drawer.scale((float)this.scale, (float)this.scale);
    	drawer.scale((float) this.scale, (float) this.scale);
    	drawer.rect((float)getX(),(float) getY(),(float) width, (float)height);
    }
    

    public double calcPerimeter() {
    	double perimeter = 2*(width+height);
    	return perimeter;
    }
    

    public double calcArea() {
    	double area = width*height;
    	return area;
    }

    public boolean isPointInside(double x, double y) {
    	if( (this.getX()<x && x<(this.getX()+this.width)) && (this.getY()<y && y<(this.getY()+this.height)) ){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
	public double getWidth() {
		return width;
	}
	

	public double getHeight() {
		return height;
	}
	

	public Double getCenter() {
		return new Point2D.Double(getX()+(width/2), getY()+(height/2));
	}
}
