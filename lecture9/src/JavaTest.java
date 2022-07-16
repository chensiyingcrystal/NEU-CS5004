public class JavaTest {
    public static void main(String[] args) {
        // Any object variable is a pointer (instead of
        // an actual object)

        // 1. create an object of Person
        // 2. create a pointer called p
        // 3. point `p` to the newly created Person object
        Person p = new Person("Tom", 32);

        // 1. Create a pointer called `p1`
        // 2. point `p1` to what `p` is pointing to
        Person p1 = p;

        // To prove that p and p1 are pointing to the same object
        System.out.println(p.age);
        p1.age = 34;
        System.out.println(p.age);

        func(p1);
        System.out.println(p.age);
        System.out.println(p1.age);

    }

    static public void func(Person arg) {
        arg.age = 10;
    }


}
