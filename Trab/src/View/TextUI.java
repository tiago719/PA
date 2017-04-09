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
    private boolean sair;
    
    public TextUI(Jogo jogo)
    {
        this.jogo=jogo;
        sair=false;
    }
    
    public void uiAwaitBeggining()
    { 
        String option1, option2;
        char c, d;
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            do
            {
                System.out.println("\n=== AWAITING FOR THE BEGINNING OF THE GAME ===\n");
                System.out.println("0 - Sair");
                System.out.println("1 - Escolher area inicial");
                System.out.println("2 - Escolher nivel de dificuldade");
                System.out.println("3 - Comecar");
                
                option1 = sc.next();
                
                if(option1.length() >= 1)
                    c = option1.charAt(0);
                else
                    c = ' ';
            }while(c < '0' || c > '3');
           
            switch(c)
            {
                case '0':
                    sair=true;
                    return;
                    
                case '1':
                    //TODO
                    return;
                    
                case '2':
                    do
                    {
                        System.out.println("Escolha o nivel de dificuldade");
                        System.out.println("1 - Casual (1 Armor, 5 HP, 5 Gold, 6 Food)");
                        System.out.println("2 - Casual (0 Armor, 5 HP, 3 Gold, 6 Food)");
                        System.out.println("3 - Casual (0 Armor, 4 HP, 2 Gold, 5 Food)");
                        System.out.println("4 - Casual (0 Armor, 3 HP, 1 Gold, 3 Food)");

                        option2 = sc.next();
                        
                    if(option2.length() >= 1)
                        d = option1.charAt(0);
                    else
                        d = ' ';

                    }while(d<0 || d >4);

                    jogo.setDifficultLevel(Integer.valueOf(d));
                    return;
                    
                case '3':
                    //TODO
                    return; 
            }
        }      
    }
    
    public void run()
    {
        while(!sair)
        {
            IStates state=jogo.getState();
            
            if(state instanceof AwaitBegining)
            {
                uiAwaitBeggining();
            }
        }
    }
}
