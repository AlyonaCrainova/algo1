package task_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NativeCacheTest {
    private final NativeCache<Integer> filter = new NativeCache<>(7, Integer.class);

    @Test
    void put_to_empty_cache() {
        filter.put("A", 1);

        assertEquals("A", filter.slots[5]);
        assertEquals(1, filter.values[5]);
    }

    @Test
    void put_with_collision_non_full_cache() {
        filter.put("A", 1);
        filter.put("H", 2);

        assertEquals("A", filter.slots[5]);
        assertEquals(1, filter.values[5]);
        assertEquals("H", filter.slots[0]);
        assertEquals(2, filter.values[0]);
    }

    @Test
    void put_with_collision_full_cache() {
        filter.slots = new String[]{"a", "b", "c", "d", "A", "f", "g"};
        filter.values = new Integer[]{0, 1, 2, 3, 4, 5, 6};
        filter.hits = new int[]{3, 4, 2, 5, 6, 7, 8};
        String[] slotsExpected = new String[7];
        System.arraycopy(filter.slots, 0, slotsExpected, 0, 7);
        slotsExpected[2] = "H";
        Integer[] valuesExpected = new Integer[7];
        System.arraycopy(filter.values, 0, valuesExpected, 0, 7);
        valuesExpected[2] = 9;
        int[] hitsExpected = new int[7];
        System.arraycopy(filter.hits, 0, hitsExpected, 0, 7);
        hitsExpected[2] = 0;

        filter.put("H", 9);

        assertArrayEquals(slotsExpected, filter.slots);
        assertArrayEquals(valuesExpected, filter.values);
        assertArrayEquals(hitsExpected, filter.hits);
    }

    @Test
    void isKey_success() {
        filter.put("A", 1);
        filter.put("H", 2);
        int[] hitsExpected = new int[7];
        hitsExpected[5] = 1;

        filter.isKey("A");

        assertArrayEquals(hitsExpected, filter.hits);
    }

    @Test
    void isKey_fail() {
        filter.put("A", 1);
        filter.put("H", 2);
        int[] hitsExpected = new int[7];

        filter.isKey("Z");

        assertArrayEquals(hitsExpected, filter.hits);
    }

    @Test
    void get_success() {
        filter.put("A", 1);
        filter.put("H", 2);
        int[] hitsExpected = new int[7];
        hitsExpected[5] = 1;

        filter.get("A");

        assertArrayEquals(hitsExpected, filter.hits);
    }

    @Test
    void get_fail() {
        filter.put("A", 1);
        filter.put("H", 2);
        int[] hitsExpected = new int[7];

        filter.get("Z");

        assertArrayEquals(hitsExpected, filter.hits);
    }
}
