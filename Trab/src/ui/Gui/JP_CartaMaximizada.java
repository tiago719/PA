/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static ui.Gui.Constants.DIM_X_CARTA_MAX;
import static ui.Gui.Constants.DIM_X_FRAME;
import static ui.Gui.Constants.DIM_Y_CARTA_MAX;
import static ui.Gui.Constants.DIM_Y_FRAME;

/**
 *
 * @author edu_f
 */
public class JP_CartaMaximizada extends JDialog implements Constants, ActionListener  {

    JP_CartaMaximizada(BufferedImage img) {
        setUndecorated(true);
        add( new JP_CartaMaximizada(img) );
        pack();
        setVisible(true);
        setLocation(new Point((DIM_X_FRAME/2)-(DIM_X_CARTA_MAX/2), (DIM_Y_FRAME/2)-(DIM_Y_CARTA_MAX/2)));
        
        
        JPanel jp = new JPanel();
        Box left = Box.createHorizontalBox();
        Box right = Box.createVerticalBox();

        JLabel Image = new JLabel(new ImageIcon(img));
        left.add(Image);

        right.setBorder(new LineBorder(Color.yellow));
        right.add(new JLabel("Escolher Carta?"));
        
        JButton btnOK = new JButton("OK");
        JButton btnCancelar = new JButton("Cancelar");
        
        btnCancelar.addActionListener(this);
        
        right.add(btnOK);
        right.add(btnCancelar);

        setLayout(new FlowLayout());
        
        jp.add(left);
        jp.add(right);
        add(jp);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }

}

class okListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e){
        
    }
    
}
