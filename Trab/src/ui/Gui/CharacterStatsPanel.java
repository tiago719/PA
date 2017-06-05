/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Tiago Coutinho
 */
public class CharacterStatsPanel extends JPanel implements Constants 
{
    private ObservableGame observableGame;
    
    public CharacterStatsPanel(ObservableGame observableGame)
    {
        this.observableGame=observableGame;
        
         this.setBorder(new LineBorder(Color.DARK_GRAY));//TODO:TIRAR

    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(MiniRoguePanel.getCharacterStats(),getWidth()-DIM_X_STATS-BORDER_X ,getHeight()/2-(DIM_Y_STATS/2) , DIM_X_STATS, DIM_Y_STATS, this);
        
    }
            
}
