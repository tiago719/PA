package ui.Gui;

import Logic.Cartas.*;
import Logic.ObservableGame;
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

    public CardsPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);
        
        setMaximumSize(new Dimension(384*5,555));
        setPreferredSize(new Dimension(384*5,555));
        setMinimumSize(new Dimension(384*5,555));
        setLayout(new GridLayout(1,5,10,0));
        //setLayout(new BorderLayout());
        ArrayList<Box> ColunaCartas = new ArrayList<>();
        for (int i =0; i< 5; i++){
            ColunaCartas.add(Box.createVerticalBox());
            ColunaCartas.get(i).add(new JP_ColunaCartas(i, observableGame));
            ColunaCartas.get(i).setBorder(new LineBorder(Color.YELLOW));
            add(ColunaCartas.get(i));
        }
            
        
        
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
//                CartasJP.add(new ImagemCarta(MiniRoguePanel.getRestingImage(), this.observableGame));
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
    }
    
//    @Override
//    public void paintComponent( Graphics g)
//    {
//        super.paintComponent(g);
//        
//    }

}
