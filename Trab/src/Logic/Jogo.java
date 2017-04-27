/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.Monster;
import Logic.Caverna;
import static Logic.Constants.*;
import Logic.Spells.Spell;
import LogicaJogo.States.AwaitBegining;
import LogicaJogo.States.AwaitFeats;
import LogicaJogo.States.AwaitSpellChoose;
import LogicaJogo.States.IStates;
import java.util.ArrayList;

/**
 *
 * @author Tiago Coutinho
 */
public class Jogo {

    private GameData gameData;
    private IStates state;

    public Jogo() {
        gameData = new GameData();
        state = new AwaitBegining(gameData);
    }

    public GameData getGame() {
        return gameData;
    }

    public IStates getState() {
        return state;
    }

    public void setDifficultLevel(Integer valueOf) {
        gameData.setDificuldade(valueOf);
    }

    public void setStartingArea(int valueOf) {
        gameData.setStartingArea(valueOf);
    }

    public void setState(IStates s) {
        state = s;
    }
    
    public boolean AnyCritical()
    {
        return gameData.AnyCritical();
    }
    
    public ArrayList<Dado> getDados()
    {
        return gameData.getDados();
    }
    
    public Dado getDado(int i){
        return gameData.getDados().get(i);
    }
    
    
    public boolean AOS_OptionSelected(int i) {
        switch (i) {
            case 1:
                return getGame().getPersonagem().addXP(1);
            case 2:
                return getGame().getPersonagem().addFood(1);
            case 3:
                return getGame().getPersonagem().addHealth(2);

        }
        return false;
    }
    
    public boolean AOS_TraidingSelection(int i)
    {
        switch(i)
        {
            case 1:
                return getGame().getPersonagem().buyRation();
            case 2:
                return getGame().getPersonagem().buyPotion();
            case 3:
                return getGame().getPersonagem().buyBigPotion();
            case 4:
                return getGame().getPersonagem().buyArmor();
            case 5:
                return getGame().getPersonagem().buyAnySpell();
            case 6:
                return getGame().getPersonagem().sellArmor();
            case 7:
                return getGame().getPersonagem().sellAnySpell();
        }
        return false;
    }

    public void OptionSelected(IStates s) {
        state = s;
    }

    public void setMonster() {
        gameData.setMonster();
    }

    public boolean AA_Reroll(int c) {
        Dado temp = gameData.getDado(c-1);
        if (temp.getFace()!=6)
            return false;
        gameData.getDado(c-1).lancaDado();
        return true;
    }

    public Monster getMonstroAlvo() {
        return gameData.getMonstroAlvo();
    }

    public ArrayList<Spell> getSpells() {
        return gameData.getPersonagem().getSpells();
    }

    public void AS_ChooseSpell(int c) {
        //TODO: CONTINUAR AQUI
    }
    
    

}
