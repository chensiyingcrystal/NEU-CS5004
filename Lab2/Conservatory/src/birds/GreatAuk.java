package birds;

public class GreatAuk extends Shorebirds {
    public GreatAuk(String birdID) {
        super("ocean");
        this.id = birdID;
        this.type = "GreatAuk";
        this.specific_c = new String[] {"black back and head", "a white front"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.smallMammals, Food.insects};
        this.nameOfWaterBody = "ocean";
    }
}
