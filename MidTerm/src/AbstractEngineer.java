public abstract class AbstractEngineer implements Engineer{
    protected String name;
    protected double baseSalary;
    protected double bonus;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setBonus(Rating rating) {
    }

    @Override
    public double getBonus() {
        return this.bonus;
    }

    @Override
    public int compareTo(Engineer o) {
        if (o == null) {
            throw new NullPointerException("object is null!");
        }

        if (o == this) return 0;

        if (!(o instanceof Engineer)) {
            throw new IllegalArgumentException("Not same type!");
        }

        String myName = this.getName();
        String otherName = this.getName();
        return myName.compareTo(otherName);

    }
}
