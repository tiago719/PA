/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.Monster;
import Logic.Spells.Spell;
import LogicaJogo.States.AwaitBegining;
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

    public boolean AnyCritical() {
        return gameData.AnyCritical();
    }

    public ArrayList<Dado> getDados() {
        return gameData.getDados();
    }

    public Dado getDado(int i) {
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

    public boolean AOS_TraidingSelection(int i) {
        switch (i) {
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
        if (gameData.getDados().size() < c || c <= 0)
            return false;
        
        Dado temp = gameData.getDado(c - 1);
        if (temp.getFace() != 6) {
            return false;
        }
        gameData.getDado(c - 1).lancaDado();
        return true;
    }

    // 1 sucesso
    // -1 feated
    // -2 gameOver
    // -3 nao tem xp
    public int AA_Feat(int d, int custo) {
        Dado temp = gameData.getDado(d - 1);

        if (temp.getFeated()) {
            return -1;
        }

        switch (custo) {
            case 1:
                if (!gameData.getPersonagem().loseHp(2)) {
                    return -2;
                }
                break;
            case 2:
                if (!gameData.getPersonagem().addXP(-1)) {
                    return -3;
                }
                break;
        }

        gameData.getDado(d - 1).setFeated(true);
        gameData.getDado(d - 1).lancaDado();
        return 1;
    }

    public Monster getMonstroAlvo() {
        return gameData.getMonstroAlvo();
    }

    public ArrayList<Spell> getSpells() {
        return gameData.getPersonagem().getSpells();
    }

    //retorna true se morreu, false se nao morreu
    public boolean AS_ChooseSpell(int c) {
        switch (c) {
            case -1:
                //TODO: menssagem de erro
                break;
            case 0:
                //TODO: sem spells
                break;
            default:
                getSpells().get(c - 1).Efeito(gameData, state);
                getSpells().remove(c - 1);

        }
        if (getMonstroAlvo().getHp() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
