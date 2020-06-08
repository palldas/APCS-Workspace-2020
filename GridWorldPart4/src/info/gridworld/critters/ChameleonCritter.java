package info.gridworld.critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import java.awt.Color;
import java.util.ArrayList;

public class ChameleonCritter extends Critter{
	private static final double DARKEN = 0.05;

	public void processActors(ArrayList<Actor> actors){
		int n = actors.size();
		if (n == 0){
			darkenFlower();
			return;
		}

		int r = (int) (Math.random() * n);
		Actor random = actors.get(r);
		setColor(random.getColor());
	}

	private void darkenFlower(){
		Color c = getColor();
		int red = (int) (c.getRed() * (1 - DARKEN));
		int green = (int) (c.getGreen() * (1 - DARKEN));
		int blue = (int) (c.getBlue() * (1 - DARKEN));
		setColor(new Color(red, green, blue));
	}
}
