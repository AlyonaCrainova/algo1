package task_8;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) {
            slots[i] = null;
        }
    }

    public int hashFun(String value) {
        int sum = 0;
        for (char c : value.toCharArray()) {
            sum = ((sum * 93) % size + (c - '!' + 1)) % size;
        }
        return sum;
    }

    public int seekSlot(String value) {
        int base = hashFun(value);
        for (int i = 0; i <= size / step; i++) {
            int nextProbe = (base + step * i) % size;
            if (slots[nextProbe] == null) {
                return nextProbe;
            }
        }
        return -1;
    }

    public int put(String value) {
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
        }
        return index;
    }

    public int find(String value) {
        int base = hashFun(value);
        for (int i = 0; i <= size / step; i++) {
            int nextProbe = (base + step * i) % size;
            if (slots[nextProbe] == null) {
                return -1;
            }
            if (slots[nextProbe].equals(value)) {
                return nextProbe;
            }
        }
        return -1;
    }
}