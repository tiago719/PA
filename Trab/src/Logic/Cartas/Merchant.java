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
public class Merchant extends AdaptadorCartas
{
    public Merchant(GameData g)
    {
        super(g);
    }
    
    @Override
    public String toString()
    {
        String s = "Carta: MERCHANT\n";
        s+="Buy: \n";
        s+="Ration: +1 Food - Custo: 1 Gold\n";
        s+="Health Potion: +1 HP - Custo: 1 Gold\n";
        s+="Big Health Potion: +4 HP - Custo: 3 Gold\n";
        s+="Armor Piece: +1 Armor - Custo: 6 Gold\n";
        s+="Any 1 Spell - Custo: 8 Gold\n";
        s+="Sell: \n";
        s+="1 Armor Piece - Recompensa: 3 Gold\n";
        s+="Any 1 Spell - Recompensa: 4 Gold\n";
        
        return s;
    }
}
