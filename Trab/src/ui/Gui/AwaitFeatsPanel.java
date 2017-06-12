/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitCardSelectionOnCurrentColumn;
import LogicaJogo.States.AwaitFeats;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static ui.Gui.Constants.DIM_X_BACKGROUNDBOTOES;
import static ui.Gui.Constants.DIM_X_COLUNA;
import static ui.Gui.Constants.DIM_Y_BACKGROUNDBOTOES;
import static ui.Gui.Constants.DIM_Y_COLUNA;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitFeatsPanel extends JPanel implements Observer {

    private ArrayList<JLabel> Dados;
    private JButton Cancelar;
    private ObservableGame observableGame;
    private ButtonGroup group;
    private JRadioButton hp, xp;
    private JLabel preco;

    public AwaitFeatsPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        Dados = new ArrayList<>();

        setVisible(observableGame.getState() instanceof AwaitFeats);

        setupComponents();
        setupLayout();

    }

    public void setupComponents() {
        Cancelar = new JButton("Cancelar");

        Cancelar.addMouseListener(new ActionListener(-2));

        group = new ButtonGroup();
        hp = new JRadioButton("2 HP");
        xp = new JRadioButton("1 XP");
        hp.setSelected(true);
        preco = new JLabel("Preço");
        hp.setVisible(true);
        xp.setVisible(true);

        for (int i = 0; i < 4; i++) {
            Dados.add(new JLabel());
            Dados.get(i).setVisible(false);
            Dados.get(i).addMouseListener(new ActionListener(i));
        }
    }

    public void setupLayout() {
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        Box b3 = Box.createHorizontalBox();

        group.add(hp);
        group.add(xp);
        b2.add(hp);
        b2.add(xp);

        setLayout(new GridLayout(3, 1));
        b3.add(Cancelar);

        for (int i = 0; i < Dados.size(); i++) {
            b1.add(Dados.get(i));
        }

        add(b1);
        add(b2);
        add(b3);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (observableGame.getState() instanceof AwaitFeats) {
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

    class ActionListener extends MouseAdapter {

        private int i;

        public ActionListener(int i) {
            this.i = i;
        }

        @Override
        public void mousePressed(MouseEvent ev) {
            if (hp.isSelected() == true) {
                observableGame.FeatsOptionSelected(i + 1, 1);
            } else {
                observableGame.FeatsOptionSelected(i + 1, 2);
            }

        }
    }
}
