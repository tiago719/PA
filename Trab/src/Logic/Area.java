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

    Area(GameData GameData, ArrayList<Carta> baralho, boolean MonsterDefeated) {
        Baralho = baralho;
        this.GameData = GameData;
        this.MonsterDefeated = MonsterDefeated;
    }
    
     public final void geraBaralho() {
        Baralho.add(new Event(GameData));
        Baralho.add(new Monster(GameData));
        Baralho.add(new Treasure(GameData));
        Baralho.add(new Merchant(GameData));
        Baralho.add(new Trap(GameData));
        Baralho.add(new Resting(GameData));
        if (GameData.getCaverna().isLastArea())
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
    
    public void setBaralho(ArrayList<Carta> b){
        this.Baralho = b;
    }
    
    public ArrayList<Carta> getBaralho(){
        return Baralho;
    }
    
}
