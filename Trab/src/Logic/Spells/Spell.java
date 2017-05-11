/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.IStates;
import java.io.Serializable;

/**
 *
 * @author edu_f
 */
public abstract class Spell implements Serializable {
    private final GameData gd;

    public Spell(GameData g) {
        gd = g;
    }
    
    public abstract String nome();
   
    public abstract IStates Efeito(GameData g, IStates s);
    
    public GameData getGame()
    {
        return gd;
    }
    
}
