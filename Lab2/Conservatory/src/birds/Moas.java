package birds;

public class Moas extends Flightless{
    AviaryCategory aviaryCategory;

    public Moas(String birdID) {
        this.id = birdID;
        this.aviaryCategory = AviaryCategory.Flightless;
        this.type = BirdType.Moas;
        this.specific_c = new String[] {"small head", "long leg"};
        this.isExtinct = true;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.seeds, Food.fruit};
    }
}
