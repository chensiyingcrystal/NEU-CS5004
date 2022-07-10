package birds;

public class HomePuffin extends Shorebirds{
    public HomePuffin(String birdID) {
        super("ocean");
        this.id = birdID;
        this.type = "HomePuffin";
        this.specific_c = new String[] {"short and stocky diving sea bird"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.fish};
        this.nameOfWaterBody = "ocean";
    }
}
