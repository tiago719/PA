/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.GameData;
import LogicaJogo.States.IStates;
import java.io.Serializable;

/**
 *
 * @author edu_f
 */
public abstract class Carta implements Serializable{
    protected final GameData gd;

    public Carta(GameData g) {
        gd = g;
    }
    
    public GameData getGame()
    {
        return gd;
    }

    public abstract int getHP();
    
    public abstract void setHP(int hp);
    
    public abstract boolean Deffend(int soma);
    
    public abstract int getDmg();

    public abstract IStates addRwd();
    
    public abstract String infoCarta();
}
