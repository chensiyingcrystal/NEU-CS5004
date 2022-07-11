package birds;

public class Kiwis extends Flightless{
    AviaryCategory aviaryCategory;

    public Kiwis(String birdID) {
        this.id = birdID;
        this.aviaryCategory = AviaryCategory.Flightless;
        this.type = BirdType.Kiwis;
        this.specific_c = new String[] {"tiny wings", "loose feather"};
        this.isExtinct = true;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.seeds, Food.insects};
    }
}
