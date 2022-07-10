package birds;

public class AfricanJacana extends Shorebirds{
    public AfricanJacana(String birdID) {
        super("wetlands");
        this.id = birdID;
        this.type = "AfricanJacana";
        this.specific_c = new String[] {"chestnut, white, and black waterbird"};
        this.isExtinct = false;
        this.numberOfWings = 2;
        this.food = new Food[] {Food.fish};
        this.nameOfWaterBody = "wetlands";
    }
}
