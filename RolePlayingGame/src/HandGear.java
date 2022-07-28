public class HandGear extends AbstractGear {
    public HandGear(String nameAdj, String nameNoun, int attackValue) {
        this.nameAdj = nameAdj;
        this.nameNoun = nameNoun;
        this.gearType = GearType.handGear;
        this.attackValue = attackValue;
        this.defenseValue = 0;
    }

    @Override
    public Gear combine(Gear other) {
        if (other == null) {
            throw new NullPointerException("Null pointer to gear!");
        }

        if (other == this) {
            throw new IllegalArgumentException("Must combine with other instances!");
        }

        if (this.getGearType() != other.getGearType()) {
            throw new IllegalArgumentException("Cannot combine with other type!");
        }

        Gear combinedGear = new HandGear(this.nameAdj + " " + other.getNameAdj(), other.getNameNoun(), this.attackValue + other.getAttackValue());
        return combinedGear;
    }
}
