/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.Cartas.BossMonster;
import Logic.Cartas.Carta;
import Logic.Cartas.Monster;
import static Logic.Constants.InfoBossMonster;
import static Logic.Constants.InfoMonster;
import Logic.Dado;
import Logic.GameData;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitAttack extends StateAdapter implements IStates
{
    public AwaitAttack(GameData g, Carta c)
    {
        super(g);
        g.setCarta(c);       
    }
    
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
        
        if (getGame().getHpMonster()>soma)
        {
            getGame().setHpMonster(getGame().getHpMonster()-soma);
            return new AwaitSpellChoose(getGame());
        } else
        {
            getGame().setHpMonster(0);
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
