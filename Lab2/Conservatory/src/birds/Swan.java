package birds;

public class Swan extends WaterFowl{
    AviaryCategory aviaryCategory;

    public Swan(String birdID) {
        super("freshwater");
        this.id = birdID;
        this.aviaryCategory = AviaryCategory.Waterfowl;
        this.type = "Swan";
        this.specific_c = new String[] {"long neck and clean feather"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.vegetation, Food.fish};
        this.nameOfWaterBody = "freshwater";
    }
}
