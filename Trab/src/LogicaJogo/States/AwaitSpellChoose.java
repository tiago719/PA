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
public class AwaitSpellChoose extends StateAdapter implements IStates, Serializable {

    public AwaitSpellChoose(GameData g) {
        super(g);
    }

    @Override
    public IStates ChooseSpell(int c/*, IStates s*/) {
        IStates temp = null /*= s*/;
        switch (c) {
            case -1:
                //TODO: menssagem de erro
                break;
            case -2:
                return MonstroAtaca();
            case 0:
                //TODO: nao usou nenhum spell dos que tinha
                break;

        }
        switch (getGame().getPersonagem().getSpells().get(c - 1).Efeito()){
            case 1:
                temp = MonstroAtaca();
                break;
            case 2:
                temp = DecideState(getGame().getMonstroAlvo().addRwd());
                break;
            case 3:
                temp = new AwaitAttack(getGame());
                break;
        }
        getGame().addMsg("Foi romovido o SPELL " + getGame().getPersonagem().getSpells().get(c - 1).nome());
        getGame().getPersonagem().getSpells().remove(c - 1);
        return temp;
    }
    
    public IStates MonstroAtaca() {
        //Monstro ataca

        int dmg = getGame().getMonstroAlvo().getDmg();

        int armor = getGame().getPersonagem().getArmor();

        int retirar = (dmg - armor);
        if (retirar > 0 && !getGame().getPersonagem().loseHp(retirar)) {
            return new GameOver(getGame());
        }
        for (Dado d : getGame().getDados()) {
            d.lancaDado();
        }
        return new AwaitAttack(getGame());
    }
    
    
    
    
    
    
    
//    @Override
//    public IStates EndBattle() {
//        getGame().addMsg("O monstro foi derrotado\n");
//        
//        if(getGame().getCaverna().getNumArea()==14 && getGame().getMonstroAlvo() instanceof BossMonster)
//            return new GameOver(getGame());
//        
//        return new AwaitCardCardSelectionOnCurrentColumn(getGame());
//
//    }

//    @Override
//    public IStates ProxRonda() {
//        //Monstro ataca
//
//        int dmg = getGame().getMonstroAlvo().getDmg();
//
//        int armor = getGame().getPersonagem().getArmor();
//
//        int retirar = (dmg - armor);
//        if (retirar > 0) {
//            if (!getGame().getPersonagem().loseHp(retirar)) 
//            {
//                return new GameOver(getGame());
//            }
//        }
//        for (Dado d : getGame().getDados()){
//            d.lancaDado();
//        }
//        return new AwaitAttack(getGame());
//    }
    
    @Override
    public IStates GameOver()
    {
        return new GameOver(getGame());
    }

}
