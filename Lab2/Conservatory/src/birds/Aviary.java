package birds;

import java.util.ArrayList;

public class Aviary {
    private String category;
    private int upperLimit;
    private ArrayList<Birds> birdList;

    public Aviary() {
        this.category = "";
        this.upperLimit = 0;
        this.birdList = new ArrayList<>();

    }

    public Aviary(int upperLimit, String category) {
        this.category = category;
        this.upperLimit = upperLimit;
        this.birdList = new ArrayList<>();
    }

    // changed to boolean type in to determine whether the bird is added to aviary successfully
    public boolean addBird(Birds birdName) throws Exception {
        if (this.isFull()) {
            throw new Exception("This aviary is full!");
        }
        this.birdList.add(birdName);
        return true;
    }

    private boolean isFull() {
        return this.birdList.size() == this.upperLimit;
    }

    public int getSize() {
        return this.birdList.size();
    }

    public int getUpperLimit() {
        return this.upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Birds> getBirdList() {
        return this.birdList;
    }

    public void setBirdList(ArrayList<Birds> birdList) {
        this.birdList = birdList;
    }



}
