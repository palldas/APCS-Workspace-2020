package das.shapes;

import java.awt.geom.Point2D;

import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * This class models a RegularPolygon. It can perform common calculations
 * as well as drawing a representation of the polygon to a Processing PApplet.
 * 
 * @author Pallavi Das
 * @version 10/22/19
 */
public class RegularPolygon extends Shape{

	private double n;
	private double sideLength;
	private ArrayList<Circle> vertices;
	
	/**
	 * Creates a default instance of a RegularPolygon object with all dimensions set to zero
	 */
	public RegularPolygon() {
		super(0,0);
		this.n =3;
		this.sideLength=100;
		vertices = new ArrayList<Circle>();
	}
	
	/** 
	 * Creates a new instance of a RegularPolygon with the center of the polygon
	 * at (x,y). The polygon has equal side lengths with n number of sides.
	 * 
	 * @param x x-coordinate of the center of the polygon
	 * @param y y-coordinate of the center of the polygon
	 * @param numSides number of sides of the polygon
	 * @param sideLength length of each side of the polygon
	 */
	public RegularPolygon(double x, double y, int numSides, double sideLength) {
		super(x, y);
		this.n = numSides;
		this.sideLength=sideLength;
		vertices = new ArrayList<Circle>();
		
		  float angleRad = (float) ((2*Math.PI) / n);
		  //Taken from the RegularPolygon class example
		  for (float i = 0; i < (float)((2*Math.PI)); i += angleRad) {
			  float xVert = (float) (getX() + Math.cos(i) * calcR());
			  float yVert = (float) (getY() + Math.sin(i) * calcR());
			  vertices.add(new Circle(xVert, yVert, 2));
		  }
			
	}
	
	/**
	 * Calculates and returns the value of one of the interior vertex angles of the polygon.
	 * All vertex angles are the same.
	 * 
	 * @return one of the interior vertex angles of the certain polygon
	 */
	public double calcVertexAngle() {
		double theta = (((this.n)-2)/(this.n))*180;
		return theta;
	}
	
	/** 
	 * Calculates and returns the perimeter of the polygon
	 * 
	 * @return the perimeter of the polygon
	 */
	public double calcPerimeter() {
		double perimeter = n*sideLength;
		return perimeter;
	}
	
	/**
	 * Calculates and returns the value of the radius of the inscribed circle of the polygon.
	 * The inscribed circle is the circle that can be drawn inside of the regular polygon
	 * such that it is tangent to every side of the polygon.
	 * 
	 * @return the radius of the inscribed circle of the polygon
	 */
	public double calcr() {
		double r = 0.5*sideLength*(1/Math.tan(Math.PI/n));
		return r;
	}
	
	/**
	 * Calculates and returns the radius of the circumscribed circle of the polygon.
	 * The circumscribed circle is the circle that intersects each vertex of the polygon.
	 * 
	 * @return the radius of the circumscribed circle of the polygon
	 */
	public double calcR() {
		double R = 0.5*sideLength*(1/Math.sin(Math.PI/n));
		return R;
	}
	
	/** 
	 * Calculates and returns the area of the polygon
	 * 
	 * @return the area of the polygon
	 */
	public double calcArea() {
		double area = 0.5*n*(Math.pow(calcR(), 2))*Math.sin((2*Math.PI)/n);
		return area;
	}
	
	/**
	 * Returns the number of sides the polygon has
	 * 
	 * @return the number of sides of the polygon
	 */
	public double getNumSides() {
		return n;
	}
	
	/**
	 * Returns the length of the side the polygon
	 * 
	 * @return the value of the side length of the polygon
	 */
	public double getSideLength() {
		return sideLength;
	}
	
	/** 
	 * Draws a new instance of a RegularPolygon object with (x,y) as the center of the polygon
	 * // The number of sides determines what type of polygon it is and how many sides it has
	 * // The side length helps draw the side of each side of the polygon
	 * // The polygon is drawn using lines that have points at the calculated vertices, given the angle, side, and center
	 *     
	 * @param drawer the PApplet to be used to draw the polygon
	 * @pre drawer must not be null, and appropriate settings should have been selected (color, fill, etc)
	 * @post the drawer will have its polygon drawn using lines connected from both of their vertices
	 */
	public void draw(PApplet drawer) {
		drawBoundingCircles(drawer);
		
		for(int i = 0; i<vertices.size(); i++) {
			Circle vert1 = vertices.get(i);
			Circle vert2;
			
			if(!((i+1)>=vertices.size())) {
				vert2 = vertices.get((i+1));
			}
			else { //for last line that'll be drawn
				vert2 = vertices.get(0);
			}
			Line l = new Line(vert1.getX(), (float)vert1.getY(), (float)vert2.getX(), (float)vert2.getY());
			l.draw(drawer);
		}
	}
	
	/** 
	 * Draws the inscribed and circumscribed circles of the polygon
	 *     
	 * @param drawer the PApplet to be used to draw the circles
	 * @pre drawer must not be null, and appropriate settings should have been selected (color, fill, etc)
	 * @post the drawer will have its circle mode modified to PApplet.CENTER 
	 */
	public void drawBoundingCircles(PApplet drawer) {
		//inner circle
		Circle inner = new Circle((float)this.getX(), (float)this.getY(), (float)calcr());
		Circle outer = new Circle((float)this.getX(), (float)this.getY(), (float)calcR());
		Circle center = new Circle((float)this.getX(), (float)this.getY(), 2);
		inner.draw(drawer);
		outer.draw(drawer);
		center.draw(drawer);
	}


	public double getWidth() {
		return calcr()*2;
	}

	
	public double getHeight() {
		return calcr()*2;
	}


	public Double getCenter() {
		return new Point2D.Double(getX(), getY());
	}

/**
 * doesn't work/ not coded
 */
	public boolean isPointInside(double x, double y) {
		return false;
	}
	
}
