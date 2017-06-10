package Logic;

import static Logic.Constants.MapaNiveis;
import LogicaJogo.States.GameOver;
import java.io.Serializable;
import java.util.ArrayList;

public class Caverna implements Serializable
{
    private GameData GameData;
    private int areaL/*level*/, areaC;
    private final ArrayList<Area> Areas;

    public Caverna(int startingArea, GameData g)
    {
        areaL = areaC = 0;
        GameData = g;
        Areas = new ArrayList<>();
        setArea(startingArea);
    }

    public GameData getGame()
    {
        return GameData;
    }

    public Area getAreaAtual()
    {
        return Areas.get(Areas.size() - 1);
    }

    public int getAreaL()
    {
        return areaL;
    }

    public void setAreaL(int areaL)
    {
        this.areaL = areaL;
    }

    public int getAreaC()
    {
        return areaC;
    }

    public void setAreaC(int areaC)
    {
        this.areaC = areaC;
    }

    public boolean isLastArea()
    {
//        int a = MapaNiveis[areaL].length;
//        int b = areaC;

        return MapaNiveis[areaL].length == areaC + 1;
    }

    public int getNumArea()
    {
        return MapaNiveis[areaL][areaC];
    }

    public int getNivel()
    {
        return areaL + 1;
    }

    public void setArea(int startingArea)
    {
        int i, j, sum = 0;

        for (i = 0; i < MapaNiveis.length; i++)
        {
            sum += MapaNiveis[i].length;
            if (sum >= startingArea)
            {
                areaL = i;
                break;
            }
        }

        for (j = 0; j < MapaNiveis[i].length; j++)
        {
            if (MapaNiveis[i][j] == startingArea)
            {
                areaC = j;
            }
        }

    }

    boolean proxArea()
    {
         if (isLastArea())
        {
            areaC = 0;
            areaL++;
        } else
        {
            areaC++;
        }
         
        Areas.add(new Area(getGame()));

        if (!getGame().getPersonagem().loseFood(1))
        {
            if (!getGame().getPersonagem().loseHp(2))
            {
                return false;
            }
        }
       
        
        return true;
    }

    void geraPrimeiraArea()
    {
        Areas.add(new Area(getGame()));
    }

    void geraProximaArea()
    {
        Areas.add(new Area(getGame()));
    }

    public void Pit()
    {
        areaL++;
        Areas.add(new Area(getGame(), getAreaAtual().getBaralho(), getAreaAtual().getMonsterDefeated(), getAreaAtual().getColuna()));
    }

    @Override
    public String toString()
    {
        String s = "Area Atual: " + getNumArea() + "\n";
        s += "Nivel: " + getNivel();
        return s;
    }

}
