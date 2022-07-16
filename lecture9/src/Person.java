public class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Person other) {
        return this.age - other.getAge();
        // equal to below

//        if (this.age > o.getAge()) return 1;
//        else if (this.age == o.getAge()) return 0;
//        else return -1;
    }
}
