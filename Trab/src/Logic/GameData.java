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
public class GameData implements Constants {

    private int dificuldade, startingArea, coluna;
    private final Personagem Personagem;
    private final Caverna Caverna;


    public GameData() {
        startingArea = 0;
        dificuldade = 2;
        coluna = 1;
        Personagem = new Personagem(dificuldade);
        Caverna = new Caverna(startingArea, this);
        
    }

   
    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
        Personagem.setStats(dificuldade);
    }

    public int getStartingArea() {
        return startingArea;
    }

    public void setStartingArea(int startingArea) {
        this.startingArea = startingArea;
        Caverna.setArea(startingArea);
    }

    void setStartingArea(Integer area) {
        startingArea = area;
    }

    public boolean intialize() {
        Caverna.geraAreas(startingArea);
        return true;
    }

    public int getColuna() {
        return coluna;
    }
    

    public Caverna getCaverna() {
        return Caverna;
    }

    public Personagem getPersonagem() {
        return Personagem;
    }
}
