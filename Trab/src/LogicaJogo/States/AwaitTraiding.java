/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.GameData;
import java.io.Serializable;

/**
 *
 * @author edu_f
 */
public class AwaitTraiding extends StateAdapter implements IStates, Serializable
{
    public AwaitTraiding(GameData g){
        super(g);
    }
    
    @Override
    public IStates skipMerchant()
    {
        if(!getGame().getCaverna().getAreaAtual().proxColuna())
            return new GameOver(getGame());
        
        return new AwaitCardSelectionOnCurrentColumn(getGame());
    }
      @Override
    public IStates BuySellMerchant(int i) {
        switch (i) {
            case 1:
                getGame().getPersonagem().buyRation();
                break;
            case 2:
                getGame().getPersonagem().buyPotion();
                break;
            case 3:
                getGame().getPersonagem().buyBigPotion();
                break;
            case 4:
                getGame().getPersonagem().buyArmor();
                break;
            case 5:
                getGame().getPersonagem().buyAnySpell();
                break;
            case 6:
                getGame().getPersonagem().sellArmor();
                break;
            case 7:
                getGame().getPersonagem().sellAnySpell();
                break;
        }
        return new AwaitTraiding(getGame());
    }
    
}
