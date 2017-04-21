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
public class Monster extends Carta {

    int inf[][] = {{2, 1}, {4, 1}, {6, 2}, {8, 10}, {10, 3}};

    public Monster(GameData g) {
        super(g);
    }

    @Override
    public String toString() {
        String s = "Carta: MONSTER\n";
        s+= "Level - DMG - REWARD\n";
        s += "1 - Undead Soldier - 2 - 1 XP\n";
        s += "2 - Skeleton - 4 - 1 XP\n";
        s += "3 - Undead Knight - 6 - 2 XP\n";
        s += "4 - Serpent Knight - 8 - 2 XP\n";
        s += "5 - Og's Sanctum Guard - 10 - 3 XP\n";
        return s;
        

    }

}
