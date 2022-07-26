public interface Gear {
    public Gear combine(Gear other);
    public GearType getGearType();
    public String getNameAdj();
    public String getNameNoun();
    public int getAttackValue();
    public int getDefenseValue();
}
