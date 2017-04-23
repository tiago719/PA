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
public class Ice extends Spell{
    
    public Ice(GameData g) {
        super(g);
    }
    
    @Override
    public String toString(){
        return "Ice  Spell: In  combat,  freeze  a  Monster  for  one  turn.  The  Monster  does  not  counter­attack.";
    }
    
    
}
