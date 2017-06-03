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
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitBeginingPanel extends JPanel implements Observer
{

    private ObservableGame observableGame;

    JButton start = new JButton("Start");

    public AwaitBeginingPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        observableGame.addObserver(this);

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        start.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.startGame();
            }
        });
    }

    public void setupLayout()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        start.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(10));
        add(start);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitBegining);
    }

}
