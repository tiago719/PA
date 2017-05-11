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
        
        return new AwaitCardCardSelectionOnCurrentColumn(getGame());
    }
}
