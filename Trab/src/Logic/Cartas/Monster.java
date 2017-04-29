/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.Constants;
import static Logic.Constants.InfoMonster;
import Logic.GameData;

/**
 *
 * @author edu_f
 */
public class Monster extends Carta
{
    private int hp;
    private final int dmg, rwd;
    private boolean poison;

    public Monster(GameData g)
    {
        super(g);
        int level = g.getCaverna().getNivel();
        dmg = Constants.InfoMonster[level-1][0]; //TODO: Nao sera o nivel aqui?? Ve se esta bem
        rwd = Constants.InfoMonster[level-1][1];
        hp = g.getCaverna().getNumArea() + (1 + (int) (Math.random() * ((6 - 1) + 1)));
        poison = false;
    }

    public Monster(GameData g, boolean event)
    {
        super(g);
        int rank = g.getPersonagem().getRank();
        dmg = g.getCaverna().getNumArea() * 2;
        rwd = 2;
        hp = g.getCaverna().getNumArea() + (1 + (int) (Math.random() * ((6 - 1) + 1)));
    }

    public boolean isPoison() {
        return poison;
    }

    public void setPoison(boolean poison) {
        this.poison = poison;
    }

    public int getDmg()
    {
        return dmg;
    }

    public int getRwd()
    {
        return rwd;
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

    //true = morto
    public boolean Deffend(int soma)
    {
        if (hp <= soma)
        {
            hp = 0;
            return true;
        } else
        {
            hp -= soma;
            return false;
        }
    }//TODO: retirar

    public int getHp()
    {
        return hp;
    }

}
