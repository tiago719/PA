/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import LogicaJogo.States.AwaitCardSelectionOnCurrentColumn;
import LogicaJogo.States.AwaitFeats;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitFeatsPanel extends JPanel implements Observer
{
    private ArrayList<JLabel> Dados;
    private JButton Cancelar;
    private ObservableGame observableGame;

    public AwaitFeatsPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        observableGame.addObserver(this);
        
        Dados=new ArrayList<>();
        
        setVisible(observableGame.getState() instanceof AwaitFeats); 

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        Cancelar=new JButton("Cancelar");
        Cancelar.addMouseListener(new ActionListener(observableGame, 0));
        
        int i;
        for (i = 0; i < observableGame.getDados().size(); i++)
        {
            Dados.add(new JLabel(new ImageIcon(MiniRoguePanel.getDadosImage().get(observableGame.getDados().get(i).getFace()))));
            
            Dados.get(i).addMouseListener(new ActionListener(observableGame,i));
        }
    }

    public void setupLayout()
    {
        add(Cancelar);
        for(int i=0;i<Dados.size();i++)
        {
            add(Dados.get(i));
        }
    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitFeats);
    }
}

class ActionListener  extends MouseAdapter
{
    private int i;
    private ObservableGame observableGame;
    
    public ActionListener(ObservableGame o,int i)
    {
        this.i=i;
        observableGame=o;
    }
    
    @Override
    public void mousePressed(MouseEvent ev)
    {
       observableGame.FeatsOptionSelected(i, 1);//TODO: Mudar a segunda variavel desta func ( 1 - HP 2 - XP)

    }
}