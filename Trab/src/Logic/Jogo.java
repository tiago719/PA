package Logic;

import Logic.Cartas.Carta;
import Logic.Spells.Spell;
import LogicaJogo.States.AwaitBegining;
import LogicaJogo.States.IStates;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Jogo implements Serializable {

    private GameData gameData;
    private IStates state;

    public Jogo() {
        gameData = new GameData();
        setState(new AwaitBegining(gameData));
    }

    public GameData getGame() {
        return gameData;
    }

    public IStates getState() {
        return state;
    }

    public void setState(IStates s) {
        state = s;
    }

    public void setDifficultLevel(Integer valueOf) {
        setState(getState().setDifficultLevel(valueOf));
    }

    public void setStartingArea(int valueOf) {
        setState(getState().setStartingArea(valueOf));
    }

    public void comecar() {
        setState(getState().start());
    }

    public void RestingOptionSelected(int i) {
        setState(getState().OptionSelected(i));
    }

    public void MerchantOptionSelected(int i) {
        if (i==8)
            setState(getState().skipMerchant());
        else
            setState(getState().BuySellMerchant(i));
    }

    public void AtacaMonstro() {
        setState(getState().AtacaMonstro());
    }

    public void Feats() {
        setState(getState().Feats());
    }

    public void FeatsOptionSelected(int d, int custo) {
        if (d == 0)
            setState(getState().VoltaAwaitAttack());
        else
            setState(getState().FeatSelected(d, custo));
    }

    public void GameOver() {
        setState(getState().GameOver());
    }

    public void ProxRonda() {
        setState(getState().ProxRonda());
    }

    public void treasure() {
        setState(getState().ResolveSelectedTreasureCard());
    }

    public void event(Carta c) {
        setState(getState().ResolveSelectedEventCard(c));
    }

    public void trap() {
        setState(getState().ResolveSelectedTrapCard());
    }

    public void monster(Carta c) {
        setState(getState().ResolveSelectedMonsterCard(c));
    }

    public void merchant() {
        setState(getState().ResolveSelectedMerchantCard());
    }

    public void resting() {
        setState(getState().ResolveSelectedRestingCard());//TODO:Isto esta a ser usado?
    }

    public boolean AA_Reroll(int c) {
        if (gameData.getDados().size() < c || c <= 0) {
            return false;
        }

        Dado temp = gameData.getDado(c - 1);
        if (temp.getFace() != 6) {
            getGame().addMsg("Dado escolhido nao Critico.");
            return false;
        }
        gameData.getDado(c - 1).lancaDado();
        return true;
    }

    public ArrayList<Spell> getSpells() {
        return gameData.getPersonagem().getSpells();
    }

    public Personagem getPersonagem() {
        return gameData.getPersonagem();
    }

    public Carta getMonstroAlvo() {
        return gameData.getMonstroAlvo();
    }

    public ArrayList<Carta> getCartasColuna() {
        return gameData.getCaverna().getAreaAtual().getCartasColuna();
    }
    
    public int getNumAreaAtual() {
        return gameData.getCaverna().getNumArea();
    }

    public void ChooseSpell(int c) {
        setState(getState().ChooseSpell(c));
    }

    public boolean AnyCritical() {
        return gameData.AnyCritical();
    }
    
    public boolean AnyDiceNotFeated() {
        return gameData.AnyDiceNotFeated();
    }

    public ArrayList<Dado> getDados() {
        return gameData.getDados();
    }

    public Dado getDado(int i) {
        return gameData.getDados().get(i);
    }

    public int getHpPersonagem() {
        return gameData.getPersonagem().getHp();
    }
    
    public boolean isLastArea() {
        return gameData.getCaverna().isLastArea();
    }

    public boolean hasHeal() {
        return gameData.getPersonagem().hasHeal();
    }

    public void Healing() {
        gameData.getPersonagem().Healing(state);
    }

    public void addMsg(String s) {
        gameData.addMsg(s);
    }

    public String getMsg() {
        return gameData.getMsg();
    }

    public int getColuna() {
        return gameData.getCaverna().getAreaAtual().getColuna();
    }
    
    public ArrayList<Carta> getBaralhoAreaAtual(){
        return gameData.getCaverna().getAreaAtual().getBaralho();
    }
    
    public int getSizeBaralho()
    {
        return gameData.getSizeBaralho();
    }

    public boolean exportarJogo() {
        try {
            Export ex = new Export();
            ObjectOutputStream out;

            out = ex.abreFObjectosEscrita(Constants.nomeFicheiro);
            out.writeObject(this.gameData);
            out.writeObject(this.state);

            return true;

        } catch (IOException ex1) {
            //Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex1);
            return false;
        }
    }

    public boolean continuarJogo() throws ClassNotFoundException {
        try {
            Export ex = new Export();
            ObjectInputStream in;

            in = ex.abreFObjectosLeitura(Constants.nomeFicheiro);
            this.gameData = (GameData) in.readObject();
            this.state = (IStates) in.readObject();
            return true;
        } catch (IOException ex1) {
            //Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex1);
            return false;
        }
    }

    @Override
    public String toString() {
        String s = getMsg();
        s += gameData.getPersonagem() + "\n";
        s += "Coluna: " + gameData.getCaverna().getAreaAtual().getColuna() + "\n";
        s += gameData.getCaverna();

        return s;
    }
}
