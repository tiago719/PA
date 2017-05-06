/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.GameData;

/**
 *
 * @author edu_f
 */
public class Resting extends AdaptadorCartas{
    
    public Resting(GameData g) {
        super(g);
    }
    
    
    @Override
    public String toString() {
        String s = "Carta: RESTING\n";
        return s;
    }
    
    @Override
    public String infoCarta() {
        String s = "Resting - Description\n";
        s += "Reinforce your Weapon: +1 XP\n";
        s += "Search for Ration: +1 Food\n";
        s += "Heal: +2 HP\n";
        return s;
    }
    
}
