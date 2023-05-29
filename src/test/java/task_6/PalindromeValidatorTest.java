package task_6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeValidatorTest {

    private final PalindromeValidator validator = new PalindromeValidator();

    @Test
    void isPalindrome_empty_string() {
        assertFalse(validator.isPalindrome(""));
    }

    @Test
    void isPalindrome_cyrillic_phrase() {
        assertTrue(validator.isPalindrome("а роза упала на лапу Азора"));
    }

    @Test
    void isPalindrome_cyrillic_success() {
        assertTrue(validator.isPalindrome("АБОБА"));
    }

    @Test
    void isPalindrome_english_fail() {
        assertTrue(validator.isPalindrome("Madam"));
    }

    @Test
    void isPalindrome_cyrillic_fail() {
        assertTrue(validator.isPalindrome("верба"));
    }

    @Test
    void isPalindrome_cyrillic_with_punctuation_phrase() {
        assertTrue(validator.isPalindrome("Он — верба, но / Она — бревно"));
    }

    @Test
    void isPalindrome_english_with_punctuation_phrase() {
        assertTrue(validator.isPalindrome("Madam, I’m Adam"));
    }

}
