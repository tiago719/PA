/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Caverna;
import static Logic.Constants.*;
import LogicaJogo.States.AwaitBegining;
import LogicaJogo.States.IStates;

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

    public void startGame(IStates s) {
        state = s;
    }

    public void ResolveRestingCard(IStates s) {
        state = s;
    }
    
    public void ResolveTreasureCard(IStates s) {
        state = s;
    }
    
     public void ResolveMerchantCard(IStates s) {
        state = s;
    }

    public boolean AOS_OptionSelection(int i) {
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
                System.out.println("FALTA FAZER");//TODO
                return false;
            case 6:
                return getGame().getPersonagem().sellArmor();
            case 7:
                System.out.println("FALTA FAZER");//TODO
                return false;
        }
        return false;
    }

    public void OptionSelected(IStates s) {
        state = s;
    }

}
