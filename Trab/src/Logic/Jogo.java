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
    
    public Jogo()
    {
        gameData=new GameData();
        state = new AwaitBegining(gameData);
    }
    
    public GameData getGame()
    {
        return gameData;
    }
    
    public IStates getState()
    {
        return state;
    }

    public void setDifficultLevel(Integer valueOf) {
        gameData.setDificuldade(valueOf);
    }

    public void setStartingArea(Integer valueOf) {
        gameData.setStartingArea(valueOf);
    }

    public void startGame(IStates s) {
        state = s;
    }
}
