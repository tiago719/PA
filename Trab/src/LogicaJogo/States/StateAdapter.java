/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.Cartas.Carta;
import Logic.Caverna;
import Logic.GameData;
import Logic.Spells.Fire;
import Logic.Spells.Healing;
import Logic.Spells.Ice;
import Logic.Spells.Poison;
import java.io.Serializable;

/**
 *
 * @author Tiago Coutinho
 */
public class StateAdapter implements IStates, Serializable{

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
        int ran = 1 + (int)(Math.random() * ((6 - 1) + 1));
        if (getGame().getCaverna().getAreaAtual().getMonsterDefeated()) {
            getGame().getPersonagem().addGold(2);
        } else {
            getGame().getPersonagem().addGold(1);
        }

        switch (ran) {
            case 1:
                getGame().getPersonagem().addArmor(1);
                break;
            case 2:
                getGame().getPersonagem().addXP(2);
                break;
            case 3:
                getGame().getPersonagem().addSpell(new Fire(getGame()));
                break;
            case 4:
                getGame().getPersonagem().addSpell(new Ice(getGame()));
                break;
            case 5:
                getGame().getPersonagem().addSpell(new Poison(getGame()));
                break;
            case 6:
                getGame().getPersonagem().addSpell(new Healing(getGame()));
                break;
        }
        if(!getGame().getCaverna().getAreaAtual().proxColuna())
            return new GameOver(getGame());
        
        return new AwaitCardSelectionOnCurrentColumn(getGame());
    }
    
    @Override
    public IStates ResolveSelectedMerchantCard() {
        return this;
    }

    @Override
    public IStates OptionSelected(int i) {
        return this;
    }
    
     @Override
    public IStates skipMerchant() {
        return this;
    }

    @Override
    public IStates ResolveSelectedEventCard(Carta c)
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
    public IStates Feats() {
        return this;
    }

    @Override
    public IStates AtacaMonstro() {
        return this;
    }

//    @Override
//    public IStates EndBattle() {
//        return this;
//    }

    @Override
    public IStates ProxRonda() {
        return this;
    }
    
    @Override
    public IStates GameOver()
    {
        return this;
    }

    @Override
    public IStates VoltaAwaitAttack()
    {
        return this;
    }

    @Override
    public IStates ResolveSelectedMonsterCard(Carta c) {
       return this;
    }

//    @Override
//    public IStates ResolveSelectedBossMonsterCard(Carta c) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public IStates BuySellMerchant(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates FeatSelected(int d, int custo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates ChooseSpell(int c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    // 0 - morto 
    // 1 - column selection
    // 2 - treasure
    public IStates DecideState(int c) {
        switch (c){
            case 0:
                return new GameOver(getGame());
                
            case 1:
                return new AwaitCardSelectionOnCurrentColumn(getGame());
                
            case 2:
                return Treasure();
        }
        return new AwaitCardSelectionOnCurrentColumn(getGame());
    }
    
    public IStates Treasure() {
        int ran = 1 + (int) (Math.random() * ((6 - 1) + 1));
        getGame().addMsg("Resultado do lancamento do dado: " + ran + "\n");

        if (getGame().getCaverna().getAreaAtual().getMonsterDefeated()) {
            getGame().addMsg("Como ja derrotaste um monstro nesta ronda recebes 2 de Gold\n");
            getGame().getPersonagem().addGold(2);
        } else {
            getGame().addMsg("Como ainda nao derrotaste um monstro nesta ronda recebes apenas 1 de Gold\n");
            getGame().getPersonagem().addGold(1);
        }

        switch (ran) {
            case 1:
                getGame().getPersonagem().addArmor(1);
                getGame().addMsg("Recebeste 1 Armor\n");
                break;
            case 2:
                getGame().getPersonagem().addXP(2);
                getGame().addMsg("Recebeste 2 XP\n");
                break;
            case 3:
                getGame().getPersonagem().addSpell(new Fire(getGame()));
                getGame().addMsg("Recebeste o spell Fire\n");
                break;
            case 4:
                getGame().getPersonagem().addSpell(new Ice(getGame()));
                getGame().addMsg("Recebeste o spell Ice\n");
                break;
            case 5:
                getGame().getPersonagem().addSpell(new Poison(getGame()));
                getGame().addMsg("Recebeste o spell Poison\n");
                break;
            case 6:
                getGame().getPersonagem().addSpell(new Healing(getGame()));
                getGame().addMsg("Recebeste o spell Healing\n");
                break;
        }
        if (!getGame().getCaverna().getAreaAtual().proxColuna()) {
            return new GameOver(getGame());
        }

        return new AwaitCardSelectionOnCurrentColumn(getGame());
    }

    @Override
    public IStates VoltaInicio() {
        getGame().setDificuldade(2);
        getGame().setCaverna(new Caverna(1, getGame()));
        return new AwaitBegining(getGame());
    }

}
