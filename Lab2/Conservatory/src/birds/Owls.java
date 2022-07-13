package birds;

public final class Owls extends AbstractBirds {
    private String[] characteristic;

    public Owls(String birdID) {
        this.id = birdID;
        this.type = BirdType.Owls;
        this.characteristic = new String[] {"round, forward-looking eyes"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.fish, Food.otherBirds, Food.insects};
    }

    @Override
    public String[] getCharacteristic() {
        return this.characteristic;
    }

    @Override
    public String getNameOfWaterBody() {
        System.out.println(getBirdType() + " are not water bird.");
        return null;
    }

    @Override
    public String getFavoriteSaying() {
        System.out.println(getBirdType() + " are not parrots.");
        return null;
    }
}
