package birds;

public interface Birds {
    String getID();

    String[] getCharacteristic();

    BirdType getBirdType();

    boolean isExtinct();

    int getNumberOfWings();

    Food[] getFood();

    String getNameOfWaterBody();

    String getFavoriteSaying();

}
