package birds;

public class GreatAuk extends Shorebirds {
    public GreatAuk(String birdID) {
        super("ocean");
        this.id = birdID;
        this.type = "GreatAuk";
        this.specific_c = new String[] {""};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.smallMammals, Food.insects};
        this.nameOfWaterBody = "ocean";
    }
}
