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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static ui.Gui.Constants.DIM_X_BETWEEN;
import static ui.Gui.Constants.DIM_X_GOLD_PANEL;
import static ui.Gui.Constants.DIM_X_QUADRICULA;
import static ui.Gui.Constants.DIM_Y_BETWEEN;
import static ui.Gui.Constants.DIM_Y_GOLD_PANEL;
import static ui.Gui.Constants.DIM_Y_QUADRICULA;

/**
 *
 * @author Tiago Coutinho
 */
public class DungeonPanel extends JPanel implements Constants, Observer
{
    private ObservableGame observableGame;
    private JLabel AreaAtual, HpMonster;
    private ArrayList<JLabel> AreaP, HpMonsterP;
    
    public DungeonPanel(ObservableGame observableGame)
    {
        this.observableGame=observableGame;
        
        observableGame.addObserver(this);
        
        AreaP = new ArrayList<>();
        HpMonsterP=new ArrayList<>();
        
        setupComponents();
        setupLayout();

    }
    
    public void setupComponents()
    {
        AreaAtual = new JLabel();
        HpMonster= new JLabel();
    }
    
    public void setupLayout()
    {
        setMinimumSize(new Dimension(DIM_X_DUNGEON, DIM_Y_DUNGEON));
        setPreferredSize(new Dimension(DIM_X_DUNGEON, DIM_Y_DUNGEON));
        setMaximumSize(new Dimension(DIM_X_DUNGEON, DIM_Y_DUNGEON));
        setLayout(null);
        
        setBorder(new LineBorder(Color.ORANGE));
        AreaAtual.setBounds(START_X_AREA_PANEL, START_Y_AREA_PANEL, DIM_X_AREA_PANEL, DIM_Y_AREA_PANEL);
        HpMonster.setBounds(START_X_HPMONSTER_PANEL, START_Y_HPMONSTER_PANEL, DIM_X_HPMONSTER_PANEL, DIM_Y_HPMONSTER_PANEL);
        
        addAreaAtual();
        addHpMonster();
        
        add(AreaAtual);
        add(HpMonster);
    }
    
    public void addHpMonster()
    {
        HpMonster.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MAXHPMONSTER; i++)
        {
            HpMonsterP.add(new JLabel());
            HpMonsterP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        HpMonster.setLayout(new GridLayout(11, 3, DIM_X_BETWEEN_MONSTER, DIM_Y_BETWEEN_MONSTER));
        HpMonster.setVisible(true);
        
        HpMonster.setMinimumSize(new Dimension(DIM_X_HPMONSTER_PANEL, DIM_Y_HPMONSTER_PANEL));
        HpMonster.setPreferredSize(new Dimension(DIM_X_HPMONSTER_PANEL, DIM_Y_HPMONSTER_PANEL));
        HpMonster.setMaximumSize(new Dimension(DIM_X_HPMONSTER_PANEL, DIM_Y_HPMONSTER_PANEL));

        for (int i = 0; i < HpMonsterP.size(); i++)
        {
            HpMonsterP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA_MONSTER, DIM_Y_QUADRICULA_MONSTER));
            HpMonsterP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA_MONSTER, DIM_Y_QUADRICULA_MONSTER));
            HpMonsterP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA_MONSTER, DIM_Y_QUADRICULA_MONSTER));
            HpMonster.add(HpMonsterP.get(i));

        }
    }
    
    public void addAreaAtual()
    {
        AreaAtual.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MAXAREA; i++)
        {
            AreaP.add(new JLabel());
            AreaP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        AreaAtual.setLayout(new GridLayout(5, 4, DIM_X_BETWEEN_AREA, DIM_Y_BETWEEN_AREA));
        AreaAtual.setVisible(true);
        
        AreaAtual.setMinimumSize(new Dimension(DIM_X_AREA_PANEL, DIM_Y_AREA_PANEL));
        AreaAtual.setPreferredSize(new Dimension(DIM_X_AREA_PANEL, DIM_Y_AREA_PANEL));
        AreaAtual.setMaximumSize(new Dimension(DIM_X_AREA_PANEL, DIM_Y_AREA_PANEL));

        for (int i = 0; i < AreaP.size(); i++)
        {
            AreaP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA_AREA, DIM_Y_QUADRICULA_AREA));
            AreaP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA_AREA, DIM_Y_QUADRICULA_AREA));
            AreaP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA_AREA, DIM_Y_QUADRICULA_AREA));
            AreaAtual.add(AreaP.get(i));
        }
    }
    
    @Override
    public void paintComponent(Graphics g)
    {  
       super.paintComponent(g);
       
        g.drawImage(MiniRoguePanel.getTheDungeonImage(),0,0, DIM_X_DUNGEON, DIM_Y_DUNGEON, this);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        //TODO:fazer
    }
            
}