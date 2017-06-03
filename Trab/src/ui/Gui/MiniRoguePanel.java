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
public class MiniRoguePanel extends JPanel implements Observer, Constants
{
    ObservableGame observableGame;
    
    public MiniRoguePanel(ObservableGame j)
    {
        observableGame=j;
    }
    
    @Override
    public void update(Observable t, Object o) 
    {
        //TODO:fazer isto
    }
}
