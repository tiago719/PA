/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.Dado;
import Logic.GameData;

/**
 *
 * @author Tiago Coutinho
 */
public class StateAdapter implements IStates {

    private GameData game;

    public StateAdapter(GameData g) {
        this.game = g;
    }

    public GameData getGame() {
        return game;
    }

    public void setGame(GameData game) {
        this.game = game;
    }

    @Override
    public IStates setStartingArea(int area) {
        return this;
    }

    @Override
    public IStates setDifficultLevel(int level) {
        return this;
    }

    @Override
    public IStates start() {
        return this;
    }

    @Override
    public IStates ResolveSelectedRestingCard() {
        return this;
    }
    
    @Override
    public IStates ResolveSelectedTreasureCard() {
        return this;
    }
    
    @Override
    public IStates ResolveSelectedMerchantCard() {
        return this;
    }

    @Override
    public IStates OptionSelected() {
        return this;
    }
    
     @Override
    public IStates skipMerchant() {
        return this;
    }

    @Override
    public IStates ResolveSelectedEventCard()
    {
        return this;
    }

    @Override
    public IStates ResolveSelectedTrapCard()
    {
        return this;
    }

    @Override
    public boolean skillCheck()
    {
        return false;
    }

    @Override
    public IStates ResvolveSelectedMonsterCard()
    {
        return this;
    }

    @Override
    public IStates Feats() {
        return this;
    }

    @Override
    public IStates AtacaMonstro() {
        return this;
    }

    @Override
    public IStates ReturnAwaitAttack() {
        return this;
    }

    @Override
    public IStates AttackMontser() {
        return this;
    }

    @Override
    public IStates GameOver()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates VoltaAwaitAttack()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
