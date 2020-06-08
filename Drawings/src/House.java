import processing.core.PApplet;

public class House {
 
	private float xCenter;
	private float yCenter;
	private float scale;
	
	public House() {
 		this.xCenter = 200;
 		this.yCenter = 150;
 		this.scale = 1;
 	}
 		
 	public void draw(PApplet surface) {
		surface.pushMatrix(); //saves current house coordinate system
		
		surface.translate(this.xCenter, this.yCenter); // makes the center (200,150)
 		surface.scale(this.scale, this.scale); //sets normal scale (100%)
 		surface.translate(-200, -150); //translates back to (0,0)
 		surface.fill(255);
 		
 		surface.rect(100, 100, 200, 115); // house body
 		surface.triangle(100, 100, 300, 100, 200, 60); // roof
 		surface.rect(185, 160, 30, 55);  //door
 		surface.rect(125,120, 30, 30); // window
 		surface.rect(245, 120, 30, 30);
 		
		surface.popMatrix(); //restores normal coordinate system
 	}	
 	
 	//scales house when called
 	//whenever parameter(0.1)is given, it's added to scale to enlarge it
 	public void scaleHouse(float factor) {
 		if(this.scale >=0.1) 
 			//makes sure doesn't scale when scale below 0.1, otherwise house reflects
 			this.scale += factor;
 		else 
 			this.scale = 0.1f;
 		
 		System.out.println(this.scale);
 	}
 	
 	//moves house when called
	//whenever parameter is given, will add to the center and replace center with that value to be new coordinates
 	public void moveHouse(float newX, float newY) {
 		this.xCenter = newX;
 		this.yCenter = newY;
		System.out.println(this.xCenter+", "+ this.yCenter);
	}	
}