package birds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConservatoryTest<eagle1> {
    Conservatory c1;
    Birds hawk1;
    Birds kiwis1;

    @Before
    public void Setup()throws Exception {
        this.hawk1 = new Hawks("hawk1");
        this.kiwis1 = new Kiwis("Kiwis1");
        this.c1 = new Conservatory();
        c1.assignBirds(hawk1);

    }

    @Test
    public void testAssignBirds() {
        try {
            c1.assignBirds(hawk1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            c1.assignBirds(kiwis1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testAddFood() {
        Aviary testAviary = new Aviary(5,"prey");
        try {
            c1.addFood(testAviary, hawk1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            c1.addFood(null, kiwis1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetAviaryOfBirds() {
        assertEquals(c1.getAviaryOfBirds(hawk1, "hawk1"),  1);
    }

    /**
     * printSignForAviary is 1-indexed
     * */
    @Test
    public void printSignForAviary() {
        try {
            c1.printSignForAviary(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            c1.printSignForAviary(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getMapOfAviaryAndBirdsInfo() {

    }

    @Test
    public void printIndex() {

    }

    @Test
    public void testGetNumOfBirds() throws Exception {
        assertEquals(c1.getNumOfBirds(), 1);

        Birds owl1 = new Owls("owls101");
        c1.assignBirds(owl1);

        assertEquals(c1.getNumOfBirds(),2);
    }

    @Test
    public void testGetNumOfAviaries() throws Exception {
        assertEquals(c1.getNumOfAviaries(), 1);

        Birds owl1 = new Owls("owls101");
        Birds duck1 = new Duck("duck102");
        c1.assignBirds(owl1);
        c1.assignBirds(duck1);

        assertEquals(c1.getNumOfAviaries(),3);
    }

    @Test
    public void setNumOfAviaries() {
        try {
            c1.setNumOfAviaries(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            c1.setNumOfAviaries(-5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}