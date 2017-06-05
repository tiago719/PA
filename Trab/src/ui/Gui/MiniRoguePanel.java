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
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
public class MiniRoguePanel extends JPanel implements Observer, Constants
{

    static private BufferedImage TheDungeonImage = null, CharacterStatsImage = null, BackCardImage = null, BossMonsterImage = null,
            EventImage = null, MerchantImage = null, MonsterImage = null, RestingImage = null, TrapImage = null, TreasureImage = null;

    public static BufferedImage getTheDungeonImage()
    {
        return TheDungeonImage;
    }

    public static BufferedImage getCharacterStats()
    {
        return CharacterStatsImage;
    }

    public static BufferedImage getBackCardImage()
    {
        return BackCardImage;
    }

    public static BufferedImage getBossMonsterImage()
    {
        return BossMonsterImage;
    }

    public static BufferedImage getEventImage()
    {
        return EventImage;
    }

    public static BufferedImage getMerchantImage()
    {
        return MerchantImage;
    }

    public static BufferedImage getMonsterImage()
    {
        return MonsterImage;
    }

    public static BufferedImage getRestingImage()
    {
        return RestingImage;
    }

    public static BufferedImage getTrapImage()
    {
        return TrapImage;
    }

    public static BufferedImage getTreasureImage()
    {
        return TreasureImage;
    }

    static
    {
        try
        {
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

        } catch (IOException e)
        {
            System.out.println("Error loading images ");
        }
    }

    private ObservableGame observableGame;

    private DungeonPanel dungeonPanel;
    private CardsPanel cardsPanel;
    private CharacterStatsPanel characterStatsPanel;

    private AwaitBattleOptionPanel awaitBattleOptionPanel;
    private AwaitBeginingPanel awaitBeginingPanel;
    private AwaitCardCardSelectionOnCurrentColumnPanel awaitCardCardSelectionOnCurrentColumnPanel;
    private AwaitFeatsPanel awaitFeatsPanel;
    private AwaitOptionSelectionPanel awaitOptionSelectionPanel;
    private AwaitSpellChoosePanel awaitSpellChoosePanel;
    private AwaitTraidingPanel awaitTraidingPanel;
    private GameOverPanel gameOverPanel;

    public MiniRoguePanel(ObservableGame j)
    {
        observableGame = j;

        observableGame.addObserver(this);

        setupComponents();
        setupLayout();

        update(observableGame, null);
    }

    public void setupComponents()
    {
        dungeonPanel = new DungeonPanel(observableGame);
        cardsPanel = new CardsPanel(observableGame);
        characterStatsPanel = new CharacterStatsPanel(observableGame);

        awaitBattleOptionPanel = new AwaitBattleOptionPanel(observableGame);
        awaitBeginingPanel = new AwaitBeginingPanel(observableGame);
        awaitCardCardSelectionOnCurrentColumnPanel = new AwaitCardCardSelectionOnCurrentColumnPanel(observableGame);
        awaitFeatsPanel = new AwaitFeatsPanel(observableGame);
        awaitOptionSelectionPanel = new AwaitOptionSelectionPanel(observableGame);
        awaitSpellChoosePanel = new AwaitSpellChoosePanel(observableGame);
        awaitTraidingPanel = new AwaitTraidingPanel(observableGame);
        gameOverPanel = new GameOverPanel(observableGame);

    }

    public void setupLayout()
    {
        Box LeftBox = Box.createVerticalBox();
        LeftBox.setMaximumSize(new Dimension(DIM_X_STATS+BORDER_X*2, DIM_Y_STATS));
        LeftBox.setMinimumSize(new Dimension(DIM_X_STATS+BORDER_X*2, DIM_Y_STATS));
        LeftBox.setPreferredSize(new Dimension(DIM_X_STATS+BORDER_X*2, DIM_Y_STATS));
        LeftBox.setBorder(new LineBorder(Color.DARK_GRAY));

        LeftBox.add(dungeonPanel);

        Box MidBox = Box.createVerticalBox();

        MidBox.add(cardsPanel);
        MidBox.setBorder(new LineBorder(Color.BLUE));

        Box RightBox = Box.createVerticalBox();

        RightBox.add(characterStatsPanel);

        Box center = Box.createHorizontalBox();

        center.add(LeftBox);
        center.add(MidBox);
        center.add(RightBox);

        JPanel south = new JPanel();
        south.setMinimumSize(new Dimension(DIM_X_FRAME, DIM_Y_FRAME));
        south.setPreferredSize(new Dimension(DIM_X_SOUTH_PANEL, DIM_Y_SOUTH_PANEL));
        south.setBorder(new LineBorder(Color.DARK_GRAY));

        south.add(awaitBattleOptionPanel);
        south.add(awaitBeginingPanel);
        south.add(awaitCardCardSelectionOnCurrentColumnPanel);//TODO: será que este vem mesmo para aqui?
        south.add(awaitFeatsPanel);
        south.add(awaitOptionSelectionPanel);
        south.add(awaitSpellChoosePanel);
        south.add(awaitTraidingPanel);
        south.add(gameOverPanel); //TODO: será que este vem mesmo para aqui?

        setLayout(new BorderLayout());
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

    }

    @Override
    public void update(Observable t, Object o)
    {
        //TODO:fazer isto
    }
}
