package das.illusions;
import java.awt.geom.Point2D;


import das.shapes.*;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	private int xCenter, yCenter;
	public DrawingSurface() {
		xCenter = 200;
		yCenter = 150;		
	}

	public void setup() {

	}
	
	public void draw() {
		fill(255);
		new Rectangle(100, 50, 200, 200).draw(this);
		for(int i=16; i>=1; i--) {
			new Circle(xCenter, yCenter, 8*i).draw(this);
		}	
	}
}
	











