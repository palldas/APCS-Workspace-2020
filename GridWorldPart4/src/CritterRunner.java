import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.critters.ChameleonCritter;
import info.gridworld.grid.Location;

import java.awt.Color;

public class CritterRunner{
	public static void main(String[] args){
		ActorWorld world = new ActorWorld();
		world.add(new Location(7, 8), new Rock());
		world.add(new Location(3, 3), new Rock());
		world.add(new Location(2, 8), new Flower(Color.BLUE));
		world.add(new Location(5, 5), new Flower(Color.PINK));
		world.add(new Location(1, 5), new Flower(Color.RED));
		world.add(new Location(7, 2), new Flower(Color.YELLOW));
		world.add(new Location(1, 1), new Bug(Color.RED));
//		world.add(new Location(5, 8), new Critter());
//		world.add(new Location(4, 8), new ChameleonCritter());
//		world.add(new Location(5, 4), new ChameleonKid());
//		world.add(new Location(3, 8), new RockHound());
//		world.add(new Location(5, 4), new BlusterCritter(3));
//		world.add(new Location(4, 2), new QuickCrab());
		world.add(new Location(7,3), new KingCrab());
		world.show();
	}
}