/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.GameData;

/**
 *
 * @author Tiago Coutinho
 */
public class GameOver extends StateAdapter implements IStates
{
    public GameOver(GameData g)
    {
        super(g);
    }
}
