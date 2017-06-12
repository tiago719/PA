/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitFeats;
import LogicaJogo.States.AwaitOptionSelection;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import static javax.swing.Box.createHorizontalBox;
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
        
        setVisible(observableGame.getState() instanceof AwaitOptionSelection); 

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        Box b1=createHorizontalBox();
        Box b2=createHorizontalBox();
        Box b3=createHorizontalBox();

        setVisible(observableGame.getState() instanceof AwaitOptionSelectionPanel);

        RYW=new JButton("Reinforce your Weapon");
        SFR=new JButton("Search for Ration");
        HEAL=new JButton("Heal");

        RYW.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.ResolveRestingCard(1);
            }
        });
        b1.add(RYW);
        SFR.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.ResolveRestingCard(2);
            }
        });
        b2.add(SFR);
        HEAL.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.ResolveRestingCard(3);
            }
        });
        b3.add(HEAL);

        add(b1);
        add(b2);
        add(b3);
    }

    public void setupLayout()
    {
        setLayout(new GridLayout(3,1));
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitOptionSelection);
    }

}
