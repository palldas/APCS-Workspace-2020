package info.gridworld.actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color; 

/**
 * This represents a Jumper that moves 2 spaces, turns, and jumps over rocks and flowers
 * @author Pallavi Das
 * @version 11/7/19
 *
 */
public class Jumper extends Actor{

	/**
	 * Constructs a default green jumper
	 */
	public Jumper(){
		setColor(Color.GREEN);
	}

	/**
	 *  Constructs a Jumper of a given color.
	 *  @param JumperColor the color for this Jumper
	 */
	public Jumper(Color JumperColor){
		setColor(JumperColor);
	}


	public void act()
	{
		if (canJump())
			jump();
		else
			turn();
	}

	/**
	 * Turns the Jumper 45 degrees to the right
	 * //location is not changed
	 */
	public void turn() {
		setDirection(getDirection() + Location.HALF_RIGHT);
	}

	/**
	 * Moves the Jumper forward two spaces
	 * location two in front must be valid or Jumper will remove itself from grid
	 */
	public void jump() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Location next2 = next.getAdjacentLocation(getDirection());
		if (gr.isValid(next2))
			moveTo(next2);
		else
			removeSelfFromGrid();
		//	        Flower flower = new Flower(getColor());
		//	        flower.putSelfInGrid(gr, loc);
	}

	/** Tests whether Jumper can move forward two spaces if front space is empty or contains a flower.
	 * 	The location one in front must be empty or contain a Rock or a Flower
	 * 	@return true if  Jumper can move
	 */ 
	public boolean canJump() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Location next2 = next.getAdjacentLocation(getDirection());
		if (!gr.isValid(next2))
			return false;
		Actor neighbor = gr.get(next2);
		return (neighbor == null) || (neighbor instanceof Flower);
		// ok to move into empty location or onto flower
		// not ok to move onto any other actor
	}
}
