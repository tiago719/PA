/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trab;

import Logic.Jogo;
import View.TextUI;

/**
 *
 * @author Tiago Coutinho
 */
public class Trab {
    
    public static void main(String[] args) {
        TextUI textUI = new TextUI(new Jogo());
        textUI.run();  
    }
}
