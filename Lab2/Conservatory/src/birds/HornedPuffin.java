package birds;

public class HornedPuffin extends Shorebirds{
    public HornedPuffin(String birdID) {
        super("ocean");
        this.id = birdID;
        this.type = BirdType.HornedPuffin;
        this.specific_c = new String[] {"short and stocky diving sea bird"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.fish};
        this.nameOfWaterBody = "ocean";
    }
}
