package Logic;

import Logic.Cartas.Carta;
import LogicaJogo.States.AwaitCardCardSelectionOnCurrentColumn;
import LogicaJogo.States.IStates;
import java.util.ArrayList;
import Logic.Spells.*;
import java.io.Serializable;

public class GameData implements Constants, Serializable {

    private int dificuldade, startingArea, coluna;
    private final Personagem Personagem;
    //private Monster MonstroAlvo;
    //private BossMonster BossMonstroAlvo;
    private final Caverna Caverna;
    private ArrayList<Dado> dados;
    private Carta MonstroAlvo;
    private String msg;

    public GameData() {
        startingArea = 1;
        dificuldade = 2;
        Personagem = new Personagem(dificuldade, this);
        Caverna = new Caverna(startingArea, this);
        //MonstroAlvo = null;
        //BossMonstroAlvo=null;
        dados = new ArrayList<>();
        dados.add(new Dado());
        MonstroAlvo = null;
        msg = "\n";
    }

    /*
    public Monster getMonstroAlvo() {
        return MonstroAlvo;
    }

    public void setMonstroAlvo(Monster MonstroAlvo) {
        this.MonstroAlvo = MonstroAlvo;
    }*/

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
        Personagem.setStats(dificuldade);
    }

    public int getStartingArea() {
        return startingArea;
    }

    public void setStartingArea(int startingArea) {
        this.startingArea = startingArea;
        Caverna.setArea(startingArea);
    }

    void setStartingArea(Integer area) {
        startingArea = area;
    }

    public boolean intialize() {
        Caverna.geraPrimeiraArea();
        return true;
    }

    public Caverna getCaverna() {
        return Caverna;
    }

    public Personagem getPersonagem() {
        return Personagem;
    }

    public boolean AnyCritical() {
        for (Dado d : dados) {
            if (d.getFace() == 6) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Dado> getDados() {
        return dados;
    }

    public Dado getDado(int i) {
        return dados.get(i);
    }

    public void addDado() {
        dados.add(new Dado());
    }

    public Carta getMonstroAlvo() {
        return MonstroAlvo;
    }

    public void setMonstroAlvo(Carta c) {
        this.MonstroAlvo = c;
    }

    public IStates Treasure() {
        int ran = 1 + (int) (Math.random() * ((6 - 1) + 1));
        if (Caverna.getAreaAtual().getMonsterDefeated()) {
            Personagem.addGold(2);
        } else {
            Personagem.addGold(1);
        }

        switch (ran) {
            case 1:
                Personagem.addArmor(1);
                break;
            case 2:
                Personagem.addXP(2);
                break;
            case 3:
                Personagem.addSpell(new Fire(this));
                break;
            case 4:
                Personagem.addSpell(new Ice(this));
                break;
            case 5:
                Personagem.addSpell(new Poison(this));
                break;
            case 6:
                Personagem.addSpell(new Healing(this));
                break;
        }
        getCaverna().getAreaAtual().proxColuna();

        return new AwaitCardCardSelectionOnCurrentColumn(this);
    }

    public boolean AS_ChooseSpell(int c, IStates s) {
        switch (c) {
            case -1:
                //TODO: menssagem de erro
                break;
            case 0:
                //TODO: sem spells
                break;
            default:
                getPersonagem().getSpells().get(c - 1).Efeito(this, s);
                getPersonagem().getSpells().remove(c - 1);

        }
        if (getMonstroAlvo().getHP() <= 0) {
            getCaverna().getAreaAtual().setMonsterDefeated(true);
            return true;
        } else {
            return false;
        }
    }

    public String getMsg() {
        String m = msg;
        msg = "\n";
        return m;
    }

    public void addMsg(String s) {
        msg += s;
    }

//    public void clearMsg() {
//        msg = "\n";
//    }

    /*
    void setMonster(Monster M) {
        MonstroAlvo= M;
    }
    
    void setBossMonster(BossMonster BM)
    {
        BossMonstroAlvo=BM;
    }*/
}
