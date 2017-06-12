package ui.Gui;

import Logic.Cartas.*;
import Logic.ObservableGame;
import LogicaJogo.States.AwaitBegining;
import LogicaJogo.States.GameOver;
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
    private int numAreaAtual;
    ArrayList<JP_ColunaCartas> ColunaCartas;

    public CardsPanel(ObservableGame observableGame) 
    {
        this.observableGame = observableGame;
        setVisible(!(observableGame.getState() instanceof AwaitBegining || observableGame.getState() instanceof GameOver));
        observableGame.addObserver(this);
        
        numAreaAtual = observableGame.getNumAreaAtual();
        
        setMaximumSize(new Dimension((DIM_X_COLUNA) * 5, DIM_Y_COLUNA));
        setPreferredSize(new Dimension((DIM_X_COLUNA) * 5, DIM_Y_COLUNA));
        setMinimumSize(new Dimension((DIM_X_COLUNA) * 5, DIM_Y_COLUNA));
        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);

        setLayout(new GridLayout(1, 5, 0, 0));
        ColunaCartas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Box b = Box.createVerticalBox();
            JP_ColunaCartas aux = new JP_ColunaCartas(i+1, observableGame);
            ColunaCartas.add(aux);

            b.add(aux);
            //b.setBorder(new LineBorder(Color.YELLOW));
            b.setSize(new Dimension(DIM_X_COLUNA, DIM_Y_COLUNA));
            add(b);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
        setVisible(!(observableGame.getState() instanceof AwaitBegining || observableGame.getState() instanceof GameOver));
        
        if (numAreaAtual != observableGame.getNumAreaAtual()){
            numAreaAtual = observableGame.getNumAreaAtual();
            for (JP_ColunaCartas c : ColunaCartas){
                c.giraCartas();
            }
        }
        if (observableGame.isLastArea())
            ColunaCartas.get(4).showBoss(true);
        else
            ColunaCartas.get(4).showBoss(false);
    }

    @Override
    public void paintComponent( Graphics g)
    {
        super.paintComponent(g);   
        g.drawImage(MiniRoguePanel.getBackgroundImage(), 0, 0, DIM_X_BACKGROUND, DIM_Y_BACKGROUND, this);
    }
}
