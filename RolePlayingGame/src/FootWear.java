public class FootWear extends GearImpl {
    public FootWear(String nameAdj, String nameNoun, int attackValue, int defenseValue) {
        this.nameAdj = nameAdj;
        this.nameNoun = nameNoun;
        this.gearType = GearType.footwear;
        this.attackValue = attackValue;
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

        Gear combinedGear = new FootWear(this.nameAdj + " " + other.getNameAdj(), other.getNameNoun(),
                this.attackValue + other.getAttackValue(), this.defenseValue + other.getDefenseValue());
        return combinedGear;
    }
}
