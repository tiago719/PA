/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.Dado;
import Logic.GameData;
import java.io.Serializable;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitFeats extends StateAdapter implements IStates, Serializable
{
    public AwaitFeats(GameData g)
    {
        super(g);
    }
    
    @Override
    public IStates GameOver()
    {
        return new GameOver(getGame());
    }
    
    @Override
    public IStates VoltaAwaitAttack()
    {
        return new AwaitBattleOption(getGame());
    }
    
    @Override
    public IStates FeatSelected(int d, int custo)
    {
        Dado dadoSelecionado;
        
        dadoSelecionado = getGame().getDado(d - 1);
        
        if (dadoSelecionado.getFeated()) {
            getGame().addMsg("Dado ja Feated!");
            return new AwaitFeats(getGame());
        }

        switch (custo) {
            case 1:
                if (!getGame().getPersonagem().loseHp(2)) {
                    
                    getGame().addMsg("HP Insuficiente!");

                    return new AwaitFeats(getGame());
                }
                break;
            case 2:
                if (!getGame().getPersonagem().TradeXpForFeat()) {
                    getGame().addMsg("XP Insuficiente!");

                    return new AwaitFeats(getGame());
                }
                break;
        }

        dadoSelecionado.setFeated(true);
        dadoSelecionado.addSomatorio(dadoSelecionado.getFace()*-1);
        dadoSelecionado.lancaDado();
        getGame().addMsg("Novo valor do dado "+ d +": "+dadoSelecionado.getFace()+".");
        
        if (!getGame().AnyDiceNotFeated())
            return new AwaitBattleOption(getGame());
        
        return new AwaitFeats(getGame());
    }
    
}
