package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.AwaitBattleOption;
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
    public int Efeito() {
        if (!getGame().getMonstroAlvo().Deffend(8))
        {
            return 1;//monstro ataca
        }
        else//se morre
        {
            getGame().getPersonagem().setPoison(false);
            getGame().getCaverna().getAreaAtual().setMonsterDefeated(true);
            return 2;//addRwd
            
        }
    }
    
    
}
