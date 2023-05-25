package task_3;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    private static final int MIN_CAPACITY = 16;
    private static final double DEALLOCATION_THRESHOLD = 50;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        if (array != null) {
            System.arraycopy(array, 0, newArray, 0, count);
        }
        array = newArray;
        capacity = new_capacity;
    }

    public T getItem(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return array[index];
    }

    public void append(T itm) {
        allocate();
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == count) {
            append(itm);
            return;
        }
        allocate();
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = itm;
        count++;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        count--;
        System.arraycopy(array, index + 1, array, index, count - index);
        array[count] = null;
        deallocate();
    }

    private void allocate() {
        if (count != capacity) {
            return;
        }
        makeArray(capacity * 2);
    }

    private void deallocate() {
        double capacity_percent = (double)count / capacity * 100;
        if (capacity_percent >= DEALLOCATION_THRESHOLD) {
            return;
        }
        int newCapacity = (int)(capacity / 1.5);
        makeArray(Math.max(newCapacity, MIN_CAPACITY));
    }
}