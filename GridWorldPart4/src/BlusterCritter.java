import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;


public class BlusterCritter extends Critter{
	private int courage;

	public BlusterCritter(int c){
		super();
		courage = c;
	}

	public ArrayList<Actor> getActors(){
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Location location = getLocation();
		for(int r = location.getRow() - 2; r <= location.getRow() + 2; r++) {
			for(int c = location.getCol() - 2; c <= location.getCol() + 2; c++){
				Location temporaryLoc = new Location(r,c);
				if(getGrid().isValid(temporaryLoc)){
					Actor a = getGrid().get(temporaryLoc);
					if(a != this && a != null)
						actors.add(a);
				}
			}
		}
		return actors;
	}

	public void processActors(ArrayList<Actor> actors){
		int count = 0;
		for(Actor a: actors)
			if(a instanceof Critter)
				count++;
		if(count < courage)
			lightenCritter();
		else
			darkenCritter();
	} 

	private void darkenCritter(){
		Color c = getColor();
		int red = c.getRed();
		int green = c.getGreen();
		int blue = c.getBlue();
		if(red > 0) 
			red--;
		if(green > 0) 
			green--;
		if(blue > 0) 
			blue--;
		setColor(new Color(red, green, blue));
	} 

	private void lightenCritter(){
		Color c = getColor();
		int red = c.getRed();
		int green = c.getGreen();
		int blue = c.getBlue();
		if(red < 255) 
			red++;
		if(green < 255) 
			green++;
		if(blue < 255) 
			blue++;
		setColor(new Color(red, green, blue));
	}
} 