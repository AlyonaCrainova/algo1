package task_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.LinkedList;

public class QueueRotatorTest {
    private final QueueRotator rotator = new QueueRotator();

    @Test
    void rotate_non_empty_queue() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        rotator.rotate(queue, 4);
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(1, queue.poll());
    }

    @Test
    void rotate_single_element_queue() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        rotator.rotate(queue, 1);
        assertEquals(1, queue.poll());
    }

    @Test
    void rotate_empty_queue() {
        LinkedList<Integer> queue = new LinkedList<>();
        rotator.rotate(queue, 2);
        assertEquals(0, queue.size());
    }

}
