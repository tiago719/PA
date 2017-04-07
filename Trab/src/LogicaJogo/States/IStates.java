/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJogo.States;

/**
 *
 * @author edu_f
 */
public interface IStates {
    IStates setStartingArea(int area);
    IStates setDifficultLevel(int level);
    IStates start();
    

}
