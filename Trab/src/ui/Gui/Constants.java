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
    
    static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    static final int DIM_X_FRAME = (int) screenSize.getWidth();
    static final int DIM_Y_FRAME = (int) screenSize.getHeight();
    
    static final int DIM_X_DUNGEON = (336*DIM_X_FRAME)/1366;
    static final int DIM_Y_DUNGEON = (477*DIM_Y_FRAME)/768;
    
    static final int BORDER_X = 10;
    static final int BORDER_Y = 10;
    
    static final int DIM_X_STATS = (661*DIM_X_FRAME)/1366;
    static final int DIM_Y_STATS = (228*DIM_Y_FRAME)/768;
    
    static final int DIM_X_SOUTH_PANEL = DIM_X_STATS*2;
    static final int DIM_Y_SOUTH_PANEL = DIM_Y_STATS;
    
    //String RESTIN = "RestingCard";
    String PATH_IMG_RESTING = "imagensficheiros/Homer.JPG";

    //String BOSS = "BossCard";
    String PATH_IMG_BOSS = "imagensficheiros/BossMonster.JPG";

//    String EVENT = "BossCard";
    String PATH_IMG_EVENT = "imagensficheiros/Event.JPG";
    
//    String MERCHANTCARD = "BossCard";
    String PATH_IMG_MERCHANT = "imagensficheiros/Merchant.JPG";
    
    String PATH_IMG_MONSTER = "imagensficheiros/Monster.JPG";
    
    String PATH_IMG_TRAP = "imagensficheiros/Trap.JPG";    
    
    String PATH_IMG_TREASURE = "Images/Treasure.JPG";

    
    static final int DIM_X_COLUNA = (205*DIM_X_FRAME)/1366;
    static final int DIM_Y_COLUNA = DIM_Y_DUNGEON;
    
    static final int DIM_X_CARTA = (144*DIM_X_FRAME)/1366;
    static final int DIM_Y_CARTA = (223*DIM_Y_FRAME)/768;//262
    
    static final int DIM_X_CARTA_MAX = (384*DIM_X_FRAME)/1366;
    static final int DIM_Y_CARTA_MAX = (554*DIM_Y_FRAME)/768;//262

    
    static final int DIM_X_WELCOME = (715*DIM_X_FRAME)/1366;
    static final int DIM_Y_WELCOME = (320*DIM_Y_FRAME)/768;//262
    
  //  static final int CORD_X_START_WELCOME = (500*DIM_X_FRAME)/1366;
  //  static final int CORD_Y_START_WELCOME = (300*DIM_Y_FRAME)/768;
 
//    static final int DIM_X_COLUNA = 245;
//    static final int DIM_Y_COLUNA = 354;


    
    
}
