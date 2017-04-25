/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.Dado;

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
    IStates ResolveSelectedEventCard();
    
    //trap
    IStates ResolveSelectedTrapCard();
    
    //combat
    IStates relancarDado(Dado dado);
    
    boolean skillCheck();


}
