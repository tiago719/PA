/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

import Logic.GameData;
import Logic.Spells.*;

/**
 *
 * @author edu_f
 */
public class AwaitCardCardSelectionOnCurrentColumn extends StateAdapter implements IStates {

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
        int ran = 1 + (int)(Math.random() * ((6 - 1) + 1));
        if (getGame().getCaverna().getAreaAtual().getMonsterDefeated()) {
            getGame().getPersonagem().addGold(2);
        } else {
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
        getGame().proxColuna();
        return this;
    }
    
    @Override
    public IStates ResolveSelectedEventCard()
    {
        int ran = 1 + (int)(Math.random() * ((6 - 1) + 1));
        
        switch(ran)
        {
            case 1:
                getGame().getPersonagem().addFood(1);
                break;
            case 2:
                getGame().getPersonagem().addHealth(2);
                break;
            case 3:
                getGame().getPersonagem().addGold(2);
                break;
            case 4:
                getGame().getPersonagem().addXP(2);
                break;
            case 5:
                getGame().getPersonagem().addArmor(1);
                break;
            case 6:
                System.out.println("FALTA FAZER");//TODO
                break;
        }
        getGame().proxColuna();
        return this;
    }
    
    @Override
    
    public boolean skillCheck()
    {
        int ran = 1 + (int)(Math.random() * ((6 - 1) + 1));
        
        return ran<=getGame().getPersonagem().getRank();
    }
    @Override
    public IStates ResolveSelectedTrapCard()
    {
        boolean flag=false;
        int ran = 1 + (int)(Math.random() * ((6 - 1) + 1));
        
        if(skillCheck())
        {
            return this;
        }
        
        switch(ran)
        {
            case 1:
                if(!getGame().getPersonagem().loseFood(1))
                {
                    flag=true;
                }
                break;
            case 2:
                if(!getGame().getPersonagem().loseGold(1))
                {
                    flag=true;
                }
                break;
            case 3:
                if(!getGame().getPersonagem().loseArmor(1))
                {
                    flag=true;
                }
                break;
            case 4:
                if(!getGame().getPersonagem().loseHp(1))
                {
                    //TODO:muda para GAMEOVER
                }
                break;
            case 5:
                if(!getGame().getPersonagem().loseXp(1))
                {
                    flag=true;
                }
                break;
            case 6:
                getGame().getPersonagem().loseHp(2);
                
                if(getGame().getCaverna().getNivel()==5)
                {
                    break;
                }
                System.out.println("FALTA FAZER");//TODO
                break;
        }
        
        if(flag)
        {
            if(!getGame().getPersonagem().loseHp(2))
            {
                //TODO: muda para GAMEOVER
            }
        }
        
        getGame().proxColuna();
        return this;//TODO
    }

    @Override
    public IStates OptionSelected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
