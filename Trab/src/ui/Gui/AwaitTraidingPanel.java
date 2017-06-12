/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitBattleOption;
import LogicaJogo.States.AwaitTraiding;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static ui.Gui.Constants.DIM_X_BACKGROUNDBOTOES;
import static ui.Gui.Constants.DIM_Y_BACKGROUNDBOTOES;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitTraidingPanel extends JPanel implements Observer {

    private ObservableGame observableGame;
    private JButton Ration, HealthPotion, BigHealthPotion, ArmorPiece, Any1Spell, SellArmorPiece, SellAny1Spell, Continuar;
    private JLabel buyTextField, sellTextField;

    public AwaitTraidingPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        setVisible(observableGame.getState() instanceof AwaitTraiding);

        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        Box b3 = Box.createHorizontalBox();
        Box b4 = Box.createHorizontalBox();
        Box b5 = Box.createHorizontalBox();

        buyTextField = new JLabel("Buy");
        b1.add(buyTextField);

        Ration = new JButton("Ration");
        Ration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.MerchantOptionSelected(1);
            }
        });
        b2.add(Ration);

        HealthPotion = new JButton("HealthPotion");
        HealthPotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.MerchantOptionSelected(2);
            }
        });
        b2.add(HealthPotion);

        BigHealthPotion = new JButton("BigHealthPotion");
        BigHealthPotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.MerchantOptionSelected(3);
            }
        });
        b2.add(BigHealthPotion);

        ArmorPiece = new JButton("ArmorPiece");
        ArmorPiece.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.MerchantOptionSelected(4);
            }
        });
        b2.add(ArmorPiece);

        Any1Spell = new JButton("Any1Spell");
        Any1Spell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.MerchantOptionSelected(5);
            }
        });
        b2.add(Any1Spell);

        sellTextField = new JLabel("Sell");
        b3.add(sellTextField);

        SellArmorPiece = new JButton("SellArmorPiece");
        SellArmorPiece.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.MerchantOptionSelected(6);
            }
        });
        b4.add(SellArmorPiece);

        SellAny1Spell = new JButton("SellAny1Spell");
        SellAny1Spell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.MerchantOptionSelected(7);
            }
        });
        b4.add(SellAny1Spell);

        Continuar = new JButton("Continuar");
        Continuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.MerchantOptionSelected(8);
            }
        });
        b5.add(Continuar);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);

    }

    public void setupLayout() {
        setLayout(new GridLayout(5, 1));

//        add(buyTextField);
//        add(Ration);
//        add(HealthPotion);
//        add(BigHealthPotion);
//        add(ArmorPiece);
//        add(Any1Spell);
//        add(sellTextField);
//        add(SellArmorPiece);
//        add(SellAny1Spell);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(observableGame.getState() instanceof AwaitTraiding);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MiniRoguePanel.getBgBotoesImg(), 0, 0, DIM_X_BACKGROUNDBOTOES, DIM_Y_BACKGROUNDBOTOES, this);
    }

}
