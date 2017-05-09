/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.Cartas.Carta;
import Logic.Cartas.Monster;
import Logic.Dado;
import Logic.GameData;
import Logic.Spells.*;
import java.io.Serializable;

/**
 *
 * @author edu_f
 */
public class AwaitCardCardSelectionOnCurrentColumn extends StateAdapter implements IStates, Serializable{

    public AwaitCardCardSelectionOnCurrentColumn(GameData g) {
        super(g);
    }

    @Override
    public IStates ResolveSelectedRestingCard() {
        return new AwaitOptionSelection(getGame());
    }

    @Override
    public IStates ResolveSelectedMerchantCard() {
        return new AwaitTraiding(getGame());
    }

    @Override
    public IStates ResolveSelectedTreasureCard() {
        int ran = 1 + (int) (Math.random() * ((6 - 1) + 1));
        getGame().addMsg("Resultado do lancamento do dado: " + ran + "\n");

        if (getGame().getCaverna().getAreaAtual().getMonsterDefeated()) {
            getGame().addMsg("Como ja derrotaste um monstro nesta ronda recebes 2 de Gold\n");
            getGame().getPersonagem().addGold(2);
        } else {
            getGame().addMsg("Como ainda nao derrotaste um monstro nesta ronda recebes apenas 1 de Gold\n");
            getGame().getPersonagem().addGold(1);
        }

        switch (ran) {
            case 1:
                getGame().getPersonagem().addArmor(1);
                break;
            case 2:
                getGame().getPersonagem().addXP(2);
                break;
            case 3:
                getGame().getPersonagem().addSpell(new Fire(getGame()));
                break;
            case 4:
                getGame().getPersonagem().addSpell(new Ice(getGame()));
                break;
            case 5:
                getGame().getPersonagem().addSpell(new Poison(getGame()));
                break;
            case 6:
                getGame().getPersonagem().addSpell(new Healing(getGame()));
                break;
        }
        getGame().getCaverna().getAreaAtual().proxColuna();

        return new AwaitCardCardSelectionOnCurrentColumn(getGame());
    }

    @Override
    public IStates ResolveSelectedEventCard(Carta c) {
        int ran = 1 + (int) (Math.random() * ((6 - 1) + 1));//TODO: maostrar ao utilizador o resultado
        getGame().addMsg("Resultado do lancamento do dado (EVENT CARD): " + ran + "\n");

        switch (ran) {
            case 1:
                getGame().getPersonagem().addFood(1);
                getGame().addMsg("Recebeste 1 FOOD\n");
                break;
            case 2:
                getGame().getPersonagem().addHealth(2);
                getGame().addMsg("Recebeste 2 HP\n");
                break;
            case 3:
                getGame().getPersonagem().addGold(2);
                getGame().addMsg("Recebeste 2 GOLD\n");
                break;
            case 4:
                getGame().getPersonagem().addXP(2);
                getGame().addMsg("Recebeste 2 XP\n");
                break;
            case 5:
                getGame().getPersonagem().addArmor(1);
                getGame().addMsg("Recebeste 1 ARMOR\n");
                break;
            case 6:
                getGame().setMonstroAlvo(c);

                for (Dado d : getGame().getDados()) {
                    d.lancaDado();
                }

                getGame().addMsg("Azar, vais ter de enfrentar um monstro! \n");

                return new AwaitAttack(getGame());
        }
        getGame().getCaverna().getAreaAtual().proxColuna();
        return this;
    }

    @Override
    public boolean skillCheck() {
        int ran = 1 + (int) (Math.random() * ((6 - 1) + 1));

        if (ran <= getGame().getPersonagem().getRank())//TODO: maostrar ao utilizador o resultado
        {
            getGame().addMsg("Suceddo no Skill Check. A trap vai ser ignorada\n");
            return true;
        } else {
            getGame().addMsg("Azar no Skill Check. Vais ter mesmo de enfrentar a trap\n");
            return false;
        }
    }

    @Override
    public IStates ResolveSelectedTrapCard() {
        boolean flag = false;
        int ran = 1 + (int) (Math.random() * ((6 - 1) + 1));//TODO: maostrar ao utilizador o resultado e consequencia
        getGame().addMsg("Resultado do lancamento do dado: " + ran + "\n");

        if (skillCheck()) {
            return this;
        }

        switch (ran) {
            case 1:
                if (!getGame().getPersonagem().loseFood(1)) {
                    flag = true;
                }
                getGame().addMsg("Perdeste 1 FOOD\n");
                break;
            case 2:
                if (!getGame().getPersonagem().loseGold(1)) {
                    flag = true;
                }
                getGame().addMsg("Perdeste 1 GOLD\n");
                break;
            case 3:
                if (!getGame().getPersonagem().loseArmor(1)) {
                    flag = true;
                }
                getGame().addMsg("Perdeste 1 ARMOR\n");
                break;
            case 4:
                if (!getGame().getPersonagem().loseHp(1)) {
                    return new GameOver(getGame());
                }
                getGame().addMsg("Perdeste 1 HP\n");
                break;
            case 5:
                if (!getGame().getPersonagem().addXP(-1)) {
                    flag = true;
                }
                getGame().addMsg("Perdeste 1 XP\n");
                break;
            case 6:
                if (!getGame().getPersonagem().loseHp(2)) {
                    return new GameOver(getGame());
                }

                if (getGame().getCaverna().getNivel() >= 11 || getGame().getCaverna().getNivel() == 5) {
                    break;
                }
                
                getGame().getCaverna().Pit();

                getGame().addMsg("Perdeste 2 HP, e Foste Movido para "
                        + "o Nivel "+getGame().getCaverna().getAreaAtual()+"\n");
                
                
                
                break;
        }

        if (flag) {
            getGame().addMsg("Infelizmente nao tens atributos suficientes para poderes sofrer a consequencias...\n Vais assim perde 2 de HP \n");
            if (!getGame().getPersonagem().loseHp(2)) {
                return new GameOver(getGame());
            }
        }

        getGame().getCaverna().getAreaAtual().proxColuna();
        return this;//TODO
    }

    @Override
    public IStates ResolveSelectedMonsterCard(Carta c) {
        getGame().setMonstroAlvo(c);

        for (Dado d : getGame().getDados()) {
            d.lancaDado();
        }
        return new AwaitAttack(getGame());
    }

//    @Override
//    public IStates ResolveSelectedBossMonsterCard(Carta c)
//    {
//        getGame().setMonstroAlvo(c);
//
//         for (Dado d : getGame().getDados()){
//            d.lancaDado();
//        }
//         return new AwaitAttack(getGame());
//    }
    @Override
    public IStates OptionSelected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
