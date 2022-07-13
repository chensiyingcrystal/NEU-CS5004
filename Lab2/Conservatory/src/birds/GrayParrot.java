package birds;

public class GrayParrot extends Parrots{
    public GrayParrot(String birdID) {
        this.id = birdID;
        this.type = BirdType.GrayParrot;
        this.specific_c = new String[]{"sweet and affectionate", "quite sociable"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[]{Food.seeds, Food.insects};
        this.numberOfWords = 1000;
        this.favoriteSaying = "Goodbye";
    }


}
