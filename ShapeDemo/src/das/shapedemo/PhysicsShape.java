package das.shapedemo;

import processing.core.PApplet;


import shirali.shapes.*;

public class PhysicsShape {
	private Shape s;
	private double vx, vy;
	
	public PhysicsShape(Shape s) {
		this.s = s;
		vx =0;
		vy =0;
	}
	
	public void act() {
		double x = s.getX();
		double y = s.getY();
		
		s.move(x + vx, y + vy);
		
		vy+=0.4;
		vx+=0.1;
	}
	
	public void inside(Rectangle screen) {
		
		if (!screen.isPointInside(this.getX(), this.getY()+50)) {
//			this.vy*= -0.5;
			this.vy = -vy;
			this.vx = -vx;
		}
		
	}
	
	public void shoot() {

		double x = s.getX();
		double y = s.getY();
		
		s.move(x-vx, y-vx);
	}
	
	public void draw(PApplet drawer) {
		s.draw(drawer);
	}
	
	public double getX() {
		return s.getX();
	}
	
	public double getY() {
		return s.getY();
	}
	
	
	public void setLocation(double x, double y) {
		s.move(x, y);
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	
}
