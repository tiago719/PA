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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitBattleOptionPanel extends JPanel implements Observer
{

    private JButton Atacar, Rerrol, Feats;
    private ObservableGame observableGame;
    private ArrayList<JLabel> Dados;
    private JButton Cancelar;

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
        Dados = new ArrayList<>();
        Cancelar = new JButton("Cancelar");
        Box estado = Box.createHorizontalBox();
        Box rerol = Box.createHorizontalBox();


        for (int i = 0; i < 4; i++)
        {
            Dados.add(new JLabel());
            Dados.get(i).setVisible(false);
            Dados.get(i).addMouseListener(new Rerrol(i));
            rerol.add(Dados.get(i));
        }

        add(estado);
        add(rerol);

        Cancelar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                estado.setVisible(true);
                rerol.setVisible(false);
            }
        });
        
        Atacar = new JButton("Atacar");
        Atacar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.AtacaMonstro();
            }
        });

        Rerrol = new JButton("Rerrol");
        Rerrol.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                estado.setVisible(false);
                rerol.setVisible(true);
            }
        });

        Feats = new JButton("Feats");
        Feats.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.Feats();
            }
        });
        
        
        estado.add(Atacar);
        estado.add(Rerrol);
        estado.add(Feats);
    }

    public void setupLayout()
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Rerrol.setVisible(observableGame.AnyCritical());
        setVisible(observableGame.getState() instanceof AwaitBattleOption);
    }

    class Rerrol extends MouseAdapter
    {
        private int i;

        public Rerrol(int i)
        {
            this.i = i;
        }

        @Override
        public void mousePressed(MouseEvent ev)
        {
            observableGame.ReroolOptionSelected(i);
        }
    }

}
