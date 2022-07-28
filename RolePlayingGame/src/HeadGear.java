public class HeadGear extends AbstractGear {
    public HeadGear(String nameAdj, String nameNoun, int defenseValue) {
        this.nameAdj = nameAdj;
        this.nameNoun = nameNoun;
        this.gearType = GearType.headGear;
        this.attackValue = 0;
        this.defenseValue = defenseValue;
    }

}
