public interface MyList<T> extends Iterable<T>{
    int size();
    void add(T val);
    T get(int index);
    // remove the elm at `index`
    void remove(int index);
    // Get a sublist of the elements that are <= 4
    MyList subList(T threshold);
}
