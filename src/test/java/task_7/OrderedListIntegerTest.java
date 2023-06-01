package task_7;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OrderedListIntegerTest {
    private final OrderedList<Integer> orderedList = new OrderedList<>(true);
    @Test
    void add_to_empty_asc() {
        orderedList.add(1);

        assertEquals(1, orderedList.head.value);
        assertEquals(orderedList.head, orderedList.tail);
        assertNull( orderedList.head.next);
        assertNull( orderedList.head.prev);
        assertEquals(1, orderedList.count());
    }

    @Test
    void add_to_head_non_empty_asc() {
        orderedList.add(4);
        orderedList.add(1);

        assertEquals(1, orderedList.head.value);
        assertEquals(orderedList.head.next, orderedList.tail);
        assertNull(orderedList.head.prev);
        assertEquals(4, orderedList.tail.value);
        assertEquals(orderedList.head, orderedList.tail.prev);
        assertNull(orderedList.tail.next);
        assertEquals(2, orderedList.count());
    }

    @Test
    void add_in_middle_asc() {
        orderedList.add(1);
        orderedList.add(3);

        orderedList.add(2);

        assertEquals(1, orderedList.head.value);
        assertEquals(2, orderedList.head.next.value);
        assertNull(orderedList.head.prev);
        assertEquals(3, orderedList.tail.value);
        assertEquals(2, orderedList.tail.prev.value);
        assertNull(orderedList.tail.next);
        assertEquals(3, orderedList.count());
    }

    @Test
    void add_to_head_non_empty_desc() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(4);

        assertEquals(4, orderedList.head.value);
        assertEquals(orderedList.head.next, orderedList.tail);
        assertNull(orderedList.head.prev);
        assertEquals(1, orderedList.tail.value);
        assertEquals(orderedList.head, orderedList.tail.prev);
        assertNull(orderedList.tail.next);
        assertEquals(2, orderedList.count());
    }


    @Test
    void add_in_middle_desc() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(3);
        orderedList.add(2);

        assertEquals(3, orderedList.head.value);
        assertEquals(2, orderedList.head.next.value);
        assertNull(orderedList.head.prev);
        assertEquals(1, orderedList.tail.value);
        assertEquals(2, orderedList.tail.prev.value);
        assertNull(orderedList.tail.next);
        assertEquals(3, orderedList.count());
    }

    @Test
    void delete_from_empty() {
        orderedList.delete(2);

        assertNull(orderedList.head);
        assertNull(orderedList.tail);
        assertEquals(0, orderedList.count());
    }

    @Test
    void delete_single_node_asc_success() {
        orderedList.add(1);

        orderedList.delete(1);
        assertNull(orderedList.head);
        assertNull(orderedList.tail);
        assertEquals(0, orderedList.count());
    }

    @Test
    void delete_single_node_asc_fail() {
        orderedList.add(1);

        orderedList.delete(2);
        assertEquals(1, orderedList.head.value);
        assertEquals(orderedList.head, orderedList.tail);
        assertNull( orderedList.head.next);
        assertNull( orderedList.head.prev);
        assertEquals(1, orderedList.count());
    }

    @Test
    void delete_multiple_asc() {
        orderedList.add(1);
        orderedList.add(1);

        orderedList.delete(1);

        assertEquals(1, orderedList.head.value);
        assertEquals(orderedList.head, orderedList.tail);
        assertNull( orderedList.head.next);
        assertNull( orderedList.head.prev);
        assertEquals(1, orderedList.count());
    }

    @Test
    void delete_from_tail() {
        orderedList.add(1);
        orderedList.add(3);
        orderedList.add(2);

        orderedList.delete(2);
        assertEquals(1, orderedList.head.value);
        assertEquals(3, orderedList.head.next.value);
        assertNull(orderedList.head.prev);
        assertEquals(3, orderedList.tail.value);
        assertEquals(1, orderedList.tail.prev.value);
        assertNull(orderedList.tail.next);
        assertEquals(2, orderedList.count());
    }

    @Test
    void find_success() {
        orderedList.add(1);
        orderedList.add(3);
        orderedList.add(2);

        Node<Integer> node = orderedList.find(2);
        assertEquals(2, node.value);
    }
    @Test
    void find_fail() {
        orderedList.add(1);
        orderedList.add(3);
        orderedList.add(2);

        Node<Integer> node = orderedList.find(4);
        assertNull( node);
    }
    @Test
    void clear_empty() {
        orderedList.clear(true);

        assertNull(orderedList.head);
        assertNull(orderedList.tail);
        assertEquals(orderedList.count(), 0);
    }

    @Test
    void clear_non_empty() {
        orderedList.add(1);
        orderedList.add(2);
        ArrayList<Node<Integer>> list = orderedList.getAll();

        orderedList.clear(true);
        assertNull(orderedList.head);
        assertNull(orderedList.tail);
        assertEquals(orderedList.count(), 0);
        assertEquals(list.size(), 2);
        assertNull(list.get(0).prev);
        assertNull(list.get(0).next);
        assertNull(list.get(1).prev);
        assertNull(list.get(1).next);
    }
}