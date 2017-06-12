/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static ui.Gui.Constants.DIM_X_AREA_PANEL;
import static ui.Gui.Constants.DIM_X_BETWEEN_AREA;
import static ui.Gui.Constants.DIM_X_DUNGEON;
import static ui.Gui.Constants.DIM_X_QUADRICULA_AREA;
import static ui.Gui.Constants.DIM_Y_AREA_PANEL;
import static ui.Gui.Constants.DIM_Y_BETWEEN_AREA;
import static ui.Gui.Constants.DIM_Y_DUNGEON;
import static ui.Gui.Constants.DIM_Y_QUADRICULA_AREA;
import static ui.Gui.Constants.MAXAREA;
import static ui.Gui.Constants.START_X_AREA_PANEL;
import static ui.Gui.Constants.START_Y_AREA_PANEL;

/**
 *
 * @author Tiago Coutinho
 */
public class JP_DungeonMaximizada extends JDialog implements Constants, java.awt.event.ActionListener
{
    private ObservableGame observableGame;
    private JLabel AreaAtual;
    private Map<Integer, JLabel> AreaP;
    private JPanel jp;
    private JLabel Image;

    JP_DungeonMaximizada(ObservableGame o, BufferedImage img)
    {
        observableGame=o;
                
        JPanel jp = new JPanel();
        
        JLabel Image = new JLabel(new ImageIcon(img));
    
        AreaP=new HashMap<>();
        
        setupComponents();
        setupLayout();
        
        Iterator it=AreaP.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry t =(Map.Entry) it.next();
            JLabel jl=(JLabel)t.getValue();
            jl.addMouseListener(new clicaArea(observableGame, (int)t.getKey(), this));
        }
        
        Image.setLayout(null);
        jp.add(Image);
        Image.add(AreaAtual);
        add(jp);

    }
    
    public void setupComponents()
    {
        AreaAtual=new JLabel();
    }
    
    public void setupLayout()
    {
        AreaAtual.setBounds(START_X_AREA_PANEL_POPUP, START_Y_AREA_PANEL_POPUP, DIM_X_AREA_PANEL_POPUP, DIM_Y_AREA_PANEL_POPUP);
        addAreaAtual();
    }
    
    public void addAreaAtual()
    {
        //AreaAtual.setBorder(new LineBorder(Color.RED));
        int aux=1;
        for (int i = 0 ; i < MAXAREA; i++)
        {
            JLabel temp = new JLabel();
            AreaAtual.add(temp);
            if(i==2 || i==3 || i==6 || i==7 || i==11 || i==15)
            {
                continue;
            }else
            {
                AreaP.put(aux, temp);
                aux++;
            }
            //AreaP.get(aux-1).setBorder(new LineBorder(Color.BLACK));
        }

        AreaAtual.setLayout(new GridLayout(5, 4, DIM_X_BETWEEN_AREA_POPUP, DIM_Y_BETWEEN_AREA_POPUP));
        AreaAtual.setVisible(true);
        
        AreaAtual.setMinimumSize(new Dimension(DIM_X_AREA_PANEL_POPUP, DIM_Y_AREA_PANEL_POPUP));
        AreaAtual.setPreferredSize(new Dimension(DIM_X_AREA_PANEL_POPUP, DIM_Y_AREA_PANEL_POPUP));
        AreaAtual.setMaximumSize(new Dimension(DIM_X_AREA_PANEL_POPUP, DIM_Y_AREA_PANEL_POPUP));

        for (int i = 1; i < aux; i++)
        {
            AreaP.get(i).setMinimumSize(new Dimension(DIM_X_QUADRICULA_AREA_POPUP, DIM_Y_QUADRICULA_AREA_POPUP));
            AreaP.get(i).setPreferredSize(new Dimension(DIM_X_QUADRICULA_AREA_POPUP, DIM_Y_QUADRICULA_AREA_POPUP));
            AreaP.get(i).setMaximumSize(new Dimension(DIM_X_QUADRICULA_AREA_POPUP, DIM_Y_QUADRICULA_AREA_POPUP));
//            AreaAtual.add(AreaP.get(i));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        dispose();
    }
    
   
}

class clicaArea extends MouseAdapter
{
    private int area;
    private ObservableGame observableGame;
    private JDialog pai;
    
    public clicaArea(ObservableGame o,int area, JDialog pai)
    {
        observableGame=o;
        this.area = area;
        this.pai=pai;
    }
    
    @Override
        public void mouseClicked(MouseEvent e) 
        {
            observableGame.setStartingArea(area);
            pai.dispose();
        }
}
