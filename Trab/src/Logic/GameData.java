/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;


/**
 *
 * @author Tiago Coutinho
 */
public class GameData implements Constants {

    private int dificuldade, startingArea, coluna;
    private final Personagem p;
    private final Caverna c;


    public GameData() {
        startingArea = 0;
        dificuldade = 2;
        coluna = 1;
        p = new Personagem(dificuldade);
        c = new Caverna(startingArea, this);
        
    }

   
    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
        p.setStats(dificuldade);
    }

    public int getStartingArea() {
        return startingArea;
    }

    public void setStartingArea(int startingArea) {
        this.startingArea = startingArea;
    }

    void setStartingArea(Integer area) {
        startingArea = area;
    }

    public boolean intialize() {
        //TODO: iniciar variaveis necessarias (para agora nao estou a ver nenhuma)
        return true;
    }

    public int getColuna() {
        return coluna;
    }

    public Caverna getCaverna() {
        return c;
    }

    public Personagem getPersonagem() {
        return p;
    }
}
