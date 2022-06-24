package birds;

public class GreatAuk extends Shorebirds {
    public GreatAuk() {
        super("ocean");
        this.type = "GreatAuk";
        this.specific_c = new String[] {""};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.smallMammals, Food.insects};
        this.nameOfWaterBody = "ocean";
    }
}
