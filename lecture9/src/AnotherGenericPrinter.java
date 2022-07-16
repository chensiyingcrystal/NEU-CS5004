public class AnotherGenericPrinter {
    private Object internal;

    public AnotherGenericPrinter(Object i) {
        this.internal = i;
    }

    public void print() {
        System.out.println(this.internal.toString());
    }

    public Object getInternal() {
        return this.internal;
        // The java compiler is not going to catch the mistake below
        //return new Integer(2);
    }

    public static void main(String[] args) {
        AnotherGenericPrinter gp =
                new AnotherGenericPrinter(new Integer(2));
        gp.print();
        Integer i = (Integer)gp.getInternal();

        AnotherGenericPrinter gp2 =
                new AnotherGenericPrinter(new Person("Tom", 32));
        gp2.print();
        Person p = (Person) gp2.getInternal();
    }
}
