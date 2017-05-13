/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.Cartas.Carta;

/**
 *
 * @author edu_f
 */
public interface IStates {
    //  Await beginning
    IStates setStartingArea(int area);
    IStates setDifficultLevel(int level);
    IStates start();
    
    //Resting Card
    IStates ResolveSelectedRestingCard();
    IStates OptionSelected();
    
    //treasure
    IStates ResolveSelectedTreasureCard();

    //merchant
    IStates ResolveSelectedMerchantCard();
    IStates skipMerchant();
    
    //event
    IStates ResolveSelectedEventCard(Carta c);
    
    //trap
    IStates ResolveSelectedTrapCard();
    
    //monster
    IStates ResolveSelectedMonsterCard(Carta c);
    
    //bossMonster
    //IStates ResolveSelectedBossMonsterCard(Carta c);
    
    boolean skillCheck();
    
    //attack
    IStates Feats();
    IStates AtacaMonstro();
            
    //feats
    IStates VoltaAwaitAttack();
            
    //spells
    //IStates EndBattle();
    IStates ProxRonda();

    IStates GameOver();

}
