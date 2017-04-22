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
                        System.out.println("2 - Casual (0 Armor, 5 HP, 3 Gold, 6 Food)");
                        System.out.println("3 - Casual (0 Armor, 4 HP, 2 Gold, 5 Food)");
                        System.out.println("4 - Casual (0 Armor, 3 HP, 1 Gold, 3 Food)");

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

    public void uiAwaitCardCardSelectionOnCurrentColumn() {
        ArrayList<Carta> c;
        Scanner sc = new Scanner(System.in);
        int op, cont = 0;
        String option1;

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

        if (temp instanceof Resting) {
            jogo.ResolveRestingCard(jogo.getState().ResolveSelectedRestingCard());
        } else if (temp instanceof Monster)
            ;

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

}
