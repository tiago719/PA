/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.Constants;
import static Logic.Constants.InfoBossMonster;
import Logic.GameData;
import LogicaJogo.States.AwaitCardCardSelectionOnCurrentColumn;
import LogicaJogo.States.GameOver;
import LogicaJogo.States.IStates;
import LogicaJogo.States.StateAdapter;

/**
 *
 * @author edu_f
 */
public class BossMonster extends AdaptadorCartas{

    private int hp;
    private final int dmg, XpRwd, GoldRwd;
    private boolean poison;
    
    public BossMonster(GameData g) 
    {
        super(g);
        int level = g.getCaverna().getNivel();
        hp=InfoBossMonster[level-1][0];
        dmg=InfoBossMonster[level-1][1];
        XpRwd=InfoBossMonster[level-1][2];
        GoldRwd=InfoBossMonster[level-1][3];
        poison=false;
    }
    
    @Override
    public String toString() {
        String s = "Carta: BOSS MONSTER\n";
        s += "Level - HP - DMG - REWARD\n";
        s += "1 - Undead Giant - 10 - 3 - 2 Coins + 2 XP + Item\n";
        s += "2 - Skeleton Lord - 15 - 5 - 2 Coins + 3 XP + Item\n";
        s += "3 - Undead Lord - 20 - 7 - 3 Coins + 4 XP + Item\n";
        s += "4 - Serpent Demon - 25 - 9 - 3 Coins + 5 XP + Item\n";
        s += "5 - Og's Remains - 30 - 12 - OG's Blood\n";
        return s;
    }

    @Override
    public int getHP() {
        return hp;
    }
    
    @Override
    public void setHP(int hp)
    {
        this.hp = hp;
    }

    @Override
    public boolean Deffend(int soma) {
        if (hp <= soma)
        {
            hp = 0;
            return true;
        } else
        {
            hp -= soma;
            return false;
        }
    }

    @Override
    public int getDmg() {
        return dmg;
    }

    @Override
    public IStates addRwd(){
        if (gd.getCaverna().getNivel()== 5){
            System.out.println("||||||||||||||VENCEU||||||||||||||||||||");//TODO: QUANDO ACABA JOGO, TIRAR LINHA        
            return new GameOver(gd);
        }
        else{
            gd.getPersonagem().addGold(GoldRwd);
            gd.getPersonagem().addXP(XpRwd);
            return gd.Treasure();//TODO: MANDAR PARA TREASURE
        }
       
        
    }
    
    
}
