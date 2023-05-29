package task_6;

import java.util.*;

public class Deque<T> {
    ArrayList<T> list;

    public Deque() {
        list = new ArrayList<>();
    }

    public void addFront(T item) {
        list.add(0, item);
    }

    public void addTail(T item) {
        list.add(item);
    }

    public T removeFront() {
        return list.isEmpty()? null : list.remove(0);
    }

    public T removeTail() {
        return list.isEmpty()? null : list.remove(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean contains(T item) {
        return list.contains(item);
    }

}