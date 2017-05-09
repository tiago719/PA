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
public class AwaitBegining extends StateAdapter implements IStates, Serializable
{
    
    public AwaitBegining(GameData g){
        super(g);
    }
    

    @Override
    public IStates setStartingArea(int area) {
        getGame().setStartingArea(area);
        return this;
    }

    @Override
    public IStates setDifficultLevel(int level) {
        getGame().setDificuldade(level);
        return this;
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
