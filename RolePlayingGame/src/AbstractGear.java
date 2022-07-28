public abstract class AbstractGear implements Gear{
    protected String nameAdj;
    protected String nameNoun;
    protected GearType gearType;
    protected int attackValue;
    protected int defenseValue;

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

    @Override
    public GearType getGearType() {
        return this.gearType;
    }

    @Override
    public String getNameAdj() {
        return nameAdj;
    }

    @Override
    public String getNameNoun() {
        return nameNoun;
    }

    @Override
    public int getAttackValue() {
        return attackValue;
    }

    @Override
    public int getDefenseValue() {
        return defenseValue;
    }

}
