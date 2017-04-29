/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author edu_f
 */
public class Area{
    
    ArrayList<Carta> Baralho;
    GameData GameData;
    boolean MonsterDefeated;
    
    public Area(GameData g){
        Baralho = new ArrayList<>();
        GameData = g;
        geraBaralho();
        MonsterDefeated = false;
        Collections.shuffle(Baralho);
    }
     public final void geraBaralho() {
        Baralho.add(new Monster(GameData));
        Baralho.add(new Monster(GameData));
        Baralho.add(new Monster(GameData));
        Baralho.add(new Monster(GameData));
        Baralho.add(new Monster(GameData));
        Baralho.add(new Monster(GameData));
        if (GameData.getCaverna().isLastArea())//TODO: CORRIGIR ESTE ERRO
        {
                
            Baralho.add(new BossMonster(GameData));
            //GameData.setBossMonster(bm);
        }
        //TODO: adicionar todas cartas
    }

    public Carta getCartaBaralho(int i) {
        return Baralho.get(i);
    }
    
    public ArrayList<Carta> getCartasColuna() {
        ArrayList<Carta> c = new ArrayList<>();
        
        switch (GameData.getColuna()){
            case 1:
                c.add(Baralho.get(0));
                break;
            case 2:
                c.add(Baralho.get(1));
                c.add(Baralho.get(2));                
                break;
            case 3:
                c.add(Baralho.get(3));                
                break;
            case 4:
                c.add(Baralho.get(4));
                c.add(Baralho.get(5));
                break;
            case 5:
                c.add(Baralho.get(6));
                break;
        }
        return c;
    }
    
    public boolean getMonsterDefeated()
    {
        return MonsterDefeated;
    }
    
    public void setMonsterDefeated(boolean b)
    {
        MonsterDefeated=b;
    }
}
