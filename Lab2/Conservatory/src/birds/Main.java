package birds;

public class Main {
    public static void main(String[] args) {
        Birds hawk1 = new Hawks("hawk01");
        Conservatory c1 = new Conservatory(0);
        try {
            c1.assignBirds(hawk1);

        }
        catch (IllegalStateException e) {
            System.out.println(e.toString());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }

        c1.printIndex();

    }
}
