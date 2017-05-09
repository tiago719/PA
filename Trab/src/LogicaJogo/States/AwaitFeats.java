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
 * @author Tiago Coutinho
 */
public class AwaitFeats extends StateAdapter implements IStates, Serializable
{
    public AwaitFeats(GameData g)
    {
        super(g);
    }
    
    @Override
    public IStates GameOver()
    {
        return new GameOver(getGame());
    }
    
    @Override
    public IStates VoltaAwaitAttack()
    {
        return new AwaitAttack(getGame());
    }
}
