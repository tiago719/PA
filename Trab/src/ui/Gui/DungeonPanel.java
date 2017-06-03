/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class DungeonPanel extends JPanel implements Constants 
{
    private ObservableGame observableGame;
    
    public DungeonPanel(ObservableGame observableGame)
    {
        this.observableGame=observableGame;

    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        
         /*...*/
    }
            
}