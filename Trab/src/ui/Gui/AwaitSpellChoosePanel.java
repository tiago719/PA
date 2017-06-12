/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitBattleOption;
import LogicaJogo.States.AwaitSpellChoose;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
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
        Box b1=Box.createHorizontalBox();
        Box b2=Box.createHorizontalBox();
        Box b3=Box.createHorizontalBox();
        
        Continuar=new JButton("Continuar");
        Continuar.addMouseListener(new ActionListener2(observableGame, 0));
        b1.add(Continuar);
        Spells.add(new JButton());
        Spells.add(new JButton());
        Spells.get(0).setVisible(false);
        Spells.get(1).setVisible(false);
        Spells.get(0).addMouseListener(new ActionListener2(observableGame,1));
        Spells.get(1).addMouseListener(new ActionListener2(observableGame,2));
        b2.add(Spells.get(0));
        b3.add(Spells.get(1));
        
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
        setVisible(observableGame.getState() instanceof AwaitSpellChoose);
        Spells.get(0).setVisible(false);
        Spells.get(1).setVisible(false);
        for (int i = 0; i < observableGame.getSpells().size(); i++)
        {
            Spells.get(i).setText("Spell " + (i+1) + ": " + observableGame.getSpells().get(i).nome());
            Spells.get(i).setVisible(true);
        }
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
