/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.Cartas.Carta;
import Logic.Dado;
import Logic.GameData;
import java.io.Serializable;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitAttack extends StateAdapter implements IStates, Serializable
{
   
    public AwaitAttack(GameData g)
    {
        super(g);
    }

    @Override
    public IStates Feats()
    {
        return new AwaitFeats(getGame());
    }

    @Override
    public IStates AtacaMonstro()
    {
        int soma = 0;
        for (Dado d : getGame().getDados())
        {
            if (!d.isMiss())
            {
                soma += d.getTotalDado();
            }
            d.clearSomatorio();
            d.setFeated(false);
        }
        if (getGame().getPersonagem().hasPoison())
        {
            soma += 5;
        }
       
        if (!getGame().getMonstroAlvo().Deffend(soma))
        {
            return new AwaitSpellChoose(getGame());
        } else
        {
            getGame().getCaverna().getAreaAtual().setMonsterDefeated(true);
            getGame().addMsg("O monstro foi derrotado\n");
            return getGame().getMonstroAlvo().addRwd();
        }
    }

    /*public AwaitAttack(GameData g, int hp, int damage)
    {
        super(g);
        g.
    }*/
}
