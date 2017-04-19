/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.Constants.MapaNiveis;

/**
 *
 * @author Tiago Coutinho
 */
public class Caverna
{

    private int areaL/*level*/, areaC;

    public Caverna()
    {
        areaL = areaC = 0;
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
        return MapaNiveis[areaL - 1].length == areaC + 1;
    }

    public int getArea()
    {
        return MapaNiveis[areaL][areaC];
    }

    public int getNivel()
    {
        return areaL + 1;
    }

    public void setArea(int startingArea)
    {
        int i,j, sum = 0;

        for (i = 0; i < MapaNiveis.length; i++)
        {
            sum += MapaNiveis[i].length;
            if (sum >= startingArea)
            {
                areaL = i;
                break;
            }
        }

        for(j=0;j<MapaNiveis[i].length;j++)
        {
            if(MapaNiveis[i][j]==startingArea)
            {
                areaC=j;
            }
        }
    }

}
