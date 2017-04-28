/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.Monster;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public class GameData implements Constants {

    private int dificuldade, startingArea, coluna;
    private final Personagem Personagem;
    private Monster MonstroAlvo;
    private final Caverna Caverna;
    private ArrayList<Dado> dados;


    public GameData() {
        startingArea = 1;
        dificuldade = 2;
        coluna = 1;
        Personagem = new Personagem(dificuldade, this);
        Caverna = new Caverna(startingArea, this);
        MonstroAlvo = null;
        dados = new ArrayList<>();
        dados.add(new Dado());
    }

    public Monster getMonstroAlvo() {
        return MonstroAlvo;
    }

    public void setMonstroAlvo(Monster MonstroAlvo) {
        this.MonstroAlvo = MonstroAlvo;
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
        Caverna.geraPrimeiraArea();
        return true;
    }

    public int getColuna() {
        return coluna;
    }

    public void proxColuna() {
        int ultimaColuna = 4;
        if (Caverna.isLastArea())
            ultimaColuna = 5;


        if (coluna < ultimaColuna) {
            coluna++;
        } else {
            coluna = 1;
            Caverna.proxArea();
        }
    }

    public Caverna getCaverna() {
        return Caverna;
    }

    public Personagem getPersonagem() {
        return Personagem;
    }
    
    public boolean AnyCritical(){
        for (Dado d : dados)
            if (d.getFace() == 6)
                return true;
        return false;
    }
    
    public ArrayList<Dado> getDados(){
        return dados;
    }
    
    public Dado getDado(int i){
        return dados.get(i);
    }

    void setMonster() {
        MonstroAlvo = new Monster(this);
    }
}
