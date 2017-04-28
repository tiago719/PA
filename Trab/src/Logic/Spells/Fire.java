/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.AwaitCardCardSelectionOnCurrentColumn;
import LogicaJogo.States.IStates;

/**
 *
 * @author edu_f
 */
public class Fire extends Spell{
    
    public Fire(GameData g) {
        super(g);
    }
    
    @Override
    public String toString(){
        return "Fireball  Spell: In  combat,  inict 8  damage  to  a  Monster";
    }

    @Override
    public IStates Efeito(GameData g, IStates s) {
        if (g.getMonstroAlvo().Deffend(8))
            return new AwaitCardCardSelectionOnCurrentColumn(g);
        
        return s;
            
    }
    
    
}
