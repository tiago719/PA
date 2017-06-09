/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
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
import javax.swing.JPanel;

/**
 *
 * @author edu_f
 */
public class JP_ColunaCartas extends JPanel implements Constants, Observer{
    
    ObservableGame observableGame;
    ArrayList<ImagemCarta> cartas;

    JP_ColunaCartas(int pos, ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);
        
        
        
        
        cartas = new ArrayList<>();
        cartas.add(new ImagemCarta(MiniRoguePanel.getRestingImage(), this.observableGame,288, 417));
        cartas.add(new ImagemCarta(MiniRoguePanel.getTrapImage(), this.observableGame,288, 417));
        
        
        setMaximumSize(new Dimension(DIM_X_COLUNA,DIM_Y_COLUNA));
        setPreferredSize(new Dimension(DIM_X_COLUNA,DIM_Y_COLUNA));
        setMinimumSize(new Dimension(DIM_X_COLUNA,DIM_Y_COLUNA));
        setLayout(new GridLayout(cartas.size(),1,0,10));
        add(cartas.get(0));
        add(cartas.get(1));
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
    
}
