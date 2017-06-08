/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public interface Constants
{
    static final String[] dificuldades = {"1 - Casual","2 - Normal","3 - Hard","4 - Impossible"};
    
   // static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    static final int DIM_X_FRAME = 500;//(int) screenSize.getWidth();
    static final int DIM_Y_FRAME = 250;//(int) screenSize.getHeight();
    
    static final int DIM_X_DUNGEON = 336;
    static final int DIM_Y_DUNGEON = 477;
    
    static final int BORDER_X = 10;
    static final int BORDER_Y = 10;
    
    static final int DIM_X_STATS = 661;
    static final int DIM_Y_STATS = 228;
    
    static final int DIM_X_SOUTH_PANEL = DIM_X_STATS*2;
    static final int DIM_Y_SOUTH_PANEL = DIM_Y_STATS;

}
