package ui.Gui;

import Logic.Cartas.*;
import Logic.ObservableGame;
import LogicaJogo.States.AwaitBegining;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CardsPanel extends JPanel implements Constants, Observer {

    private ObservableGame observableGame;

    public CardsPanel(ObservableGame observableGame) 
    {
        this.observableGame = observableGame;
        setVisible(!(observableGame.getState() instanceof AwaitBegining));
        observableGame.addObserver(this);
        
        setMaximumSize(new Dimension((DIM_X_COLUNA)*5,DIM_Y_COLUNA));
        setPreferredSize(new Dimension((DIM_X_COLUNA)*5,DIM_Y_COLUNA));
        setMinimumSize(new Dimension((DIM_X_COLUNA)*5,DIM_Y_COLUNA));
        setAlignmentX(CENTER_ALIGNMENT);
                setAlignmentY(CENTER_ALIGNMENT);
        
        setLayout(new GridLayout(1,5,0,0));
        //setLayout(new BorderLayout());
        ArrayList<JP_ColunaCartas> ColunaCartas = new ArrayList<>();
        for (int i =0; i< 5; i++){
            Box b = Box.createVerticalBox();
            JP_ColunaCartas aux = new JP_ColunaCartas(i, observableGame);
            ColunaCartas.add(aux);
            
            
            b.add(aux);
            b.setBorder(new LineBorder(Color.YELLOW));
            b.setSize(new Dimension(DIM_X_COLUNA, DIM_Y_COLUNA));
            add(b);
        }
        update(observableGame, null);
            
        
        
//        List<Carta> Baralho = observableGame.getBaralhoAreaAtual();

//        ArrayList<JPanel> CartasJP = new ArrayList<>();

//        setMaximumSize(new Dimension(DIMX_IMGS_COLECCAO*listaPersonagens.size(), DIMY_IMGS_COLECCAO));
//        setPreferredSize(new Dimension(DIMX_IMGS_COLECCAO*listaPersonagens.size(), DIMY_IMGS_COLECCAO));
//        setMinimumSize(new Dimension(DIMX_IMGS_COLECCAO*listaPersonagens.size(), DIMY_IMGS_COLECCAO));
                
//        setLayout(new GridLayout(1,listaPersonagens.size(),0,0));
//        for (/*Carta c : Baralho*/ int i  = 0; i< 5; i ++) {
//            if (c instanceof Resting) {
//                CartasJP.add(new ImagemCarta(MiniRoguePanel.getRestingImage(), this.observableGame));
//            }
//                add(new ImagemCarta(MiniRoguePanel.getRestingImage(), this.observableGame));
//            if (c instanceof BossMonster) {
//                CartasJP.add(new ImagemCarta(MiniRoguePanel.getRestingmage(), this.observableGame));
//            }
//                add(new ImagemCarta(MiniRoguePanel.getBossMonsterImage(), observableGame));
//            if (c instanceof Event) {
//                CartasJP.add(new ImagemCarta(MiniRoguePanel.getMonsterImage(), observableGame));
//            }
//                add(new ImagemCarta(MiniRoguePanel.getEventImage(), observableGame));
//            if (c instanceof Monster) {
//                CartasJP.add(new ImagemCarta(MiniRoguePanel.getMonsterImage(), observableGame));
//            }
//                add(new ImagemCarta(MiniRoguePanel.getMonsterImage(), observableGame));
//            if (c instanceof Merchant) //                add(new ImagemCarta(MiniRoguePanel.getMerchantImage(), observableGame));
//            {
//                CartasJP.add(new ImagemCarta(MiniRoguePanel.getMerchantImage(), observableGame));
//            }
//            if (c instanceof Treasure) //                add(new ImagemCarta(MiniRoguePanel.getTreasureImage(), observableGame));
//            {
//                CartasJP.add(new ImagemCarta(MiniRoguePanel.getTreasureImage(), observableGame));
//            }
//            if (c instanceof Trap) //                add(new ImagemCarta(MiniRoguePanel.getTrapImage(), observableGame));
//            {
//                CartasJP.add(new ImagemCarta(MiniRoguePanel.getTrapImage(), observableGame));
//            }

        }


    @Override
    public void update(Observable o, Object arg) {
        repaint();
        setVisible(!(observableGame.getState() instanceof AwaitBegining));
    }
    
//    @Override
//    public void paintComponent( Graphics g)
//    {
//        super.paintComponent(g);
//        
//    }

}
