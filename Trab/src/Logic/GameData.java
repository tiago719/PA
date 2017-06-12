package Logic;

import Logic.Cartas.Carta;
import java.util.ArrayList;
import java.io.Serializable;

public class GameData implements Constants, Serializable {

    private int dificuldade, startingArea;
    private final Personagem Personagem;
    private Caverna Caverna;
    private ArrayList<Dado> dados;
    private Carta MonstroAlvo;
    private String msg;

    public GameData() {
        startingArea = 1;
        dificuldade = 2;
        Personagem = new Personagem(dificuldade, this);
        Caverna = new Caverna(startingArea, this);
        dados = new ArrayList<>();
        dados.add(new Dado());
        MonstroAlvo = null;
        msg = "\n";
    }
    
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

    public String getMsg() {
        String m = msg;
        msg = "\n";
        return m;
    }

    public void addMsg(String s) {
        msg += s;
    }
    
    public boolean AnyDiceNotFeated() {
        int cont = 0;
        for (Dado dado : dados) {
            if (dado.getFeated()) {
                cont++;
            }
        }
        if (cont == dados.size()) {
            addMsg("Nenhum dado disponivel para fazer Feat.");
            return false;
        }
        return true;
    }
    
    public int getSizeBaralho()
    {
        return Caverna.getAreaAtual().getSizeBaralho();
    }

    public void setCaverna(Caverna caverna) {
        this.Caverna = caverna;
    }
}
