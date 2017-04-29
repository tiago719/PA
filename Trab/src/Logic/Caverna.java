/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import static Logic.Constants.MapaNiveis;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public class Caverna {

    private GameData GameData;
    private int areaL/*level*/, areaC;
    private final ArrayList<Area> Areas;

    public Caverna(int startingArea, GameData g) {
        areaL = areaC = 0;
        GameData = g;
        Areas = new ArrayList<>();
        
        setArea(startingArea);
    }
    
    public Area getAreaAtual(){
        //int ola=getNumArea()-GameData.getStartingArea();
        return Areas.get(getNumArea()-GameData.getStartingArea());
    }

    public int getAreaL() {
        return areaL;
    }

    public void setAreaL(int areaL) {
        this.areaL = areaL;
    }

    public int getAreaC() {
        return areaC;
    }

    public void setAreaC(int areaC) {
        this.areaC = areaC;
    }

    public boolean isLastArea() {
        int a = MapaNiveis[areaL].length;
        int b = areaC;
        
        return MapaNiveis[areaL].length == areaC + 1;
    }

    public int getNumArea() {
        return MapaNiveis[areaL][areaC];
    }

    public int getNivel() {
        return areaL + 1;
    }

    public void setArea(int startingArea) {
        int i, j, sum = 0;

        for (i = 0; i < MapaNiveis.length; i++) {
            sum += MapaNiveis[i].length;
            if (sum >= startingArea) {
                areaL = i;
                break;
            }
        }

        for (j = 0; j < MapaNiveis[i].length; j++) {
            if (MapaNiveis[i][j] == startingArea) {
                areaC = j;
            }
        }
        
    }

    void proxArea() {
        Areas.add(new Area(GameData));

        if (isLastArea()){
            areaC=0;
            areaL++;
        }
        else{
            areaC++;
        }
    }

    void geraPrimeiraArea() {
        Areas.add(new Area(GameData));
    }
    
    void geraProximaArea()
    {
        Areas.add(new Area(GameData));
    }

}
