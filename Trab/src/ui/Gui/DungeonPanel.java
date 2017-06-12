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
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DungeonPanel extends JPanel implements Constants, Observer {

    private ObservableGame observableGame;
    private JLabel AreaAtual, HpMonster;
    private Map<Integer, JLabel> AreaP;
    private Map<Integer, JLabel> HpMonsterP;

    private int HPMonsterToken, AreaToken;

    public DungeonPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;

        observableGame.addObserver(this);

        AreaP = new HashMap<>();
        HpMonsterP = new HashMap<>();

        setupComponents();
        setupLayout();

    }

    public void setupComponents() {
        AreaAtual = new JLabel();
        HpMonster = new JLabel();
    }

    public void setupLayout() {
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

        HPMonsterToken = -1;
        AreaToken = 1;
        AreaP.get(AreaToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage2()));
    }

    public void addHpMonster() {
        int i, j, a = 30;
        HpMonsterP.put(0, new JLabel());
        HpMonsterP.get(0).setBorder(new LineBorder(Color.BLACK));
        HpMonsterP.get(0).setMinimumSize(new Dimension(DIM_X_QUADRICULA_MONSTER, DIM_Y_QUADRICULA_MONSTER));
        HpMonsterP.get(0).setPreferredSize(new Dimension(DIM_X_QUADRICULA_MONSTER, DIM_Y_QUADRICULA_MONSTER));
        HpMonsterP.get(0).setMaximumSize(new Dimension(DIM_X_QUADRICULA_MONSTER, DIM_Y_QUADRICULA_MONSTER));

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 3; j++) {
                int tr = -1;
                if (j == 0) {
                    HpMonsterP.put(a, new JLabel());
                    tr = a;
                }
                if (j == 1) {
                    HpMonsterP.put(a - 10, new JLabel());
                    tr = a - 10;
                }
                if (j == 2) {
                    HpMonsterP.put(a - 20, new JLabel());
                    tr = a - 20;
                }
                HpMonsterP.get(tr).setBorder(new LineBorder(Color.BLACK));
                HpMonsterP.get(tr).setMinimumSize(new Dimension(DIM_X_QUADRICULA_MONSTER, DIM_Y_QUADRICULA_MONSTER));
                HpMonsterP.get(tr).setPreferredSize(new Dimension(DIM_X_QUADRICULA_MONSTER, DIM_Y_QUADRICULA_MONSTER));
                HpMonsterP.get(tr).setMaximumSize(new Dimension(DIM_X_QUADRICULA_MONSTER, DIM_Y_QUADRICULA_MONSTER));
                HpMonster.add(HpMonsterP.get(tr));
            }
            a--;
        }
        HpMonster.add(new JLabel());
        HpMonster.add(new JLabel());
        HpMonster.add(HpMonsterP.get(0));
        
        HpMonster.setBorder(new LineBorder(Color.RED));

        HpMonster.setLayout(new GridLayout(11, 3, DIM_X_BETWEEN_MONSTER, DIM_Y_BETWEEN_MONSTER));
        HpMonster.setVisible(true);

        HpMonster.setMinimumSize(new Dimension(DIM_X_HPMONSTER_PANEL, DIM_Y_HPMONSTER_PANEL));
        HpMonster.setPreferredSize(new Dimension(DIM_X_HPMONSTER_PANEL, DIM_Y_HPMONSTER_PANEL));
        HpMonster.setMaximumSize(new Dimension(DIM_X_HPMONSTER_PANEL, DIM_Y_HPMONSTER_PANEL));
    }

    public void addAreaAtual() {
        AreaAtual.setBorder(new LineBorder(Color.RED));
        int aux = 1;
        for (int i = 0; i < MAXAREA; i++) {
            JLabel temp = new JLabel();
            AreaAtual.add(temp);
            if (i == 2 || i == 3 || i == 6 || i == 7 || i == 11 || i == 15) {
//                AreaP.put(dec--, temp);
                continue;
            } else {
                AreaP.put(aux, temp);
                aux++;
            }
            //AreaP.add(new JLabel());
            AreaP.get(aux - 1).setBorder(new LineBorder(Color.BLACK));
            AreaP.get(aux - 1).setMinimumSize(new Dimension(DIM_X_QUADRICULA_AREA, DIM_Y_QUADRICULA_AREA));
            AreaP.get(aux - 1).setPreferredSize(new Dimension(DIM_X_QUADRICULA_AREA, DIM_Y_QUADRICULA_AREA));
            AreaP.get(aux - 1).setMaximumSize(new Dimension(DIM_X_QUADRICULA_AREA, DIM_Y_QUADRICULA_AREA));
        }

        AreaAtual.setLayout(new GridLayout(5, 4, DIM_X_BETWEEN_AREA, DIM_Y_BETWEEN_AREA));
        AreaAtual.setVisible(true);

        AreaAtual.setMinimumSize(new Dimension(DIM_X_AREA_PANEL, DIM_Y_AREA_PANEL));
        AreaAtual.setPreferredSize(new Dimension(DIM_X_AREA_PANEL, DIM_Y_AREA_PANEL));
        AreaAtual.setMaximumSize(new Dimension(DIM_X_AREA_PANEL, DIM_Y_AREA_PANEL));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(MiniRoguePanel.getTheDungeonImage(), 0, 0, DIM_X_DUNGEON, DIM_Y_DUNGEON, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (observableGame.getNumAreaAtual() != AreaToken) {
            AreaP.get(AreaToken).setIcon(null);
            AreaToken = observableGame.getNumAreaAtual();
            AreaP.get(AreaToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage2()));
        }
        if (observableGame.isMonsterSet()) {
            if (observableGame.getMonsterHP() != HPMonsterToken) {
                try {
                    HpMonsterP.get(HPMonsterToken).setIcon(null);
                } catch (Exception e) {
                }
                HPMonsterToken = observableGame.getMonsterHP();
                HpMonsterP.get(HPMonsterToken).setIcon(new ImageIcon(MiniRoguePanel.getTokenImage2()));
            }
        }

    }

}
