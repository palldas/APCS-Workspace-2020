package rborah.classes;

import java.util.ArrayList;

import das.shapes.Line;
import das.shapes.Shape;
import processing.core.PApplet;
import rborah.running.DrawingSurface;

public class PhysicsShape {
	private Shape shape;
	private double vX, vY;
	
	public PhysicsShape(Shape s) {
		this.shape = s;
		this.vX = 0;
		this.vY = 0;
	}
	
	public PhysicsShape act(DrawingSurface pap) {
		this.vY += 1;
		double[] x2y2 = this.bounce(pap);
		shape.move(x2y2[0], x2y2[1]);
		return this;
	}
	
	public Shape getShape() {
		return shape;
	}
	
	public double[] bounce(DrawingSurface pap) {
		double x1 = shape.getX();
		double y1 = shape.getY();
		double x2 = shape.getX() + vX;
		double y2 = shape.getY() + vY;
		Line path = new Line(x1,y1,x2,y2);
		ArrayList<Line> edges = pap.getEdges();
		for (Line ed : edges) {
			if (path.intersects(ed)) {
				/**double cx2 = ed.getX()+(ed.getCenter().getX()-ed.getX())*2;
				double cy2 = ed.getY() + (ed.getCenter().getY() - ed.getY())*2;
				x2=shape.getX()-ed.getX()+cx2;
				y2 = shape.getY()-ed.getY()+cy2;*/
				vX = -1*vX*Math.random()*Math.abs(vX)/vX;
				vY = -1*vY*Math.random()*Math.abs(vY)/vY;
				x2 = shape.getX() - vX/**(Math.abs(vX)/vX)*/;
				y2 = shape.getY() - vY/**(Math.abs(vY)/vY)*/;
			}
		}
		return new double[] {x2, y2};
	}

	public PhysicsShape draw(PApplet pap) {
		try {
			shape.primeProp(pap);
		} catch (Exception e) {
			
		}
		shape.draw(pap);
		return this;
	}
	
	public PhysicsShape setLocation(double x, double y) {
		shape.move(x, y);
		vY = 0;
		vX = 0;
		return this;
	}
	public PhysicsShape setVelocity(double x, double y) {
		vX = x;
		vY = y;
		return this;
	}
}
