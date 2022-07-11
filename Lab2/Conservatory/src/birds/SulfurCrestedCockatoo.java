package birds;

public class SulfurCrestedCockatoo extends Parrots{
    public SulfurCrestedCockatoo(String birdID) {
        this.id = birdID;
        this.type = BirdType.SulfurCrestedCockatoo;
        this.specific_c = new String[]{"large white cockatoo"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[]{Food.seeds, Food.insects};
        this.numberOfWords = 30;
        this.favoriteSaying = "bye";
    }
}
