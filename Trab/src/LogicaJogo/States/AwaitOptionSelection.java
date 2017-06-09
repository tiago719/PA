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
public class AwaitOptionSelection extends StateAdapter implements IStates, Serializable{

    public AwaitOptionSelection(GameData g) {
        super(g);
    }

//    public boolean ReinforceWeapon(){
//        return getGame().getPersonagem().addXP(1);
//
//    }
//    public boolean SearchRation(){
//        return getGame().getPersonagem().addFood(1);
//    }
//    
//    public boolean Heal(){
//        return getGame().getPersonagem().addHealth(2);
//    }

    @Override
    public IStates OptionSelected(int i) {
         switch (i) {
            case 1:
                getGame().getPersonagem().addXP(1);
                break;
            case 2:
                getGame().getPersonagem().addFood(1);
                break;
            case 3:
                getGame().getPersonagem().addHealth(2);
                break;

        }
        
        
        if(!getGame().getCaverna().getAreaAtual().proxColuna())
            return new GameOver(getGame());
        
        return new AwaitCardSelectionOnCurrentColumn(getGame());
    }
    
}
