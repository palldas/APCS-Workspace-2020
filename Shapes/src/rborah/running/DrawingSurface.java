package rborah.running;



import java.awt.Color;
import java.util.ArrayList;

import das.shapes.Circle;
import das.shapes.Line;
import das.shapes.Rectangle;
import das.shapes.Shape;
import processing.core.PApplet;
import processing.event.MouseEvent;
import rborah.classes.PhysicsShape;



public class DrawingSurface extends PApplet {

	private ArrayList<PhysicsShape> ps;
	
	public DrawingSurface() {
		Rectangle r = new Rectangle(10, 10, 1, 1);
		ps = new ArrayList<PhysicsShape>();
		ps.add(new PhysicsShape(r));
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
	}
	
	public ArrayList<PhysicsShape> getShapes() {
		return new ArrayList<PhysicsShape>(ps);
	}
	
	public ArrayList<Line> getEdges() {
		ArrayList<Line> list = new ArrayList<Line>();
		list.add(new Line(0, 0, this.width, 0));
		list.add(new Line(0,0, 0, height));
		list.add(new Line(0, height, width, height));
		list.add(new Line(width, 0, width, height));
		return list;
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() {
		//r.setStrokeColor(new Color((int)(frameRate > 255 ? 255 :frameRate), (int)(frameRate > 255 ? 255 :frameRate), 0*(int)(frameRate > 255 ? 255 :frameRate)));
		background(255);
		
		for (PhysicsShape s : ps)
		{
			//draw
			s.draw(this);
			double x1 = s.getShape().getX();
			double y1 = s.getShape().getY();
			for (PhysicsShape z : ps) {
				if (z == s) continue;
				double x2 = z.getShape().getX();
				double y2 = z.getShape().getY();
				//(new Line(x1, y1, x2, y2)).draw(this);
			}
			//change
			s.act(this);
		}

		if (ps.size() > 30) {
			ps = new ArrayList<PhysicsShape>(ps.subList(0, 30));
		}
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
		super.mousePressed(event);
		double dmx = mouseX - pmouseX;
		double dmy = mouseY - pmouseY;
		if (Math.sqrt(dmx*dmx + dmy *dmy) > 30) {
			dmx = 30*Math.sin(Math.atan(dmy/dmx));
			dmy = 30*Math.cos(Math.atan(dmy/dmx));
		}
		for (PhysicsShape s : ps) {
			s.setLocation(mouseX, mouseY);
			s.setVelocity(dmx, dmy);
		}
		double repet = Math.random()*3;
		boolean rectorcirc = Math.random() > 0.5;
		Rectangle r1 =  new Rectangle(mouseX+Math.random()*5, mouseY+Math.random()*5, Math.random()*20, Math.random()*20);
		r1.setStrokeColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
		r1.setStrokeWidth(2);
		Circle c1 = new Circle(mouseX+Math.random()*5, mouseY+Math.random()*5, Math.random()*20);
		c1.setStrokeColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
		c1.setStrokeWidth(2);
		Shape shape = rectorcirc ? r1 : c1;
		for (int i = 0; i <= repet; i++) ps.add((new PhysicsShape(shape)).setVelocity((Math.random() - 0.5)*Math.random()*dmx, (Math.random() - 0.5)*Math.random()*dmy));
	}
	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		super.mousePressed(event);
		mouseDragged(event);
	}
	
}










