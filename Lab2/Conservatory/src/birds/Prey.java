package birds;

abstract class Prey extends AbstractBirds {
    protected String[] specific_c;
    private static String[] SHARED_C = {"sharp hooked beaks", "visible nostrils"};

    @Override
    public String[] getCharacteristic() {
        int specificLen = specific_c.length;
        int sharedLen = SHARED_C.length;
        String[] added_c = new String[specificLen + sharedLen];

        System.arraycopy(SHARED_C, 0, added_c, 0, sharedLen);
        System.arraycopy(specific_c, 0, added_c, sharedLen, specificLen + sharedLen);
        return added_c;
    }




}