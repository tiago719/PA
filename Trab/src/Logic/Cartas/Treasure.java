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
public class Treasure extends AdaptadorCartas{
    
    public Treasure(GameData g) {
        super(g);
    }
    
    
    @Override
    public String toString() {
        String s = "Carta: TREASURE\n";
        return s;
    }
    
     @Override
    public String infoCarta() {
        String s="Treasure - Description\n";
        s += "+1 Coin No Monster Defeated\n";
        s += "+2 Coins if a Monster was Deafeated\n";
        s += "----------------------------\n";
        s += "1 - Armor Piece: +1 Armor\n";
        s += "2 - Better Weapon: +2 XP\n";
        s += "3 - Fireball Spell: +8 DMG\n";
        s += "4 - Ice Spell: freeze 1 turn\n";
        s += "5 - Poison Spell: +5 DMG/turn\n";
        s += "6 - Healing Spell: +8 HP\n";
        
        return s;
    }
    
}
