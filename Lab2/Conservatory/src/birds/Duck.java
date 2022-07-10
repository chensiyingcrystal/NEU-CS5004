package birds;

public class Duck extends WaterFowl{
    AviaryCategory aviaryCategory;

    public Duck(String birdID) {
        super("freshwater");
        this.id = birdID;
        this.aviaryCategory = AviaryCategory.Waterfowl;
        this.type = "Duck";
        this.specific_c = new String[] {"waterproof feathers"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.vegetation, Food.insects};
        this.nameOfWaterBody = "freshwater";
    }
}
