/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Tiago Coutinho
 */
public interface Constants
{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    static final int DIM_X_FRAME = (int) screenSize.getWidth();
    static final int DIM_Y_FRAME = (int) screenSize.getHeight();
    
    static final int DIM_X_STATS = 200;
    static final int DIM_Y_STATS = 400;
    
    static final int DIM_X_DUNGEON = 200;
    static final int DIM_Y_DUNGEON = 400;
    
    static final int BORDER_X = 10;
    static final int BORDER_Y = 10;
    
    static final int DIM_X_SOUTH_PANEL = DIM_X_FRAME;
    static final int DIM_Y_SOUTH_PANEL = 65;

}
