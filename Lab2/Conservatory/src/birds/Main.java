package birds;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Conservatory c1 = new Conservatory();

        Birds eagle1 = new Eagles("eagle22");
        c1.assignBirds(eagle1);

        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 3; ++j) {
                Birds eagle = new Eagles("eagle" + j);
                c1.assignBirds(eagle);
            }
                Birds hawk = new Hawks("hawk" + i);
            c1.assignBirds(hawk);
        }

        Birds osprey1 = new Osprey("Osprey123");
        c1.assignBirds(osprey1);

        Birds owls = null;
        for (int i = 0; i < 2; ++i) {
            owls = new Owls("owl" + i);
            c1.assignBirds(owls);
        }
        c1.getMapOfAviaryAndBirdsInfo();

        c1.getAviaryOfBirds(owls, "owl1");

        c1.printSignForAviary(2);// 1-indexed

        c1.printIndex();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        c1.printFoodMap();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");

        List<AviaryCategory> l1 = Arrays.asList(AviaryCategory.Flightless, AviaryCategory.Prey);

    }
}
