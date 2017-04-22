/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.GameData;
import javax.smartcardio.Card;

/**
 *
 * @author edu_f
 */
public class AwaitCardCardSelectionOnCurrentColumn extends StateAdapter implements IStates{
    public AwaitCardCardSelectionOnCurrentColumn(GameData g){
        super(g);
    }    
    
    @Override
    public IStates ResolveSelectedRestingCard() {
        return new AwaitOptionSelection(getGame());
    }
    
    @Override
    public IStates ResolveSelectedTreasureCard()
    {
        if(getGame().getCaverna().getAreaAtual().getMonsterDefeated())
        {
            getGame().getPersonagem().addGold(2);
        }
        else
        {
            getGame().getPersonagem().addGold(1);
        }
        
        return this;
        //TODO: falta o resto
    }

    @Override
    public IStates OptionSelected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
