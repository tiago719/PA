/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.Carta;
import LogicaJogo.States.AwaitCardCardSelectionOnCurrentColumn;
import LogicaJogo.States.IStates;
import java.util.ArrayList;
import Logic.Spells.*;


/**
 *
 * @author Tiago Coutinho
 */
public class GameData implements Constants {

    private int dificuldade, startingArea, coluna;
    private final Personagem Personagem;
    //private Monster MonstroAlvo;
    //private BossMonster BossMonstroAlvo;
    private final Caverna Caverna;
    private ArrayList<Dado> dados;
    private Carta MonstroAlvo;


    public GameData() {
        startingArea = 1;
        dificuldade = 2;
        coluna = 1;
        Personagem = new Personagem(dificuldade, this);
        Caverna = new Caverna(startingArea, this);
        //MonstroAlvo = null;
        //BossMonstroAlvo=null;
        dados = new ArrayList<>();
        dados.add(new Dado());
        MonstroAlvo=null;
    }
/*
    public Monster getMonstroAlvo() {
        return MonstroAlvo;
    }

    public void setMonstroAlvo(Monster MonstroAlvo) {
        this.MonstroAlvo = MonstroAlvo;
    }*/

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
    
    public void addDado(){
         dados.add(new Dado());
    }
        
    public Carta getMonstroAlvo()
    {
        return MonstroAlvo;
    }
    
    public void setMonstroAlvo(Carta c)
    {
        this.MonstroAlvo=c;
    }
    
    public IStates Treasure(){
        int ran = 1 + (int)(Math.random() * ((6 - 1) + 1));
        if (Caverna.getAreaAtual().getMonsterDefeated()) {
            Personagem.addGold(2);
        } else {
            Personagem.addGold(1);
        }

        switch (ran) {
            case 1:
               Personagem.addArmor(1);
                break;
            case 2:
               Personagem.addXP(2);
                break;
            case 3:
                Personagem.addSpell(new Fire(this));
                break;
            case 4:
                Personagem.addSpell(new Ice(this));
                break;
            case 5:
                Personagem.addSpell(new Poison(this));
                break;
            case 6:
                Personagem.addSpell(new Healing(this));
                break;
        }
        proxColuna();
        
        return new AwaitCardCardSelectionOnCurrentColumn(this);
    }
    
    
/*
    void setMonster(Monster M) {
        MonstroAlvo= M;
    }
    
    void setBossMonster(BossMonster BM)
    {
        BossMonstroAlvo=BM;
    }*/
}
