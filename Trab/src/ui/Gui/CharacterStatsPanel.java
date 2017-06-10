/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import static Logic.Constants.MaxGold;
import Logic.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
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
    private JPanel GoldStats;
    private ArrayList<JPanel> GoldP;
    
    public CharacterStatsPanel(ObservableGame observableGame)
    {
        this.observableGame=observableGame;
        observableGame.addObserver(this);
        
        setMinimumSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setPreferredSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setMaximumSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
                
        setupComponents();
        setupLayout();
    }
    
    public void setupComponents()
    {
        GoldStats=new JPanel();
        GoldStats.setBorder(new LineBorder(Color.YELLOW));
        GoldStats.setMinimumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        GoldStats.setPreferredSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        GoldStats.setMaximumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        
        GoldP=new ArrayList<>();
        
        for(int i=0;i<MaxGold;i++)
        {
            GoldP.add(new JPanel());
            GoldP.get(i).setBorder(new LineBorder(Color.BLACK));
            GoldP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            GoldP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            GoldP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
        }
    }
    
    public void setupLayout()
    {
        GoldStats.setLayout(new GridLayout(1,MaxGold,DIM_X_BETWEEN, DIM_Y_BETWEEN));
        
        for(int i=0;i<GoldP.size();i++)
        {
            GoldStats.add(GoldP.get(i));
        }
        
        add(GoldStats);
        setAlignmentX(LEFT_ALIGNMENT);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(MiniRoguePanel.getCharacterStats(),0,0, DIM_X_STATS, DIM_Y_STATS, this);
        
    }

    @Override
    public void update(Observable o, Object arg)
    {
        //TODO: fazer
    }
            
}
