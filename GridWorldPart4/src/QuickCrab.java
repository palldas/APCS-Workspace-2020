import info.gridworld.critters.CrabCritter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;


public class QuickCrab extends CrabCritter{

	public QuickCrab(){
		setColor(Color.CYAN);
	} 

	public ArrayList<Location> getMoveLocations(){
		ArrayList<Location> locations = new ArrayList<Location>();
		Grid grid = getGrid();

		findEmptyTwoAway(locations,getDirection() + Location.LEFT);
		findEmptyTwoAway(locations,getDirection() + Location.RIGHT);

		if (locations.size() == 0)
			return super.getMoveLocations();

		return locations;
	}

	private void findEmptyTwoAway(ArrayList<Location> locs,int direction){
		Grid g = getGrid();
		Location loc = getLocation();

		Location temp = loc.getAdjacentLocation(direction);

		if(g.isValid(temp) && g.get(temp) == null){
			Location loc2 = temp.getAdjacentLocation(direction);
			if(g.isValid(loc2) && g.get(loc2)== null)
				locs.add(loc2);
		}
	}
}