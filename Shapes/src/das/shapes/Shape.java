package das.shapes;

import java.awt.geom.Point2D;
import java.awt.Color;

import processing.core.PApplet;

/**
 * This class models a Shape. It can perform common calculations as well as
 * drawing a representation of the shape to a Processing PApplet.
 * 
 * @author Pallavi Das
 * @version 10/9/19
 */
public abstract class Shape {

	// FIELDS

	private double x, y, scale;

	private Color strokeColor;

	private int strokeWidth;

	// CONSTRUCTOR

	/**
	 * Creates a new instance of a shape object with a x and y coordinated depending
	 * on the shape
	 * 
	 * @param x main x-coordinate of the shape
	 * @param y main y-coordinate of the shape
	 */
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
		this.scale = 1;
	}

	// METHODS

	/**
	 * Returns the width of the shape
	 * 
	 * @return width width of the shape
	 */
	public abstract double getWidth();

	/**
	 * Returns the height of the shape
	 * 
	 * @return height height of the shape
	 */
	public abstract double getHeight();

	/**
	 * Returns the color of the stroke
	 * 
	 * @return the current stroke color of the stroke
	 */
	public Color getStrokeColor() {
		return strokeColor;
	}

	/**
	 * Sets the stroke color to new color given
	 * 
	 * @param c the new color stroke is being set to
	 * @post the drawer will have its stroke modified to the new color given
	 */
	public void setStrokeColor(Color c) {
		strokeColor = c;
	}

	/**
	 * Sets the stroke to the given width and color
	 * 
	 * @param set drawer the PApplet to be used to draw the shape
	 * @pre drawer must not be null
	 * @post the stroke will be modified to the certain width and color
	 */
	public void primeProp(PApplet set) {
		set.stroke(strokeColor.getRed(), strokeColor.getGreen(), strokeColor.getBlue());
		set.strokeWeight(strokeWidth);
	}

	public abstract void draw(PApplet drawer);

	/**
	 * Calculates and returns the center point of the shape
	 * 
	 * @return center center of the shape
	 */
	public abstract Point2D.Double getCenter();

	/**
	 * Moves the shape by giving a new coordinate
	 * 
	 * @param x the new x-value of the coordinate
	 * @param y the new y-value of the coordinate
	 */
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Scales the shape
	 * 
	 * @param factor the value that is being added to the scale to make the shape
	 *               bigger/smaller
	 */
	public void scale(double factor) {
		this.scale += factor;
	}

	/**
	 * Returns the main x-cooridnate
	 * 
	 * @return the main x-cooridnate of the shape
	 */
	public double getX() {
		return x;
	}

	/**
	 * Returns the main y-cooridnate
	 * 
	 * @return the main y-cooridnate of the shape
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the stroke width to new width given
	 * 
	 * @param d the new width the line stroke is being set to
	 * @pre the stroke (d) must be an integer
	 */
	public void setStrokeWidth(int d) {
		strokeWidth = d;
	}

	/**
	 * Returns the width of the stroke
	 * 
	 * @return the current stroke width of the stroke
	 */
	public int getStrokeWidth() {
		return strokeWidth;
	}

	// Shape2D

	/**
	 * Calculates and returns the area of the shape
	 * 
	 * @return the area of the shape
	 */
	public abstract double calcArea();

	/**
	 * Calculates and returns the perimeter of the shape
	 * 
	 * @return the perimeter of the shape
	 */
	public abstract double calcPerimeter();

	/**
	 * Determines whether the point x,y is contained inside the shape
	 * 
	 * @param x the x-coordinate of the point to check
	 * @param y the y-coordinate of the point to check
	 * @return true if the point (x,y) is contained inside, or on the border, of
	 *         this shape
	 */
	public abstract boolean isPointInside(double x, double y);

}
