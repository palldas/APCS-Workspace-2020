import processing.core.PApplet;

import java.lang.Math;

import processing.event.MouseEvent;

/*
 * 
 * 
 * + the style is good
 * + i like the idea
 * 
 * - the shield isn't matching up with the mouse
 * - the arrows aren't disappearing 
 * 
 * delta instead of stopping the arrows you can make them not visible
 * delta try multiplying the x and y of the shield by 2
 * 
 * 
 */

public class DrawingSurface extends PApplet {

	private House house;
	private Person person;
	private Line arrow;
	private boolean spacePressed;
	int y;
	int x1;
	int x2;

	private boolean intersect;

	public DrawingSurface() {
		this.house = new House();
		this.person = new Person();
		this.spacePressed = false;
		this.intersect = false;
		this.x1 = 370;
		this.x2 = 400;

	}

	public void draw() {
		this.background(255); // background white

		float xRatio = width / 400.0f;
		float yRatio = height / 300.0f;
		this.scale(xRatio, yRatio);

		this.house.draw(this); // draws on DrawingSurface
		this.person.draw(this);

		if (spacePressed) {
			this.arrow = new Line(this.x1, this.y, this.x2, this.y);

			this.intersect = this.arrow.intersects(this.person.getShield());

			if (this.intersect) {
				fill(0);
				textSize(30);
				textAlign(CENTER);
				text("deflected", this.width / 2, 50);
			}

			else if (!this.intersect && this.x2 >= 5) {
				this.arrow.draw(this);
				this.x1 -= 5;
				this.x2 -= 5;
			}
		}

		fill(0);
		textSize(10);
		textAlign(CORNER);
		text("Interactions: Arrow Keys, Mouse Clicks, Mouse Moved, Space Key", 10, 10);
	}

	public void mouseDragged() {
		this.house.moveHouse((this.mouseX / (this.width / 400.0f)), (this.mouseY / (this.height / 300.0f)));
		// takes mousePos and divides by x and y ratio
	}

	public void mouseWheel(MouseEvent event) {
		float e = event.getCount(); // gets count of mouseScroll
		this.person.scalePerson(e / 10); // becomes 0.1 smaller so can be added to scale
	}

	public void keyPressed() {
		if (this.keyCode == UP) {
			this.house.scaleHouse(0.1f); // scales up (scale+= 0.1)
		} else if (this.keyCode == DOWN) {
			this.house.scaleHouse(-0.1f); // scales down (scale-=0.1)
		} else if (this.keyCode == RIGHT) {
			this.person.movePerson(5, 0);
		} else if (this.keyCode == LEFT) {
			this.person.movePerson(-5, 0);
		} else if (this.keyCode == ' ') {
			System.out.println("space pressed");
			y = (int) (Math.random() * 300) + 10;
			this.spacePressed = true;

			if (this.x1 == -30) {
				this.x1 = 370;
				this.x2 = 400;
			}
		}

	}

}