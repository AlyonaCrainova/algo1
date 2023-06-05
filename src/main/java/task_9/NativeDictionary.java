package task_9;
import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        if(key == null){
            return 0;
        }
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum = ((sum * 93) % size + (c - '!' + 1)) % size;
        }
        return sum;
    }

    public boolean isKey(String key) {
        String slot = slots[hashFun(key)];
        return slot != null && slot.equals(key);
    }

    public void put(String key, T value) {
        int index = hashFun(key);
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key) {
        int index = hashFun(key);
        String slot = slots[index];
        return slot != null && slot.equals(key)? values[index] : null;
    }
}