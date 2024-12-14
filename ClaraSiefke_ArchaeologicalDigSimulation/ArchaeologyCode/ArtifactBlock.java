// Class: ArtifactBlock
//
// Author: Alyce Brady and Clara Siefke
//
// Created on May 28, 2024
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
 *  An <code>ArtifactBlock</code> object represents an artifact block
 *  in a site map for an archaeological dig.  The contents of the grid
 *  block may be hidden, in which case the grid display should not
 *  show them, or may be visible.
 *
 *  @author Alyce Brady and Clara Siefke
 *  @version May 31, 2024
 **/
public class ArtifactBlock extends ArchSimGridBlock
{
  // instance variables encapsulated for EACH grid block

    /** Initializes a new ArtifactBlock object.
     *    @param grid    the grid in which to place this grid block
     *    @param loc     the location of the new object in <code>grid</code>
     */
    public ArtifactBlock(Grid grid, Location loc)
    {
        super(grid, loc, "A", Color.RED);
        
    }
    
    /** Initializes a new ArtifactBlock object.
     *    @param grid    the grid in which to place this grid block
     *    @param loc     the location of the new object in <code>grid</code>
     *    @param textLabel  a one- or two-character label for this object
     *    @param color      the color to use when drawing the object
     */
    public ArtifactBlock(Grid grid, Location loc,
                             String textLabel, Color color)
    {
        super(grid, loc, textLabel, color);
    }

    @Override
    public String toString()
    {
        return location().toString();
    }
    
    

}
