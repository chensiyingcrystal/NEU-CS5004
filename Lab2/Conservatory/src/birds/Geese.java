package birds;

public class Geese extends WaterFowl{
    AviaryCategory aviaryCategory;

    public Geese(String birdID) {
        super("freshwater");
        this.id = birdID;
        this.aviaryCategory = AviaryCategory.Waterfowl;
        this.type = BirdType.Geese;
        this.specific_c = new String[] {"long foot"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.nuts, Food.vegetation, Food.insects};
        this.nameOfWaterBody = "freshwater";
    }
}
