package birds;

public class Main {
    public static void main(String[] args) throws Exception {
        Conservatory c1 = new Conservatory();

//        Birds eagle1 = new Eagles("eagle22");
//        c1.assignBirds(eagle1);

        for (int i=0;i<7;++i) {
            Birds hawk = new Hawks("hawk" + i);
            c1.assignBirds(hawk);
        }

        for (int i=0;i<600;++i) {
            Birds owls = new Owls("owl" + i);
            c1.assignBirds(owls);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~");
        System.out.println("total number of Aviaries: " + c1.getNumOfAviaries());
        System.out.println("~~~~~~~~~~~~~~~~~~");

        /**
         * aviary满了后加不进去第二个
         *
         * */

        c1.getMapOfAviaryAndBirdsInfo();

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
