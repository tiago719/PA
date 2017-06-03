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

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitFeatsPanel extends JPanel implements Observer 
{
    private ObservableGame observableGame;

    public AwaitFeatsPanel(ObservableGame observableGame) 
    {
        this.observableGame=observableGame;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        //TODO: fazer isto
    }

    
}