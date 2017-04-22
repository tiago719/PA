/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.Constants.NivelDificuldade;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public final class Personagem
{
    private int armor, hp, gold, food, rank;
    ArrayList<Dado> dados;
    
    public Personagem(int dificuldade)
    {
        setStats(dificuldade);
        dados = new ArrayList<>();
        dados.add(new Dado());
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
    
    public boolean addFood(int i) 
    {
        if(i<0)
        {
            return false;
        }
        if (food + i <= 6)
        {
            food += i;
            return true;
        }
        else
        {
            food=6;
            return true;
        }
    }

    public boolean addHealth(int i) 
    {
        if(i<0)
        {
            return false;
        }
        if (hp + i <= 20){
            hp += i;
            return true;
        }
        else
        {
            hp=20;
            return true;
        }
    }

    public boolean addXP(int i) 
    {
        if(i<0)
        {
            return false;
        }
        rank += i;
        return true;
        //TODO: ENTENDER A CENA DO XP E RANKS ...
    }
    
    public boolean addGold(int g)
    {
        if(g<0)
        {
            return false;
        }
        else if(gold+g<=20)
        {
            gold+=g;
            return true;
        }
        else
        {
            gold=20;
            return true;
        }
    }
    
    public void setStats(int dificuldade)
    {
        armor = NivelDificuldade[dificuldade-1][0];
        hp = NivelDificuldade[dificuldade-1][1];
        gold = NivelDificuldade[dificuldade-1][2];
        food = NivelDificuldade[dificuldade-1][3];
    }
}
