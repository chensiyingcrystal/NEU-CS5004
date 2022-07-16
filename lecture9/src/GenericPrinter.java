public class GenericPrinter<U> {
    private U i;

    public GenericPrinter(U i) {
        this.i = i;
    }

    public void print() {
        System.out.println(i.toString());
    }

    public U getInternal() {
        return this.i;
    }

    public static void main(String[] args) {
        GenericPrinter<Integer> gp =
                new GenericPrinter<Integer>(new Integer(2));
        gp.print();
        Integer i = gp.getInternal();

        GenericPrinter<Person> gp2 =
                new GenericPrinter<>(new Person("Tom", 32));
        gp2.print();
        Person p = gp2.getInternal();

    }
}
