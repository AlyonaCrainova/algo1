package task_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostfixStatementTest {
    private final PostfixStatement statement = new PostfixStatement();

    @Test
    void calculate_without_return_value() {
        Double result = statement.calculate("1 2 + 3 *");
        assertNull(result);
        assertEquals(9, statement.getPreviousResult());
    }

    @Test
    void calculate_with_return_value() {
        Double result = statement.calculate("8 2 + 5 * 9 + =");
        assertEquals(59, result);
    }

    @Test
    void calculate_invalid_input_unsupported_form() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            statement.calculate("3 10 15 − *");
        });
        assertNotNull(exception);
    }

    @Test
    void calculate_invalid_input_doubles() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            statement.calculate("3.20 10 15 − *");
        });
        assertNotNull(exception);
    }

    @Test
    void calculate_invalid_input_empty() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            statement.calculate("");
        });
        assertNotNull(exception);
    }

    @Test
    void calculate_division() {
        Double result = statement.calculate("8 2 + 5 * 5 / =");
        assertEquals(10, result);
    }

    @Test
    void calculate_subtraction() {
        Double result = statement.calculate("8 2 + 5 * 5 - =");
        assertEquals(45, result);
    }
}
