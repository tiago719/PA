/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import Logic.GameData;

import static Logic.Constants.NivelDificuldade;
import Logic.Spells.*;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public final class Personagem {

    private int armor, hp, gold, food, rank;
    ArrayList<Spell> spells;
    GameData gamedata;
    

    public Personagem(int dificuldade, GameData gamedata) {
        setStats(dificuldade);
        spells = new ArrayList<>();
        this.gamedata = gamedata;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean addFood(int i) {
        if (i < 0) {
            return false;
        }
        if (food + i <= 6) {
            food += i;
            return true;
        } else {
            food = 6;
            return true;
        }
    }

    public boolean addHealth(int i) {
        if (i < 0) {
            return false;
        }
        if (hp + i <= 20) {
            hp += i;
            return true;
        } else {
            hp = 20;
            return true;
        }
    }

    public boolean addXP(int i) {
        if (i < 0) {
            return false;
        }
        rank += i;
        return true;
        //TODO: ENTENDER A CENA DO XP E RANKS ...
    }

    public boolean addGold(int g) {
        if (g < 0) {
            return false;
        } else if (gold + g <= 20) {
            gold += g;
            return true;
        } else {
            gold = 20;
            return true;
        }
    }

    public boolean addArmor(int a) {
        if (a < 0) {
            return false;
        } else if (armor + a <= 5) {
            armor += a;
            return true;
        } else {
            armor = 5;
            return true;
        }
    }

    public void setStats(int dificuldade) {
        armor = NivelDificuldade[dificuldade - 1][0];
        hp = NivelDificuldade[dificuldade - 1][1];
        gold = NivelDificuldade[dificuldade - 1][2];
        food = NivelDificuldade[dificuldade - 1][3];
    }

    public boolean buyRation() {
        if (gold >= 1) {
            if (addFood(1)) {
                gold--;
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean buyPotion() {
        if (gold >= 1) {
            if (addHealth(1)) {
                gold--;
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean buyBigPotion() {
        if (gold >= 3) {
            if (addHealth(4)) {
                gold -= 3;
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean buyArmor() {
        if (gold >= 6) {
            if (addArmor(1)) {
                gold -= 6;
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean sellArmor() {
        if (armor > 0) {
            if (addGold(4)) {
                armor--;
                return true;
            }
            return false;
        }
        return false;
    }

    public void addSpell(Spell s) {
        spells.add(s);
    }

    public boolean buyAnySpell() {
        int rand = 1 + (int)(Math.random() * ((5 - 1) + 1));

        if ((gold - 8) < 0) {
            return false;
        }

        switch (rand) {
            case 1:
                spells.add(new Fire(gamedata));
                break;
            case 2:
                gamedata.getPersonagem().addSpell(new Fire(gamedata));
                break;
            case 3:
                gamedata.getPersonagem().addSpell(new Ice(gamedata));
                break;
            case 4:
                gamedata.getPersonagem().addSpell(new Poison(gamedata));
                break;
            case 5:
                gamedata.getPersonagem().addSpell(new Healing(gamedata));
                break;
        }
        gold -= 8;
        return true;
    }

    public boolean sellAnySpell() {
        int rand = 0 + (int)(Math.random() * ((spells.size() - 0) + 1));
        spells.remove(rand);
        gold+=4;
        
        return true;
        

    }
    
    public boolean loseFood(int f)
    {
        if(f>=0)
        {
            return false;
        }
        if(food-f<0)
        {
            return false;
        }
        else
        {
            food-=f;
            return true;
        }
    }
    
    public boolean loseGold(int g)
    {
        if(g>=0)
        {
            return false;
        }
        if(gold-g<0)
        {
            return false;
        }
        else
        {
            gold-=g;
            return true;
        }
    }
    
    public boolean loseArmor(int a)
    {
        if(armor-a<0)
        {
            return false;
        }
        else
        {
            armor-=a;
            return true;
        }
    }
    
    public boolean loseHp(int h)
    {
        if(hp-h<0)
        {
            hp=0;
            return false;
        }
        else
        {
            hp-=h;
            return true;
        }
    }
    
    public boolean loseXp(int x)
    {
        if(rank-x<0)
        {
            return false;
        }
        else
        {
            rank-=x;
            //TODO: entender a cena da xp e dos niveis
            return true;
        }
    }
    
    public ArrayList<Spell> getSpells(){
        return spells;
    }
}
