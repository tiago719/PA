/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.GameData;

/**
 *
 * @author Tiago Coutinho
 */
public class Event extends Carta
{
    public Event(GameData g)
    {
        super(g);
    }
    
    @Override
    public String toString() 
    {
        String s = "Carta: EVENT\n";
        s += "Events - Effect\n";
        s += "1 - Food Ration - You don’t know what this meat is, and you don’t care. Gain 1 Food.\n";
        s += "2: Found Health - A Monster’s favorite drink. Might as well drink a sip too. Gain 2 HP.\n";
        s += "3: Found Loot - You’ve found a coin hidden in a crack between two stones. Gain 2 Gold.\n";
        s += "4: Found Whetstone - You’ve found a Monster’s blade sharpening tools. Gain 2 XP.\n";
        s += "5: Found Armor - A piece of armor found on a Monster’s carcass. Gain 1 Armor.\n";
        s += "6: Monster - Fight!";
        return s;
    }
}
