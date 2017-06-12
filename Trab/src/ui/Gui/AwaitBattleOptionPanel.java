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

import java.awt.Graphics;

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
import static ui.Gui.Constants.DIM_X_BACKGROUNDBOTOES;
import static ui.Gui.Constants.DIM_Y_BACKGROUNDBOTOES;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitBattleOptionPanel extends JPanel implements Observer {

    private JButton Atacar, Rerrol, Feats;
    private ObservableGame observableGame;
    private ArrayList<JLabel> Dados;
    private JButton Cancelar;
    private Box estado;

    public AwaitBattleOptionPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        setVisible(observableGame.getState() instanceof AwaitBattleOption);

        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        Dados = new ArrayList<>();
        
        estado = Box.createHorizontalBox();
        Box dados = Box.createHorizontalBox();

        Box atacar = Box.createHorizontalBox();
        Box feats = Box.createHorizontalBox();


        for (int i = 0; i < 4; i++) {
            Dados.add(new JLabel());
            Dados.get(i).setVisible(false);
            Dados.get(i).addMouseListener(new Rerrol(i));
            dados.add(Dados.get(i));
        }


        Atacar = new JButton("Atacar");
        Atacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.AtacaMonstro();
            }
        });


        Feats = new JButton("Feats");
        Feats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.Feats();
            }
        });

        atacar.add(Atacar);
        feats.add(Feats);
        add(dados);
        add(atacar);
        add(feats);

    }

    public void setupLayout() {
        setLayout(new GridLayout(3, 1));

    }

    @Override
    public void update(Observable o, Object arg) {
        if (observableGame.getState() instanceof AwaitBattleOption) {
            setVisible(true);

            for (int i = 0; i < observableGame.getDados().size(); i++) {
                Dados.get(i).setVisible(true);
                Dados.get(i).setIcon(new ImageIcon(MiniRoguePanel.getDadosImage().get(observableGame.getDados().get(i).getFace() - 1)));
            }
        } else {
            setVisible(false);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MiniRoguePanel.getBgBotoesImg(), 0, 0, DIM_X_BACKGROUNDBOTOES, DIM_Y_BACKGROUNDBOTOES, this);
    }

    class Rerrol extends MouseAdapter {

        private int i;

        public Rerrol(int i) {

            this.i = i;
        }

        @Override
        public void mousePressed(MouseEvent ev) {
            observableGame.ReroolOptionSelected(i + 1);
        }

    }

}
