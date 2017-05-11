package Logic;

import static Logic.Constants.NivelDificuldade;
import Logic.Spells.*;
import LogicaJogo.States.IStates;
import java.io.Serializable;
import java.util.ArrayList;

public final class Personagem implements Serializable
{

    private final GameData gd;
    private boolean poison;
    private int armor, hp, gold, food, rank, xp;
    private ArrayList<Spell> spells;

    public Personagem(int dificuldade, GameData gamedata)
    {
        setStats(dificuldade);
        spells = new ArrayList<>();
        rank = 1;
        xp = 0;
        gd = gamedata;
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
        if (i < 0)
        {
            return false;
        }
        if (food + i <= 6)
        {
            food += i;
            return true;
        } else
        {
            food = 6;
            gd.addMsg("Nao pode obter mais FOOD\n");
            return false;
        }
    }

    public boolean addHealth(int i)
    {
        if (i < 0)
        {
            return false;
        }
        if (hp + i <= 20)
        {
            hp += i;
            return true;
        } else
        {
            hp = 20;
            gd.addMsg("Nao pode obter mais HEALTH");
            return false;
        }
    }

    public boolean addXP(int i)
    { //TODO: retorna sempre true; Considerar mudar de boolean para void
        int aux;
        //se rank = 4 adiciona 1hp
        if (rank == 4)
        {
            addHealth(1);
            gd.addMsg("Limite de XP atingido, adicionado 1 HP!");
            return true;
        } //se esta a retirar xp
        else if (i < 0)
        {
            //se baixa de rank
            if (xp + i < 0)
            {
                //se esta no 1º rank
                if (rank == 1)
                {
                    xp = 0;
                    return true;
                }
                rank--;
                aux = xp + i;
                xp = 6 + aux;//continua com 6xp do rank anterior - o xp retirado a mais do rank atual(6 + (1 - 3))
            } //se nao passa para rank anterior
            else
            {
                xp += i;
            }

            gd.addMsg("A personagem tem agora " + xp + " XP e esta no rank " + rank + "\n");
        } //se passa para rank seguinte
        else if (xp + i >= 6)
        {
            gd.addDado();
            gd.addMsg("Foi adicionado um novo dado a personagem\n");
            rank++;
            if (xp + i > 6)
            {
                xp = xp + i - 6;//fica com o xp recebido a mais (5+2=7   7-6 = 1 <- fica com 1xp)
            } //se xp + i = 6
            else
            {
                xp = 0;
            }
            gd.addMsg("A personagem tem agora " + xp + " XP e esta no rank " + rank + "\n");

        } //se nao passa para prox rank
        else
        {
            //gd.addMsg("Foi adicionado " + i + " XP\n");
            xp += i;
        }
        return true;
    }

    public boolean addGold(int g)
    {
        if (g < 0)
        {
            return false;
        } else if (gold + g <= 20)
        {
            gold += g;
            return true;
        } else
        {
            gold = 20;
            gd.addMsg("Nao pode ganhar mais GOLD");
            return false;
        }
    }

    public boolean addArmor(int a)
    {
        if (a < 0)
        {
            return false;
        } else if (armor + a <= 5)
        {
            armor += a;
            return true;
        } else
        {
            armor = 5;
            gd.addMsg("Nao pode obter mais ARMOR");
            return false;
        }
    }

    public void setStats(int dificuldade)
    {
        armor = NivelDificuldade[dificuldade - 1][0];
        hp = NivelDificuldade[dificuldade - 1][1];
        gold = NivelDificuldade[dificuldade - 1][2];
        food = NivelDificuldade[dificuldade - 1][3];
    }

    public boolean buyRation()
    {
        if (gold >= 1)
        {
            if (addFood(1))
            {
                gold--;
                return true;
            }
            return false;
        } else
        {
            gd.addMsg("GOLD Insuficiente");
            return false;
        }
    }

    public boolean buyPotion()
    {
        if (gold >= 1)
        {
            if (addHealth(1))
            {
                gold--;
                return true;
            }
            return false;
        } else
        {
            gd.addMsg("GOLD Insuficiente");
            return false;
        }
    }

    public boolean buyBigPotion()
    {
        if (gold >= 3)
        {
            if (addHealth(4))
            {
                gold -= 3;
                return true;
            }
            return false;
        } else
        {
            gd.addMsg("GOLD Insuficiente");
            return false;
        }
    }

