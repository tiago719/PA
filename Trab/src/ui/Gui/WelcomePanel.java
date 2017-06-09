/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import static ui.Gui.Constants.DIM_X_DUNGEON;
import static ui.Gui.Constants.DIM_Y_DUNGEON;

/**
 *
 * @author Tiago Coutinho
 */
public class WelcomePanel extends JPanel implements Constants, Observer
{
    private ObservableGame observableGame;
    
    public WelcomePanel(ObservableGame observableGame)
    {
        this.observableGame=observableGame;

    }
    
    @Override
    public void paintComponent(Graphics g)
    {  
       super.paintComponent(g);
        
        g.drawImage(MiniRoguePanel.getTheDungeonImage(),0,0, DIM_X_DUNGEON, DIM_Y_DUNGEON, this);
    }
    
     @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
