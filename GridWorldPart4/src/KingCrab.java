import info.gridworld.actor.Actor;
import info.gridworld.critters.CrabCritter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter{

	public KingCrab(){
		setColor(Color.GREEN);
	}

	public int distanceFrom(Location loc1, Location loc2){
		int x1 = loc1.getRow();
		int y1 = loc1.getCol();
		int x2 = loc2.getRow();
		int y2 = loc2.getCol();
		double distance = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)) + .5;
		return (int)Math.floor(distance);
	}

	private boolean moveOneAway(Actor a){
		ArrayList<Location> locations = getGrid().getEmptyAdjacentLocations(a.getLocation());

		for(Location loc : locations){
			if(distanceFrom(getLocation(), loc) > 1){
				a.moveTo(loc);
				return true;
			}
		}
		return false;
	}

	public void processActors(ArrayList<Actor> actors){
		for (Actor a : actors){
			if (!moveOneAway(a))
				a.removeSelfFromGrid();	
		}
	}
}