/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Tiago Coutinho
 */
public class GameData implements Constants{
    private int dificuldade, startingArea, armor, hp, gold, food, rank, areaAtual, coluna;
    
    public GameData()
    {
        rank = 0;
        startingArea=0;
        dificuldade=2;
        coluna=1;
        armor = NivelDificuldade[dificuldade-1][0];
        hp = NivelDificuldade[dificuldade-1][1];
        gold = NivelDificuldade[dificuldade-1][2];
        food = NivelDificuldade[dificuldade-1][3];
    }

    void setDifficultLevel(Integer dificuldade) {
        this.dificuldade = dificuldade;
        armor = NivelDificuldade[dificuldade-1][0];
        hp = NivelDificuldade[dificuldade-1][1];
        gold = NivelDificuldade[dificuldade-1][2];
        food = NivelDificuldade[dificuldade-1][3];
    }

    void setStartingArea(Integer area) {
        startingArea = area;
    }

    public boolean intialize() {
        //TODO: iniciar variaveis necessarias (para agora nao estou a ver nenhuma)
        return true;
    }
    
    public int getNivel()
    {
        for(int i=0;i<MapaNiveis.length;i++)
        {
            for(int j=0;j<MapaNiveis[i].length;j++)
            {
                if(MapaNiveis[i][j]==areaAtual)
                {
                    return i+1;
                }
            }
        }
        return -1;
    }
    
    public int getArea()
    {
        return areaAtual;
    }
    
    public int getColuna()
    {
        return coluna;
    }
}
