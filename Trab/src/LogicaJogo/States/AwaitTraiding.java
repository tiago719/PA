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
public class AwaitTraiding extends StateAdapter implements IStates
{
    public AwaitTraiding(GameData g){
        super(g);
    }
    
    @Override
    public IStates skipMerchant()
    {
        getGame().proxColuna();
        return new AwaitCardCardSelectionOnCurrentColumn(getGame());
    }
}
