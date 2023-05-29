package task_5;

import java.util.Stack;

public class QueueStack<T> {
    private Stack<T> enqueue_stack;
    private Stack<T> dequeue_stack;

    public QueueStack() {
        enqueue_stack = new Stack<>();
        dequeue_stack = new Stack<>();
    }

    public void enqueue(T item) {
        enqueue_stack.push(item);
    }

    public T dequeue() {
        if (enqueue_stack.isEmpty() & dequeue_stack.isEmpty()) {
            return null;
        }
        if (dequeue_stack.isEmpty()) {
            while (!enqueue_stack.isEmpty()) {
                dequeue_stack.push(enqueue_stack.pop());
            }
        }
        return dequeue_stack.pop();
    }

    public int size() {
        return enqueue_stack.size() + dequeue_stack.size();
    }
}
