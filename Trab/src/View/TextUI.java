/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Logic.Cartas.*;
import Logic.Dado;
import Logic.Jogo;
import Logic.Spells.Spell;
import LogicaJogo.States.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tiago Coutinho
 */
public class TextUI
{

    private Jogo jogo;
    private boolean sair;

    public TextUI(Jogo jogo)
    {
        this.jogo = jogo;
        sair = false;
    }

    public void uiAwaitBeggining()
    {
        String option1, option2;
        char c, d;
        int f;
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            do
            {
                System.out.println("\n=== AWAITING FOR THE BEGINNING OF THE GAME ===\n");
                System.out.println("0 - Sair");
                System.out.println("1 - Escolher area inicial");
                System.out.println("2 - Escolher nivel de dificuldade");
                System.out.println("3 - Comecar");

                option1 = sc.next();

                if (option1.length() >= 1)
                {
                    c = option1.charAt(0);
                } else
                {
                    c = ' ';
                }
            } while (c < '0' || c > '3');

            switch (c)
            {
                case '0'://sair
                    sair = true;
                    return;

                case '1'://escolher area inicial
                    do
                    {
                        System.out.println("Escolha a area a comecar: (1-14)");

                        option2 = sc.next();

                        try
                        {
                            f = (int) Integer.parseInt(option2);
                        } catch (Exception ex)
                        {
                            f = -1;
                        }
                    } while (f < 1 || f > 14);

                    jogo.setStartingArea(f);
                    return;

                case '2'://escolher nivel dificuldade
                    do
                    {
                        System.out.println("Escolha o nivel de dificuldade");
                        System.out.println("1 - Casual (1 Armor, 5 HP, 5 Gold, 6 Food)");
                        System.out.println("2 - Normal (0 Armor, 5 HP, 3 Gold, 6 Food)");
                        System.out.println("3 - Hard (0 Armor, 4 HP, 2 Gold, 5 Food)");
                        System.out.println("4 - Impossible (0 Armor, 3 HP, 1 Gold, 3 Food)");

                        option2 = sc.next();

                        try
                        {
                            f = Integer.parseInt(option2);
                        } catch (Exception ex)
                        {
                            f = -1;
                        }

                    } while (f < 1 || f > 4);

                    jogo.setDifficultLevel(f);
                    return;

                case '3'://comecar
                    jogo.setState(jogo.getState().start());
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

        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
        System.out.println("Food: " + jogo.getGame().getPersonagem().getFood());
        System.out.println("Health: " + jogo.getGame().getPersonagem().getHp());
        System.out.println("Gold: " + jogo.getGame().getPersonagem().getGold());
        System.out.println("Armor: " + jogo.getGame().getPersonagem().getArmor());
        System.out.println("Area Atual: " + jogo.getGame().getCaverna().getNumArea());
        System.out.println("Nivel Atual: " + jogo.getGame().getCaverna().getNivel());
        System.out.println("Coluna Atual: " + jogo.getGame().getColuna());
        System.out.println("Nivel de dificuldade " + jogo.getGame().getDificuldade());
        System.out.println("Escolha uma carta da coluna em que se encontra\n");

        c = jogo.getGame().getCaverna().getAreaAtual().getCartasColuna();
        for (Carta cartasColuna : c)
        {
            System.out.println((++cont) + " - " + cartasColuna + "\n");
        }

        do
        {
            System.out.println("Escolha Uma Carta ( 1 - " + (c.size()) + ")");

            option1 = sc.next();

            try
            {
                op = (int) Integer.parseInt(option1);
            } catch (Exception ex)
            {
                op = -1;
            }

        } while (op < 1 || op > c.size());

        Carta temp = c.get(op - 1);

        if (temp instanceof Resting)
        {
            jogo.setState(jogo.getState().ResolveSelectedRestingCard());

        } else if (temp instanceof Treasure)
        {
            jogo.setState(jogo.getState().ResolveSelectedTreasureCard());
        } else if (temp instanceof Merchant)
        {
            jogo.setState(jogo.getState().ResolveSelectedMerchantCard());
        } else if (temp instanceof Event)
        {
            jogo.setState(jogo.getState().ResolveSelectedEventCard());
        } else if (temp instanceof Trap)
        {
            jogo.setState(jogo.getState().ResolveSelectedTrapCard());
        } else if (temp instanceof Monster)
        {
            jogo.setMonster();
            jogo.setState(jogo.getState().ResvolveSelectedMonsterCard());
        } else if (temp instanceof BossMonster)
        {
            System.out.println("FALTA FAZER");//TODO
        }
    }

    private void uiAwaitOptionSelection()
    {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c;

        do
        {
            System.out.println("\n=== AWAITING OPTION SELECTION(RESTING CARD) ===\n");
            System.out.println("1 - Reinforce your Weapon: +1 XP");
            System.out.println("2 - Search for Ration: +1 FOOD");
            System.out.println("3 - Heal: +2 HP");

            option1 = sc.next();

            try
            {
                c = (int) Integer.parseInt(option1);
            } catch (Exception ex)
            {
                c = -1;
            }

        } while (c < 1 || c > 3);

        if (!jogo.AOS_OptionSelected(c))
                //TODO: TRATAR erro
                ; else
        {
            jogo.OptionSelected(jogo.getState().OptionSelected());
        }
    }

    private void uiAwaitTrading()
    {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c;
        boolean skip = false;

        do
        {
            do
            {
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
                    skip = true;
                    break;
                }

            } while (c < 0 || c > 7);

            if (!jogo.AOS_TraidingSelection(c))
            {
                //TODO: tratar erro
            }

        } while (!skip);
    }

