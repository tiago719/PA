/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tiago Coutinho
 */
public class MiniRogueView extends JFrame implements Observer, Constants {

    ObservableGame observableGame;
    MiniRoguePanel panel;

    public MiniRogueView(ObservableGame j) throws IOException {
        this(j, 0, 0, DIM_X_FRAME, DIM_Y_FRAME);
    }

    public MiniRogueView(ObservableGame j, int x, int y) throws IOException {
        this(j, x, y, DIM_X_FRAME, DIM_Y_FRAME);
    }

    public MiniRogueView(ObservableGame j, int x, int y, int width, int height) throws IOException {
        super("Mini Rogue");

        observableGame = j;

        observableGame.addObserver(this);

        Container cp = getContentPane();

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        menuBar = new JMenuBar();

        menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("Game MENU");
        menuBar.add(menu);

//a group of JMenuItems
        menuItem = new JMenuItem("Stop", KeyEvent.VK_G);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Stops Game");
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.GameOver();
            }
        }
        );
        menu.add(menuItem);

        menuItem = new JMenuItem("Load");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JFileChooser fc = new JFileChooser("./data");
                int returnVal = fc.showOpenDialog(MiniRogueView.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try {
                        observableGame.LoadGame(file);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MiniRogueView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("Operation Canceled");
                }
            }
        }
        );
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent ev) {

                JFileChooser fileChooser = new JFileChooser("./data");
                if (fileChooser.showSaveDialog(MiniRogueView.this) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    observableGame.SaveGame(file);
                }
                
            }
        }
        );
        menu.add(menuItem);

//a group of radio button menu items
        menu.addSeparator();

        menuItem = new JMenuItem("Exit");

        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        menuItem.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });
        menu.add(menuItem);

        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "It Helps");
        menu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                JOptionPane.showMessageDialog(MiniRogueView.this, "HELP HELP HELP");
            }
        });
        menuBar.add(menu);
        setJMenuBar(menuBar);

        panel = new MiniRoguePanel(observableGame);

        cp.add(panel, BorderLayout.CENTER);

        setLocation(x, y);
        setSize(width, height);
        setMinimumSize(new Dimension(width, height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}
