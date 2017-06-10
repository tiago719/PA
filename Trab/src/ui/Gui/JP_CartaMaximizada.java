/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.Cartas.BossMonster;
import Logic.Cartas.Carta;
import Logic.Cartas.Event;
import Logic.Cartas.Monster;
import Logic.Cartas.Resting;
import Logic.Cartas.Trap;
import Logic.Cartas.Treasure;
import Logic.ObservableGame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author edu_f
 */
public class JP_CartaMaximizada extends JDialog implements Constants, ActionListener {

    private ObservableGame o;
    private Carta carta;

    JP_CartaMaximizada(BufferedImage img, ObservableGame o, Carta c) {
        setUndecorated(true);
        this.o = o;
        this.carta = c;
//        add( new JLabel(new ImageIcon(img)) );
//        pack();
//        setVisible(true);
//        setLocation(new Point((DIM_X_FRAME/2)-(DIM_X_CARTA_MAX/2), (DIM_Y_FRAME/2)-(DIM_Y_CARTA_MAX/2)));
//        setModal(true);

        JPanel jp = new JPanel();
        Box left = Box.createVerticalBox();
        Box right = Box.createVerticalBox();

        JLabel Image = new JLabel(new ImageIcon(img));
        left.add(Image);

//        left.setBorder(new LineBorder(Color.yellow));
        right.add(new JLabel("Resolve this Card?"));

        JButton btnOK = new JButton("Yes, please");
        btnOK.addMouseListener(new okListener(o, c, this));
        JButton btnCancelar = new JButton("No way!");

        btnCancelar.addActionListener(this);

        right.add(btnOK);
        right.add(btnCancelar);
        setLayout(new FlowLayout());

        jp.add(left);
        jp.add(right);

        jp.setBorder(new BevelBorder(1));

        add(jp);

    }
    
    public void Close(){
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

}

class okListener extends MouseAdapter {

    private ObservableGame o;
    private Carta carta;
    JP_CartaMaximizada pai;
    
    public okListener(ObservableGame o, Carta c, JP_CartaMaximizada aThis) {
        this.o = o;
        this.carta = c;
        this.pai = aThis;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (carta instanceof Resting) {
            o.SelectedRestingCard();
        }
        if (carta instanceof Monster) {
            o.SelectedMonsterCard(carta);
        }
        if (carta instanceof BossMonster) {
            o.SelectedBoosMonsterCard(carta);
        }
        if (carta instanceof Treasure) {
            o.SelectedTreasureCard();
        }
        if (carta instanceof Event) {
            o.SelectedEventCard(carta);
        }
        if (carta instanceof Trap) {
            o.SelectedEventCard(carta);
        }
        pai.dispose();
    }

}
