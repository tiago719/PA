/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.AwaitAttack;
import LogicaJogo.States.IStates;

/**
 *
 * @author edu_f
 */
public class Ice extends Spell {

    public Ice(GameData g) {
        super(g);
    }

    @Override
    public String toString() {
        return "Ice  Spell: In  combat,  freeze  a  Monster  for  one  turn.  The  Monster  does  not  counter­attack.";
    }

    @Override
    public IStates Efeito(GameData g, IStates s) {
        return new AwaitAttack(g);
    }

}
