import java.util.*;

public class DepartmentImpl implements Department{
    public Map<Integer, OrderedListImpl<Engineer>> engineerMap;

    public DepartmentImpl() {
        this.engineerMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            engineerMap.put(i, new OrderedListImpl<>());
        }
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (Map.Entry<Integer, OrderedListImpl<Engineer>> entry : this.engineerMap.entrySet()) {
            OrderedListImpl<Engineer> l1 = entry.getValue();
            for (int i = 0; i < l1.size(); i++) {
                totalSize++;
            }
        }
        return totalSize;
    }


    @Override
    public boolean hire(Engineer e, int teamId) {
        if (teamId >= 4) {
            throw new IndexOutOfBoundsException("Wrong team id");
        }

        if (this.engineerMap.get(teamId).size() == 3) {
            System.out.println("This team is full!");
            return false;
        }

        this.engineerMap.get(teamId).add(e);
        return true;
    }


    @Override
    public void giveOutBonus() {
        for (Map.Entry<Integer, OrderedListImpl<Engineer>> entry : this.engineerMap.entrySet()) {
            OrderedListImpl<Engineer> l1 = entry.getValue();
            for (int i = 0; i < l1.size(); i++) {
                Engineer e1 = l1.get(i);
                e1.setBonus(Rating.EXCEED_EXPECTATION);
            }
        }
    }

    @Override
    public Iterator<Engineer> iterator() {
        return new DepartmentIterator(this);
    }
}
