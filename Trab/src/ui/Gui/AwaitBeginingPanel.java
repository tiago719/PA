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
import LogicaJogo.States.AwaitCardSelectionOnCurrentColumn;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Spinner;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static ui.Gui.Constants.DIM_X_CARTA_MAX;
import static ui.Gui.Constants.DIM_X_FRAME;
import static ui.Gui.Constants.DIM_Y_CARTA_MAX;
import static ui.Gui.Constants.DIM_Y_FRAME;
import ui.Gui.ImagemCarta.ClickListener;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitBeginingPanel extends JPanel implements Observer
{

    private ObservableGame observableGame;

    JButton start, setStartingArea;
    JSpinner dificuldades;
    JDialog dialog;
   
    public AwaitBeginingPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;

        observableGame.addObserver(this);
        
        setVisible(observableGame.getState() instanceof AwaitBegining); 

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        start = new JButton("Start");
        setStartingArea=new JButton("Set Starting Area");
        SpinnerListModel SM = new SpinnerListModel(Constants.dificuldades);
        dificuldades = new JSpinner(SM);
        
        start.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.startGame();
                
            }
        });
        
        setStartingArea.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                dialog=new JP_DungeonMaximizada(observableGame, MiniRoguePanel.getTheDungeonImage());
                dialog.setUndecorated(true);
                dialog.pack();
                dialog.setModal(true);
                dialog.setLocation(new Point((DIM_X_FRAME/2)-(DIM_X_CARTA_MAX/2), (DIM_Y_FRAME/2)-(DIM_Y_CARTA_MAX/2)));
                dialog.setVisible(true);
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
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(CENTER_ALIGNMENT);
        add(start);
        add(dificuldades);
        add(setStartingArea);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitBegining);
    }

}

