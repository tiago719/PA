/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Tiago Coutinho
 */
public class AwaitFeatsPanel extends JPanel implements Observer
{

    private ArrayList<JButton> Dados;
    private JButton Cancelar;
    private ObservableGame observableGame;

    public AwaitFeatsPanel(ObservableGame observableGame)
    {
        this.observableGame = observableGame;
        observableGame.addObserver(this);

        setupComponents();
        setupLayout();
    }

    public void setupComponents()
    {
        Cancelar=new JButton("Cancelar");
        Cancelar.addActionListener(new ActionListener()
        {
            @Override
                public void actionPerformed(ActionEvent ev)
                {
                    observableGame.FeatsOptionSelected(0, 1);

                }
        });
        int i,j;
        for (i = 0; i < observableGame.getDados().size(); i++)
        {
//            Dados.add(new JButton("Dados " + i + ": " + observableGame.getDado(i).getFace()));
/*            Dados.get(i).addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ev)
                {
                    //TODO: comecar aqui
                   // observableGame.FeatsOptionSelected(i, 1);//TODO: Mudar a segunda variavel desta func

                }
            });*/
        }
    }

    public void setupLayout()
    {

    }

    @Override
    public void update(Observable o, Object arg)
    {
        setVisible(observableGame.getState() instanceof AwaitFeatsPanel);
    }

}
