package das.shapedemo;


import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
import shirali.shapes.*;


public class DrawingSurface extends PApplet {

	private ArrayList<PhysicsShape> shape;
	
	private Line shooter;
	private Rectangle screen;
	private int count;
	
	public DrawingSurface() {
		shooter = new Line(this.width/2,300, 200, this.mouseY, Color.BLACK);
		shape = new ArrayList<PhysicsShape>();
		screen = new Rectangle(0,0,300,300,Color.GREEN);
		count = 0;
	}

	public void setup() { 

	}
	
	public void draw() {
		background(255); 
		
		
		// DRAWINGS
		screen = new Rectangle(0,0,this.width,this.height,Color.GREEN);
		//screen = new Rectangle(0,0,width,height,Color.GREEN);
		screen.draw(this);
		//shooter = new Line(200,300, this.mouseX, 200, Color.BLACK);
		shooter = new Line(this.width/2,this.height, this.mouseX, this.height-75, Color.BLACK);
		shooter.draw(this);
		screen = new Rectangle(0,0,this.width-100,this.height-50,Color.GREEN);
		
		for(int i =0; i<shape.size(); i++) {
			PhysicsShape s = shape.get(i);
			s.draw(this);
					
		}
		
		// MOVING / INTERACTING / CHANGING
		for(int i =0; i<shape.size(); i++) {
			PhysicsShape s = shape.get(i);
			
			s.act();
			//s.shoot();
			s.inside(screen);
//			for(int j =0; j<shape.size(); j++) {
//				mouseClicked(s);
//				mouseReleased(s);
//			}
		}	
	}
	
	public void mousePressed() {
		shape.add(new PhysicsShape(new Rectangle(mouseX, mouseY, 50, 50, Color.BLACK)));
		
	}
	
	
	public void mouseClicked(PhysicsShape s) {
		s.setLocation(mouseX, mouseY);
		
		s.setVelocity(mouseX-pmouseX, mouseY-pmouseY);
	}
	
	public void mouseReleased(PhysicsShape s) {
		s.act();
	}

}
	











