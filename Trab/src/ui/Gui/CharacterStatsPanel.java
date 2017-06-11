/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import static Logic.Constants.MaxGold;
import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static ui.Gui.Constants.DIM_X_FRAME;
import static ui.Gui.Constants.DIM_Y_FRAME;

/**
 *
 * @author Tiago Coutinho
 */
public class CharacterStatsPanel extends JPanel implements Constants, Observer
{

    private ObservableGame observableGame;
    private JLabel GoldStats;
    private ArrayList<JLabel> GoldP;
    
    private int xpToken, goldToken, hpToken, armorToken, spellsToken[], foodToken;
    private ImageIcon goldIcon;
    
    public CharacterStatsPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        GoldP = new ArrayList<>();

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        GoldStats = new JLabel();
    }

    public void setupLayout()
    {
        setMinimumSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setPreferredSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setMaximumSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setLayout(null);
        GoldStats.setBounds(START_X_GOLD_PANEL, START_Y_GOLD_PANEL, DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL);
        setBorder(new LineBorder(Color.GRAY));
        addGoldStats();

        add(GoldStats);
        //setAlignmentX(LEFT_ALIGNMENT);
        
        xpToken = observableGame.getGameData().getPersonagem().getXp();//TODO: MUDAR ISTO PARA METEDOS NOVOS
        goldToken = observableGame.getGameData().getPersonagem().getGold();
        hpToken = observableGame.getGameData().getPersonagem().getHp();
        armorToken = observableGame.getGameData().getPersonagem().getArmor();
//        spellsToken[0] = ;
//        spellsToken[1] = 3;
        foodToken = observableGame.getGameData().getPersonagem().getFood();
        
        
        GoldP.get(goldToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
    }

    public void addGoldStats()
    {
        GoldStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MaxGold; i++)
        {
            GoldP.add(new JLabel());
            GoldP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        GoldStats.setLayout(new GridLayout(1, MaxGold, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        GoldStats.setVisible(true);
        
        //GoldStats.set;
        
        //GoldStats.setLocation(START_X_GOLD_PANEL, START_Y_GOLD_PANEL);
        GoldStats.setMinimumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        GoldStats.setPreferredSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        GoldStats.setMaximumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));

        for (int i = 0; i < GoldP.size(); i++)
        {
            GoldP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            GoldP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            GoldP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            GoldStats.add(GoldP.get(i));

        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(MiniRoguePanel.getCharacterStats(), 0, 0, DIM_X_STATS, DIM_Y_STATS, this);
                GoldStats.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg)
    {
        if(observableGame.getGameData().getPersonagem().getGold() != goldToken){
            GoldP.get(goldToken).setIcon(null);
            goldToken = observableGame.getGameData().getPersonagem().getGold();
            GoldP.get(goldToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        }
        
        
        //GoldP.get(1).re;
    }

}
