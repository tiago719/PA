/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitBattleOption;
import LogicaJogo.States.AwaitSpellChoose;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitSpellChoosePanel extends JPanel implements Observer
{
    private ArrayList<JButton> Spells;
    private JButton Continuar;
    private ObservableGame observableGame;

    public AwaitSpellChoosePanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        observableGame.addObserver(this);
        
        Spells=new ArrayList<>();
        
        setVisible(observableGame.getState() instanceof AwaitSpellChoose);

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        Continuar=new JButton("Continuar");
        Continuar.addMouseListener(new ActionListener(observableGame, 0));
        
        for (int i = 0; i < observableGame.getSpells().size(); i++)
        {
            Spells.add(new JButton("Spell " + (i+1) + ": " + observableGame.getSpells().get(i)));
            Spells.get(i).addMouseListener(new ActionListener2(observableGame,i));
        }
    }

    public void setupLayout()
    {
        add(Continuar);
        for(int i=0;i<Spells.size();i++)
        {
            add(Spells.get(i));
        }
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitSpellChoose);
    }
}

class ActionListener2  extends MouseAdapter
{
    private int i;
    private ObservableGame observableGame;
    
    public ActionListener2(ObservableGame o,int i)
    {
        this.i=i;
        observableGame=o;
    }
    
    @Override
    public void mousePressed(MouseEvent ev)
    {
       observableGame.ChooseSpell(i);
    }
}
