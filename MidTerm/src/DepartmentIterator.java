import java.util.*;

public class DepartmentIterator implements Iterator<Engineer>{
    private Map<Integer, OrderedListImpl<Engineer>> map;
    private int teamid;
    private int index;
    private int count;


    public DepartmentIterator(DepartmentImpl department) {
        this.map = department.engineerMap;
        teamid = 0;
        index = 0;
        count = department.getTotalSize();
    }

    @Override
    public boolean hasNext() {
        return count != 0;
    }

    @Override
    public Engineer next() {
        if (map.get(teamid) == null || index >= map.get(teamid).size()) {
            teamid++;
            index = 0;
            return next();
        }

        Engineer e1 = map.get(teamid).get(index);
        index++;
        count--;
        return e1;


    }
}
