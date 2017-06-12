/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.Cartas.Carta;
import Logic.ObservableGame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static ui.Gui.Constants.DIM_X_CARTA_MAX;
import static ui.Gui.Constants.DIM_X_FRAME;
import static ui.Gui.Constants.DIM_Y_CARTA_MAX;
import static ui.Gui.Constants.DIM_Y_FRAME;

/**
 *
 * @author edu_f
 */
public class ImagemCarta extends JLabel implements Constants, Observer {

    BufferedImage img;
    ObservableGame observableGame;
    private Carta carta;
    boolean duasCartas;
    int posColuna;

    ImagemCarta(ObservableGame observableGame, boolean duasCartas, 
            int posColuna) {
        this.observableGame = observableGame;
        this.posColuna = posColuna;
        observableGame.addObserver(this);

        this.duasCartas = duasCartas;

        img = MiniRoguePanel.getBackCardImage();

        addMouseListener(new ClickListener());

    }

    void setImg(BufferedImage img, Carta c) {
        this.img = img;
        this.carta = c;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (duasCartas) {
            g.drawImage(img, 10, 10, DIM_X_CARTA - 10, DIM_Y_CARTA - 10, this);
        } else {
            g.drawImage(img, 10, (getHeight() / 2) - (DIM_Y_CARTA / 2),
                     DIM_X_CARTA - 10, (getHeight() / 2), this);
        }
    }

    @Override

    public void update(Observable o, Object arg) {
        repaint();
    }

    class ClickListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (posColuna!=observableGame.getNumColunaAtual())
                return;
            
            JDialog dialog = new JP_CartaMaximizada(img, observableGame, carta);
            
            dialog.setUndecorated(true);

            dialog.pack();
            
            dialog.setModal(true);
            dialog.setLocation(new Point((DIM_X_FRAME/2)-(DIM_X_CARTA_MAX/2), (DIM_Y_FRAME/2)-(DIM_Y_CARTA_MAX/2)));
            dialog.setVisible(true);
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }
    }
}
