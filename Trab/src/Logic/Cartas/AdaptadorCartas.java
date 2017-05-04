/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic.Cartas;

import Logic.GameData;
import LogicaJogo.States.IStates;

/**
 *
 * @author edu_f
 */
public class AdaptadorCartas extends Carta{

    public AdaptadorCartas(GameData g) {
        super(g);
    }

    @Override
    public int getHP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHP(int hp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //true = morto
    @Override
    public boolean Deffend(int soma) {
        
        if (getHP() <= soma)
        {
            setHP(0);
            return true;
        } else
        {
            setHP(getHP()-soma);
            return false;
        }
    }

    @Override
    public int getDmg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates addRwd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String infoCarta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
