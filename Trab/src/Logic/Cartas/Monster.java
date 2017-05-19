package Logic.Cartas;

import Logic.Constants;
import Logic.GameData;
import LogicaJogo.States.AwaitCardCardSelectionOnCurrentColumn;
import LogicaJogo.States.GameOver;
import LogicaJogo.States.IStates;
import java.io.Serializable;

public class Monster extends AdaptadorCartas implements Serializable {

    private int hp;
    private final int dmg, rwd;
    private boolean ice;

    public Monster(GameData g) {
        super(g);
        int level = g.getCaverna().getNivel();
        dmg = Constants.InfoMonster[level - 1][0];
        rwd = Constants.InfoMonster[level - 1][1];
        hp = g.getCaverna().getNumArea() + (1 + (int) (Math.random() * ((6 - 1) + 1)));
        ice=false;
    }

    /*public Monster(GameData g, boolean event) {
        super(g);
        dmg = g.getCaverna().getNumArea() * 2;
        rwd = 2;
        hp = g.getCaverna().getNumArea() + (1 + (int) (Math.random() * ((6 - 1) + 1)));
    }*/

    @Override
    public int getDmg() {
        return dmg;
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public int addRwd() {
        getGame().getPersonagem().addXP(rwd);
        if(!getGame().getCaverna().getAreaAtual().proxColuna())
            return 0;
        
        return 1;
    }

    @Override
    public String toString() {
        String s = "Carta: MONSTER\n";
        s += "HP Atual do Monstro: "+ hp +"\n";
        s += "Damage: "+ dmg +"\n";
        s += "Recompensa: "+ rwd +"XP\n";
        return s;

    }

    @Override
    public String infoCarta() {
        String s = "Carta: MONSTER\n";
        s += "Level - DMG - REWARD\n";
        s += "1 - Undead Soldier - 2 - 1 XP\n";
        s += "2 - Skeleton - 4 - 1 XP\n";
        s += "3 - Undead Knight - 6 - 2 XP\n";
        s += "4 - Serpent Knight - 8 - 2 XP\n";
        s += "5 - Og's Sanctum Guard - 10 - 3 XP\n";
        return s;

    }

//    @Override
//    //true = morto
//    public boolean Deffend(int soma)
//    {
//        if (hp <= soma)
//        {
//            hp = 0;
//            return true;
//        } else
//        {
//            hp -= soma;
//            return false;
//        }
//    }
    @Override
    public int getHP() {
        return hp;
    }
    
    @Override
    public void setIce(boolean i)
    {
        ice=i;
    }
    
    @Override
    public boolean getIce()
    {
        return ice;
    }

}
