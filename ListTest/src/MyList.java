public interface MyList {
    int size();
    void add(int val);
    int get(int index);
    void remove(int index);
    MyList subList();
}
