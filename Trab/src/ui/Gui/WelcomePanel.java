/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitBegining;
import java.awt.Dimension;
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
        observableGame.addObserver(this);
        setVisible(observableGame.getState() instanceof AwaitBegining);
        setMaximumSize(new Dimension(DIM_X_WELCOME, DIM_Y_WELCOME));
        setMinimumSize(new Dimension(DIM_X_WELCOME, DIM_Y_WELCOME));
        setPreferredSize(new Dimension(DIM_X_WELCOME, DIM_Y_WELCOME));
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {  
       super.paintComponent(g);
        
        g.drawImage(MiniRoguePanel.getWelcomeImage(),0,0, DIM_X_WELCOME, DIM_Y_WELCOME, this);
    }
    
     @Override
    public void update(Observable o, Object arg) {
//        setVisible(observableGame.getState() instanceof AwaitBegining);
//        repaint();
          setVisible(observableGame.getState() instanceof AwaitBegining);
    }
}
