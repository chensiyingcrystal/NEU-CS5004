package birds;

import java.util.ArrayList;
import java.util.Map;

public class Conservatory {
    private int numOfAviaries;
    private ArrayList<Aviary> aviaryArrayList;
    //Calculate what food needs to be kept and in what quantities
    private ArrayList<Map<Food, Integer>> foodMap;

    public Conservatory(int numOfAviaries) {
        this.numOfAviaries = numOfAviaries;



    }


    //Add and Assign a bird to an aviary in the conservatory. Assignments must follow some criteria.
    public int assignBirds(Birds bird) {
        //check if bird is extinct

        //first check if the conservatory is full

        //check bird type and if its specific aviary is full

        return 0;

    }

    private boolean isFull() {
        return true;
    }


    //Have a guest look up which aviary a bird is in
    //add birdID
    public int getAviaryOfBirds(Birds bird) {
        //first find aviary according to birdCategory

        //find bird according to birdID in those aviaries

        return 0;

    }

    //Print a sign for any given aviary that gives a description of the birds it houses and any interesting information that it may have about that animal.
    public void printSignForAviary(int aviaryIndex) {
        //
        return;

    }

    //Print a “map” that lists all the aviaries by location and the birds they house
    public void getMapOfAviaryAndBirdsInfo() {
        return;

    }

    //Print an index that lists all birds in the conservatory in alphabetical order and their location
    public void printIndex() {
        return;

    }

    public int getNumOfAviaries() {
        return this.numOfAviaries;
    }

    public void setNumOfAviaries(int numOfAviaries) {
        this.numOfAviaries = numOfAviaries;

    }

}
