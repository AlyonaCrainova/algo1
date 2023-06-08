package task_10;


public class PowerSet {
    public String[] slots;
    int count;
    private static final int STEP = 1;

    public PowerSet() {
        slots = new String[20000];
    }

    public int size() {
        return slots.length;
    }

    private PowerSet(PowerSet set) {
        slots = set.slots;
        count = set.count;
    }

    public void put(String value) {
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
            count ++;
        }
    }

    public boolean get(String value) {
        return find(value) != -1;
    }

    public boolean remove(String value) {
        int index = find(value);
        if(index != -1) {
            slots[index] = null;
            count --;
        }
        return index != -1;
    }

    public PowerSet intersection(PowerSet set2) {
        if (set2 == null){
            return new PowerSet();
        }
        PowerSet intersection = new PowerSet();
        for (String value : slots) {
            if (value != null && set2.get(value)) {
                intersection.put(value);
            }
        }
        return intersection;
    }

    public PowerSet union(PowerSet set2) {
        if (set2 == null){
            return new PowerSet(this);
        }
        PowerSet union = new PowerSet(set2);
        for (String value: slots) {
            if(value != null) {
                union.put(value);
            }
        }
        return union;
    }

    public PowerSet difference(PowerSet set2) {
        if (set2 == null){
            return new PowerSet(this);
        }
        PowerSet difference = new PowerSet();
        for (String value: slots) {
            if(value != null && !set2.get(value)){
                difference.put(value);
            }
        }
        return difference;
    }

    public boolean isSubset(PowerSet set2) {
        if (set2 == null){
            return false;
        }
        for (String value: set2.slots) {
            if(value != null && !get(value)){
                return false;
            }
        }
        return true;
    }

    private int hashFun(String value) {
        int sum = 0;
        for (char c : value.toCharArray()) {
            sum = ((sum * 94) % slots.length + (c - '!' + 1)) % slots.length;
        }
        return sum;
    }

    private int seekSlot(String value) {
        int base = hashFun(value);
        for (int i = 0; i <= slots.length / STEP; i++) {
            int nextProbe = (base + STEP * i) % slots.length;
            if (slots[nextProbe] == null) {
                return nextProbe;
            }
            if(slots[nextProbe].equals(value)){
                return -1;
            }
        }
        return -1;
    }

    private int find(String value) {
        int base = hashFun(value);
        for (int i = 0; i <= slots.length / STEP; i++) {
            int nextProbe = (base + STEP * i) % slots.length;
            if (slots[nextProbe] != null && slots[nextProbe].equals(value)) {
                return nextProbe;
            }
        }
        return -1;
    }

    public int count(){
        return count;
    }
}