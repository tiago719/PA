package Logic;

import Logic.Cartas.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Area implements Serializable {

    private ArrayList<Carta> Baralho;
    private GameData GameData;
    private boolean MonsterDefeated;
    private int coluna;

    public Area(GameData g) {
        GameData = g;
        Baralho = new ArrayList<>();
        geraBaralho();
        MonsterDefeated = false;
        coluna = 1;
    }

    public Area(GameData GameData, ArrayList<Carta> baralho, boolean MonsterDefeated, int coluna) {
        Baralho = baralho;
        this.GameData = GameData;
        this.MonsterDefeated = MonsterDefeated;
        this.coluna = coluna;
    }

    public final void geraBaralho() {
        Baralho.add(new Monster(GameData));
        Baralho.add(new Treasure(GameData));
        Baralho.add(new Merchant(GameData));
        Baralho.add(new Resting(GameData));
        Baralho.add(new Event(GameData));
        Baralho.add(new Trap(GameData));


        Collections.shuffle(Baralho);

        if (getGame().getCaverna().isLastArea()) 
            Baralho.add(new BossMonster(GameData));
        
    }
    
    public int getSizeBaralho()
    {
        return Baralho.size();
    }

    public GameData getGame() {
        return GameData;
    }

    public Carta getCartaBaralho(int i) {
        return Baralho.get(i);
    }

    public ArrayList<Carta> getCartasColuna() {
        ArrayList<Carta> c = new ArrayList<>();

        switch (getGame().getCaverna().getAreaAtual().getColuna()) {
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

    public boolean getMonsterDefeated() {
        return MonsterDefeated;
    }

    public void setMonsterDefeated(boolean b) {
        MonsterDefeated = b;
    }

    public void setBaralho(ArrayList<Carta> b) {
        this.Baralho = b;
    }

    public ArrayList<Carta> getBaralho() {
        return Baralho;
    }

    public int getColuna() {
        return coluna;
    }

    public boolean proxColuna() {
        int ultimaColuna = 4;
        if (getGame().getCaverna().isLastArea()) {
            ultimaColuna = 5;
        }

        if (coluna < ultimaColuna) {
            coluna++;
            return true;
        } else {
            coluna = 1;
            
            
            return getGame().getCaverna().proxArea();
        }
    }

}
