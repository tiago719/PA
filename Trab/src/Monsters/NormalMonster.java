/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monsters;

import Logic.Constants;
import Logic.GameData;

/**
 *
 * @author edu_f
 */
public class NormalMonster extends Monster
{
    private final int rwd;

    public NormalMonster(GameData g)
    {
        super(g);
        int level = g.getCaverna().getNivel();
        super.setDmg(Constants.InfoMonster[level-1][0]); //TODO: Nao sera o nivel aqui?? Ve se esta bem
        rwd = Constants.InfoMonster[level-1][1];
        super.setHP(g.getCaverna().getNumArea() + (1 + (int) (Math.random() * ((6 - 1) + 1))));
    }

    public NormalMonster(GameData g, boolean event)
    {
        super(g);
        int rank = g.getPersonagem().getRank();
        super.setDmg(g.getCaverna().getNumArea() * 2);
        rwd = 2;
        super.setHP(g.getCaverna().getNumArea() + (1 + (int) (Math.random() * ((6 - 1) + 1))));
    }

    @Override
    public String toString()
    {
        String s = "Carta: MONSTER\n";
//        s += "Level - DMG - REWARD\n";
//        s += "1 - Undead Soldier - 2 - 1 XP\n";
//        s += "2 - Skeleton - 4 - 1 XP\n";
//        s += "3 - Undead Knight - 6 - 2 XP\n";
//        s += "4 - Serpent Knight - 8 - 2 XP\n";
//        s += "5 - Og's Sanctum Guard - 10 - 3 XP\n";
        return s;

    }

}
