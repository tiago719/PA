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
import Logic.Spells.*;
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
public class CharacterStatsPanel extends JPanel implements Constants, Observer {

    private ObservableGame observableGame;
    private int xpToken, goldToken, hpToken, armorToken, foodToken;
    ArrayList<Integer> spellsToken;
    private ImageIcon goldIcon;
    private JLabel GoldStats, HpStats, ArmorStats, SpellsStats, FoodStats, XpStats;
    private ArrayList<JLabel> GoldP, HpP, ArmorP, SpellsP, FoodP, XpP;

    public CharacterStatsPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        GoldP = new ArrayList<>();
        HpP = new ArrayList<>();
        ArmorP = new ArrayList<>();
        SpellsP = new ArrayList<>();
        FoodP = new ArrayList<>();
        XpP = new ArrayList<>();

        spellsToken = new ArrayList<>();

        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        GoldStats = new JLabel();
        HpStats = new JLabel();
        ArmorStats = new JLabel();
        SpellsStats = new JLabel();
        FoodStats = new JLabel();
        XpStats = new JLabel();

    }

    public void setupLayout() {
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
        xpToken = observableGame.getPerXP();
        goldToken = observableGame.getPerGold();
        hpToken = observableGame.getPerHP();
        armorToken = observableGame.getPerArmor();

        spellsToken.add(null);
        spellsToken.add(null);

        foodToken = observableGame.getPerFood();

        GoldP.get(goldToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        HpP.get(hpToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        ArmorP.get(armorToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        XpP.get(xpToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        FoodP.get(foodToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));

        add(HpStats);
        add(ArmorStats);
        add(SpellsStats);
        add(FoodStats);
    }

    public void addXpStats() {
        XpStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < 42; i++) {
            XpP.add(new JLabel());
            XpP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        XpStats.setLayout(new GridLayout(2, 21, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        XpStats.setVisible(true);

        XpStats.setMinimumSize(new Dimension(DIM_X_XP_PANEL, DIM_Y_XP_PANEL));
        XpStats.setPreferredSize(new Dimension(DIM_X_XP_PANEL, DIM_Y_XP_PANEL));
        XpStats.setMaximumSize(new Dimension(DIM_X_XP_PANEL, DIM_Y_XP_PANEL));

        for (int i = 0; i < XpP.size(); i++) {
            XpP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            XpP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            XpP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            XpStats.add(XpP.get(i));

        }

    }

    public void addGoldStats() {
        GoldStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MaxGold; i++) {
            GoldP.add(new JLabel());
            GoldP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        GoldStats.setLayout(new GridLayout(1, MaxGold, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        GoldStats.setVisible(true);

        GoldStats.setMinimumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        GoldStats.setPreferredSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        GoldStats.setMaximumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));

        for (int i = 0; i < GoldP.size(); i++) {
            GoldP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            GoldP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            GoldP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            GoldStats.add(GoldP.get(i));

        }
    }

    public void addHpStats() {
        HpStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MaxHP; i++) {
            HpP.add(new JLabel());
            HpP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        HpStats.setLayout(new GridLayout(1, MaxHP, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        HpStats.setVisible(true);

        HpStats.setMinimumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        HpStats.setPreferredSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));
        HpStats.setMaximumSize(new Dimension(DIM_X_GOLD_PANEL, DIM_Y_GOLD_PANEL));

        for (int i = 0; i < HpP.size(); i++) {
            HpP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            HpP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            HpP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            HpStats.add(HpP.get(i));

        }

    }

    public void addArmorStats() {
        ArmorStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MaxArmor; i++) {
            ArmorP.add(new JLabel());
            ArmorP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        ArmorStats.setLayout(new GridLayout(1, MaxArmor, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        ArmorStats.setVisible(true);

        ArmorStats.setMinimumSize(new Dimension(DIM_X_ARMOR_PANEL, DIM_Y_ARMOR_PANEL));
        ArmorStats.setPreferredSize(new Dimension(DIM_X_ARMOR_PANEL, DIM_Y_ARMOR_PANEL));
        ArmorStats.setMaximumSize(new Dimension(DIM_X_ARMOR_PANEL, DIM_Y_ARMOR_PANEL));

        for (int i = 0; i < ArmorP.size(); i++) {
            ArmorP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            ArmorP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            ArmorP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            ArmorStats.add(ArmorP.get(i));

        }

    }

    public void addSpellsStats() {
        SpellsStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < 8; i++) {
            SpellsP.add(new JLabel());
            SpellsP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        SpellsStats.setLayout(new GridLayout(1, 8, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        SpellsStats.setVisible(true);

        SpellsStats.setMinimumSize(new Dimension(DIM_X_SPELLS_PANEL, DIM_Y_SPELLS_PANEL));
        SpellsStats.setPreferredSize(new Dimension(DIM_X_SPELLS_PANEL, DIM_Y_SPELLS_PANEL));
        SpellsStats.setMaximumSize(new Dimension(DIM_X_SPELLS_PANEL, DIM_Y_SPELLS_PANEL));

        for (int i = 0; i < SpellsP.size(); i++) {
            SpellsP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            SpellsP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            SpellsP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            SpellsStats.add(SpellsP.get(i));
        }

    }

    public void addFoodStats() {
        FoodStats.setBorder(new LineBorder(Color.RED));

        for (int i = 0; i < MaxFood; i++) {
            FoodP.add(new JLabel());
            FoodP.get(i).setBorder(new LineBorder(Color.BLACK));
        }

        FoodStats.setLayout(new GridLayout(1, MaxFood, DIM_X_BETWEEN, DIM_Y_BETWEEN));
        FoodStats.setVisible(true);

        FoodStats.setMinimumSize(new Dimension(DIM_X_FOOD_PANEL, DIM_Y_FOOD_PANEL));
        FoodStats.setPreferredSize(new Dimension(DIM_X_FOOD_PANEL, DIM_Y_FOOD_PANEL));
        FoodStats.setMaximumSize(new Dimension(DIM_X_FOOD_PANEL, DIM_Y_FOOD_PANEL));

        for (int i = 0; i < FoodP.size(); i++) {
            FoodP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            FoodP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            FoodP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA, DIM_Y_QUADRICULA));
            FoodStats.add(FoodP.get(i));
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(MiniRoguePanel.getCharacterStats(), 0, 0, DIM_X_STATS, DIM_Y_STATS, this);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (observableGame.getPerGold() != goldToken) {
            GoldP.get(goldToken).setIcon(null);
            goldToken = observableGame.getPerGold();
            GoldP.get(goldToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        }
        if (observableGame.getPerArmor() != armorToken) {
            ArmorP.get(armorToken).setIcon(null);
            armorToken = observableGame.getPerArmor();
            ArmorP.get(armorToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        }

        if (observableGame.getPerFood() != foodToken) {
            FoodP.get(foodToken).setIcon(null);
            foodToken = observableGame.getPerFood();
            FoodP.get(foodToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        }

        if (observableGame.getPerHP() != hpToken) {
            HpP.get(hpToken).setIcon(null);
            hpToken = observableGame.getPerHP();
            HpP.get(hpToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        }

        if (observableGame.getPerXP() != xpToken) {
            XpP.get(xpToken).setIcon(null);
            xpToken = observableGame.getPerXP();
            XpP.get(xpToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        }

//        for (int i = 0; i< observableGame.getPerSpells().size(); i++){
//            Spell c = observableGame.getPerSpells().get(i);
//        spellsToken.set(0, null);
//        spellsToken.set(1, null);
        try {
            SpellsP.get(spellsToken.get(0)).setIcon(null);
            SpellsP.get(spellsToken.get(1)).setIcon(null);
        } catch (Exception e) {
        }
        for (Integer c : spellsToken)        
            c = null;
        for (int i = 0; i< spellsToken.size(); i++)
            spellsToken.set(i, null);
//        for (JLabel c:SpellsP ){
//            c.setIcon(null);
//        }

        int aux=0;
        for (Spell c : observableGame.getPerSpells()) {
            if (c instanceof Fire) {
                spellsToken.set(aux, 0);
                if (spellsToken.get(0) == spellsToken.get(aux) && aux != 0) {
                    spellsToken.set(aux, 1);
                }
            }
            if (c instanceof Ice) {
                spellsToken.set(aux, 2);
                if (spellsToken.get(0) == spellsToken.get(aux) && aux != 0) {
                    spellsToken.set(aux, 3);
                }
            }
            if (c instanceof Poison) {
                spellsToken.set(aux, 4);
                if (spellsToken.get(0) == spellsToken.get(aux) && aux != 0) {
                    spellsToken.set(aux, 5);
                }
            }
            if (c instanceof Healing) {
                spellsToken.set(aux, 6);
                if (spellsToken.get(0) == spellsToken.get(aux) && aux != 0) {
                    spellsToken.set(aux, 7);
                }
            }

            aux++;
        }
        try {
            SpellsP.get(spellsToken.get(0)).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
            SpellsP.get(spellsToken.get(1)).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        } catch (Exception e) {
        }
       

        if (observableGame.getPerXP()
                != xpToken) {
            XpP.get(xpToken).setIcon(null);
            xpToken = observableGame.getPerXP();
            XpP.get(xpToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage()));
        }

        //GoldP.get(1).re;
    }

}
