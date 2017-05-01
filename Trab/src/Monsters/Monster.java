/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monsters;

import Logic.GameData;

/**
 *
 * @author edu_f
 */
public abstract class Monster
{
    private int hp, dmg;
    private boolean poison;

    public Monster(GameData g)
    {
        poison = false;
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

    public int getHP()
    {
        return hp;
    }

    public  void setHP(int hp){
        this.hp = hp;
    }
    
    public void setDmg(int hp){
        this.hp = hp;
    }
}
