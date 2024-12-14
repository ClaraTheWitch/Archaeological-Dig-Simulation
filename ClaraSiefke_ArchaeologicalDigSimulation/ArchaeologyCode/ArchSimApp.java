// Class: ArchSimApp
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

import javax.swing.JMenu;

import edu.kzoo.grid.display.DisplayMap;
import edu.kzoo.grid.display.TextCellDisplay;
import edu.kzoo.grid.gui.nuggets.BasicHelpMenu;
import edu.kzoo.util.NamedColor;

/**
 *  Archaeological Dig:<br>
 *
 *  The <code>ArchSimApp</code> class provides the <code>main</code>
 *  method for a simulation of an archaeological dig.
 *
 *  @author Alyce Brady and Clara Siefke
 *  @version June 04, 2024
 **/
public class ArchSimApp
{
    private static final String usualTitle = "Archaeology Simulation";
    private static final Color usualBgColor = Color.GRAY;
    private static final Color successfulCompletionBgColor =
                                        new Color(200, 100, 100);
                                        // or NamedColor.CINNAMON;
    private static final Color damagedArtifactBgColor = Color.DARK_GRAY;

    public static void main(String[] args)
    {
        DisplayMap.associate("ArchSimGridBlock",
                             new TextCellDisplay());
        JMenu helpMenu = new BasicHelpMenu("Archaeology Dig Simulation",
            "Clara Siefke",
            "with assistance from Alyce and Jackson Kiino-Terburg",
            "06/04/24", "file:ArchDigHelp.html");
        ArchSimGUI gui = new ArchSimGUI(usualTitle, helpMenu,
                                    usualBgColor,
                                    successfulCompletionBgColor,
                                    damagedArtifactBgColor, 20,
                                    new DummyArchSimulation());
    }
}
