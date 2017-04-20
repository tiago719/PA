/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.BossMonster;
import Logic.Cartas.Carta;
import Logic.Cartas.Monster;
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
        geraBaralho();
        GameData = g;
        MonsterDefeated = false;
        Collections.shuffle(Baralho);
    }
     public final void geraBaralho() {
        Baralho.add(new Monster(GameData));
        //TODO: adicionar todas cartas
    }
     public void addBoss(){
        Baralho.add(new BossMonster(GameData));

     }
    

}
