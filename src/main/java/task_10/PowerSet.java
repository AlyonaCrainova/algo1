package task_10;

public class PowerSet {
    private ArrayList<String> list;

    public PowerSet() {
        list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    private PowerSet(ArrayList<String> set) {
        list = set;
    }

    public void put(String value) {
        if (!list.contains(value)) {
            list.add(value);
        }
    }

    public boolean get(String value) {
        return list.contains(value);
    }

    public boolean remove(String value) {
        return list.remove(value);
    }

    public PowerSet intersection(PowerSet set2) {
        if (set2 == null){
            return new PowerSet();
        }
        PowerSet intersection = new PowerSet();
        for (String s : list) {
            if (set2.get(s)) {
                intersection.put(s);
            }
        }
        return intersection;
    }

    public PowerSet union(PowerSet set2) {
        if (set2 == null){
            return new PowerSet(list);
        }
        PowerSet union = new PowerSet(set2.list);
        for (String value: list) {
            union.put(value);
        }
        return union;
    }

    public PowerSet difference(PowerSet set2) {
        if (set2 == null){
            return new PowerSet(list);
        }
        PowerSet difference = new PowerSet();
        for (String value: list) {
            if(!set2.list.contains(value)){
                difference.put(value);
            }
        }
        return difference;
    }

    public boolean isSubset(PowerSet set2) {
        if (set2 == null){
            return false;
        }
        for (String value: set2.list) {
            if(!list.contains(value)){
                return false;
            }
        }
        return true;
    }
}