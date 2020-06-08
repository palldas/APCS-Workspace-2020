package das.two;

import java.awt.Color;

import das.shapes.*;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	private int xCenter, yCenter;
	private double lineLength;
	private double x2, y2;
	public DrawingSurface() {
		xCenter = 200;
		yCenter = 150;		
	}

	public void setup() { 

	}
	
	public void draw() {
		background(255);
		lineLength = 120;
		for(int i=0; i<40; i++) {
			x2 = lineLength*Math.cos(9*i);
			y2 =lineLength*Math.sin(9*i);
			Line spoke = new Line(xCenter, yCenter, (xCenter+x2), (yCenter+y2));
			spoke.setStrokeWidth(2);
			spoke.setStrokeColor(Color.BLACK);
			spoke.primeProp(this);
			spoke.draw(this);
		}
		for(int j =1; j<=6; j++) {
			Line vert = new Line(60+(40*j),30,60+(40*j),270);
			vert.setStrokeWidth(4);
			vert.setStrokeColor(Color.RED);
			vert.primeProp(this);
			vert.draw(this);
		}		
	}
}
	











