package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.IStates;
import java.io.Serializable;

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
        return "Fire  Spell: In  combat,  inict 8  damage  to  a  Monster";
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
            return g.getMonstroAlvo().addRwd();
        }
    }
    
    
}
