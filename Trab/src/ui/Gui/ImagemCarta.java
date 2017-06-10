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
public class ImagemCarta extends JPanel implements Constants, Observer {

    //private boolean show;
    BufferedImage img;
    ObservableGame observableGame;
    private Carta carta;
    boolean duasCartas;
    int posColuna;

//    JP_CartaMaximizada CartaMaximizada;
    ImagemCarta(ObservableGame observableGame, boolean duasCartas, 
            int posColuna) {
        this.observableGame = observableGame;
        this.posColuna = posColuna;
        observableGame.addObserver(this);
        //this.show = false;
        this.duasCartas = duasCartas;

//        setAlignmentX(CENTER_ALIGNMENT);
//        setAlignmentY(CENTER_ALIGNMENT);
        img = MiniRoguePanel.getBackCardImage();

//        Box b = Box.createHorizontalBox();
//        
//        b.add(Box.createHorizontalGlue());
//        b.add(Box.createVerticalGlue());
//        CartaMaximizada = new  JP_CartaMaximizada(img, 0, 0, 500, 500, observableGame);
//        b.add(CartaMaximizada);
//        
//        b.add(Box.createHorizontalGlue());
//        b.add(Box.createVerticalGlue());        
//        CartaMaximizada.setVisible(false);
//        CartaMaximizada.setEnabled(false);
//        
//        add(b);
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
            
//            CartaMaximizada.setVisible(true);
//            CartaMaximizada.setImg(img);
//            CartaMaximizada.update(null, null);
            JDialog dialog = new JP_CartaMaximizada(img, observableGame, carta);
            
            dialog.setUndecorated(true);
            //JLabel label = new JLabel(new ImageIcon(img));
//            dialog.add( new JP_CartaMaximizada(img) );
            dialog.pack();
            
            dialog.setModal(true);
            dialog.setLocation(new Point((DIM_X_FRAME/2)-(DIM_X_CARTA_MAX/2), (DIM_Y_FRAME/2)-(DIM_Y_CARTA_MAX/2)));
            dialog.setVisible(true);
            
            
            
            //TODO: JANELA PRINCIPAL NAO SELECIONAVEL
//            int dialogButton = JOptionPane.YES_NO_OPTION;

//            int i = JOptionPane.showConfirmDialog(null, new JP_CartaMaximizada(img));
//Object[] options = {"Yes, please",
//                "No way!"};
//            int n = JOptionPane.showOptionDialog(null,
//                    new JP_CartaMaximizada(img),
//                    "A Silly Question",
//                    JOptionPane.YES_NO_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null, //do not use a custom Icon
//                    options, //the titles of buttons
//                    options[0]);
//            if (n == dialogButton) {
//                System.out.println("ui.Gui.ImagemCarta.ClickListener.mousePressed()");
//            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }
    }
}
