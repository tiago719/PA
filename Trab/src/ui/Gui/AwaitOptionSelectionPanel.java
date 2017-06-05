/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitOptionSelectionPanel extends JPanel implements Observer
{
    JButton RYW, SFR, HEAL;
    private ObservableGame observableGame;

    public AwaitOptionSelectionPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        RYW=new JButton("Reinforce your Weapon: + 1 CP");
        SFR=new JButton("Search for Ration: + 1 FOOD");
        HEAL=new JButton("Heal: + 2 HP");

        RYW.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.ResolveRestingCard(1);
            }
        });
        
        SFR.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.ResolveRestingCard(2);
            }
        });
        
        HEAL.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.ResolveRestingCard(3);
            }
        });
    }

    public void setupLayout()
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        RYW.setAlignmentX(Component.CENTER_ALIGNMENT);
        SFR.setAlignmentX(Component.CENTER_ALIGNMENT);
        HEAL.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        add(RYW);
        add(SFR);
        add(HEAL);

    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitOptionSelectionPanel);
    }

}
