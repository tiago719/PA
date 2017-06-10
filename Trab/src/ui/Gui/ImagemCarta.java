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
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
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

    ImagemCarta(ObservableGame observableGame, boolean duasCartas) {
        this.observableGame = observableGame;
        
        observableGame.addObserver(this);
        //this.show = false;
        this.duasCartas = duasCartas;
        
        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);
        
        img = MiniRoguePanel.getBackCardImage();
        
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
    public void update(Observable o, Object arg)
    {
        //TODO: fazer 
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
