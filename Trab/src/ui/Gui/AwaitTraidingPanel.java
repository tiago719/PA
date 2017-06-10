/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitBattleOption;
import LogicaJogo.States.AwaitTraiding;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitTraidingPanel extends JPanel implements Observer
{
    private ObservableGame observableGame;
    private JButton Ration, HealthPotion, BigHealthPotion, ArmorPiece, Any1Spell,SellArmorPiece, SellAny1Spell, Continuar;
    private JTextField buyTextField,sellTextField; 

    public AwaitTraidingPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        observableGame.addObserver(this);
        
        setVisible(observableGame.getState() instanceof AwaitTraiding);

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        buyTextField=new JTextField("Buy");
        
        Ration=new JButton("Ration");  
        Ration.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.MerchantOptionSelected(1);
            }
        });
        
        HealthPotion=new JButton("HealthPotion");
        HealthPotion.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.MerchantOptionSelected(2);
            }
        });
        
        BigHealthPotion=new JButton("BigHealthPotion");
        BigHealthPotion.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.MerchantOptionSelected(3);
            }
        });
        
        ArmorPiece=new JButton("ArmorPiece");
        ArmorPiece.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.MerchantOptionSelected(4);
            }
        });
          
        Any1Spell=new JButton("Any1Spell");
        Any1Spell.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.MerchantOptionSelected(5);
            }
        });
        
        sellTextField=new JTextField("Sell");
        
        SellArmorPiece=new JButton("SellArmorPiece");
        SellArmorPiece.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.MerchantOptionSelected(6);
            }
        });
        
        SellAny1Spell=new JButton("SellAny1Spell");
        SellAny1Spell.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.MerchantOptionSelected(7);
            }
        });
        
        Continuar=new  JButton("Continuar");
        Continuar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ev)
            {
                observableGame.MerchantOptionSelected(8);
            }
        });
    }

    public void setupLayout()
    {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        add(buyTextField);
        add(Ration);
        add(HealthPotion);
        add(BigHealthPotion);
        add(ArmorPiece);
        add(Any1Spell);
        add(sellTextField);
        add(SellArmorPiece);
        add(SellAny1Spell);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitTraiding);
    }

}
