public abstract class GearImpl implements Gear{
    protected String nameAdj;
    protected String nameNoun;
    protected GearType gearType;
    protected int attackValue;
    protected int defenseValue;

    @Override
    public Gear combine(Gear other) {
        return null;
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
