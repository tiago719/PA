/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitCardSelectionOnCurrentColumn;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AwaitCardSelectionOnCurrentColumnPanel extends JPanel implements Observer, Constants {

    private ObservableGame observableGame;
    private JButton heal;

    public AwaitCardSelectionOnCurrentColumnPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);
        setVisible(observableGame.getState() instanceof AwaitCardSelectionOnCurrentColumn);

        setupComponents();
        setupLayout();
    }
    
     void setupComponents()
     {
        Box b1=Box.createHorizontalBox();

        heal = new JButton("Heal");

        heal.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.Heal();
            }
        });

        b1.add(heal);
        add(b1);
     }
     
     void setupLayout()
     {
        setLayout(new GridLayout(1,1));
     }

    @Override
    public void update(Observable o, Object arg) {
        heal.setVisible(observableGame.hasHeal());
        setVisible(observableGame.getState() instanceof AwaitCardSelectionOnCurrentColumn);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MiniRoguePanel.getBgBotoesImg(), 0, 0, DIM_X_BACKGROUNDBOTOES, DIM_Y_BACKGROUNDBOTOES, this);
    }

}
