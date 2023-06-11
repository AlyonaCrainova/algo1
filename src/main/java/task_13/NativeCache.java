package task_13;

import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int size, Class clazz)
    {
        this.size = size;
        this.slots = new String[size];
        this.hits = new int[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        if (key == null) {
            return 0;
        }
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum = ((sum * 93) % size + (c - '!' + 1)) % size;
        }
        return sum;
    }

    public boolean isKey(String key) {
        int index = hashFun(key);
        String slot = slots[index];
        if (slot != null && slot.equals(key)) {
            hits[index]++;
            return true;
        }
        return false;
    }

    public void put(String key, T value) {
        int index = hashFun(key);
        if (slots[index] != null) {
            index = getLeastUsed();
            hits[index] = 0;
        }
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key) {
        int index = hashFun(key);
        String slot = slots[index];
        if (slot != null && slot.equals(key)) {
            hits[index]++;
            return values[index];
        }
        return null;
    }

    private int getLeastUsed(){
        int index = 0;
        int minHits = hits[0];
        for (int i = 1; i < hits.length; i++) {
            if (hits[i] < minHits) {
                minHits = hits[i];
                index = i;
            }
        }
        return index;
    }
}