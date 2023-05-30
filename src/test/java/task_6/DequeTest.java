package task_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {
    private final Deque<Integer> deque = new Deque<>();

    @Test
    void addFront_to_empty() {
        deque.addFront(1);

        assertEquals(1, deque.size());
        assertTrue(deque.contains(1));
    }

    @Test
    void addFront_to_non_empty() {
        deque.addFront(1);
        deque.addFront(2);

        assertEquals(2, deque.size());
        assertTrue(deque.contains(2));
    }

    @Test
    void removeFront_from_empty() {
        assertNull(deque.removeFront());
        assertEquals(0, deque.size());
    }

    @Test
    void removeFront_from_non_empty() {
        deque.addFront(1);
        deque.addFront(2);

        assertEquals(2, deque.size());
        assertEquals(2, deque.removeFront());
        assertEquals(1, deque.size());
        assertFalse(deque.contains(2));
    }

    @Test
    void addTail_to_empty() {
        deque.addTail(1);

        assertEquals(1, deque.size());
        assertTrue(deque.contains(1));
    }

    @Test
    void addTail_to_non_empty() {
        deque.addTail(1);
        deque.addTail(2);

        assertEquals(2, deque.size());
        assertEquals(2, deque.removeTail());
    }

    @Test
    void removeTail_from_empty() {
        assertNull(deque.removeTail());
    }

    @Test
    void removeTail_from_non_empty() {
        deque.addTail(1);
        deque.addTail(2);

        assertEquals(2, deque.size());
        assertEquals(2, deque.removeTail());
        assertEquals(1, deque.size());
        assertFalse(deque.contains(2));
    }

}