package task_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BracketStringTest {
    private final BracketString bracketString = new BracketString();

    @Test
    void isBalanced_success() {
        boolean balanced = bracketString.isBalanced("(()((())()))");
        assertTrue(balanced);
    }

    @Test
    void isBalanced_missing_closing_bracket() {
        boolean balanced = bracketString.isBalanced("((())");
        assertFalse(balanced);
    }

    @Test
    void isBalanced_without_any_match() {
        boolean balanced = bracketString.isBalanced("))((");
        assertFalse(balanced);
    }
}
