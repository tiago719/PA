/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logic.Jogo;
import LogicaJogo.States.AwaitBegining;
import LogicaJogo.States.IStates;
import java.util.Scanner;

/**
 *
 * @author Tiago Coutinho
 */
public class TextUI {
    private Jogo jogo;
    
    public TextUI(Jogo jogo)
    {
        this.jogo=jogo;
    }
    
    public void uiAwaitBeggining()
    { 
         int option;
         do
         {
         System.out.println("\n=== AWAITING FOR THE BEGINNING OF THE GAME ===\n");
         System.out.println("Escolha o nivel de dificuldade");
         System.out.println("1 - Casual (1 Armor, 5 HP, 5 Gold, 6 Food)");
         System.out.println("2 - Casual (0 Armor, 5 HP, 3 Gold, 6 Food)");
         System.out.println("3 - Casual (0 Armor, 4 HP, 2 Gold, 5 Food)");
         System.out.println("4 - Casual (0 Armor, 3 HP, 1 Gold, 3 Food)");
         
         Scanner sc = new Scanner(System.in);
         option = sc.nextInt();
         
         }while(option<0 || option >4);
         
         jogo.setDificuldade(option);
         
    }
    
    public void run()
    {
        while(true)//TODO: mudar condicao de paragem
        {
            IStates state=jogo.getState();
            
            if(state instanceof AwaitBegining)
            {
                uiAwaitBeggining();
            }
        }
    }
}
