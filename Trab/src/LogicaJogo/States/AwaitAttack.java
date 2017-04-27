/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

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
    public IStates Feats(){
        return new AwaitFeats(getGame());
    }
    
    @Override
    public IStates Spells(){
        int soma = 0;
        for(Dado d : getGame().getDados())
            soma += d.getTotalDado();
        
        getGame().getMonstroAlvo().Deffend(soma);
        return new AwaitSpellChoose(getGame());
    }
    
    /*public AwaitAttack(GameData g, int hp, int damage)
    {
        super(g);
        g.
    }*/
}