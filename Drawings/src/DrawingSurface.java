import processing.core.PApplet;
import processing.event.MouseEvent;

/*
 * + Dividing interactions into separate methods
 * + Fully functional
 * + Windows class is cool for other windows, but unnecessary
 * - Not enough method comments
 * - movePerson and moveHouse methods are complicated
 * delta - add method headers
 * delta - you might want to consider eliminating the print line statements after you have tested fully
 */

public class DrawingSurface extends PApplet {
	
	private House house;
	private Person person;

	public DrawingSurface() {
		this.house = new House();
		this.person = new Person();
	}
	
	public void draw() {
		this.background(255); //background white
		
		float xRatio = width/400.0f;
		float yRatio = height/300.0f;
		this.scale(xRatio, yRatio);
		
		this.house.draw(this); //draws on DrawingSurface
		this.person.draw(this);	
	}
	
	public void mousePressed() {
		this.house.moveHouse( (this.mouseX/(this.width/400.0f)), (this.mouseY /(this.height/300.0f)) ); 
		//takes mousePos and divides by x and y ratio
	}
	
	public void mouseWheel(MouseEvent event) {
		float e = event.getCount(); //gets count of mouseScroll
		System.out.println(e);
		this.person.scalePerson(e/10); //becomes 0.1 smaller so can be added to scale	
	}
	
	public void keyPressed() {
 		if(this.keyCode == UP) {
 			this.house.scaleHouse(0.1f); //scales up (scale+= 0.1)
 		}
 		else if(this.keyCode == DOWN) {
 			this.house.scaleHouse(-0.1f); //scales down (scale-=0.1)
 		}
 		else if(this.keyCode == RIGHT) {
 			this.person.movePerson(5, 0); 
 			System.out.println("moved right");
 		}
 		else if(this.keyCode == LEFT) {
 			this.person.movePerson(-5,  0);
 			System.out.println("moved left");
 		}	
 		
 	}
	
}