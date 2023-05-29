package task_6;

import java.util.*;

public class Deque<T>
{
    LinkedList<T> list;
    public Deque()
    {
        list = new LinkedList<>();
    }

    public void addFront(T item)
    {
        list.addFirst(item);
    }

    public void addTail(T item)
    {
        list.addLast(item);
    }

    public T removeFront()
    {
        return list.pollFirst();
    }

    public T removeTail()
    {
        return list.pollLast();
    }

    public int size()
    {
        return list.size();
    }
}