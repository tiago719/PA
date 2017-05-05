/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.BossMonster;
import Logic.Cartas.Carta;
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
        setState(new AwaitBegining(gameData));
    }

    public GameData getGame() {
        return gameData;
    }

    public IStates getState() {
        return state;
    }
    
    public void setState(IStates s) {
        state = s;
    }

    // Methods that are intended to be used by the user interfaces and that are delegated in the current state of the finite state machine 
    
    public void setDifficultLevel(Integer valueOf) {
        setState(getState().setDifficultLevel(valueOf));
    }

    public void setStartingArea(int valueOf) {
        setState(getState().setStartingArea(valueOf));
    }
    
    public void comecar()
    {
        setState(getState().start());
    }
    
    public void RestingOptionSelected() {
        setState(getState().OptionSelected());
    }
    
    public void MerchantOptionSelected()
    {
        setState(getState().skipMerchant());
    }
    
    public void AtacaMonstro()
    {
        setState(getState().AtacaMonstro());
    }
    
    public void Feats()
    {
        setState(getState().Feats());
    }
    
    public void VoltaAwaitAttack()
    {
        setState(getState().VoltaAwaitAttack());
    }
    
    public void GameOver()
    {
        setState(getState().GameOver());
    }
    
    public void EndBatle()
    {
        setState(getState().EndBattle());
    }
    
    public void ProxRonda()
    {
        setState(getState().ProxRonda());
    }
        public void treasure()
    {
        setState(getState().ResolveSelectedTreasureCard());
    }
    
    public void event(Carta c)
    {
        setState(getState().ResolveSelectedEventCard(c));
    }
    
    public void trap()
    {
        setState(getState().ResolveSelectedTrapCard());
    }
    
    public void monster(Carta c)
    {
        setState(getState().ResolveSelectedMonsterCard(c));
    }
    
    public void merchant()
    {
        setState(getState().ResolveSelectedMerchantCard());
    }   
    
    public void resting()
    {
        setState(getState().ResolveSelectedRestingCard());
    }
    

   /* public void setMonster(Monster M) {
        gameData.setMonster(M);
    }*/

    // Methods retrieve data from the game
    
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
                if (!gameData.getPersonagem().TradeXpForFeat()) {
                    return -3;
                }
                break;
        }

        gameData.getDado(d - 1).setFeated(true);
        gameData.getDado(d-1).clearSomatorio();
        gameData.getDado(d - 1).lancaDado();
        return 1;
    }
/*
    public Monster getMonstroAlvo() {
        return gameData.getMonstroAlvo();
    }*/

    public ArrayList<Spell> getSpells() {
        return gameData.getPersonagem().getSpells();
    }


    
    public Personagem getPersonagem()
    {
        return gameData.getPersonagem();
    }
    
    public Carta getMonstroAlvo()
    {
        return gameData.getMonstroAlvo();
    }
    
    public ArrayList<Carta> getCartasColuna()
    {
        return gameData.getCaverna().getAreaAtual().getCartasColuna();
    }
    
    public boolean AS_ChooseSpell(int c)
    {
        return gameData.AS_ChooseSpell(c, state);
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

    //TODO: QUANDO NAO PODE ADICIONAR MAIS XP(POR EXEMPLO) ADICIONA 1 HP, CRIAR MSG AVISAR USER
    public void AOS_OptionSelected(int i) {
        switch (i) {
            case 1:
                gameData.getPersonagem().addXP(1);
            case 2:
                gameData.getPersonagem().addFood(1);
            case 3:
                gameData.getPersonagem().addHealth(2);

        }
    }

    public boolean AOS_TraidingSelection(int i) {
        switch (i) {
            case 1:
                return gameData.getPersonagem().buyRation();
            case 2:
                return gameData.getPersonagem().buyPotion();
            case 3:
                return gameData.getPersonagem().buyBigPotion();
            case 4:
                return gameData.getPersonagem().buyArmor();
            case 5:
                return gameData.getPersonagem().buyAnySpell();
            case 6:
                return gameData.getPersonagem().sellArmor();
            case 7:
                return gameData.getPersonagem().sellAnySpell();
        }
        return false;
    }

    
}


