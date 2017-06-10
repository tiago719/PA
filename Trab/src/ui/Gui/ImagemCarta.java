/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

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
import javax.swing.JPanel;

/**
 *
 * @author edu_f
 */
public class ImagemCarta extends JPanel implements Constants, Observer{
    
    //private boolean show;
    BufferedImage img;
    ObservableGame observableGame;
    boolean duasCartas;
    
//    JP_CartaMaximizada CartaMaximizada;

    ImagemCarta(ObservableGame observableGame, boolean duasCartas) {
        this.observableGame = observableGame;

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
    
    void setImg(BufferedImage img){
        this.img = img;
        
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (duasCartas)
            g.drawImage(img, 10, 10,DIM_X_CARTA-10,DIM_Y_CARTA-10, this);
        else
            g.drawImage(img, 10, (getHeight()/2)-(DIM_Y_CARTA/2)
                    ,DIM_X_CARTA-10,(getHeight()/2), this);
    }    

    @Override

    public void update(Observable o, Object arg) {
        repaint();
    }
    
    class ClickListener extends MouseAdapter 
    {
       
        @Override
        public void mousePressed(MouseEvent e){
//            CartaMaximizada.setVisible(true);
//            CartaMaximizada.setImg(img);
//            CartaMaximizada.update(null, null);
//            JDialog dialog = new JP_CartaMaximizada(img);
            
//            dialog.setUndecorated(true);
            //JLabel label = new JLabel(new ImageIcon(img));
//            dialog.add( new JP_CartaMaximizada(img) );
//            dialog.pack();
//            dialog.setVisible(true);
//            dialog.setLocation(new Point((DIM_X_FRAME/2)-(DIM_X_CARTA_MAX/2), (DIM_Y_FRAME/2)-(DIM_Y_CARTA_MAX/2)));
            //TODO: JANELA PRINCIPAL NAO SELECIONAVEL

        }
        
        @Override
        public void mouseEntered(MouseEvent e){
            
        }
    }
}
