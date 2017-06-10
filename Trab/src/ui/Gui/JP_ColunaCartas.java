/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.Cartas.*;
import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author edu_f
 */
public class JP_ColunaCartas extends JPanel implements Constants, Observer {

    ObservableGame observableGame;
    ArrayList<ImagemCarta> cartas;
    final int Coluna;

    JP_ColunaCartas(int pos, ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);
        this.Coluna = pos;
        cartas = new ArrayList<>();
        if (pos == 2 || pos == 4){
            cartas.add(new ImagemCarta(this.observableGame, true, pos));
            cartas.add(new ImagemCarta(this.observableGame, true, pos));
        }
        else
          cartas.add(new ImagemCarta(this.observableGame, false, pos));  
            

        setMaximumSize(new Dimension(DIM_X_COLUNA, DIM_Y_COLUNA));
        setPreferredSize(new Dimension(DIM_X_COLUNA, DIM_Y_COLUNA));
        setMinimumSize(new Dimension(DIM_X_COLUNA, DIM_Y_COLUNA));
        setLayout(new GridLayout(cartas.size(),1,0,0));
        
        
        for(ImagemCarta c : cartas)
            add(c);
        
//        setAlignmentX(CENTER_ALIGNMENT);
//        setAlignmentY(CENTER_ALIGNMENT);
//        Box box = Box.createHorizontalBox();
//        box.setMaximumSize(new Dimension(DIM_X_COLUNA, DIM_Y_COLUNA));
//        box.setPreferredSize(new Dimension(DIM_X_COLUNA, DIM_Y_COLUNA));
//        box.setMinimumSize(new Dimension(DIM_X_COLUNA, DIM_Y_COLUNA));
//        box.add(Box.createHorizontalGlue());

//        add(cartas.get(0));
//        box.add(Box.createHorizontalGlue());
//        setLayout(new BorderLayout());
//        add(box, BorderLayout.CENTER);
//        add(Box.createHorizontalGlue());
//        add(cartas.get(1));

    }

    @Override
    public void update(Observable o, Object arg) {
        
//        repaint();
        if (Coluna == observableGame.getNumColunaAtual()){
            ArrayList<Carta> Baralho = observableGame.getCartasColuna();
            for (int i=0; i< Baralho.size(); i++){
                Carta CartaTemp = Baralho.get(i);
                ImagemCarta ICtemp = cartas.get(i);
                
                if (CartaTemp instanceof Resting)
                    ICtemp.setImg(MiniRoguePanel.getRestingImage(),CartaTemp);
                if (CartaTemp instanceof Monster)
                    ICtemp.setImg(MiniRoguePanel.getMonsterImage(),CartaTemp);
                if (CartaTemp instanceof BossMonster)
                    ICtemp.setImg(MiniRoguePanel.getBossMonsterImage(),CartaTemp);
                if (CartaTemp instanceof Treasure)
                    ICtemp.setImg(MiniRoguePanel.getTreasureImage(),CartaTemp);
                if (CartaTemp instanceof Event)
                    ICtemp.setImg(MiniRoguePanel.getEventImage(),CartaTemp);
                if (CartaTemp instanceof Trap)
                    ICtemp.setImg(MiniRoguePanel.getTrapImage(),CartaTemp);
                
            }
        }
        
        
        
    }

}
