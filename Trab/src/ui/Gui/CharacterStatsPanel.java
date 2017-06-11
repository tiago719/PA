/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import static Logic.Constants.MaxArmor;
import static Logic.Constants.MaxFood;
import static Logic.Constants.MaxGold;
import static Logic.Constants.MaxHP;
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
    private int xpToken, goldToken, hpToken, armorToken, spellsToken[], foodToken;
    private ImageIcon goldIcon;
    private JLabel GoldStats, HpStats, ArmorStats, SpellsStats, FoodStats, XpStats;
    private ArrayList<JLabel> GoldP, HpP, ArmorP, SpellsP, FoodP, XpP;


    public CharacterStatsPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        GoldP = new ArrayList<>();
        HpP=new ArrayList<>();
        ArmorP=new ArrayList<>();
        SpellsP=new ArrayList<>();
        FoodP=new ArrayList<>();
        XpP=new ArrayList<>();

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        GoldStats = new JLabel();
        HpStats= new JLabel();
        ArmorStats= new JLabel();
        SpellsStats= new JLabel();
        FoodStats= new JLabel();
        XpStats= new JLabel();
        
    }

    public void setupLayout()
    {
        setMinimumSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setPreferredSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setMaximumSize(new Dimension(DIM_X_STATS, DIM_Y_STATS));
        setLayout(null);
        
        GoldStats.setBounds(START_X_GOLD_PANEL, START_Y_GOLD_PANEL, DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL);
        HpStats.setBounds(START_X_HP_PANEL, START_Y_HP_PANEL, DIM_X_HP_PANEL, DIM_Y_HP_PANEL);
        ArmorStats.setBounds(START_X_ARMOR_PANEL, START_Y_ARMOR_PANEL, DIM_X_ARMOR_PANEL, DIM_Y_ARMOR_PANEL);
        SpellsStats.setBounds(START_X_SPELLS_PANEL, START_Y_SPELLS_PANEL, DIM_X_SPELLS_PANEL, DIM_Y_SPELLS_PANEL);
        FoodStats.setBounds(START_X_FOOD_PANEL, START_Y_FOOD_PANEL, DIM_X_FOOD_PANEL, DIM_Y_FOOD_PANEL);
        XpStats.setBounds(START_X_XP_PANEL, START_Y_XP_PANEL, DIM_X_XP_PANEL, DIM_Y_XP_PANEL);
       
        setBorder(new LineBorder(Color.GRAY));
        
        addXpStats();
        addGoldStats();
        addHpStats();
        addArmorStats();
        addSpellsStats();
        addFoodStats();
        
        add(XpStats);
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

        add(HpStats);
        add(ArmorStats);
        add(SpellsStats);
        add(FoodStats);
    }
    
    public void addXpStats()
    {
        XpStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < 19; i++)
        {
            XpP.add(new JLabel());
            XpP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        XpStats.setLayout(new GridLayout(1, 19, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        XpStats.setVisible(true);

        XpStats.setMinimumSize(new Dimension(DIM_X_XP_PANEL, DIM_Y_XP_PANEL));
        XpStats.setPreferredSize(new Dimension(DIM_X_XP_PANEL, DIM_Y_XP_PANEL));
        XpStats.setMaximumSize(new Dimension(DIM_X_XP_PANEL, DIM_Y_XP_PANEL));

        for (int i = 0; i < XpP.size(); i++)
        {
            XpP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            XpP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            XpP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            XpStats.add(XpP.get(i));

        }

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
    
    public void addHpStats()
    {
        HpStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MaxHP; i++)
        {
            HpP.add(new JLabel());
            HpP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        HpStats.setLayout(new GridLayout(1, MaxHP, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        HpStats.setVisible(true);

        HpStats.setMinimumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        HpStats.setPreferredSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        HpStats.setMaximumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));

        for (int i = 0; i < HpP.size(); i++)
        {
            HpP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            HpP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            HpP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            HpStats.add(HpP.get(i));

        }

    }

    public void addArmorStats()
    {
        ArmorStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MaxArmor; i++)
        {
            ArmorP.add(new JLabel());
            ArmorP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        ArmorStats.setLayout(new GridLayout(1, MaxArmor, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        ArmorStats.setVisible(true);

        ArmorStats.setMinimumSize(new Dimension(DIM_X_ARMOR_PANEL, DIM_Y_ARMOR_PANEL));
        ArmorStats.setPreferredSize(new Dimension(DIM_X_ARMOR_PANEL, DIM_Y_ARMOR_PANEL));
        ArmorStats.setMaximumSize(new Dimension(DIM_X_ARMOR_PANEL, DIM_Y_ARMOR_PANEL));

        for (int i = 0; i < ArmorP.size(); i++)
        {
            ArmorP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            ArmorP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            ArmorP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            ArmorStats.add(ArmorP.get(i));

        }

    }
    
    public void addSpellsStats()
    {
        SpellsStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < 8; i++)
        {
            SpellsP.add(new JLabel());
            SpellsP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        SpellsStats.setLayout(new GridLayout(1, 8, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        SpellsStats.setVisible(true);

        SpellsStats.setMinimumSize(new Dimension(DIM_X_SPELLS_PANEL, DIM_Y_SPELLS_PANEL));
        SpellsStats.setPreferredSize(new Dimension(DIM_X_SPELLS_PANEL, DIM_Y_SPELLS_PANEL));
        SpellsStats.setMaximumSize(new Dimension(DIM_X_SPELLS_PANEL, DIM_Y_SPELLS_PANEL));

        for (int i = 0; i < SpellsP.size(); i++)
        {
            SpellsP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            SpellsP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            SpellsP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            SpellsStats.add(SpellsP.get(i));
        }

    }
    
    public void addFoodStats()
    {
        FoodStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MaxFood; i++)
        {
            FoodP.add(new JLabel());
            FoodP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        FoodStats.setLayout(new GridLayout(1, MaxFood, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        FoodStats.setVisible(true);

        FoodStats.setMinimumSize(new Dimension(DIM_X_FOOD_PANEL, DIM_Y_FOOD_PANEL));
        FoodStats.setPreferredSize(new Dimension(DIM_X_FOOD_PANEL, DIM_Y_FOOD_PANEL));
        FoodStats.setMaximumSize(new Dimension(DIM_X_FOOD_PANEL, DIM_Y_FOOD_PANEL));

        for (int i = 0; i < FoodP.size(); i++)
        {
            FoodP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            FoodP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            FoodP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            FoodStats.add(FoodP.get(i));
        }

    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(MiniRoguePanel.getCharacterStats(), 0, 0, DIM_X_STATS, DIM_Y_STATS, this);

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
