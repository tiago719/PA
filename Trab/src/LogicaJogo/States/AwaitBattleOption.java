package LogicaJogo.States;

import Logic.Cartas.Carta;
import Logic.Dado;
import Logic.GameData;
import java.io.Serializable;

public class AwaitBattleOption extends StateAdapter implements IStates, Serializable
{
   
    public AwaitBattleOption(GameData g)
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
            getGame().getPersonagem().setPoison(false);
            return super.DecideState(getGame().getMonstroAlvo().addRwd());

        }
    }

}
