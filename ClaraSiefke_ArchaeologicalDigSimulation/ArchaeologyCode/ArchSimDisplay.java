// Class: ArchSimDisplay
//
// Author: Alyce Brady
//
// Created on May 18, 2004
//      Modified on May 21, 2017 to override updateLocation
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
import java.awt.Graphics2D;

import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.display.ScrollableGridDisplay;

/**
 *  Archaeological Dig:<br>
 *
 *  The <code>ArchSimDisplay</code> class extends the
 *  <code>ScrollableGridDisplay</code> class to allow hidden
 *  objects to not be displayed. 
 *
 *  @author Alyce Brady
 *  @version May 21, 2017
 **/
public class ArchSimDisplay extends ScrollableGridDisplay
{

    /** Constructs a new ArchSimDisplay object with no grid
     *  and an empty view.
     *  (Precondition: <code>width</code> and <code>height</code> must be
     *  at least as large as <code>minimumCellSize</code>.)
     *    @param width  the width of the viewing area
     *    @param height the height of the viewing area
     *    @param minimumCellSize minimum cell side length
     */
    public ArchSimDisplay(int width, int height, int minimumCellSize)
    {
        super(width, height, minimumCellSize);
    }

    /** Constructs a new ArchSimDisplay object with no grid
     *  and an empty view.
     *  (Precondition: <code>width</code> and <code>height</code> must be
     *  at least as large as <code>minimumCellSize</code>.)
     *  @param viewingWidth  the width of the viewing area
     *  @param viewingHeight the height of the viewing area
     *  @param minimumCellSize minimum cell side length
     *  @param backgroundColor color to paint background of grid
     **/
    public ArchSimDisplay(int viewingWidth, int viewingHeight,
                              int minimumCellSize, Color backgroundColor)
    {
        super(viewingWidth, viewingHeight, minimumCellSize, backgroundColor);
    }

    /** {@inheritDoc}
     */
    @Override
    protected void drawGridObject(Graphics2D g2, GridObject obj)
    {
        ArchSimGridBlock gridBlock = (ArchSimGridBlock) obj;
        if ( gridBlock.isVisible() )
            super.drawGridObject(g2, obj);
    }

    /** {@inheritDoc}
     */
    @Override
    public void updateLocation(Location loc)
    {
        ArchSimGridBlock gridBlock = (ArchSimGridBlock) grid().objectAt(loc);
        if ( gridBlock != null && gridBlock.isVisible() )
            super.updateLocation(loc);
    }


}
