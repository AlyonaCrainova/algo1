package task_1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

public class LinkedListAdderTest {
    private final LinkedListAdder adder = new LinkedListAdder();

    @Test
    void sum_empty() {
        ArrayList<Node> result = adder.sum(new LinkedList(), new LinkedList());

        assertTrue(result.isEmpty());
    }

    @Test
    void sum_different_size() {
        LinkedList addendum_1 = new LinkedList();
        addendum_1.addInTail(new Node(1));
        addendum_1.addInTail(new Node(2));
        LinkedList addendum_2 = new LinkedList();
        addendum_1.addInTail(new Node(5));

        ArrayList<Node> result = adder.sum(addendum_1, addendum_2);

        assertTrue(result.isEmpty());
    }

    @Test
    void sum_multiple() {
        LinkedList addendum_1 = new LinkedList();
        addendum_1.addInTail(new Node(1));
        addendum_1.addInTail(new Node(2));
        LinkedList addendum_2 = new LinkedList();
        addendum_2.addInTail(new Node(5));
        addendum_2.addInTail(new Node(6));

        ArrayList<Node> result = adder.sum(addendum_1, addendum_2);

        assertEquals(result.get(0).value, 6);
        assertEquals(result.get(1).value, 8);
    }
}
