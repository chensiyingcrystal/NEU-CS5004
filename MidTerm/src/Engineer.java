public interface Engineer extends Comparable<Engineer> {
  // get the name
  String getName();

  // compute and set bonus according to the rules
  void setBonus(Rating rating);

  // get the computed bonus
  double getBonus();
}
