/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trab;

import Logic.ObservableGame;
import java.io.IOException;
import ui.Gui.MiniRogueView;

/**
 *
 * @author Tiago Coutinho
 */
public class MainGUI
{
    public static void main(String args[]) throws IOException 
    {
        ObservableGame ob = new ObservableGame();        
        new MiniRogueView(ob);
    }
}
