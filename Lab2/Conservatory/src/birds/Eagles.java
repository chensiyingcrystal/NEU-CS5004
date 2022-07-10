package birds;

public class Eagles extends Prey{
    AviaryCategory aviaryCategory;

    public Eagles(String birdID) {
        this.id = birdID;
        this.aviaryCategory = AviaryCategory.Prey;
        this.type = "Eagles";
        this.specific_c = new String[] {"powerful vision"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.smallMammals, Food.fish, Food.otherBirds};
    }
}
