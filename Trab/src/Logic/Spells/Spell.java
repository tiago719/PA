/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Spells;

import Logic.GameData;

/**
 *
 * @author edu_f
 */
public abstract class Spell {
    private final GameData gd;

    public Spell(GameData g) {
        gd = g;
    }
    
    public abstract void Efeito(GameData g);
    
}
