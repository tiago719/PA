package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.AwaitAttack;
import LogicaJogo.States.IStates;
import java.io.Serializable;

public class Ice extends Spell implements Serializable{

    public Ice(GameData g) {
        super(g);
    }

    @Override
    public String nome()
    {
        return "Ice";
    }
    
    @Override
    public String toString() {
        return "Ice  Spell: In  combat,  freeze  a  Monster  for  one  turn.  The  Monster  does  not  counter­attack.";
    }

    @Override
    public IStates Efeito() {
        return new AwaitAttack(getGame());
    }

}
