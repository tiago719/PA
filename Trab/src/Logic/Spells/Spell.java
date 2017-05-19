package Logic.Spells;

import Logic.Dado;
import Logic.GameData;
import LogicaJogo.States.AwaitAttack;
import LogicaJogo.States.GameOver;
import LogicaJogo.States.IStates;
import java.io.Serializable;

public abstract class Spell implements Serializable {
    private final GameData gd;

    public Spell(GameData g) {
        gd = g;
    }
    
    public abstract String nome();
   
    public abstract int Efeito();
    
    public GameData getGame()
    {
        return gd;
    }
    
//    public IStates MonstroAtaca(){
//        return gd.MonstroAtaca();
//    }

    
}
