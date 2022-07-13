package birds;

abstract class NearWaterBirds extends AbstractBirds {
    protected String nameOfWaterBody;

    @Override
    public String getNameOfWaterBody() {
        return this.nameOfWaterBody;
    }


    @Override
    public String getFavoriteSaying() {
        throw new IllegalStateException(getBirdType() + " are not parrots.");
    }
}
