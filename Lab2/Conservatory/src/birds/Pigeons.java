package birds;

public final class Pigeons extends AbstractBirds {
    private String[] characteristic;

    public Pigeons(String birdID) {
        this.id = birdID;
        this.type = "Pigeons";
        this.characteristic = new String[] {"gentle, plump, small-billed birds"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.seeds, Food.fruit};
    }

    @Override
    public String[] getCharacteristic() {
        return this.characteristic;
    }
}