package birds;

public final class Owls extends AbstractBirds {
    private String[] characteristic;

    public Owls() {
        this.type = "Owls";
        this.characteristic = new String[] {"round, forward-looking eyes"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.fish, Food.otherBirds, Food.insects};
    }

    @Override
    public String[] getCharacteristic() {
        return this.characteristic;
    }
}
