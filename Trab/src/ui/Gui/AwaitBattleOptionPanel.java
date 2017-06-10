/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitBattleOption;
import LogicaJogo.States.AwaitBegining;
import LogicaJogo.States.AwaitCardSelectionOnCurrentColumn;
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
public class AwaitBattleOptionPanel extends JPanel implements Observer
{
    private JButton Atacar, Rerrol, Feats;
    private ObservableGame observableGame;

    public AwaitBattleOptionPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        observableGame.addObserver(this);
        
        setVisible(observableGame.getState() instanceof AwaitBattleOption);

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        Atacar=new JButton("Atacar");  
        Atacar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.AtacaMonstro();
            }
        });
        
        Rerrol=new JButton("Rerrol");  
        Rerrol.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                //observableGame.ReroolOptionSelected();TODO: falta fazer
            }
        });
        
        Feats=new JButton("Feats");  
        Feats.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.Feats();
            }
        });
    }

    public void setupLayout()
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        add(Atacar);
        add(Rerrol);
        add(Feats);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Rerrol.setVisible(observableGame.AnyCritical());
        setVisible(observableGame.getState() instanceof AwaitBattleOption);
    }

}
