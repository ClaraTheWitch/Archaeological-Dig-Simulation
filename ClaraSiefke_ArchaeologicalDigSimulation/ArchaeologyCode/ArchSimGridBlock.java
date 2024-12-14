// Class: ArchSimGridBlock
//
// Author: Alyce Brady
//
// Created on May 18, 2004
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

import java.awt.Color;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.TextCell;

/**
 *  Archaeological Dig:<br>
 *
 *  An <code>ArchSimGridBlock</code> object represents a grid block
 *  in a site map for an archaeological dig.  The contents of the grid
 *  block may be hidden, in which case the grid display should not
 *  show them, or may be visible.
 *
 *  @author Alyce Brady and Clara Siefke
 *  @version June 04, 2024
 **/
public class ArchSimGridBlock extends TextCell
{
  // instance variables encapsulated for EACH grid block
    private boolean visibleStatus; // is false if invisible. true if visible

    /** Initializes a new ArchSimGridBlock object.
     *    @param grid    the grid in which to place this grid block
     *    @param loc     the location of the new object in <code>grid</code>
     *    @param textLabel  a one- or two-character label for this object
     *    @param color      the color to use when drawing the object
     */
    public ArchSimGridBlock(Grid grid, Location loc,
                             String textLabel, Color color)
        {
        super(textLabel, color, grid, loc);
        this.visibleStatus = false;
        
        }

    /** Returns true if what is in this grid block is now visible
     *  (meaning that archaeologists have explored this site location);
     *  otherwise, returns false.
     *  @return  a boolean telling whether the object is visible
     **/
    public boolean isVisible()
        {
        if(visibleStatus == true)
            {
            return true;
            }
        else
            {
            return false;
            }
        
        }

    /** Return true if what is in this grid block is still hidden;
     *  otherwise, returns false.
     *  @return  a boolean telling whether the object is hidden
     **/
    public boolean isHidden()
        {
        if(visibleStatus == false)
            {
            return true;
            }
        else
            {
            return false;
            }
        }

    @Override
    public String toString()
        {
        return location().toString();
        }
    
    
    /** Makes the object visible
     * 
     */
    public void makeVisible()
        {
        visibleStatus = true;
        }
        
    

}
