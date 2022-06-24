package birds;

abstract class Parrots extends AbstractBirds {
    protected String[] specific_c;
    private static String[] SHARED_C = {"short, curved beak", "intelligence and mimic sounds"};
    int numberOfWords;
    String favoriteSaying;

    @Override
    public String[] getCharacteristic() {
        int specificLen = specific_c.length;
        int sharedLen = SHARED_C.length;
        String[] added_c = new String[specificLen + sharedLen];

        System.arraycopy(SHARED_C, 0, added_c, 0, sharedLen);
        System.arraycopy(specific_c, 0, added_c, sharedLen, specificLen + sharedLen);
        return added_c;
    }


    int getNumberOfWords() {
        return this.numberOfWords;
    }

    String getFavoriteSaying() {
        return this.favoriteSaying;
    }

}
