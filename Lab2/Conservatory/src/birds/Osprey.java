package birds;

public class Osprey extends Prey{
    AviaryCategory aviaryCategory;

    public Osprey(String birdID) {
        this.id = birdID;
        this.aviaryCategory = AviaryCategory.Prey;
        this.type = BirdType.Osprey;
        this.specific_c = new String[] {"powerful vision"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.smallMammals, Food.fish, Food.otherBirds};
    }
}
