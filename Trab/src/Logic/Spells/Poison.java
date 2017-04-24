/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Spells;

import Logic.GameData;

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
    public void Efeito(GameData g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
