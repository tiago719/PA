/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import LogicaJogo.States.AwaitBegining;
import javax.swing.JButton;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitBeginingPanel extends JPanel implements Observer 
{
    private ObservableGame observableGame;
    
    JButton start=new JButton("Start");
    JButton load = new JButton("Load");
    
    public AwaitBeginingPanel(ObservableGame observableGame) 
    {
        this.observableGame=observableGame;
        
        observableGame.addObserver(this);
        
        setupComponents();
        setupLayout();
    }
    
    public void setupComponents()
    {
        
    }
    
    public void setupLayout()
    {
        
    }
    

    @Override
    public void update(Observable o, Object arg)
    {
         setVisible(observableGame.getState() instanceof AwaitBegining ); 
    }

    
}
