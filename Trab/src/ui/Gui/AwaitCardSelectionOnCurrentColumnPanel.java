/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitCardSelectionOnCurrentColumn;
import java.awt.Component;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitCardSelectionOnCurrentColumnPanel extends JPanel implements Observer 
{
    private ObservableGame observableGame;
    JButton heal;

    public AwaitCardSelectionOnCurrentColumnPanel(ObservableGame observableGame) 
    {
        this.observableGame=observableGame;
        observableGame.addObserver(this);
        setVisible(observableGame.getState() instanceof AwaitCardSelectionOnCurrentColumnPanel ); 
        
        setupComponents();
        setupLayout();
    }
    
     void setupComponents()
     {
        heal = new JButton("Heal");
     }
     
     void setupLayout()
     {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        heal.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        add(heal);
     }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitCardSelectionOnCurrentColumn && observableGame.hasHeal()); 
    }

    
}
