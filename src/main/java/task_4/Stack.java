package task_4;

import java.util.*;

public class Stack<T> {
    LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public int size() {
        return list.size();
    }

    public T pop() {
       return list.size() == 0? null: list.pop();
    }

    public void push(T val) {
        list.push(val);
    }

    public T peek() {
        return list.peek();
    }
}