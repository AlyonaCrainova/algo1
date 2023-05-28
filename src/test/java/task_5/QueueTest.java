package task_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class QueueTest {
    private final Queue<Integer> queue = new Queue<>();

    @Test
    void enqueue_to_empty_queue() {
        queue.enqueue(1);
        assertEquals(1, queue.size());
        assertEquals(1, queue.dequeue());
    }

    @Test
    void enqueue_to_non_empty_queue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }

    @Test
    void dequeue_from_empty_queue() {
        assertNull(queue.dequeue());
    }

    @Test
    void dequeue_from_non_empty_queue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        assertEquals(1, queue.size());
    }
}
