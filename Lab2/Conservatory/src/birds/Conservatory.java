package birds;

import java.util.*;

public class Conservatory {
    private int numOfAviaries = 0;
    private int numOfBirds = 0;
    private final int maxNumOfAviaries = 20;
    private ArrayList<Aviary> aviaryArrayList;
    //Calculate what food needs to be kept and in what quantities
    private Map<Aviary,Map<Food, Integer>> foodMap;
    private Map<Aviary, Integer> locationMap;


    // create a conservatory with given arbitrary number of aviaries
    public Conservatory(int numOfAviaries) {
        this.numOfAviaries = numOfAviaries;

    }

   /**
    * A method is required to put bird into one of four different aviaries by bird category.
    *
    *
    *
    *
    *
    * */


    //Add and Assign a bird to an aviary in the conservatory. Assignments must follow some criteria.
    public String assignBirds(Birds bird) throws Exception {
        //check if bird is extinct
        if (bird.isExtinct()) {
            throw new IllegalStateException("Extinct bird cannot be added to conservatory.");
        }

        // add the first bird to the first aviary
        if (aviaryArrayList.isEmpty() && numOfAviaries == 0) {
            Aviary firstAviary = new Aviary(5, bird.getType());
            newBird(bird, firstAviary);

        }

        String newBirdType = bird.getType();
        // add the bird to the existing aviary with specific type
        for (int i = 0; i < aviaryArrayList.size(); ++ i) {
            Aviary tempAviary = aviaryArrayList.get(i);
            if (tempAviary.getCategory().equals(newBirdType)) {
                // if added to aviary, no change to aviary position and number;
                if (tempAviary.addBird(bird)) {
                    numOfBirds ++;
                    for (int j = 0; j < bird.getFood().length; ++j) {
                        foodMap.get(tempAviary).merge(bird.getFood()[j], 1, Integer::sum);
                    }
                    return bird.getID();
                }
            }
        }

        // if not found existing aviary, try to add the bird to a new aviary
        if (!isFullConservatory()) {
            Aviary newAviary = new Aviary(5, bird.getType());
            aviaryArrayList.add(newAviary);
            newBird(bird, newAviary);
            return bird.getID();
        }

        // if no existing specific aviary is found and conservatory reaches its maximum capacity,
        // return null;
        return null;

    }

    private void newBird(Birds bird, Aviary newAviary) {
        numOfAviaries ++;
        numOfBirds++;
        locationMap.put(newAviary, numOfAviaries);
        for (int i = 0; i < bird.getFood().length; ++i) {
            foodMap.get(newAviary).merge(bird.getFood()[i], 1, Integer::sum);
        }
    }

    private boolean isFullConservatory() {
        if (numOfAviaries == maxNumOfAviaries)
            return true;
        return false;
    }


    // Have a guest look up which aviary a bird is in
    // return aviary location
    public int getAviaryOfBirds(Birds bird) {
        //first find aviary according to birdCategory
        for (int i = 0; i < aviaryArrayList.size(); ++ i) {
            Aviary tempAviary = aviaryArrayList.get(i);
            // if a correct type of existed aviary is found
            if (tempAviary.getCategory().equals(bird.getType())) {
                // loop through birdList in this existing aviary to find the bird
                for (int j = 0; j <tempAviary.getBirdList().size(); ++ j) {
                    if (bird.getID().equals(tempAviary.getBirdList().get(j))) {
                        System.out.println(bird.getID() + " is at" + locationMap.get(tempAviary));
                        return locationMap.get(tempAviary); // or return i ??
                    }
                }
            }
        }
        // find bird according to birdID in those aviaries
        // if not found, return -1;
        return -1;

    }

    //Print a sign for any given aviary that gives a description of the birds it houses and any interesting information that it may have about that animal.
    public void printSignForAviary(int aviaryIndex) {
        //
        if (aviaryIndex > aviaryArrayList.size()) {
            throw new IllegalStateException("At given location, no aviary found.");
        }

        Aviary tempAviary = aviaryArrayList.get(aviaryIndex);
        for (int i = 0; i < tempAviary.getSize(); ++ i) {
            Birds bird = tempAviary.getBirdList().get(i);
            System.out.println("bird " + i
                    + "id : " + bird.getID()
                    + ", bird type: " + bird.getType()
                    + ", characteristics: " + Arrays.toString(bird.getCharacteristic())
                    + ", number of wings: " + bird.getNumberOfWings()
                    + ", favorite food: " + Arrays.toString(bird.getFood()));
        }

    }

    //Print a “map” that lists all the aviaries by location and the birds they house
    public void getMapOfAviaryAndBirdsInfo() {
        for (Map.Entry<Aviary, Integer> entry : this.locationMap.entrySet()) {
            Aviary currAviary = entry.getKey();
            System.out.println("location:" + entry.getValue() + "; "
                             + "aviary category" + currAviary.getCategory());
            for (int i = 0; i < currAviary.getSize(); i++) {
                Birds currBird = currAviary.getBirdList().get(i);
                System.out.print("birdID:" + currBird.getID() + ", "+ "birdType" + currBird.getType() + "; ");
            }
            System.out.println("--------------------------------");
        }

        return;

    }

    //Print an index that lists all birds in the conservatory in alphabetical order and their location
    public void printIndex() {
        //loop through each aviaries and add each bird in it to the map with their id and location
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<Aviary, Integer> entry : this.locationMap.entrySet()) {
            Integer currLocation = entry.getValue();
            Aviary currAviary = entry.getKey();
            for (int i = 0; i < currAviary.getSize(); i++) {
                Birds currBird = currAviary.getBirdList().get(i);
                String birdTypeAndID = "BirdType:" + currBird.getType() + ", " + "BirdID:" + currBird.getID();
                map.put(birdTypeAndID, currLocation);
            }
        }
        //instantiate a treemap from map and print out all birds information and their location
        Map<String, Integer> treeMap = new TreeMap<>(map);
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " ,BirdLocation: " + entry.getValue());
        }

        return;

    }

    public int getNumOfAviaries() {
        return this.numOfAviaries;
    }

    public void setNumOfAviaries(int numOfAviaries) {
        this.numOfAviaries = numOfAviaries;

    }

}
