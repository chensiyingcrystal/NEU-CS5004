package birds;

public interface Birds {
    String getID();

    String getType();

    String[] getCharacteristic();

    boolean isExtinct();

    int getNumberOfWings();

    Food[] getFood();

}
