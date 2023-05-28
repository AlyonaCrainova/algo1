package task_5;

import java.util.*;

public class Queue<T>
{
    private LinkedList<T> queue;
    public Queue()
    {
        queue = new LinkedList<>();
    }

    public void enqueue(T item)
    {
        //O(1)
        queue.add(item);
    }

    public T dequeue()
    {
        //O(1)
        return queue.poll();
    }

    public int size()
    {
        return queue.size();
    }

}