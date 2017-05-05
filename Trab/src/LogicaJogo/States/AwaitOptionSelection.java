/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.GameData;

/**
 *
 * @author edu_f
 */
public class AwaitOptionSelection extends StateAdapter implements IStates{

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
    public IStates OptionSelected() {
        getGame().proxColuna();
        return new AwaitCardCardSelectionOnCurrentColumn(getGame());
    }
    
}
