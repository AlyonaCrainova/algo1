package task_4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private final Stack<Integer> stack = new Stack<>();

    @Test
    void push_to_empty_stack() {
        stack.push(2);
        assertEquals(1, stack.size());
        assertEquals(2, stack.peek());
    }

    @Test
    void push_to_non_empty_stack() {
        stack.push(2);
        stack.push(3);
        assertEquals(2, stack.size());
        assertEquals(3, stack.peek());
    }

    @Test
    void pop_from_empty_stack() {
        assertNull(stack.pop());
    }

    @Test
    void pop_from_non_empty_stack() {
        stack.push(2);
        stack.push(3);
        int result = stack.pop();
        assertEquals(3, result);
        assertEquals(1, stack.size());
    }

    @Test
    void peek_from_empty_stack() {
        assertNull(stack.peek());
    }

    @Test
    void peek_from_non_empty_stack() {
        stack.push(2);
        stack.push(3);
        int result = stack.peek();
        assertEquals(3, result);
        assertEquals(2, stack.size());
    }

    @Test
    void size_of_empty_stack() {
        assertEquals(0, stack.size());
    }

    @Test
    void size_of_non_empty_stack() {
        stack.push(2);
        stack.push(3);
        assertEquals(2, stack.size());
    }
}
