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
public class AwaitBegining extends StateAdapter implements IStates
{
    
    public AwaitBegining(GameData g){
        super(g);
    }
    

    @Override
    public IStates setStartingArea(int area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates setDifficultLevel(int level) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates start() {
        if (getGame().intialize())
        {
            return new AwaitCardCardSelectionOnCurrentColumn(getGame());
        }
        return this;

    }

}
