/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.IStates;

/**
 *
 * @author edu_f
 */
public abstract class Spell {
    private final GameData gd;

    public Spell(GameData g) {
        gd = g;
    }
    
    public abstract IStates Efeito(GameData g, IStates s);
    
}
