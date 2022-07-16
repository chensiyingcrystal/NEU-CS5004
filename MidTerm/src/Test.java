import java.util.Iterator;

public class Test {
  public static void main(String[] args) {
    Department d = new DepartmentImpl();
    // senior SDE to team 0, bonus should be
    d.hire(new SeniorSDE(/*name*/"Tom", /*base salary*/100, /*num of reports*/10), 0);
    // junior SDE to team 0
    d.hire(new JuniorSDE(/*name*/"Jack", /*base salary*/ 100, /* lines of code*/ 200), 0);
    // junior SDE to team 2
    d.hire(new JuniorSDE(/*name*/"Kathy", 200, 200), 2);
    Iterator<Engineer> it = d.iterator();
    int idx = 0;
    // expected output:
    // 0 Jack 0.0
    // 1 Tom 0.0
    // 2 Kathy 0.0
    while(it.hasNext()) {
      Engineer e = it.next();
      System.out.println(idx + " " + e.getName() + " " + e.getBonus());
      idx++;
    }
    // give out bonus
    d.giveOutBonus();
    System.out.println("Giving out bonus");
    it = d.iterator();
    idx = 0;
    // expected output:
    // 0 Jack 200.0
    // 1 Tom 200.0
    // 2 Kathy 400.0
    while(it.hasNext()) {
      Engineer e = it.next();
      System.out.println(idx + " " + e.getName() + " " + e.getBonus());
      idx++;
    }
  }

}
