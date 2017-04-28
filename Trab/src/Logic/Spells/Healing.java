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
public class Healing extends Spell{
    
    public Healing(GameData g) {
        super(g);
    }
    
    @Override
    public String toString(){
        return "Healing  Spell: Gain  8  HP  in  Combat  or  before  resolving  a  Room  card";
    }

    @Override
    public IStates Efeito(GameData g, IStates s) {
        g.getPersonagem().addHealth(8);
        return s;
    }
    
    
}
