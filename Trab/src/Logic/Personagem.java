/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.Constants.NivelDificuldade;

/**
 *
 * @author Tiago Coutinho
 */
public class Personagem
{
    private int armor, hp, gold, food, rank;
    
    public Personagem(int dificuldade)
    {
        setStats(dificuldade);
    }

    public int getArmor()
    {
        return armor;
    }

    public void setArmor(int armor)
    {
        this.armor = armor;
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getGold()
    {
        return gold;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }

    public int getFood()
    {
        return food;
    }

    public void setFood(int food)
    {
        this.food = food;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }
    
    public boolean addFood(int i) {
        if (food < 6){
            food += i;
            return true;
        }
        else return false;
    }

    public boolean addHealth(int i) {
        if (hp < 20){
            hp += i;
            return true;
        }
        else return false;
    }

    public boolean addXP(int i) {
        rank += i;
        return true;
        //TODO: ENTENDER A CENA DO XP E RANKS ...
    }
    
    public void setStats(int dificuldade)
    {
        armor = NivelDificuldade[dificuldade-1][0];
        hp = NivelDificuldade[dificuldade-1][1];
        gold = NivelDificuldade[dificuldade-1][2];
        food = NivelDificuldade[dificuldade-1][3];
    }
}