    public boolean buyArmor()
    {
        if (gold >= 6)
        {
            if (addArmor(1))
            {
                gold -= 6;
                return true;
            }
            return false;
        } else
        {
            gd.addMsg("GOLD Insuficiente");
            return false;
        }
    }

    public boolean sellArmor()
    {
        if (armor > 0)
        {
            if (addGold(4))
            {
                armor--;
                return true;
            }
            return false;
        }
        gd.addMsg("Nao tem Armor");
        return false;
    }

    public void addSpell(Spell s)
    {
        if(spells.size()>=2)
        {
            spells.remove(1);
            spells.add(s);
            return;
        }
        spells.add(s);
    }

    public boolean buyAnySpell()
    {
        int rand = 1 + (int) (Math.random() * ((5 - 1) + 1));
        gd.addMsg("Resultado do lancamento do dado: " + rand);

        if ((gold - 8) < 0)
        {
            return false;
        }

        switch (rand)
        {
            case 1:
                spells.add(new Fire(gd));
                break;
            case 2:
                spells.add(new Fire(gd));
                break;
            case 3:
                spells.add(new Ice(gd));
                break;
            case 4:
                spells.add(new Poison(gd));
                break;
            case 5:
                spells.add(new Healing(gd));
                break;
        }
        gold -= 8;
        return true;
    }

    public boolean sellAnySpell()
    {
        if (spells.size() != 0)
        {
            int rand = 0 + (int) (Math.random() * ((spells.size() - 0) + 1));
            Spell temp = spells.get(rand);
            spells.remove(rand);
            gold += 4;
            gd.addMsg("Foi removido o spell " + temp.nome() + ".\n");
            return true;
        }

        gd.addMsg("Nao tem spells para remover.\n");
        return false;
    }

    public boolean Healing(IStates s)
    {
        for (int i = 0; i < spells.size(); i++)
        {
            if (spells.get(i) instanceof Healing)
            {
                spells.get(i).Efeito(gd, s);
                return true;
            }
        }
        return false;
    }

    public boolean loseFood(int f)
    {
        if (f <= 0)
        {
            return false;
        }
        if (food - f < 0)
        {
            return false;
        } else
        {
            food -= f;
            return true;
        }
    }

    public boolean TradeXpForFeat()
    {
        if (xp <= 0)
        {
            if (rank == 1)
            {
                return false;
            } else
            {
                xp = 5;
                rank--;
                return true;
            }
        } else
        {
            xp--;
            return true;
        }
    }

    public boolean loseGold(int g)
    {
        if (g <= 0)
        {
            return false;
        }
        if (gold - g < 0)
        {
            return false;
        } else
        {
            gold -= g;
            return true;
        }
    }

    public boolean loseArmor(int a)
    {
        if (a <= 0)
        {
            return false;
        }
        if (armor - a < 0)
        {
            return false;
        } else
        {
            armor -= a;
            return true;
        }
    }

    public boolean loseHp(int h)
    {
        if (hp - h <= 0)
        {
            hp = 0;
            return false;
        } else
        {
            hp -= h;
            return true;
        }
    }

    public ArrayList<Spell> getSpells()
    {
        return spells;
    }

    public int getXp()
    {
        return xp;
    }

    public boolean hasPoison()
    {
        return poison;
    }

    public void setPoison(boolean p)
    {
        poison = p;
    }

    public boolean hasHeal()
    {
        for (int i = 0; i < spells.size(); i++)
        {
            if (spells.get(i) instanceof Healing)
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString()
    {
        String s = "Personagem: \n";
        s += "HP: " + hp + "\n";
        s += "Armor: " + armor + "\n";
        s += "Gold: " + gold + "\n";
        s += "Food: " + food + "\n";
        s += "Rank: " + rank + "\n";
        s += "XP: " + xp + "\n";
        s+="Spells:\n";

        for (Spell d : getSpells())
        {
            s += "Spell " + d + "\n";
        }
        return s;
    }

    //true = morto
    /*public boolean DeffendMonstro(int soma, int hpMonstro)
    {
        if (hpMonstro <= soma)
        {
            
            return true;
        } else
        {
            hp -= soma;
            return false;
        }
    }*/
}
