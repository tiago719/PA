/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Logic.Cartas.Carta;
import Logic.Spells.Spell;
import LogicaJogo.States.IStates;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Coutinho
 */
public class JogoTest
{
    
    public JogoTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getGame method, of class Jogo.
     */
    @Test
    public void testGetGame()
    {
        System.out.println("getGame");
        Jogo instance = new Jogo();
        GameData expResult = null;
        GameData result = instance.getGame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class Jogo.
     */
    @Test
    public void testGetState()
    {
        System.out.println("getState");
        Jogo instance = new Jogo();
        IStates expResult = null;
        IStates result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setState method, of class Jogo.
     */
    @Test
    public void testSetState()
    {
        System.out.println("setState");
        IStates s = null;
        Jogo instance = new Jogo();
        instance.setState(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDifficultLevel method, of class Jogo.
     */
    @Test
    public void testSetDifficultLevel()
    {
        System.out.println("setDifficultLevel");
        Integer valueOf = null;
        Jogo instance = new Jogo();
        instance.setDifficultLevel(valueOf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartingArea method, of class Jogo.
     */
    @Test
    public void testSetStartingArea()
    {
        System.out.println("setStartingArea");
        int valueOf = 0;
        Jogo instance = new Jogo();
        instance.setStartingArea(valueOf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comecar method, of class Jogo.
     */
    @Test
    public void testComecar()
    {
        System.out.println("comecar");
        Jogo instance = new Jogo();
        instance.comecar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RestingOptionSelected method, of class Jogo.
     */
    @Test
    public void testRestingOptionSelected()
    {
        System.out.println("RestingOptionSelected");
        Jogo instance = new Jogo();
        instance.RestingOptionSelected();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MerchantOptionSelected method, of class Jogo.
     */
    @Test
    public void testMerchantOptionSelected()
    {
        System.out.println("MerchantOptionSelected");
        Jogo instance = new Jogo();
        instance.MerchantOptionSelected();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AtacaMonstro method, of class Jogo.
     */
    @Test
    public void testAtacaMonstro()
    {
        System.out.println("AtacaMonstro");
        Jogo instance = new Jogo();
        instance.AtacaMonstro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Feats method, of class Jogo.
     */
    @Test
    public void testFeats()
    {
        System.out.println("Feats");
        Jogo instance = new Jogo();
        instance.Feats();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of VoltaAwaitAttack method, of class Jogo.
     */
    @Test
    public void testVoltaAwaitAttack()
    {
        System.out.println("VoltaAwaitAttack");
        Jogo instance = new Jogo();
        instance.VoltaAwaitAttack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GameOver method, of class Jogo.
     */
    @Test
    public void testGameOver()
    {
        System.out.println("GameOver");
        Jogo instance = new Jogo();
        instance.GameOver();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EndBatle method, of class Jogo.
     */
    @Test
    public void testEndBatle()
    {
        System.out.println("EndBatle");
        Jogo instance = new Jogo();
        instance.EndBatle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ProxRonda method, of class Jogo.
     */
    @Test
    public void testProxRonda()
    {
        System.out.println("ProxRonda");
        Jogo instance = new Jogo();
        instance.ProxRonda();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of treasure method, of class Jogo.
     */
    @Test
    public void testTreasure()
    {
        System.out.println("treasure");
        Jogo instance = new Jogo();
        instance.treasure();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of event method, of class Jogo.
     */
    @Test
    public void testEvent()
    {
        System.out.println("event");
        Carta c = null;
        Jogo instance = new Jogo();
        instance.event(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trap method, of class Jogo.
     */
    @Test
    public void testTrap()
    {
        System.out.println("trap");
        Jogo instance = new Jogo();
        instance.trap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of monster method, of class Jogo.
     */
    @Test
    public void testMonster()
    {
        System.out.println("monster");
        Carta c = null;
        Jogo instance = new Jogo();
        instance.monster(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of merchant method, of class Jogo.
     */
    @Test
    public void testMerchant()
    {
        System.out.println("merchant");
        Jogo instance = new Jogo();
        instance.merchant();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resting method, of class Jogo.
     */
    @Test
    public void testResting()
    {
        System.out.println("resting");
        Jogo instance = new Jogo();
        instance.resting();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AA_Reroll method, of class Jogo.
     */
    @Test
    public void testAA_Reroll()
    {
        System.out.println("AA_Reroll");
        int c = 0;
        Jogo instance = new Jogo();
        boolean expResult = false;
        boolean result = instance.AA_Reroll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AA_Feat method, of class Jogo.
     */
    @Test
    public void testAA_Feat()
    {
        System.out.println("AA_Feat");
        int d = 0;
        int custo = 0;
        Jogo instance = new Jogo();
        int expResult = 0;
        int result = instance.AA_Feat(d, custo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpells method, of class Jogo.
     */
    @Test
    public void testGetSpells()
    {
        System.out.println("getSpells");
        Jogo instance = new Jogo();
        ArrayList<Spell> expResult = null;
        ArrayList<Spell> result = instance.getSpells();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonagem method, of class Jogo.
     */
    @Test
    public void testGetPersonagem()
    {
        System.out.println("getPersonagem");
        Jogo instance = new Jogo();
        Personagem expResult = null;
        Personagem result = instance.getPersonagem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonstroAlvo method, of class Jogo.
     */
    @Test
    public void testGetMonstroAlvo()
    {
        System.out.println("getMonstroAlvo");
        Jogo instance = new Jogo();
        Carta expResult = null;
        Carta result = instance.getMonstroAlvo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCartasColuna method, of class Jogo.
     */
    @Test
    public void testGetCartasColuna()
    {
        System.out.println("getCartasColuna");
        Jogo instance = new Jogo();
        ArrayList<Carta> expResult = null;
        ArrayList<Carta> result = instance.getCartasColuna();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AS_ChooseSpell method, of class Jogo.
     */
    @Test
    public void testAS_ChooseSpell()
    {
        System.out.println("AS_ChooseSpell");
        int c = 0;
        Jogo instance = new Jogo();
        boolean expResult = false;
        boolean result = instance.AS_ChooseSpell(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AnyCritical method, of class Jogo.
     */
    @Test
    public void testAnyCritical()
    {
        System.out.println("AnyCritical");
        Jogo instance = new Jogo();
        boolean expResult = false;
        boolean result = instance.AnyCritical();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDados method, of class Jogo.
     */
    @Test
    public void testGetDados()
    {
        System.out.println("getDados");
        Jogo instance = new Jogo();
        ArrayList<Dado> expResult = null;
        ArrayList<Dado> result = instance.getDados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDado method, of class Jogo.
     */
    @Test
    public void testGetDado()
    {
        System.out.println("getDado");
        int i = 0;
        Jogo instance = new Jogo();
        Dado expResult = null;
        Dado result = instance.getDado(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AOS_OptionSelected method, of class Jogo.
     */
    @Test
    public void testAOS_OptionSelected()
    {
        System.out.println("AOS_OptionSelected");
        int i = 0;
        Jogo instance = new Jogo();
        instance.AOS_OptionSelected(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AOS_TraidingSelection method, of class Jogo.
     */
    @Test
    public void testAOS_TraidingSelection()
    {
        System.out.println("AOS_TraidingSelection");
        int i = 0;
        Jogo instance = new Jogo();
        boolean expResult = false;
        boolean result = instance.AOS_TraidingSelection(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHpPersonagem method, of class Jogo.
     */
    @Test
    public void testGetHpPersonagem()
    {
        System.out.println("getHpPersonagem");
        Jogo instance = new Jogo();
        int expResult = 0;
        int result = instance.getHpPersonagem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasHeal method, of class Jogo.
     */
    @Test
    public void testHasHeal()
    {
        System.out.println("hasHeal");
        Jogo instance = new Jogo();
        boolean expResult = false;
        boolean result = instance.hasHeal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Healing method, of class Jogo.
     */
    @Test
    public void testHealing()
    {
        System.out.println("Healing");
        Jogo instance = new Jogo();
        instance.Healing();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMsg method, of class Jogo.
     */
    @Test
    public void testAddMsg()
    {
        System.out.println("addMsg");
        String s = "";
        Jogo instance = new Jogo();
        instance.addMsg(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMsg method, of class Jogo.
     */
    @Test
    public void testGetMsg()
    {
        System.out.println("getMsg");
        Jogo instance = new Jogo();
        String expResult = "";
        String result = instance.getMsg();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColuna method, of class Jogo.
     */
    @Test
    public void testGetColuna()
    {
        System.out.println("getColuna");
        Jogo instance = new Jogo();
        int expResult = 0;
        int result = instance.getColuna();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportarJogo method, of class Jogo.
     */
    @Test
    public void testExportarJogo()
    {
        System.out.println("exportarJogo");
        Jogo instance = new Jogo();
        boolean expResult = false;
        boolean result = instance.exportarJogo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of continuarJogo method, of class Jogo.
     */
    @Test
    public void testContinuarJogo() throws Exception
    {
        System.out.println("continuarJogo");
        Jogo instance = new Jogo();
        boolean expResult = false;
        boolean result = instance.continuarJogo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Jogo.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Jogo instance = new Jogo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
