package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AbstractBirdsTest{
    Birds hawk1;
    Birds owl1;
    Birds roseRingParakeet1;
    Birds greatAuk1;
    Birds kiwis1;
    Birds swan1;

    @Before
    public void setUp() throws Exception {
        this.hawk1 = new Hawks("hawk1");
        this.owl1 = new Owls("owl1");
        this.roseRingParakeet1 = new RoseRingParakeet("roseRingParakeet1");
        this.greatAuk1 = new GreatAuk("greatAuk1");
        this.kiwis1 = new Kiwis(("kiwis1"));

    }

    @Test
    public void testGetID() {
        assertEquals("hawk1", hawk1.getID());
        assertEquals("owl1", owl1.getID());
        assertEquals("roseRingParakeet1", roseRingParakeet1.getID());
        assertEquals("greatAuk1", greatAuk1.getID());
        assertEquals("kiwis1", kiwis1.getID());
    }

    @Test
    public void testGetCharacteristic() {
        assertEquals(new String[] {"sharp hooked beaks", "visible nostrils", "sharp, curved talons"}, hawk1.getCharacteristic());
        assertEquals(new String[] {"round, forward-looking eyes"}, owl1.getCharacteristic());
        assertEquals(new String[] {"short, curved beak", "intelligence and mimic sounds", "rose colored ring"}, roseRingParakeet1.getCharacteristic());
        assertEquals(new String[] {"", "black back and head", "a white front"}, greatAuk1.getCharacteristic());
        assertEquals(new String[] {"fewer wing bones", "live on the ground","tiny wings", "loose feather"}, kiwis1.getCharacteristic());
    }

    @Test
    public void testGetBirdType() {
        assertEquals(BirdType.Hawks, hawk1.getBirdType());
        assertEquals(BirdType.Owls, owl1.getBirdType());
        assertEquals(BirdType.RoseRingParakeet, roseRingParakeet1.getBirdType());
        assertEquals(BirdType.GreatAuk, greatAuk1.getBirdType());
        assertEquals(BirdType.Kiwis, kiwis1.getBirdType());
    }

    @Test
    public void testIsExtinct() {
        this.kiwis1 = new Kiwis("kiwis1");
        assertFalse(hawk1.isExtinct());
        assertFalse(owl1.isExtinct());
        assertFalse(roseRingParakeet1.isExtinct());
        assertFalse(greatAuk1.isExtinct());
        assertTrue(kiwis1.isExtinct());
    }

    @Test
    public void testGetNumberOfWings() {
        assertEquals(2, hawk1.getNumberOfWings());
        assertEquals(2, owl1.getNumberOfWings());
        assertEquals(2, roseRingParakeet1.getNumberOfWings());
        assertEquals(2, greatAuk1.getNumberOfWings());
        assertEquals(2, kiwis1.getNumberOfWings());
    }

    @Test
    public void testGetFood() {
        assertEquals(Arrays.toString(new String[]{String.valueOf(Food.smallMammals), String.valueOf(Food.insects)}), Arrays.toString(hawk1.getFood()));
        assertEquals(Arrays.toString(new String[]{String.valueOf(Food.fish), String.valueOf(Food.otherBirds), String.valueOf(Food.insects)}), Arrays.toString(owl1.getFood()));
        assertEquals(Arrays.toString(new String[]{String.valueOf(Food.smallMammals), String.valueOf(Food.insects)}), Arrays.toString(roseRingParakeet1.getFood()));
        assertEquals(Arrays.toString(new String[]{String.valueOf(Food.smallMammals), String.valueOf(Food.insects)}), Arrays.toString(greatAuk1.getFood()));
        assertEquals(Arrays.toString(new String[]{String.valueOf(Food.seeds), String.valueOf(Food.insects)}), Arrays.toString(kiwis1.getFood()));
    }

    @Test
    public void testGetWaterBody() {
        this.swan1 = new Swan("swan1");
        this.kiwis1 = new Kiwis("kiwis1");
        assertEquals("ocean", greatAuk1.getNameOfWaterBody());
        assertEquals("freshwater",swan1.getNameOfWaterBody());
        try {
            assertEquals("something",kiwis1.getNameOfWaterBody());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetFavoriteSaying() {
        assertEquals("hello", roseRingParakeet1.getFavoriteSaying());
        try {
            assertEquals("something", greatAuk1.getFavoriteSaying());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}