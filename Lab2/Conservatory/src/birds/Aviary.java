package birds;

import java.util.ArrayList;

public class Aviary {
    private String category;
    private int upperLimit;
    private ArrayList<Birds> birdList;

    /**
     * Class constructor.
     */
    public Aviary() {
        this.category = "";
        this.upperLimit = 0;
        this.birdList = new ArrayList<>();

    }

    /**
     * Class constructor(overloading) specifying its attributes.
     * Create an aviary with its category, upperLimit and birdList.
     * upperlimit should less or equal to 5.
     *
     * @param category The category of the aviary
     * @param upperLimit The upper limit of birds that one aviary can accommodate
     */
    public Aviary(int upperLimit, String category) {
        if(upperLimit > 5) {
            throw new IllegalArgumentException("No aviary can house more than 5 birds");
        }

        this.category = category;
        this.upperLimit = upperLimit;
        this.birdList = new ArrayList<>();
    }

    //add birds to the aviary
    // changed to boolean type in to determine whether the bird is added to aviary successfully
    public boolean addBird(Birds birdName) throws Exception {
        if (this.isFull()) {
            return false;
        }
        this.birdList.add(birdName);
        return true;
    }

    //check if the aviary is full
    private boolean isFull() {
        return this.birdList.size() == this.upperLimit;
    }

    //check if the aivary is empty
    private boolean isEmpty() {
        return this.birdList.size() == 0;
    }

    //get the number of birds in this aviary
    public int getSize() {
        return this.birdList.size();
    }

    //get the upper limit of the aviary
    public int getUpperLimit() {
        return this.upperLimit;
    }

    //set the upper limit of this aviary
    //the upper limit should <= 5 and not less than current upper limit and size.
    public void setUpperLimit(int upperLimit) {
        if(upperLimit > 5) {
            throw new IllegalArgumentException("No aviary can house more than 5 birds");
        }

        if (upperLimit < this.getUpperLimit() || upperLimit < this.getSize()) {
            throw new IllegalArgumentException("Cannot set upper limit less than current limit or size");
        }
        this.upperLimit = upperLimit;
    }

    //get the category of this aviary
    public String getCategory() {
        return this.category;
    }

    //set or reset this aviary's category only when it's empty
    public void setCategory(String category) {
        if (!this.isEmpty() && this.category != category) {
            throw new IllegalStateException("Cannot set category now");
        }
        this.category = category;
    }

    //get this aviary's bird list
    public ArrayList<Birds> getBirdList() {
        return this.birdList;
    }




}
