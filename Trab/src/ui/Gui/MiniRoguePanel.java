/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Tiago Coutinho
 */
public class MiniRoguePanel extends JPanel implements Observer, Constants {

    static private BufferedImage TheDungeonImage = null, CharacterStatsImage = null, BackCardImage = null, BossMonsterImage = null,
            EventImage = null, MerchantImage = null, MonsterImage = null, RestingImage = null, TrapImage = null, TreasureImage = null, WelcomeImage = null,
            TokenImage1 = null, TokenImage2 = null, BackgroundImage = null, WinImage= null, GOImage=null, bgBotoesImage = null;
    static private ArrayList<BufferedImage> dadosImage = new ArrayList<>();

    public static BufferedImage getTheDungeonImage() {
        return TheDungeonImage;
    }

    public static ArrayList<BufferedImage> getDadosImage() {
        return dadosImage;
    }

    public static BufferedImage getTokenImage1() {
        return TokenImage1;
    }

    public static BufferedImage getTokenImage2() {
        return TokenImage2;
    }

    public static BufferedImage getCharacterStats() {
        return CharacterStatsImage;
    }

    public static BufferedImage getBackCardImage() {
        return BackCardImage;
    }

    public static BufferedImage getBossMonsterImage() {
        return BossMonsterImage;
    }

    public static BufferedImage getEventImage() {
        return EventImage;
    }

    public static BufferedImage getMerchantImage() {
        return MerchantImage;
    }

    public static BufferedImage getMonsterImage() {
        return MonsterImage;
    }

    public static BufferedImage getRestingImage() {
        return RestingImage;
    }

    public static BufferedImage getTrapImage() {
        return TrapImage;
    }

    public static BufferedImage getTreasureImage() {
        return TreasureImage;
    }

    public static BufferedImage getWelcomeImage() {
        return WelcomeImage;
    }

    public static BufferedImage getBackgroundImage() {
        return BackgroundImage;
    }

    public static BufferedImage getGameoverImg() {
        return GOImage;
    }

    public static BufferedImage getWinImg() {
        return WinImage;
    }
    public static Image getBgBotoesImg() {
        return bgBotoesImage;
    }

    static {
        try {
            TheDungeonImage = ImageIO.read(Resources.getResourceFile("images/TheDungeon.JPG"));
            CharacterStatsImage = ImageIO.read(Resources.getResourceFile("images/CharacterStats.JPG"));
            BackCardImage = ImageIO.read(Resources.getResourceFile("images/BackCard.JPG"));
            BossMonsterImage = ImageIO.read(Resources.getResourceFile("images/BossMonster.JPG"));
            EventImage = ImageIO.read(Resources.getResourceFile("images/Event.JPG"));
            MerchantImage = ImageIO.read(Resources.getResourceFile("images/Merchant.JPG"));
            MonsterImage = ImageIO.read(Resources.getResourceFile("images/Monster.JPG"));
            RestingImage = ImageIO.read(Resources.getResourceFile("images/Resting.JPG"));
            TrapImage = ImageIO.read(Resources.getResourceFile("images/Trap.JPG"));
            TreasureImage = ImageIO.read(Resources.getResourceFile("images/Treasure.JPG"));
            WelcomeImage = ImageIO.read(Resources.getResourceFile("images/MiniRogue.png"));
            TokenImage1 = ImageIO.read(Resources.getResourceFile("images/Token_24x26.png"));
            TokenImage2 = ImageIO.read(Resources.getResourceFile("images/Token_37x41.png"));
            BackgroundImage = ImageIO.read(Resources.getResourceFile("images/Fundo.jpg"));
            
            GOImage = ImageIO.read(Resources.getResourceFile("images/Gameover.png"));
            WinImage = ImageIO.read(Resources.getResourceFile("images/Win.png"));
            bgBotoesImage = ImageIO.read(Resources.getResourceFile("images/bgBotoes.png"));
            
            dadosImage.add(ImageIO.read(Resources.getResourceFile("images/d1.png")));
            dadosImage.add(ImageIO.read(Resources.getResourceFile("images/d2.png")));
            dadosImage.add(ImageIO.read(Resources.getResourceFile("images/d3.png")));
            dadosImage.add(ImageIO.read(Resources.getResourceFile("images/d4.png")));
            dadosImage.add(ImageIO.read(Resources.getResourceFile("images/d5.png")));
            dadosImage.add(ImageIO.read(Resources.getResourceFile("images/d6.png")));

        } catch (IOException e) {
            System.out.println("Error loading images ");
        }
    }

    

