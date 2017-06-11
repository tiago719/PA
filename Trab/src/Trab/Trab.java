/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trab;

import Logic.Jogo;
import Logic.ObservableGame;
import View.TextUI;
import java.io.IOException;
import ui.Gui.MiniRogueView;

/**
 *
 * @author Tiago Coutinho
 */
public class Trab {
    
    public static void main(String[] args) throws IOException {
        /*
        TextUI textUI = new TextUI(new Jogo());
        textUI.run();  */
//TODO: MUDAR PARA TEXTO

        ObservableGame ob = new ObservableGame();        
        new MiniRogueView(ob);

    }
}
