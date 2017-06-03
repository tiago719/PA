/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitBegining;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitBattleOptionPanel extends JPanel implements Observer
{

    private ObservableGame observableGame;

    public AwaitBattleOptionPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
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
        setVisible(observableGame.getState() instanceof AwaitBattleOptionPanel);
    }

}
