/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A <code>CustomBug</code> is an actor that can move and turn. It drops flowers as
 * it moves. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class CustomBug extends Bug
{
	private Color CustomBugColor;
    /**
     * Constructs a red CustomBug.
     */
    public CustomBug()
    {
    	CustomBugColor = Color.RED;
        setColor(CustomBugColor);
        
    }

    /**
     * Constructs a CustomBug of a given color.
     * @param CustomBugColor the color for this CustomBug
     */
    public CustomBug(Color CustomBugColor)
    {
    	this.CustomBugColor= CustomBugColor;
        setColor(CustomBugColor);
    }
    
    /**
     * Moves if it can move, turns otherwise.
     */
    
    public void setNewColor(Color CustomBugColor) {
    	this.CustomBugColor = CustomBugColor;
    	setColor(CustomBugColor);
    }
    
    public void act()
    {
    	
    	
    	//if(num%2 == 0) {
    	
    	
    		if (canMove()) {
    			move();
    		}
    		else {
    			setColor(Color.GREEN);
    			turn();
    			move();
    			removeSelfFromGrid();
    			
    		}
    	//}
    	//num++;
    }

    /**
     * Turns the CustomBug 45 degrees to the right without changing its location.
     */
//    public void turn()
//    {
//        setDirection(getDirection() + Location.HALF_RIGHT);
//    }
    
  public void turn()
  {
      setDirection(getDirection() + Location.RIGHT);
  }

    /**
     * Moves the CustomBug forward, putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }

    /**
     * Tests whether this CustomBug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this CustomBug can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
}
