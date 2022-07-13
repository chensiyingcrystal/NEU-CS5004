package birds;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Conservatory c1 = new Conservatory();

        Birds duck = new Duck("duck123");
        c1.assignBirds(duck);

        Random rand = new Random();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 2; ++j) {
                Birds eagle = new Eagles("eagle" + rand.nextInt(50));
                while (set.contains(eagle.getID())) {
                    eagle = new Eagles("eagle" + rand.nextInt(50));
                }
                c1.assignBirds(eagle);
                set.add(eagle.getID());
            }
            Birds hawk = new Hawks("hawk" + rand.nextInt(50));
            c1.assignBirds(hawk);
        }

        Birds osprey1 = new Osprey("Osprey123");
        c1.assignBirds(osprey1);

        Birds owls = null;
        for (int i = 0; i < 2; ++i) {
            owls = new Owls("owl" + i);
            c1.assignBirds(owls);
        }

        // printing the map if all aviaries
        System.out.println("######### getMapOfAviaryAndBirdsInfo() demo, printing out birds in each aviary#################");
        c1.getMapOfAviaryAndBirdsInfo();
        System.out.println("###############################################################################################\n");

        // printing where is the target bird owl1 is located
        System.out.println("********* demo of getAviaryOfBirds() function to printing out owl1 location *****************");
        c1.getAviaryOfBirds(owls, "owl1");
        System.out.println("********************************************************************************************\n");

        System.out.println("^^^^^^^^^ printSignForAviary() demo, printing put all birds in aviary 2 ^^^^^^^^^^^^^^^^^^^");
        c1.printSignForAviary(2);// 1-indexed
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&& printIndex() demo, printing all existing birds&&&&&&&&&&&&&&&&&&&&&");
        c1.printIndex();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");

        System.out.println("~~~~~~printFoodMap(), printing all food distribution~~~~~~~~~~~~~~~~~");
        c1.printFoodMap();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

    }
}
