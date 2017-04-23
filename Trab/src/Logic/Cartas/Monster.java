/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.Constants;
import Logic.GameData;

/**
 *
 * @author edu_f
 */
public class Monster extends Carta {

    private final int dmg, rwd;

    public Monster(GameData g) {
        super(g);
        int rank = g.getPersonagem().getRank();
        dmg = Constants.InfoMonster[rank ][0]; 
        rwd = Constants.InfoMonster[rank][1];
    }

    public int getDmg() {
        return dmg;
    }

    public int getRwd() {
        return rwd;
    }

    @Override
    public String toString() {
        String s = "Carta: MONSTER\n";
        s+= "Level - DMG - REWARD\n";
        s += "1 - Undead Soldier - 2 - 1 XP\n";
        s += "2 - Skeleton - 4 - 1 XP\n";
        s += "3 - Undead Knight - 6 - 2 XP\n";
        s += "4 - Serpent Knight - 8 - 2 XP\n";
        s += "5 - Og's Sanctum Guard - 10 - 3 XP\n";
        return s;
        

    }

}
