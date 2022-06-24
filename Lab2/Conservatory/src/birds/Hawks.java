package birds;

public final class Hawks extends Prey {
    public Hawks() {
        this.type = "Hawks";
        this.specific_c = new String[] {"sharp, curved talons"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.smallMammals, Food.insects};
    }
}
