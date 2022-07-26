public class HeadGear extends GearImpl {
    public HeadGear(String nameAdj, String nameNoun, int defenseValue) {
        this.nameAdj = nameAdj;
        this.nameNoun = nameNoun;
        this.gearType = GearType.headGear;
        this.attackValue = 0;
        this.defenseValue = defenseValue;
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

        Gear combinedGear = new HeadGear(this.nameAdj + " " + other.getNameAdj(), other.getNameNoun(), this.defenseValue + other.getDefenseValue());
        return combinedGear;
    }
}
