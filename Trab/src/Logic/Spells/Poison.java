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
public class Poison extends Spell{
    
    public Poison(GameData g) {
        super(g);
    }
    
    @Override
    public String toString(){
        return "Poison  Spell: In  Combat,  for  the  remainder  of  the  Combat  sequence,  inict 5  extra  damage  per  turn";
    }

    @Override
    public IStates Efeito(GameData g, IStates s) {
        g.getMonstroAlvo().setPoison(true);
        return s;
    }
    
    
}
