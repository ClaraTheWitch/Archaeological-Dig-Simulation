// Class: DummyArchSimulation
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

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.util.RandNumGenerator;
import java.util.ArrayList;
import java.awt.Color;

/**
 *  Archaeological Dig:<br>
 *
 *  The <code>DummyArchSimulation</code> object controls the
 *  simulation of digging around artifacts in an archaeological dig.
 *
 *  @author Alyce Brady and Clara Siefke with assistance from Jackson 
 *          Kiino-Terburg
 *  @version June 04, 2024
 **/
public class DummyArchSimulation implements ArchSimulation
    {
    // initializes a random number generator
    RandNumGenerator random = RandNumGenerator.getInstance();
    
    
    
    // declares an array artifact blocks
    ArtifactBlock[] artifacts;
    
    // ArrayList for artifact counter blocks
    ArrayList<ArtifactCounterBlock> counterBlocks = new 
    ArrayList<ArtifactCounterBlock>();
    
    // declares a variable to be used to keep track of the number of clicked counter blocks
    int visibleCounters;
    
    // declares variable to store the number of artifacts (from 5 to 10% of the board)
    int numArtifacts;
    
    // declares variable to keep track of how many artifacts have been added
    int numArtAdded;
    
    /** Starts or restarts the application. **/
    public void startSimulation(Grid grid)
        {
        // clears the grid at the start of each simulation
        grid.removeAll();
        
        // creates and adds all the artifacts
        generateArtifacts(grid);
        
        
        // creates and adds all the counter blocks
        generateCounters(grid);
        
        
        
        
        }

    /** Handles a mouse click on a location of the grid.
     * @param  loc  the location that has been clicked on
     **/
    public void dig(Location loc)
        {
        // checks if the clicked location matches the location of any artifacts
        for(int i = 0; i < artifacts.length; i++)
            {
            if(loc.equals(artifacts[i].location()))
                {
                artifacts[i].makeVisible(); // makes the block visible
                }
            }
        
        // checks if the clicked location matches the location of any counter blocks
        for(int i = 0; i < counterBlocks.size(); i++)
            {
            if(loc.equals(counterBlocks.get(i).location()))
                {
                counterBlocks.get(i).makeVisible(); // makes the block visible
                }
            }
        
        }
        
    

    /** Returns true if the simulation is over; otherwise, returns false. 
     * @return  a boolean representing whether the simulation is over
     **/
    public boolean simulationOver()
    {
        // checks if any artifacts are visible. returns true if so
        for(int i = 0; i < artifacts.length; i++)
            {
            if(artifacts[i].isVisible() == true)
                {
                return true;
                }
            }
        
        // initializes the variable for counting visible counter blocks
        visibleCounters = 0;
        
        // increases the variable by 1 for every visible counter block
        for(int i = 0; i < counterBlocks.size(); i++)
            {
            if(counterBlocks.get(i).isVisible() == true)
                {
                visibleCounters++;
                }
            }
        
        // checks if all counter blocks are visible. returns true if so. false otherwise
        if(visibleCounters == counterBlocks.size())
            {
            return true;
            }
        else
            {
            return false;
            }
        
        
    }
    
    

    /** Returns true if the simulation is over and the user successfully
     *  identified all artifact locations without damaging any;
     *  false otherwise.
     **/
    public boolean digSuccessful()
    {
        
        // checks if any artifacts are visible. returns false if so
        for(int i = 0; i < artifacts.length; i++)
            {
            if(artifacts[i].isVisible() == true)
                {
                return false;
                }
            }
        
        // initializes the variable for counting visible counter blocks
        visibleCounters = 0;
        
        // increases the variable by 1 for every visible counter block
        for(int i = 0; i < counterBlocks.size(); i++)
            {
            if(counterBlocks.get(i).isVisible() == true)
                {
                visibleCounters++;
                }
            }
        
        // checks if all counter blocks are visible. returns true if so. false otherwise
        if(visibleCounters == counterBlocks.size())
            {
            return true;
            }
        else
            {
            return false;
            }
        
        
    }
    
    /** Generates and adds a random number of artifacts between 5 and 10% of the grid
     * 
     */
    private void generateArtifacts(Grid grid)
        {
        // initializes variable to store the number of artifacts (from 5 to 10% of the board)
        numArtifacts = 5 + random.nextInt((
                       (grid.numRows() * grid.numCols())/10) - 5);
        
        // array to store each artifact
        artifacts = new ArtifactBlock[numArtifacts];
        
        numArtAdded = 0; // initializes variable for the while loop to keep track of how many artifacts have been added
        
        // while loop to generate artifacts in unique locations
        while(numArtAdded < numArtifacts)
            {
            Location loc = new Location(
                                        random.nextInt(grid.numRows()), 
                                        random.nextInt(grid.numCols())
                                       ); // creates a location
            
            // if statement checks if that location is taken
            if(grid.isEmpty(loc) == true)
                {
                artifacts[numArtAdded] = new ArtifactBlock(grid, loc); // adds artifact
                
                numArtAdded++; // increments by 1
                }
            
            
            }
        }
    
    /** Fills the non empty spaces the grid with bomb counter blocks
     * 
     */
    private void generateCounters(Grid grid)
        {
        // for loop that traverses the grid to add artifact counter blocks
        for(int row = 0; row < grid.numRows(); row++)
            {
            for(int col = 0; col < grid.numCols(); col++)
                {
                // checks if the generated locaton is empty
                if(grid.isEmpty(new Location(row, col)) == true)
                    {
                    int numArtNbrs = 0; // initializes variable to hold the number of artifacts touching the square
                    ArrayList<Location> nbrs = 
                    grid.neighborsOf(new Location(row, col)); // initializes a list of neighbors
                    // checks each neighbor if it's an artifact
                    for(int i = 0; i < nbrs.size(); i++)
                        {
                        if(grid.objectAt(nbrs.get(i)) instanceof ArtifactBlock)
                            {
                            numArtNbrs++; // increases for each artifact the square touches
                            }
                        }
                    
                    // determines whether to lable with a number or a dash
                    if(numArtNbrs > 0)
                        {
                        // converts the number of artifact neighbors to a string
                        String numArtNbrsString = "" + numArtNbrs;
                    
                        // creates a new artifact counter block in the grid
                        counterBlocks.add(new ArtifactCounterBlock(grid, 
                        new Location(row, col), numArtNbrsString));
                        }
                    else
                        {
                        // creates a new artifact counter block in the grid
                        counterBlocks.add(new ArtifactCounterBlock(grid, 
                        new Location(row, col), "-", Color.WHITE));
                        }
                    
                    
                    }
                
                
                }
            }
        }

    }
