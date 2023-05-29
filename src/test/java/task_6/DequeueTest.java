package task_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DequeueTest {
    private final Deque<Integer> queue = new Deque<>();

    @Test
    void addFront_to_empty_queue() {
        queue.addFront(1);
        assertEquals(1, queue.size());
        assertEquals(1, queue.removeFront());
    }

    @Test
    void addFront_to_non_empty_queue() {
        queue.addFront(1);
        queue.addFront(2);
        assertEquals(2, queue.size());
        assertEquals(2, queue.removeFront());
    }

    @Test
    void removeFront_from_empty_queue() {
        assertNull(queue.removeFront());
    }

    @Test
    void addTail_to_empty_queue() {
        queue.addTail(1);
        assertEquals(1, queue.size());
        assertEquals(1, queue.removeTail());
    }

    @Test
    void addTail_to_non_empty_queue() {
        queue.addTail(1);
        queue.addTail(2);
        assertEquals(2, queue.size());
        assertEquals(2, queue.removeTail());
    }

    @Test
    void removeTail_from_empty_queue() {
        assertNull(queue.removeTail());
    }

}