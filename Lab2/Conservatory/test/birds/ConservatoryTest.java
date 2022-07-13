package birds;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class ConservatoryTest {
    Conservatory c1;
    Birds hawk1;
    Birds kiwis1;
    Birds hawk2;
    Birds owls1;
    Birds pigeons1;
    Birds pigeons2;
    Birds greatauk1;
    Birds swans1;
    Birds geese1;

    @Before
    public void Setup()throws Exception {
        this.hawk1 = new Hawks("hawk1");
        this.kiwis1 = new Kiwis("Kiwis1");
        this.hawk2 = new Hawks("hawk2");
        this.owls1 = new Owls("owls1");
        this.pigeons1 = new Pigeons("pigeon101");
        this.pigeons2 = new Pigeons("pigeon102");
        this.greatauk1 = new GreatAuk("greatauk1");
        this.swans1 = new Swan("swan1");
        this.geese1 = new Geese("geese1");

        this.c1 = new Conservatory();
        c1.assignBirds(hawk1);
        c1.assignBirds(hawk2);
        c1.assignBirds(owls1);
        c1.assignBirds(pigeons1);
        c1.assignBirds(pigeons2);
        c1.assignBirds(greatauk1);
        c1.assignBirds(swans1);
        c1.assignBirds(geese1);

    }

    @Test
    public void testAssignBirds() {
        try {
            c1.assignBirds(hawk1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //test if extinct birds can be added to the conservatory
        //expected: IllegalStateException
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
            c1.printSignForAviary(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printSignForAviary2() {
        //test if index passed is invalid(less than 1)
        try {
            c1.printSignForAviary(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //test if index passed is invalid(greater than total number of aviaries in this conservatory)
        try {
            c1.printSignForAviary(6);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getMapOfAviaryAndBirdsInfo() {
        c1.getMapOfAviaryAndBirdsInfo();

    }

    @Test
    public void printIndex() {
        c1.printIndex();

    }

    @Test
    public void testGetNumOfBirds() throws Exception {
        assertEquals(c1.getNumOfBirds(), 8);

        Birds owl1 = new Owls("owls101");
        c1.assignBirds(owl1);

        assertEquals(c1.getNumOfBirds(),9);
    }

    @Test
    public void testGetNumOfAviaries() throws Exception {
        assertEquals(c1.getNumOfAviaries(), 4);

        Birds owl1 = new Owls("owls101");
        Birds duck1 = new Duck("duck102");
        c1.assignBirds(owl1);
        c1.assignBirds(duck1);

        assertEquals(c1.getNumOfAviaries(),4);
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