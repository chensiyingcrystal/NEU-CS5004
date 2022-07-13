package birds;

import java.util.Arrays;
import java.util.List;

abstract class Shorebirds extends NearWaterBirds {
    protected String[] specific_c;
    private static String[] SHARED_C = {""};
    private static List<String> valid = Arrays.asList("wetlands", "saltwater", "ocean");

    public Shorebirds(String waterBody) {
        if (!valid.contains(waterBody)) {
            throw new IllegalArgumentException("This is not a shorebirds!");
        }
    }


    @Override
    public String[] getCharacteristic() {
        int specificLen = specific_c.length;
        int sharedLen = SHARED_C.length;
        String[] added_c = new String[specificLen + sharedLen];

        System.arraycopy(SHARED_C, 0, added_c, 0, sharedLen);
        System.arraycopy(specific_c, 0, added_c, sharedLen, specificLen);
        return added_c;
    }
    


}
