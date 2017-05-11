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
public class Poison extends Spell implements Serializable{
    
    public Poison(GameData g) {
        super(g);
    }
    
    @Override
    public String nome()
    {
        return "Poison";
    }
    @Override
    public String toString(){
        return "Poison  Spell: In  Combat,  for  the  remainder  of  the  Combat  sequence,  inict 5  extra  damage  per  turn";
    }

    @Override
    public IStates Efeito(GameData g, IStates s) {
        g.getPersonagem().setPoison(true);
        return s;
    }
    
    
}
