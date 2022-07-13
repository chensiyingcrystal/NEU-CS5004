package birds;

abstract class Flightless extends AbstractBirds{
    protected String[] specific_c;
    private static String[] SHARED_C = {"fewer wing bones", "live on the ground"};

    @Override
    public String[] getCharacteristic() {
        int specificLen = specific_c.length;
        int sharedLen = SHARED_C.length;
        String[] added_c = new String[specificLen + sharedLen];

        System.arraycopy(SHARED_C, 0, added_c, 0, sharedLen);
        System.arraycopy(specific_c, 0, added_c, sharedLen, specificLen);
        return added_c;
    }

    @Override
    public String getNameOfWaterBody() {
        System.out.println(getBirdType() + " are not water bird.");
        return null;
    }

    @Override
    public String getFavoriteSaying() {
        System.out.println(getBirdType() + " are not parrots.");
        return null;
    }
}
