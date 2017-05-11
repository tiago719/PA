/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.AwaitCardCardSelectionOnCurrentColumn;
import LogicaJogo.States.IStates;
import java.io.Serializable;

/**
 *
 * @author edu_f
 */
public class Fire extends Spell implements Serializable{
    
    public Fire(GameData g) {
        super(g);
    }
    
    @Override
    public String nome()
    {
        return "Fire";
    }
    
    @Override
    public String toString(){
        return "Fireball  Spell: In  combat,  inict 8  damage  to  a  Monster";
    }

    @Override
    public IStates Efeito(GameData g, IStates s) {
        if (!g.getMonstroAlvo().Deffend(8))
        {
            return s;
        }
        else
        {
            g.getCaverna().getAreaAtual().setMonsterDefeated(true);
            g.getMonstroAlvo().addRwd();
            getGame().getCaverna().getAreaAtual().proxColuna();//TODO: ACHO QUE NAO PASSA AQUI (TESTAR)
            return new AwaitCardCardSelectionOnCurrentColumn(g);
        }
    }
    
    
}
