/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.Carta;
import LogicaJogo.States.IStates;
import java.util.ArrayList;
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
    
    public ArrayList<Carta> getBaralhoAreaAtual(){
        return GameModel.getBaralhoAreaAtual();
    }

    public IStates getState()
    {
        return GameModel.getState();
    }

    // Methods retrieve data from the game
    
    public int getSizeBaralho()
    {
        return GameModel.getSizeBaralho();
    }
    
    public ArrayList<Carta> getCartasColuna()
    {
        return GameModel.getCartasColuna();
    }
    
    public int getNumColunaAtual() {
        return GameModel.getColuna();
    }
    
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
