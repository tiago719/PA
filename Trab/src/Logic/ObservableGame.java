/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import LogicaJogo.States.IStates;
import java.util.Observable;

/**
 *
 * @author Tiago Coutinho
 */
public class ObservableGame extends Observable
{

    private Jogo GameModel;

    public ObservableGame()
    {
        GameModel = new Jogo();
    }

    public void setGameModel(Jogo gameModel)
    {
        this.GameModel = gameModel;

        setChanged();
        notifyObservers();
    }

    public GameData getGameData()
    {
        return GameModel.getGame();
    }

    public IStates getState()
    {
        return GameModel.getState();
    }

    // Methods retrieve data from the game
    
    //...
    
    // Methods that are intended to be used by the user interfaces and that are delegated in the current state of the finite state machine 
    public void startGame()
    {
        GameModel.comecar();

        setChanged();
        notifyObservers();
    }
    
    public void setDificultyLevel(int a)
    {
        
        GameModel.setDifficultLevel(a);
        
        setChanged();
        notifyObservers();
    }
    
    public void setStartingArea(int a)
    {
        GameModel.setStartingArea(a);

        setChanged();
        notifyObservers();
    }
    
    public void ResolveRestingCard(int a)
    {
        GameModel.RestingOptionSelected(a);

        setChanged();
        notifyObservers();
    }
    
}
