/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.GameData;
import java.io.Serializable;

/**
 *
 * @author Tiago Coutinho
 */
public class Trap extends AdaptadorCartas implements Serializable
{
    public Trap(GameData g)
    {
        super(g);
    }
    
    @Override
    public String toString() 
    {
        String s = "Carta: TRAP\n";
        return s;
    }
    
     @Override
    public String infoCarta() 
    {
        String s = "Traps - Description\n";
        s += "1: Mold Miasma - A terrible stench seems to have added a layer of white and blue hair on your meat. Lose 1 Food ration.\n";
        s += "2: Tripwire - You tripped and fell hard to the ground. A Gold piece was ejected from your bag. Lose 1 Gold.\n";
        s += "3: Acid Mist - Powerful acid falls from the ceiling and damages your equipment. Lose 1 Armor.\n";
        s += "4: Spring Blades - You walked on a pressure plate and jumped just in time to avoid losing your head. Lose 1 HP.\n";
        s += "5: Moving Walls - Moving walls were about to crush you, but you sacri􀃕ced your sword to save yourself. Lose 1 XP.\n";
        s += "6: Pit - You fell into a hole and landed a Level below. You broke a bone. Lose 2 HP and move your character token to the dungeon Area directly under the current one.";
        return s;
    }
}
