/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logic.Cartas.*;
import Logic.Jogo;
import LogicaJogo.States.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tiago Coutinho
 */
public class TextUI {

    private Jogo jogo;
    private boolean sair;

    public TextUI(Jogo jogo) {
        this.jogo = jogo;
        sair = false;
    }

    public void uiAwaitBeggining() {
        String option1, option2;
        char c, d;
        int f;
        Scanner sc = new Scanner(System.in);
        while (true) {
            do {
                System.out.println("\n=== AWAITING FOR THE BEGINNING OF THE GAME ===\n");
                System.out.println("0 - Sair");
                System.out.println("1 - Escolher area inicial");
                System.out.println("2 - Escolher nivel de dificuldade");
                System.out.println("3 - Comecar");

                option1 = sc.next();

                if (option1.length() >= 1) {
                    c = option1.charAt(0);
                } else {
                    c = ' ';
                }
            } while (c < '0' || c > '3');

            switch (c) {
                case '0'://sair
                    sair = true;
                    return;

                case '1'://escolher area inicial
                    do {
                        System.out.println("Escolha a area a comecar: (1-14)");

                        option2 = sc.next();

                        try {
                            f = (int) Integer.parseInt(option2);
                        } catch (Exception ex) {
                            f = -1;
                        }
                    } while (f < 1 || f > 14);

                    jogo.setStartingArea(f);
                    return;

                case '2'://escolher nivel dificuldade
                    do {
                        System.out.println("Escolha o nivel de dificuldade");
                        System.out.println("1 - Casual (1 Armor, 5 HP, 5 Gold, 6 Food)");
                        System.out.println("2 - Normal (0 Armor, 5 HP, 3 Gold, 6 Food)");
                        System.out.println("3 - Hard (0 Armor, 4 HP, 2 Gold, 5 Food)");
                        System.out.println("4 - Impossible (0 Armor, 3 HP, 1 Gold, 3 Food)");

                        option2 = sc.next();

                        try {
                            f = Integer.parseInt(option2);
                        } catch (Exception ex) {
                            f = -1;
                        }

                    } while (f < 1 || f > 4);

                    jogo.setDifficultLevel(f);
                    return;

                case '3'://comecar
                    jogo.startGame(jogo.getState().start());
                    return;
            }
        }
    }

    public void uiAwaitCardCardSelectionOnCurrentColumn() 
    {
        ArrayList<Carta> c;
        Scanner sc = new Scanner(System.in);
        int op, cont = 0;
        String option1;

         for(int i=0;i<50;i++)
                {
                    System.out.println();
                }
        System.out.println("Area Atual: " + jogo.getGame().getCaverna().getNumArea());
        System.out.println("Nivel Atual: " + jogo.getGame().getCaverna().getNivel());
        System.out.println("Coluna Atual: " + jogo.getGame().getColuna());
        System.out.println("Nivel de dificuldade " + jogo.getGame().getDificuldade());
        System.out.println("Escolha uma carta da coluna em que se encontra\n");

        c = jogo.getGame().getCaverna().getAreaAtual().getCartasColuna();
        for (Carta cartasColuna : c) {
            System.out.println((++cont) + " - " + cartasColuna + "\n");
        }

        do {
            System.out.println("Escolha Uma Carta ( 1 - " + (c.size()) + ")");

            option1 = sc.next();

            try {
                op = (int) Integer.parseInt(option1);
            } catch (Exception ex) {
                op = -1;
            }

        } while (op < 1 || op > c.size());

        Carta temp = c.get(op - 1);

        if (temp instanceof Resting) 
        {
            jogo.ResolveRestingCard(jogo.getState().ResolveSelectedRestingCard());
        } else if (temp instanceof Treasure)
        {
            jogo.ResolveTreasureCard(jogo.getState().ResolveSelectedTreasureCard());
        }
        else if(temp instanceof Merchant)
        {
            jogo.ResolveMerchantCard(jogo.getState().ResolveSelectedMerchantCard());
        }
    }

    private void uiAwaitOptionSelection() {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c;

        do {
            System.out.println("\n=== AWAITING OPTION SELECTION(RESTING CARD) ===\n");
            System.out.println("1 - Reinforce your Weapon: +1 XP");
            System.out.println("2 - Search for Ration: +1 FOOD");
            System.out.println("3 - Heal: +2 HP");

            option1 = sc.next();

            try {
                c = (int) Integer.parseInt(option1);
            } catch (Exception ex) {
                c = -1;
            }

        } while (c < 1 || c > 3);

        if (!jogo.AOS_OptionSelection(c))
                //TODO: TRATAR erro
                ; 
        else {
            jogo.OptionSelected(jogo.getState().OptionSelected());
        }
    }
    
    private void uiAwaitTrading()
    {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c;
        boolean skip=false;
        
        do
        {
            do
            {
                for(int i=0;i<50;i++)
                {
                    System.out.println();//TODO: tirar
                }
                System.out.println("Food: " + jogo.getGame().getPersonagem().getFood());
                System.out.println("Health: " + jogo.getGame().getPersonagem().getHp());
                System.out.println("Gold: " + jogo.getGame().getPersonagem().getGold());
                System.out.println("Armor: " + jogo.getGame().getPersonagem().getArmor());
                System.out.println("\n=== AWAITING TRAIDING(MERCHANT CARD) ===\n");
                System.out.println("Buy:");
                System.out.println("1 - Ration: +1 Food - Custo: 1 Gold");
                System.out.println("2 - Health Potion: +1 HP - Custo: 1 Gold");
                System.out.println("3 - Big Health Potion: +4 HP - Custo: 3 Gold");
                System.out.println("4 - Armor Piece: +1 Armor - Custo: 6 Gold");
                System.out.println("5 - Any 1 Spell - Custo: 8 Gold");
                System.out.println("\nSell:");
                System.out.println("6 - 1 Armor Piece - Recompensa: 3 Gold");
                System.out.println("7 - Any 1 Spell - Recompensa: 4 Gold");
                System.out.println("\n8 - Continue");

                option1 = sc.next();

                try
                {
                    c = (int) Integer.parseInt(option1);
                } catch (Exception ex)
                {
                    c = -1;
                }

                if (c == 8)
                {
                    jogo.OptionSelected(jogo.getState().skipMerchant());
                    skip=true;
                    break;
                }

            } while (c < 0 || c > 7);

            if(!jogo.AOS_TraidingSelection(c))
            {
                //TODO: tratar erro
            }
            
        }while(!skip);
    }
    
     public void run() {
        while (!sair) {
            IStates state = jogo.getState();

            if (state instanceof AwaitBegining) {
                uiAwaitBeggining();
            } else if (state instanceof AwaitCardCardSelectionOnCurrentColumn) {
                uiAwaitCardCardSelectionOnCurrentColumn();
            } else if (state instanceof AwaitOptionSelection) {
                uiAwaitOptionSelection();
            }
            else if(state instanceof AwaitTraiding)
            {
                uiAwaitTrading();
            }
        }
    }
}
