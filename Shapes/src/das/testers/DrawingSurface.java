package das.testers;

import das.shapes.*;
import processing.core.PApplet;



//javadoc -author -version -tag pre:cm:"Precondition:" -tag post:cm:"Postcondition:" -d doc -classpath ./lib/* -sourcepath ./src ./src/*    to scan everything
//javadoc -author -version -tag pre:cm:"Precondition:" -tag post:cm:"Postcondition:" -d doc -classpath ./lib/* -sourcepath ./src/ das.shapes   to scan a certain package
//jar cvf shapes.jar das/shapes      to make jar file

public class DrawingSurface extends PApplet{

	public void draw() {
		background(255);
//		new Rectangle(100, 50, 200, 200).draw(this);
//		for(int i=16; i>=1; i--) {
//			new Circle(250, 250, 8*i).draw(this);
//		}
		
		RegularPolygon poly = new RegularPolygon();
		RegularPolygon square = new RegularPolygon(200, 200, 4, 10);
		RegularPolygon octagon = new RegularPolygon(200, 200, 8, 5.75);
		RegularPolygon enneadecagon = new RegularPolygon(200, 200, 19, 2);
		RegularPolygon enneacontakaihenagon = new RegularPolygon(200, 200, 91, 0.5);
		
		RegularPolygon pentagon = new RegularPolygon(200, 200, 5, 100);
		pentagon.draw(this);
//		
//		square.draw(this);
//		octagon.draw(this);
//		enneadecagon.draw(this);
//		enneacontakaihenagon.draw(this);
		
		System.out.println(square.getNumSides());
		System.out.println(octagon.getNumSides());
		System.out.println(enneadecagon.getNumSides());
		System.out.println(enneacontakaihenagon.getNumSides());
		System.out.println();
		
		System.out.println(square.getSideLength());
		System.out.println(octagon.getSideLength());
		System.out.println(enneadecagon.getSideLength());
		System.out.println(enneacontakaihenagon.getSideLength());
		System.out.println();
		
		
		System.out.println(square.calcVertexAngle());
		System.out.println(octagon.calcVertexAngle());
		System.out.println(enneadecagon.calcVertexAngle());
		System.out.println(enneacontakaihenagon.calcVertexAngle());
		System.out.println();
		
		System.out.println(square.calcr());
		System.out.println(octagon.calcr());
		System.out.println(enneadecagon.calcr());
		System.out.println(enneacontakaihenagon.calcr());
		System.out.println();
		
		System.out.println(square.calcR());
		System.out.println(octagon.calcR());
		System.out.println(enneadecagon.calcR());
		System.out.println(enneacontakaihenagon.calcR());
		System.out.println();
		
		System.out.println(square.calcPerimeter());
		System.out.println(octagon.calcPerimeter());
		System.out.println(enneadecagon.calcPerimeter());
		System.out.println(enneacontakaihenagon.calcPerimeter());
		System.out.println();
		
		System.out.println(square.calcArea());
		System.out.println(octagon.calcArea());
		System.out.println(enneadecagon.calcArea());
		System.out.println(enneacontakaihenagon.calcArea());
		System.out.println();
		
	}

}
