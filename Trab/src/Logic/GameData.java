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
public class GameData implements Constants
{
    private int dificuldade, coluna;
    private final Personagem p;
    private final Caverna c;
    
    public GameData()
    {
        dificuldade=2;
        coluna=1;
        p=new Personagem(dificuldade);
        c=new Caverna();
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) 
    {
        this.dificuldade = dificuldade;
        p.setStats(dificuldade);
    }

    public void setStartingArea(int startingArea) 
    {
        c.setArea(startingArea);
    }

    public boolean intialize() 
    {
        //TODO: iniciar variaveis necessarias (para agora nao estou a ver nenhuma)
        return true;
    }
    
    public int getColuna()
    {
        return coluna;
    }
    
    public Caverna getCaverna()
    {
        return c;
    }
    
    public Personagem getPersonagem()
    {
        return p;
    }
}
