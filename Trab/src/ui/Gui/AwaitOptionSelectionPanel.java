/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitFeats;
import LogicaJogo.States.AwaitOptionSelection;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import static ui.Gui.Constants.DIM_X_BACKGROUNDBOTOES;
import static ui.Gui.Constants.DIM_Y_BACKGROUNDBOTOES;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitOptionSelectionPanel extends JPanel implements Observer {

    JButton RYW, SFR, HEAL;
    private ObservableGame observableGame;

    public AwaitOptionSelectionPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        setVisible(observableGame.getState() instanceof AwaitOptionSelection);

        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        setVisible(observableGame.getState() instanceof AwaitOptionSelectionPanel);

        RYW = new JButton("Reinforce your Weapon");
        SFR = new JButton("Search for Ration");
        HEAL = new JButton("Heal");

        RYW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.ResolveRestingCard(1);
            }
        });

        SFR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.ResolveRestingCard(2);
            }
        });

        HEAL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.ResolveRestingCard(3);
            }
        });
    }

    public void setupLayout() {
//        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        RYW.setAlignmentX(Component.CENTER_ALIGNMENT);
        SFR.setAlignmentX(Component.CENTER_ALIGNMENT);
        HEAL.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(RYW);
        add(SFR);
        add(HEAL);

    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(observableGame.getState() instanceof AwaitOptionSelection);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MiniRoguePanel.getBgBotoesImg(), 0, 0, DIM_X_BACKGROUNDBOTOES, DIM_Y_BACKGROUNDBOTOES, this);
    }

}
