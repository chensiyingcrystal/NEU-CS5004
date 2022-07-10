package birds;

public class Emus extends Flightless{
    AviaryCategory aviaryCategory;

    public Emus(String birdID) {
        this.id = birdID;
        this.aviaryCategory = AviaryCategory.Flightless;
        this.type = "Emus";
        this.specific_c = new String[] {"soft-feathered", "long necks"};
        this.isExtinct = true;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.seeds, Food.insects};
    }
}
