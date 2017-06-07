/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.MenuBar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author Tiago Coutinho
 */
public class MiniRogueView extends JFrame implements Observer, Constants
{ 
    ObservableGame observableGame;
    MiniRoguePanel panel;
    
    public MiniRogueView( ObservableGame j) 
    {
        this( j, 0,0, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MiniRogueView( ObservableGame j, int x, int y ) 
    {
        this( j, x,y, DIM_X_FRAME, DIM_Y_FRAME);
    }
    
    public MiniRogueView( ObservableGame j, int x, int y, int width, int height)
    {
        super("Mini Rogue");

        observableGame=j;
                  
        j.addObserver(this);
        
        Container cp = getContentPane(); 
               
        panel = new MiniRoguePanel(observableGame);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cp.add(panel, BorderLayout.CENTER);
               
        setLocation(x, y); 
        setSize(width,height); 
        setMinimumSize(new Dimension(width,height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

    @Override
    public void update(Observable o, Object arg)
    {
        //TODO: fazer isto
    }
}
