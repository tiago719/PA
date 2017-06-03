/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

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

    public MiniRoguePanel(ObservableGame j)
    {
        observableGame = j;
    }

    @Override
    public void update(Observable t, Object o)
    {
        //TODO:fazer isto
    }
}
