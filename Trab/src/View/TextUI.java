package View;

import Logic.Cartas.*;
import Logic.Dado;
import Logic.Jogo;
import Logic.Spells.Spell;
import LogicaJogo.States.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                System.out.println("\n=== Bem-vindo ao Mini-Rogue ===\n");
                System.out.println("0 - Sair");
                System.out.println("1 - Escolher area inicial");
                System.out.println("2 - Escolher nivel de dificuldade");
                System.out.println("3 - Comecar Novo Jogo");
                System.out.println("4 - Continuar Jogo");

                option1 = sc.next();

                if (option1.length() >= 1) {
                    c = option1.charAt(0);
                } else {
                    c = ' ';
                }
            } while (c < '0' || c > '4');

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

                case '3'://novo jogo
                    jogo.comecar();
                    return;
                case '4': {
                    try {
                        //retomar jogo
                        if (!jogo.continuarJogo()) {
                            System.out.println("Nao existe nenhum jogo gravado");
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(TextUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return;

            }
        }
    }

    public void uiAwaitCardCardSelectionOnCurrentColumn() {
        ArrayList<Carta> c;
        Scanner sc = new Scanner(System.in);
        int op, cont = 0;
        String option1;

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
            

        System.out.println(jogo);
        System.out.println("Escolha uma carta da coluna em que se encontra\n");

        c = jogo.getCartasColuna();
        for (Carta cartasColuna : c) {
            System.out.println((++cont) + " - " + cartasColuna.infoCarta() + "\n");
        }

        do {
            System.out.println("Escolha Uma Carta ( 1 - " + (c.size()) + ")");
            System.out.println("0 - Salvar Jogo");
            if (jogo.hasHeal()) {
                System.out.println("3 - Healing");
            }

            option1 = sc.next();

            try {
                op = (int) Integer.parseInt(option1);
            } catch (Exception ex) {
                op = -1;
            }
            if (op == 3) {
                jogo.Healing();
            }

        } while (op < 0 || op > c.size());

        if (op == 0) {
            if (!jogo.exportarJogo()) {
                System.out.println("Nao foi possivel gravar o jogo");
            } else {
                System.out.println("Jogo gravado com sucesso");
                sair = true;
            }
            return;
        }
        Carta temp = c.get(op - 1);

        //TODO: TALVEZ PASSAR ISTO PARA UMA FUNCAO NO JOGO
        if (temp instanceof Resting) {
            jogo.resting();
        } else if (temp instanceof Treasure) {
            jogo.treasure();
        } else if (temp instanceof Merchant) {
            jogo.merchant();
        } else if (temp instanceof Event) {
            jogo.event(temp);
        } else if (temp instanceof Trap) {
            jogo.trap();
        } else if (temp instanceof Monster || temp instanceof BossMonster) {
            jogo.monster(temp);
        }
    }

    private void uiAwaitOptionSelection() {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c;

        do {
            System.out.println(jogo.getPersonagem());
            System.out.println("\n=== Escolha uma opcao! ===\n");
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

        jogo.RestingOptionSelected(c);
    }

    private void uiAwaitTrading() {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c;
        boolean skip = false;

        do {
            System.out.println(jogo.getPersonagem());
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

            try {
                c = (int) Integer.parseInt(option1);
            } catch (Exception ex) {
                c = -1;
            }

            jogo.MerchantOptionSelected(c);

        } while (c < 0 || c > 8);

        System.out.println(jogo.getMsg());

    }

    private void uiAwaitAttack() {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c, i, aux;
        boolean end = false;
        do {

            do {
                i = 0;
                aux = 1;
                System.out.println(jogo.getPersonagem());
                System.out.println(jogo.getMonstroAlvo());
                System.out.println(jogo.getMsg());
                System.out.println("\n=== Escolha uma opcao ===\n");
                System.out.println("Resultado dos dados: ");

                for (Dado d : jogo.getDados()) {
                    System.out.println("Dado " + ++i + ": " + d);
                }

                System.out.println("0 - Sair");

                System.out.println("1 - Atacar");

                if (jogo.AnyDiceNotFeated()) {
                    System.out.println(++aux + " - Feats");
                }
                if (jogo.AnyCritical()) {
                    System.out.println(++aux + " - Reroll");
                }

                option1 = sc.next();

                try {
                    c = (int) Integer.parseInt(option1);
                } catch (Exception ex) {
                    c = -1;
                }

            } while (c < 0 || c > aux);

            if (!jogo.AnyDiceNotFeated() && c == 2) {
                c=3;
            }

            switch (c) {
                case 1:
                    jogo.AtacaMonstro();
                    end = true;
                    break;
                case 2:
                    jogo.Feats();
                    end = true;
                    break;
                case 3:
                    do {
                        System.out.println("0 - Sair");
                        System.out.println("Escolha o dado que pretende fazer reroll: ");
                        i = 0;
                        for (Dado d : jogo.getDados()) {
                            if (d.getFace() == 6) {
                                System.out.println(++i + ": " + d);
                            }
                        }

                        option1 = sc.next();

                        try {
                            c = (int) Integer.parseInt(option1);
                        } catch (Exception ex) {
                            c = -1;
                        }

                    } while (c < 0 || c > i);
                    if (c != 0) {
                        jogo.AA_Reroll(c);
                    }                        
                    break;
            }
        } while (!end);
    }

    private void uiAwaitFeats() {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c, e, i;

        do {
            i = 0;
            System.out.println("\n" + jogo.getMsg() + "\n");
            System.out.println("\nFeats: Escolha uma opcao\n");
            System.out.println("ATENCAO: Custo: 2 HP ou 1 XP");

            System.out.println("0 : Sair");

            System.out.println("Escolha o dado que pretende fazer Feat: ");
            for (Dado d : jogo.getDados()) {
                System.out.println(++i + " : " + d);
            }

            System.out.println("\n0 - Sair ");

            option1 = sc.next();

            try {
                c = (int) Integer.parseInt(option1);
            } catch (Exception ex) {
                c = -1;
                break;
            }

        } while (c < 0 || c > i);

        do {
            System.out.println("Forma de pagamento: 2 HP ou 1 XP");
            System.out.println("Opcao 1: 2 HP");
            System.out.println("Opcao 2: 1 XP");
            option1 = sc.next();

            try {
                e = (int) Integer.parseInt(option1);
            } catch (Exception ex) {
                e = -1;
            }

        } while (e != 1 && e != 2);

        jogo.FeatsOptionSelected(c, e);
    }

    private void uiAwaitSpellChoose() {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c, i = 0;
        do {
            System.out.println("\n=== Escolha o Spell ===\n");

            System.out.println(jogo.getMonstroAlvo());

            if (!jogo.getSpells().isEmpty()) {
                System.out.println("0 - Continuar");
                System.out.println("Spells:");

                for (Spell d : jogo.getSpells()) {
                    System.out.println("Spell " + ++i + ": " + d);
                }

                option1 = sc.next();

                try {
                    c = (int) Integer.parseInt(option1);
                } catch (Exception ex) {
                    c = -1;
                }

            } else {
                c = -2;
                break;
            }

        } while (c < 0 || c > i);
        jogo.ChooseSpell(c);

    }

    private void uiGameOver() {
        if (jogo.getHpPersonagem() <= 0) {
            //perdeu
            System.out.println("Oh, sorry, you died, right? Mini Rogue can sometimes be a punishingly hard game. Nevertheless, you’ve faced great odds, found great loot, and kicked ass!");
        } else {
            System.out.println("the Og’s Blood is now yours! You have won the game!");//venceu
        }
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
            } else if (state instanceof AwaitTraiding) {
                uiAwaitTrading();
            } else if (state instanceof AwaitAttack) {
                uiAwaitAttack();
            } else if (state instanceof AwaitFeats) {
                uiAwaitFeats();
            } else if (state instanceof AwaitSpellChoose) {
                uiAwaitSpellChoose();
            } else if (state instanceof GameOver) {
                uiGameOver();
                sair = true;
            }
        }
    }
}
