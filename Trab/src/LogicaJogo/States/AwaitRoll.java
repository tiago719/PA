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
 * @author edu_f
 */
public class AwaitRoll extends StateAdapter implements IStates {
    
    public AwaitRoll(GameData g) {
        super(g);
    }

    @Override
    public IStates relancarDado(Dado dado) {
        //todo: relancar o dado e adicionar ao somatorio
        return this;
    }
    
    
    
}
