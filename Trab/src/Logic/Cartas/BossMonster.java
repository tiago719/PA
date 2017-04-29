/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.Constants;
import static Logic.Constants.InfoBossMonster;
import Logic.GameData;

/**
 *
 * @author edu_f
 */
public class BossMonster extends Carta{

    private int hp;
    private final int dmg, XpRwd, GRwd;
    private boolean poison;
    
    public BossMonster(GameData g) 
    {
        super(g);
        int level = g.getCaverna().getNivel();
        hp=InfoBossMonster[level-1][0];
        dmg=InfoBossMonster[level-1][1];
        XpRwd=InfoBossMonster[level-1][2];
        GRwd=InfoBossMonster[level-1][3];
        poison=false;
    }
    
    @Override
    public String toString() {
        String s = "Carta: BOSS MONSTER\n";
        s += "Level - HP - DMG - REWARD\n";
        s += "1 - Undead Giant - 10 - 3 - 2 Coins + 2 XP + Item\n";
        s += "2 - Skeleton Lord - 15 - 5 - 2 Coins + 3 XP + Item\n";
        s += "3 - Undead Lord - 20 - 7 - 3 Coins + 4 XP + Item\n";
        s += "4 - Serpent Demon - 25 - 9 - 3 Coins + 5 XP + Item\n";
        s += "5 - Og's Remains - 30 - 12 - OG's Blood\n";
        return s;
    }
    
    
}
