package Logic.Spells;

import Logic.GameData;
import LogicaJogo.States.IStates;
import java.io.Serializable;

public abstract class Spell implements Serializable {
    private final GameData gd;

    public Spell(GameData g) {
        gd = g;
    }
    
    public abstract String nome();
   
    public abstract IStates Efeito(GameData g, IStates s);
    
    public GameData getGame()
    {
        return gd;
    }
    
}
