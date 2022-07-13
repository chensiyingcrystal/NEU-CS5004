package birds;

abstract class AbstractBirds implements Birds {
    protected String id;
    protected BirdType type;
    protected boolean isExtinct;
    protected int numberOfWings;
    protected Food[] food;

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public BirdType getBirdType() { return this.type;}

    @Override
    public boolean isExtinct() {
        return this.isExtinct;
    }

    @Override
    public int getNumberOfWings() {
        return this.numberOfWings;
    }

    @Override
    public Food[] getFood() {
        return this.food;
    }

}
