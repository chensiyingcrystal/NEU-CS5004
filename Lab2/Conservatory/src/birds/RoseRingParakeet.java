package birds;

public class RoseRingParakeet extends Parrots {
    public RoseRingParakeet(String birdID) {
        this.id = birdID;
        this.type = "Roseringparakeet";
        this.specific_c = new String[] {"rose colored ring"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.smallMammals, Food.insects};
        this.numberOfWords = 20;
        this.favoriteSaying = "hello";
    }
}