    private ObservableGame observableGame;
    private DungeonPanel dungeonPanel;
    private CardsPanel cardsPanel;
    private CharacterStatsPanel characterStatsPanel;

    private AwaitBattleOptionPanel awaitBattleOptionPanel;
    private AwaitBeginingPanel awaitBeginingPanel;
    private AwaitCardSelectionOnCurrentColumnPanel awaitCardCardSelectionOnCurrentColumnPanel;
    private AwaitFeatsPanel awaitFeatsPanel;
    private AwaitOptionSelectionPanel awaitOptionSelectionPanel;
    private AwaitSpellChoosePanel awaitSpellChoosePanel;
    private AwaitTraidingPanel awaitTraidingPanel;
    private GameOverPanel gameOverPanel;
    private WelcomePanel welcomePanel;

    public MiniRoguePanel(ObservableGame j) throws IOException {
        observableGame = j;

        observableGame.addObserver(this);

        setupComponents();
        setupLayout();

        update(observableGame, null);
    }

    public void setupComponents() throws IOException {
        dungeonPanel = new DungeonPanel(observableGame);
        cardsPanel = new CardsPanel(observableGame);
        characterStatsPanel = new CharacterStatsPanel(observableGame);
        welcomePanel = new WelcomePanel(observableGame);

        awaitBattleOptionPanel = new AwaitBattleOptionPanel(observableGame);
        awaitBeginingPanel = new AwaitBeginingPanel(observableGame);
        awaitCardCardSelectionOnCurrentColumnPanel = new AwaitCardSelectionOnCurrentColumnPanel(observableGame);
        awaitFeatsPanel = new AwaitFeatsPanel(observableGame);
        awaitOptionSelectionPanel = new AwaitOptionSelectionPanel(observableGame);
        awaitSpellChoosePanel = new AwaitSpellChoosePanel(observableGame);
        awaitTraidingPanel = new AwaitTraidingPanel(observableGame);
        gameOverPanel = new GameOverPanel(observableGame);

    }

    public void setupLayout() {
        Box LeftBox = Box.createVerticalBox();
        LeftBox.setMaximumSize(new Dimension(DIM_X_DUNGEON, DIM_Y_DUNGEON));
        LeftBox.setMinimumSize(new Dimension(DIM_X_DUNGEON, DIM_Y_DUNGEON));
        LeftBox.setPreferredSize(new Dimension(DIM_X_DUNGEON, DIM_Y_DUNGEON));

        LeftBox.add(dungeonPanel);

        Box MidBox = Box.createVerticalBox();

        Box b = Box.createHorizontalBox();
        b.add(Box.createHorizontalGlue());
        b.add(Box.createVerticalGlue());
        b.add(welcomePanel);
        b.add(Box.createHorizontalGlue());
        b.add(Box.createVerticalGlue());

        MidBox.add(cardsPanel);
        MidBox.add(b);
        welcomePanel.setBorder(new LineBorder(Color.darkGray));
        MidBox.setBorder(new LineBorder(Color.BLUE));

        Box center = Box.createHorizontalBox();
        center.add(LeftBox);
        center.add(MidBox);

        JPanel south = new JPanel();
        south.setMinimumSize(new Dimension(DIM_X_SOUTH_PANEL, DIM_Y_SOUTH_PANEL));
        south.setPreferredSize(new Dimension(DIM_X_SOUTH_PANEL, DIM_Y_SOUTH_PANEL));
        south.setBorder(new LineBorder(Color.GREEN));
        south.setLayout(new GridLayout());

        Box StatsBox = Box.createHorizontalBox();
        StatsBox.add(characterStatsPanel);
        StatsBox.setBorder(new LineBorder(Color.YELLOW));

        Box StateBox = Box.createVerticalBox();
        StateBox.add(awaitBattleOptionPanel);
        StateBox.add(awaitBeginingPanel);
        StateBox.add(awaitCardCardSelectionOnCurrentColumnPanel);
        StateBox.add(awaitFeatsPanel);
        StateBox.add(awaitOptionSelectionPanel);
        StateBox.add(awaitSpellChoosePanel);
        StateBox.add(awaitTraidingPanel);
        StateBox.add(gameOverPanel);
        StateBox.setBorder(new LineBorder(Color.RED));

        south.add(StatsBox);
        south.add(StateBox);

        setLayout(new BorderLayout());
//        setLayout(new GridLayout(2,2,0,0));
        center.setSize(900, 500);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        validate();

    }

    @Override
    public void update(Observable t, Object o) {
        
    }
}
