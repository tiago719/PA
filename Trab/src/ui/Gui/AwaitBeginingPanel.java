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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Spinner;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitBeginingPanel extends JPanel implements Observer
{

    private ObservableGame observableGame;

    JButton start = new JButton("Start");
    JSpinner dificuldades;
   

    public AwaitBeginingPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        observableGame.addObserver(this);

        SpinnerListModel SM = new SpinnerListModel(Constants.dificuldades);
        dificuldades = new JSpinner(SM);

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

        dificuldades.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent ev)
            {
                observableGame.setDificultyLevel(Integer.parseInt(
                        String.valueOf(dificuldades.getModel().getValue().toString().charAt(0))));
            }
        });

    }

    public void setupLayout()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        start.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(start);
        add(Box.createVerticalGlue());
        add(dificuldades);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitBegining);
    }

}
