/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.GameData;
import LogicaJogo.States.IStates;

/**
 *
 * @author edu_f
 */
public abstract class Carta {
    protected final GameData gd;

    public Carta(GameData g) {
        gd = g;
    }

    public abstract int getHP();
    
    public abstract void setHP(int hp);
    
    public abstract boolean Deffend(int soma);
    
    public abstract int getDmg();

    public abstract IStates addRwd();

    
}
