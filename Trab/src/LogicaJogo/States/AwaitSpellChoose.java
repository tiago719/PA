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
public class AwaitSpellChoose extends StateAdapter implements IStates {

    public AwaitSpellChoose(GameData g) {
        super(g);
    }

    @Override
    public IStates EndBattle() {
        getGame().proxColuna();
        return new AwaitCardCardSelectionOnCurrentColumn(getGame());

    }

    @Override
    public IStates ProxRonda() {
        //Monstro ataca

        int dmg = getGame().getMonstroAlvo().getDmg();

        int armor = getGame().getPersonagem().getArmor();

        int retirar = (dmg - armor);
        if (retirar > 0) {
            if (!getGame().getPersonagem().loseHp(retirar)) {
                return new GameOver(getGame());
            }
        }
        for (Dado d : getGame().getDados()){
            d.lancaDado();
        }
        return new AwaitAttack(getGame());
    }
    
    @Override
    public IStates GameOver()
    {
        return new GameOver(getGame());
    }

}
