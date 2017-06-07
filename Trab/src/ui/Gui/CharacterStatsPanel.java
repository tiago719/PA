/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static ui.Gui.Constants.DIM_X_FRAME;
import static ui.Gui.Constants.DIM_Y_FRAME;

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
        
        setMinimumSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setPreferredSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setMaximumSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        
        setAlignmentX(LEFT_ALIGNMENT);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(MiniRoguePanel.getCharacterStats(),0,0, DIM_X_STATS, DIM_Y_STATS, this);
        
    }
            
}
