//Class: ArchSimulation
//
//Author: Alyce Brady
//
//Created on May 18, 2004
//
//License Information:
//This class is free software; you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation.
//
//This class is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;

/**
 *  Archaeological Dig:<br>
 *
 *  An <code>ArchSimulation</code> object controls the simulation
 *  of digging around artifacts in an archaeological dig.
 *
 *  @author Alyce Brady
 *  @version June 04, 2024
 **/
public interface ArchSimulation
{
    /** Starts or restarts the application. **/
    public abstract void startSimulation(Grid grid);

    /** Handles a mouse click on a location of the grid.
     **/
    public void dig(Location loc);

    /** Returns true if the simulation is over; otherwise, returns false. **/
    public abstract boolean simulationOver();
    
    

    /** Returns true if the simulation is over and the user successfully
     *  identified all artifact locations without damaging any;
     *  false otherwise.
     **/
    public abstract boolean digSuccessful();
}
