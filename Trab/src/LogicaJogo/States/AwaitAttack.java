/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.Cartas.Carta;
import Logic.Dado;
import Logic.GameData;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitAttack extends StateAdapter implements IStates
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
            else
            {
                System.out.println("O dado tem o valor 1, nao pode ser usado nesta ronda");//TODO: tirar
            }
            d.clearSomatorio();
            d.setFeated(false);
        }
        if (getGame().getPersonagem().hasPoison())
        {
            soma += 5;
        }
        
        if (getGame().getMonstroAlvo().getHP()>soma)
        {
            getGame().getMonstroAlvo().setHP(getGame().getMonstroAlvo().getHP()-soma);
            return new AwaitSpellChoose(getGame());
        } else
        {
            getGame().getMonstroAlvo().setHP(0);
            getGame().getPersonagem().recompensa();
            getGame().proxColuna();
            return new AwaitCardCardSelectionOnCurrentColumn(getGame());
        }
    }

    /*public AwaitAttack(GameData g, int hp, int damage)
    {
        super(g);
        g.
    }*/
}
