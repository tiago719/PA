/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author edu_f
 */
public class ImagemCarta extends JPanel implements Constants{
    
    private boolean show;
    BufferedImage img;
    ObservableGame observableGame;
    int width, height;

    ImagemCarta(BufferedImage Image, ObservableGame observableGame, int width, int height) {
        this.img = Image;
        this.observableGame = observableGame;
        this.show = false;
        this.width=width;
        this.height=height;
        
        addMouseListener(new ClickListener());
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(img, 0, 0,width,height, this);

    }    
    
    class ClickListener extends MouseAdapter 
    {
       
//        @Override
//        public void mousePressed(MouseEvent e){
//            int num = modelo.getPersonagens().indexOf(new Personagem(nomeEstaPersonagem));
//            if (num != -1)
//                modelo.setDestaque(num);
//        }
    }
}
