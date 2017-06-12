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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
    private JPanel estado, rerol;

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
        estado = new JPanel();
        rerol = new JPanel();
        
        Box b1=Box.createHorizontalBox();
        estado.setLayout(new GridLayout(2,1));
        rerol.setLayout(new GridLayout(2,1));
        estado.add(b1);
        rerol.add(b1);
        
        for (int i = 0; i < 4; i++)
        {
            Dados.add(new JLabel());
            Dados.get(i).setVisible(false);
            Dados.get(i).addMouseListener(new Rerrol(i, estado, rerol));
            b1.add(Dados.get(i));
        }

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

        rerol.setVisible(false);
        rerol.add(Cancelar);
        estado.add(Atacar);
        estado.add(Rerrol);
        estado.add(Feats);
        add(estado);
        add(rerol);
    }

    public void setupLayout()
    {
//        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if (observableGame.getState() instanceof AwaitBattleOption)
        {
            setVisible(true);
            estado.setVisible(true);
            rerol.setVisible(false);

            Rerrol.setVisible(observableGame.AnyCritical());

            for (int i = 0; i < observableGame.getDados().size(); i++)
            {
                Dados.get(i).setVisible(true);
                Dados.get(i).setIcon(new ImageIcon(MiniRoguePanel.getDadosImage().get(observableGame.getDados().get(i).getFace() - 1)));
            }
        }
        else
            setVisible(false);
    }

    class Rerrol extends MouseAdapter
    {

        private int i;
        private JPanel estado, rerrol;

        public Rerrol(int i, JPanel estado, JPanel rerrol)
        {
            this.i = i;
            this.estado=estado;
            this.rerrol=rerrol;
        }

        @Override
        public void mousePressed(MouseEvent ev)
        {
            observableGame.ReroolOptionSelected(i+1);
            estado.setVisible(true);
            rerrol.setVisible(false);
        }
    }

}
