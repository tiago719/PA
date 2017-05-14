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
        return new AwaitAttack(getGame());
    }
    
    @Override
    public IStates FeatSelected(int d, int custo)
    {
        int cont = 0;
        Dado temp;
                
        for(Dado dado: getGame().getDados()){
            if (dado.getFeated())
                cont++;
        }
        if (cont == getGame().getDados().size() ){
            getGame().addMsg("Nenhum dado disponivel para fazer Feat.");
            return new AwaitAttack(getGame());
        }
        
        temp = getGame().getDado(d - 1);
        
        if (temp.getFeated()) {
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

        getGame().getDado(d - 1).setFeated(true);
        getGame().getDado(d - 1).clearSomatorio();
        getGame().getDado(d - 1).lancaDado();
        return new AwaitFeats(getGame());
    }
    
}
