// Class: ArchSimGUI
//
// Author: Alyce Brady
//    Modified 21 May 2017 to add @Override
//
// Created on 18 May 2004
// Modified on 10 March 2005 to use latest version of grid.jar, including
//    InitializationButton
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

import javax.swing.JMenu;

import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.display.ScrollableGridDisplay;
import edu.kzoo.grid.gui.EnabledDisabledStates;
import edu.kzoo.grid.gui.GridAppFrame;
import edu.kzoo.grid.gui.nuggets.InitializationButton;
import edu.kzoo.grid.gui.nuggets.MinimalFileMenu;

/**
 *  Archaeological Dig:<br>
 *
 *  An <code>ArchSimGUI</code> object represents a window with
 *  control buttons and a display for an archaeological dig simulation.
 *  Most of the functionality is provided in the GridAppFrame
 *  superclass.
 *
 *  @author Alyce Brady
 *  @version 04 June 2024
 **/
public class ArchSimGUI extends GridAppFrame
                        implements InitializationButton.Initializer
{
    private String usualTitle;
    private int numRows;
    private Color usualBgColor;
    private Color successfulCompletionBgColor;
    private Color damagedArtifactBgColor;

    private ArchSimulation simulation;

    /** Constructs a new ArchSimGUI object.
     *    @param title         window title
     *    @param helpMenu      Help menu
     *    @param usualBgColor  grid background color during simulation
     *    @param successBgColor bg color if simulated dig succeeds
     *    @param failureBgColor bg color if simulated dig fails
     *    @param numRows        number of rows (and columns) in the grid
     *    @param sim            object that controls the simulation
     */
    public ArchSimGUI(String title, JMenu helpMenu, Color usualBgColor,
                         Color successBgColor, Color failureBgColor,
                         int numRows, ArchSimulation sim)
    {
        super();
        this.usualTitle = title;
        this.usualBgColor = usualBgColor;
        this.successfulCompletionBgColor = successBgColor;
        this.damagedArtifactBgColor = failureBgColor;
        this.numRows = numRows;
        includeMenu(new MinimalFileMenu());
        includeMenu(helpMenu);
        includeControlComponent(new InitializationButton(this, "Restart",
                                                         this, true),
                                EnabledDisabledStates.ALWAYS_ENABLED);
        constructWindowContents(title, usualBgColor, 500, 500,
                                numRows);
        simulation = sim;
        initialize();
    }

    // Redefines constructDisplay to create a customized graphical user
    // interface that checks whether a grid object is visible before display.
    @Override
    protected ScrollableGridDisplay constructDisplay(
        int viewingWidth, int viewingHeight, int minCellSize, Color bgColor)
    {
        return new ArchSimDisplay(viewingWidth, viewingHeight,
                                      minCellSize, bgColor);
    }

    // Redefines setGrid to also reset the window title and
    // background color of the grid.
    @Override
    public void setGrid(Grid grid)
    {
        super.setGrid(grid);
        setTitle(usualTitle);
        getDisplay().setBackgroundColor(usualBgColor);
        getDisplay().setToolTipsEnabled(false);
    }

    /** Starts or restarts the application. **/
    public void initialize()
    {
        // Create a new grid, initialize a new simulation, and
        // display the grid.
        setGrid(new BoundedGrid(true, numRows, numRows));
        simulation.startSimulation(getGrid());
        showGrid();
    }

    // Redefines onMousePressOverDisplay to handle mouse clicks.
    @Override
    protected void onMousePressOverDisplay(Location loc)
    {
        if ( loc != null )
        {
            simulation.dig(loc);
            if ( simulation.simulationOver() )
            {
                if ( simulation.digSuccessful() )
                    notifyDigSuccessfullyCompleted();
                else
                    notifyArtifactDamaged();
                showGrid();
            }
            else
                getDisplay().updateLocation(loc);
        }
    }

    /** Notifies the user that he or she completed the simulation
     *  successfully.
     *  Alters the background color of the grid and prints a message to the
     *  console.
     **/
    public void notifyDigSuccessfullyCompleted()
    {
        setTitle("You successfully completed the dig!");
        getDisplay().setBackgroundColor(successfulCompletionBgColor);
    }

    /** Notifies the user that at least one artifact was damaged.
     *  Alters the background color of the grid and prints a message to the
     *  console.
     **/
    public void notifyArtifactDamaged()
    {
        setTitle("Oops! At least one artifact was damaged...");
        getDisplay().setBackgroundColor(damagedArtifactBgColor);
    }

}
