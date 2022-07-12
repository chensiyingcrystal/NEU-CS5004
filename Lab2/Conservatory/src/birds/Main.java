package birds;

public class Main {
    public static void main(String[] args) throws Exception {
        Conservatory c1 = new Conservatory();

        Birds eagle1 = new Eagles("eagle22");
        c1.assignBirds(eagle1);

        for (int i = 0; i < 7; ++i) {
            Birds hawk = new Hawks("hawk" + i);
            c1.assignBirds(hawk);
        }

        Birds osprey1 = new Osprey("Osprey123");
        c1.assignBirds(osprey1);
//        Birds owls = null;
//        for (int i = 0; i < 100; ++i) {
//            owls = new Owls("owl" + i);
//            c1.assignBirds(owls);
//        }
        c1.getMapOfAviaryAndBirdsInfo();
        System.out.println("~~~~~~~~~~~~~~~~~~");
        System.out.println("total number of Aviaries: " + c1.getNumOfAviaries());
        System.out.println("total number of birds: " + c1.getNumOfBirds());
        System.out.println("~~~~~~~~~~~~~~~~~~");

//        c1.getAviaryOfBirds(owls, "owl1");

        c1.printSignForAviary(2);// 1-indexed
//        c1.printIndex();


//        try {
//            c1.assignBirds(hawk1);
//
//        }
//        catch (IllegalStateException e) {
//            System.out.println(e.toString());
//        }
//        catch (Exception e) {
//            System.out.println(e.toString());
//        }
//
//        c1.printIndex();

    }
}
