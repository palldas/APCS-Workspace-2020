
import java.awt.*;
import java.util.*;

import processing.core.PImage;

public class Mario extends Sprite {

	public static final int MARIO_WIDTH = 40;
	public static final int MARIO_HEIGHT = 60;
	private double xVel;
	private double yVel;
	private boolean touching;
	private double friction;
	private double gravity;

	public Mario(PImage img, int x, int y) {
		super(img, x, y, MARIO_WIDTH, MARIO_HEIGHT);
		this.xVel = 0;
		this.yVel = 0;
		this.touching = false;
		this.gravity = 1;
		this.friction = 0.1;
	}

	// METHODS
	/**
	 * This method should, in some way, cause Mario to move left or right. A basic
	 * version might directly move Mario, while a more advanced version might try to
	 * accelerate him using Sprite velocities.
	 * 
	 * @param dir This will be a positive 1 to indicate walking to the right, or a
	 *            -1 to indicate left.
	 */
	public void walk(int dir) {

		if (this.xVel <= 5.0 && this.xVel >= -5.0) {
			this.accelerate(dir, 0);
			xVel += dir;
		}
		
	}

	/**
	 * This method should, in some way, cause Mario to move upward. A basic version
	 * might just directly move him up. A more advanced version would try to use
	 * velocities to give a jump that feels right, and to only allow jumping when
	 * Mario is touching the ground.
	 */
	public void jump() {

		if (this.touching) {
			this.yVel -= 15;
			this.accelerate(0, -15);
		}

	}

	/**
	 * This method should cause Mario to do everything he does whether keys are
	 * pressed or not. Though this could be lots of things, it should at least be: -
	 * Falling downward - Colliding with obstacles such as platforms
	 * 
	 * @param obstacles A list of obstacles in the window that Mario should not be
	 *                  able to intersect with.
	 */
	public void act(ArrayList<Shape> obstacles) {
		if(yVel + gravity < 15) {
			yVel += gravity;
			this.accelerate(0, gravity);
		}

		if (xVel >= 0.1) {
			xVel -= friction;
			this.accelerate(-friction, 0);
		} else if (xVel <= -0.1) {
			xVel += friction;
			this.accelerate(friction, 0);
		}
		
		//y += yVel;
		moveByVelocities();

		boolean onGround = false;
		for (Shape s : obstacles) {
			if (s.intersects(this)) {
				if (this.y < s.getBounds().getY()) {
					onGround = true;
					break;
				}
			}
		}
		if(onGround) {
			//y -= yVel;
			this.moveByAmount(0, -yVel);
			this.setVelocity(xVel, 0);
			yVel = 0;
			this.touching = true;
		} else {
			this.touching = false;
		}
		
	
	}

}
