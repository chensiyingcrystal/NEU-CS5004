package birds;


public final class Hawks extends Prey {
    AviaryCategory aviaryCategory;

    public Hawks(String birdID) {
        this.id = birdID;
        this.aviaryCategory = AviaryCategory.Prey;
        this.type = BirdType.Hawks;
        this.specific_c = new String[] {"sharp, curved talons"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.smallMammals, Food.insects};
    }
}
