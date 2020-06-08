import info.gridworld.actor.Actor;
import info.gridworld.critters.ChameleonCritter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;


public class ChameleonKid extends ChameleonCritter{

	public ArrayList<Actor> getActors(){
		ArrayList<Actor> actors = new ArrayList<Actor>();
		int[] loc = {Location.AHEAD, Location.HALF_CIRCLE};
		for (Location i : getNeighborLoctionInDirection(loc)){
			Actor a = getGrid().get(i);
			if (a != null) {
				actors.add(a);
			}
		}
		return actors;
	} 

	public ArrayList<Location> getNeighborLoctionInDirection(int[] directions){
		ArrayList<Location> locations = new ArrayList<Location>();
		Grid grid = getGrid();
		Location currLoc = getLocation();

		for (int d : directions){
			Location neighborLoc = currLoc.getAdjacentLocation(getDirection() + d);
			if (grid.isValid(neighborLoc))
				locations.add(neighborLoc);
		}
		return locations;
	}
}