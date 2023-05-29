package task_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeueTest {
    private final Deque<Integer> queue = new Deque<>();

    @Test
    void addFront_to_empty_queue() {
        queue.addFront(1);

        assertEquals(1, queue.size());
        assertTrue(queue.contains(1));
    }

    @Test
    void addFront_to_non_empty_queue() {
        queue.addFront(1);
        queue.addFront(2);

        assertEquals(2, queue.size());
        assertTrue(queue.contains(2));
    }

    @Test
    void removeFront_from_empty_queue() {
        assertNull(queue.removeFront());
        assertEquals(0, queue.size());
    }

    @Test
    void removeFront_from_non_empty_queue() {
        queue.addFront(1);
        queue.addFront(2);

        assertEquals(2, queue.size());
        assertEquals(2, queue.removeFront());
        assertEquals(1, queue.size());
        assertFalse(queue.contains(2));
    }

    @Test
    void addTail_to_empty_queue() {
        queue.addTail(1);

        assertEquals(1, queue.size());
        assertTrue(queue.contains(1));
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

    @Test
    void removeTail_from_non_empty_queue() {
        queue.addTail(1);
        queue.addTail(2);

        assertEquals(2, queue.size());
        assertEquals(2, queue.removeTail());
        assertEquals(1, queue.size());
        assertFalse(queue.contains(2));
    }

}