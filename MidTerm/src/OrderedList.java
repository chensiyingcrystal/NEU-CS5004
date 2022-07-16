public interface OrderedList<E extends Comparable<E>> {
  // Add `val` to the ordered list.
  void add(E val);

  // Returns the element at index `i`
  E get(int index);

  // Returns the length of the list
  int size();
}
