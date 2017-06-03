/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.AwaitBattleOption;
import LogicaJogo.States.IStates;
import java.io.Serializable;

/**
 *
 * @author edu_f
 */
public class Healing extends Spell implements Serializable{
    
    public Healing(GameData g) {
        super(g);
    }
    
    @Override
    public String nome()
    {
        return "Healing";
    }
    
    @Override
    public String toString(){
        return "Healing  Spell: Gain  8  HP  in  Combat  or  before  resolving  a  Room  card";
    }

    @Override
    public int Efeito() {
        getGame().getPersonagem().addHealth(8);
        return 2;
    }
    
    
}