    private void uiAwaitAttack()
    {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c, i = 0, aux = 2;
        boolean end = false;
        do
        {

            do
            {
                System.out.println("Food: " + jogo.getGame().getPersonagem().getFood());
                System.out.println("Health: " + jogo.getGame().getPersonagem().getHp());
                System.out.println("Gold: " + jogo.getGame().getPersonagem().getGold());
                System.out.println("Armor: " + jogo.getGame().getPersonagem().getArmor());
                System.out.println("\n=== AWAITING ATTACK ===\n");
                System.out.println("Resultado dos dados: ");

                for (Dado d : jogo.getDados())
                {
                    System.out.println("Dado " + ++i + ": " + d);
                }

                System.out.println("1 - Atacar");
                System.out.println("2 - Feats");
                if (jogo.AnyCritical())
                {
                    System.out.println("3 - Reroll");
                    aux = 3;
                }

                option1 = sc.next();

                try
                {
                    c = (int) Integer.parseInt(option1);
                } catch (Exception ex)
                {
                    c = -1;
                }

            } while (c < 1 || c > aux);

            switch (c)
            {
                case 1:
                    jogo.setState(jogo.getState().AttackMontser());
                    end = true;
                    break;
                case 2:
                    jogo.setState(jogo.getState().Feats());
                    end = true;
                    break;
                case 3:
                    do
                    {
                        System.out.println("Escolha o dado que pretende fazer reroll: ");
                        for (Dado d : jogo.getDados())
                        {
                            System.out.println("Dado " + ++i + ": " + d);
                        }
                        //TODO: adicionar opcao de sair/nao escolher dado

                        option1 = sc.next();

                        try
                        {
                            c = (int) Integer.parseInt(option1);
                        } catch (Exception ex)
                        {
                            c = -1;
                        }

                    } while (c < 1 || c > i);
                    jogo.AA_Reroll(c);//TODO: interpretar erro
                    break;
            }
        } while (!end);
    }

    private void uiAwaitFeats()
    {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c, e, i = 0;
        boolean continuar = true;
        do
        {

            do
            {
                i = 0;
                System.out.println("\n=== AWAITING FEATS ===\n");
                System.out.println("ATENCAO: Custo: 2 HP ou 1 XP");

                System.out.println("Escolha o dado que pretende fazer Feat: ");
                for (Dado d : jogo.getDados())
                {
                    System.out.println("Dado " + ++i + ": " + d);
                }
                //TODO: adicionar opcao de sair/nao escolher dado
                
                System.out.println("\n0 - Sair ");
                
                option1 = sc.next();

                try
                {
                    c = (int) Integer.parseInt(option1);
                } catch (Exception ex)
                {
                    c = -1;
                    break;
                }

            } while (c < 0 || c > i);

            if(c==0)
            {
                jogo.setState(jogo.getState().VoltaAwaitAttack());
            }

            do
            {
                System.out.println("Forma de pagamento: 2 HP ou 1 XP");
                System.out.println("Opcao 1: 2 HP");
                System.out.println("Opcao 2: 1 XP");
                option1 = sc.next();

                try
                {
                    e = (int) Integer.parseInt(option1);
                } catch (Exception ex)
                {
                    e = -1;
                }

            } while (e != 1 && e != 2);
            
            switch (jogo.AA_Feat(c, e))
            {
                case -3:
                    System.out.println("Nao tem xp suficiente");
                    break;
                case -2:
                    jogo.setState(jogo.getState().GameOver());
                    continuar = false;
                    break;
                case -1:
                    System.out.println("Once a die has been rerolled through a Feat, you must accept its result");
                    continuar = true;
                    break;
                case 1:
                    System.out.println("Sucesso a featar o dado");
                    jogo.setState(jogo.getState().VoltaAwaitAttack());
                    continuar=false;
                    break;
            }
        } while (continuar);
    }

    private void uiAwaitSpellChoose()
    {
        Scanner sc = new Scanner(System.in);
        String option1;
        int c, i = 0;
        do
        {
            System.out.println("\n=== AWAITING SPELLS CHOOSE ===\n");

            System.out.println("Status do Monstro:");
            System.out.println(jogo.getMonstroAlvo());

            if (!jogo.getSpells().isEmpty())
            {
                System.out.println("Spells:");
                for (Spell d : jogo.getSpells())
                {
                    System.out.println("Spell " + ++i + ": " + d);
                }

                option1 = sc.next();

                try
                {
                    c = (int) Integer.parseInt(option1);
                } catch (Exception ex)
                {
                    c = -1;
                }

            } else
            {
                c=0;
                break;
            }

        } while (c < 1 || c > i);
        if(jogo.AS_ChooseSpell(c))
            jogo.setState(jogo.getState().EndBattle());
        else
            jogo.setState(jogo.getState().ProxRonda());

    }

    public void run()
    {
        while (!sair)
        {
            IStates state = jogo.getState();

            if (state instanceof AwaitBegining)
            {
                uiAwaitBeggining();
            } else if (state instanceof AwaitCardCardSelectionOnCurrentColumn)
            {
                uiAwaitCardCardSelectionOnCurrentColumn();
            } else if (state instanceof AwaitOptionSelection)
            {
                uiAwaitOptionSelection();
            } else if (state instanceof AwaitTraiding)
            {
                uiAwaitTrading();
            } else if (state instanceof AwaitAttack)
            {
                uiAwaitAttack();
            } else if (state instanceof AwaitFeats)
            {
                uiAwaitFeats();
            } else if (state instanceof AwaitSpellChoose)
            {
                uiAwaitSpellChoose();
            } else if (state instanceof GameOver)
            {
                System.out.println();
                System.out.println("************** Game over *****************");
                sair = true;
            }
        }
    }
}
