import org.junit.Before;
import org.junit.Test;

import dungeon.*;
import static org.junit.Assert.*;

public class MedievalLevelBuilderTest {
    MedievalLevelBuilder m1;

    @Before
    public void setup() {
        m1 = new MedievalLevelBuilder(1, 5, 20, 10);
        for (int i = 0; i < 5; i++) {
            m1.addRoom("room");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor() {
        MedievalLevelBuilder m2 = new MedievalLevelBuilder(-1, 2, 5, 8);
    }

    @Test(expected = IllegalStateException.class)
    public void testAddRoom() {
        m1.addRoom("room");
    }

    @Test(expected = IllegalStateException.class)
    public void testAddGoblins() {
        m1.addGoblins(0, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoblins2() {
        m1.addGoblins(6, 2);
    }

    @Test(expected = IllegalStateException.class)
    public void testAddOrc() {
        m1.addGoblins(0, 20);
        m1.addOrc(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGOrc2() {
        m1.addOrc(8);
    }

    @Test(expected = IllegalStateException.class)
    public void testAddOgre() {
        m1.addGoblins(0, 20);
        m1.addOgre(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGOgre2() {
        m1.addOgre(9);
    }

    @Test(expected = IllegalStateException.class)
    public void testAddHuman() {
        m1.addGoblins(0, 20);
        m1.addHuman(1, "John", "a shy boy", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddHuman2() {
        m1.addHuman(9, "Pola", " a girl", 11);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddPotion2() {
        m1.addPotion(9);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuild() {
        m1.build();
    }

    @Test
    public void testBuild2() {
        MedievalLevelBuilder m3 = new MedievalLevelBuilder(6, 1, 4, 3);
        m3.addRoom("room");
        m3.addGoblins(0, 1);
        m3.addOgre(0);
        m3.addOrc(0);
        m3.addHuman(0, "Jessy", "a talktive guy", 20);
        m3.addPotion(0);
        m3.addGold(0, 8);
        m3.addWeapon(0, "a sword");
        Level l6 = m3.build();

        assertEquals(l6.getLevelNumber(), 6);
        System.out.println(l6.toString());
    }


}