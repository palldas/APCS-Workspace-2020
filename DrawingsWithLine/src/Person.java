import processing.core.PApplet;

/*
 * My extra goal was scaling the person, but I took that out because it was too 
 * difficult for the line intersect
*/



public class Person {
	
 	private float xCenter;
	private float yCenter;
 	private float scale;
 	
 	private Line shield;
 	
 	public Person() {
 		this.xCenter = 40;
 		this.yCenter = 175;
 		this.scale = 1;
 		
 	}
 	
 	public void draw (PApplet surface) {
 		
		surface.pushMatrix(); //saves current person coordinate system
		
 		surface.translate(this.xCenter, this.yCenter); //makes the center
 		surface.scale(this.scale, this.scale); //sets normal scale (100%)
 		surface.translate(-40, -175); //translates back to (0,0)
 		surface.fill(255);
 		
 		surface.ellipse(50, 135, 35, 35); // head
 		surface.line(50, 152.5f, 50, 200);  //body
 		surface.line(35, 175, 65, 175); // arms
 		
 		surface.stroke(255,0,255);
 		shield = new Line(65, 175, surface.mouseX/this.scale, surface.mouseY/this.scale); //shield
 		
 		shield.draw(surface);
 		surface.stroke(0);
 		surface.line(50, 200, 35, 215); // legs
 		surface.line(50, 200, 65, 215);
 		
 		surface.popMatrix(); //restores normal coordinate system
 	}
 	
 	//scales person when called
 	//whenever parameter(0.1)is given, it's added to scale to enlarge it
 	
 	public Line getShield() {
 		return shield;
 	}
 	
 	public void scalePerson(float factor) { 
 		if(this.scale >=0.1) 
 			//makes sure doesn't scale when scale below 0.1, otherwise person reflects
 			this.scale += factor;
 		else 
 			this.scale = 0.1f;
 	}
 	
 	//moves person when called
 	//whenever parameter (x) is given, will add to the center and replace center with that value to be new coordinates
 	public void movePerson(float newX, float newY) { 
 		this.xCenter += newX; 
 		this.yCenter += newY;
	}
 	
 	//public void detectCollision()
 	
}