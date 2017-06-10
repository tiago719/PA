/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.Carta;
import Logic.Spells.Spell;
import LogicaJogo.States.IStates;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Tiago Coutinho
 */
public class ObservableGame extends Observable {

    private Jogo GameModel;

    public ObservableGame() {
        GameModel = new Jogo();
    }

    public void setGameModel(Jogo gameModel) {
        this.GameModel = gameModel;

        setChanged();
        notifyObservers();
    }

    public GameData getGameData() {
        return GameModel.getGame();
    }

    public ArrayList<Carta> getBaralhoAreaAtual() {
        return GameModel.getBaralhoAreaAtual();
    }

    public IStates getState() {
        return GameModel.getState();
    }

    // Methods retrieve data from the game
    public int getSizeBaralho() {
        return GameModel.getSizeBaralho();
    }

    public ArrayList<Carta> getCartasColuna() {
        return GameModel.getCartasColuna();
    }

    public boolean hasHeal() {
        return GameModel.hasHeal();
    }

    public boolean AnyCritical() {
        return GameModel.AnyCritical();
    }

    public ArrayList<Dado> getDados() {
        return GameModel.getDados();
    }


    public Dado getDado(int index) {
        return GameModel.getDado(index);
    }
  
    public ArrayList<Spell> getSpells()
    {
        return GameModel.getSpells();
    }

    public int getNumColunaAtual() {
        return GameModel.getColuna();

    }

    public boolean isLastArea() {
        return GameModel.isLastArea();

    }

    
    // Methods that are intended to be used by the user interfaces and that are delegated in the current state of the finite state machine 
    public void startGame() {
        GameModel.comecar();

        setChanged();
        notifyObservers();
    }

    public void setDificultyLevel(int a) {

        GameModel.setDifficultLevel(a);

        setChanged();
        notifyObservers();
    }

    public void setStartingArea(int a) {
        GameModel.setStartingArea(a);

        setChanged();
        notifyObservers();
    }

    public void SelectedRestingCard() {
        GameModel.resting();

        setChanged();
        notifyObservers();
    }

    public void SelectedMonsterCard(Carta c) {
        GameModel.monster(c);

        setChanged();
        notifyObservers();
    }

    public void SelectedBoosMonsterCard(Carta c) {
        GameModel.monster(c);

        setChanged();
        notifyObservers();
    }

    public void SelectedEventCard(Carta c) {
        GameModel.event(c);

        setChanged();
        notifyObservers();
    }

    public void SelectedMerchantCard() {
        GameModel.merchant();

        setChanged();
        notifyObservers();
    }

    public void SelectedTrapCard() {
        GameModel.trap();

        setChanged();
        notifyObservers();
    }

    public void SelectedTreasureCard() {
        GameModel.treasure();

        setChanged();
        notifyObservers();
    }

    public void ResolveRestingCard(int a) {
        GameModel.RestingOptionSelected(a);

        setChanged();
        notifyObservers();
    }

    public void MerchantOptionSelected(int option) {
        GameModel.MerchantOptionSelected(option);

        setChanged();
        notifyObservers();
    }

    public void AtacaMonstro() {
        GameModel.AtacaMonstro();

        setChanged();
        notifyObservers();
    }

    public void Feats() {
        GameModel.Feats();

        setChanged();
        notifyObservers();
    }

    public void FeatsOptionSelected(int indexDado, int custo) {
        GameModel.FeatsOptionSelected(indexDado, custo);

        setChanged();
        notifyObservers();
    }

    public void ReroolOptionSelected(int c) {
        GameModel.AA_Reroll(c);

        setChanged();
        notifyObservers();
    }

    public void ChooseSpell(int indexVetorSpells) {
        GameModel.ChooseSpell(indexVetorSpells);

        setChanged();
        notifyObservers();
    }

    public void GameOver() {
        GameModel.GameOver();

        setChanged();
        notifyObservers();
    }

}
