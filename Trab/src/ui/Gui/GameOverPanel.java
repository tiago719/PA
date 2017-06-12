/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitBegining;
import LogicaJogo.States.AwaitTraiding;
import LogicaJogo.States.GameOver;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import static ui.Gui.Constants.DIM_X_BACKGROUNDBOTOES;
import static ui.Gui.Constants.DIM_X_WELCOME;
import static ui.Gui.Constants.DIM_Y_BACKGROUNDBOTOES;
import static ui.Gui.Constants.DIM_Y_WELCOME;

/**
 *
 * @author Tiago Coutinho
 */
public class GameOverPanel extends JPanel implements Observer {

    private ObservableGame observableGame;

    public GameOverPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        setVisible(observableGame.getState() instanceof AwaitTraiding);
        setMaximumSize(new Dimension(DIM_X_WELCOME, DIM_Y_WELCOME));
        setMinimumSize(new Dimension(DIM_X_WELCOME, DIM_Y_WELCOME));
        setPreferredSize(new Dimension(DIM_X_WELCOME, DIM_Y_WELCOME));

//        Image temp;
//        if (observableGame.getPerHP() == 0) {
//            temp = MiniRoguePanel.getGameoverImg();
//        } else {
//            temp = MiniRoguePanel.getWinImg();
//        }
        JButton b = new JButton("Recomecar");
        add(b);
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                observableGame.selectAwaitStart();
            }

        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MiniRoguePanel.getBgBotoesImg(), 0, 0, DIM_X_BACKGROUNDBOTOES, DIM_Y_BACKGROUNDBOTOES, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(observableGame.getState() instanceof GameOver);
    }

}
