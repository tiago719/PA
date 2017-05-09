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
public class GameOver extends StateAdapter implements IStates, Serializable
{
    public GameOver(GameData g)
    {
        super(g);
    }
}
