package test_9;

import org.junit.jupiter.api.Test;
import task_9.NativeDictionary;

import static org.junit.jupiter.api.Assertions.*;


public class NativeDictionaryTest {
    private final NativeDictionary<Integer> dictionary = new NativeDictionary<>(17, Integer.class);

    @Test
    void hashFun_single_result_for_equal_values() {
        Integer result_1 = dictionary.hashFun("fuzzy");
        Integer result_2 = dictionary.hashFun("fuzzy");

        assertEquals(result_1, result_2);
    }

    @Test
    void hashFun_different_result_for_different_values() {
        Integer result_1 = dictionary.hashFun("fail");
        Integer result_2 = dictionary.hashFun("success");

        assertNotEquals(result_1, result_2);
    }

    @Test
    void hashFun_different_result_for_different_case() {
        Integer result_1 = dictionary.hashFun("fail");
        Integer result_2 = dictionary.hashFun("Fail");

        assertNotEquals(result_1, result_2);
    }

    @Test
    void hashFun_zero_for_null() {
        Integer result = dictionary.hashFun(null);

        assertEquals(0, result);
    }

    @Test
    void is_key_success() {
        dictionary.put("apple", 1);

        boolean result = dictionary.isKey("apple");

        assertTrue(result);
    }

    @Test
    void is_key_fail() {
        dictionary.put("apple", 1);

        boolean result = dictionary.isKey("banana");

        assertFalse(result);
    }

    @Test
    void put_to_empty() {
        dictionary.put("apple", 1);

        Integer result = dictionary.get("apple");

        assertEquals(1, result);
    }

    @Test
    void put_to_non_empty() {
        dictionary.put("apple", 1);
        dictionary.put("banana", 2);

        Integer result_1 = dictionary.get("apple");
        Integer result_2 = dictionary.get("banana");

        assertEquals(1, result_1);
        assertEquals(2, result_2);
    }

    @Test
    void put_collide() {
        dictionary.put("apple", 1);
        dictionary.put("apple", 3);

        Integer result = dictionary.get("apple");

        assertEquals(3, result);
    }

    @Test
    void get_success() {
        dictionary.put("apple", 1);

        Integer result = dictionary.get("apple");

        assertEquals(1, result);
    }

    @Test
    void get_fail() {
        dictionary.put("apple", 1);

        Integer result = dictionary.get("banana");

        assertNull(result);
    }

}