package task_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PowerSetTest {
    private final PowerSet set = new PowerSet();

    @Test
    void put_new_value() {
        set.put("Abc");

        assertTrue(set.get("Abc"));
        assertEquals(1, set.count());
    }

    @Test
    void put_present_value() {
        set.put("Abc");

        set.put("Abc");

        assertTrue(set.get("Abc"));
        assertEquals(1, set.count());
    }

    @Test
    void remove_present_value() {
        set.put("Abc");

        boolean deleted = set.remove("Abc");

        assertTrue(deleted);
        assertEquals(0, set.count());
    }

    @Test
    void remove_absent_value() {
        set.put("Abc");

        boolean deleted = set.remove("Def");

        assertFalse(deleted);
        assertEquals(1, set.count());
    }

    @Test
    void intersection_empty_set() {
        set.put("apple");
        set.put("pineapple");
        set.put("banana");
        PowerSet set2 = new PowerSet();

        PowerSet intersection = set.intersection(set2);

        assertEquals(0, intersection.count());
    }

    @Test
    void intersection_non_empty_set() {
        set.put("apple");
        set.put("banana");
        set.put("pineapple");
        PowerSet set2 = new PowerSet();
        set2.put("apple");
        set2.put("pineapple");

        PowerSet intersection = set.intersection(set2);

        assertEquals(2, intersection.count());
        assertTrue(intersection.get("apple"));
        assertTrue(intersection.get("pineapple"));
    }

    @Test
    void union_non_empty_sets() {
        set.put("apple");
        set.put("banana");
        set.put("pineapple");
        PowerSet set2 = new PowerSet();
        set2.put("apple");
        set2.put("pineapple");

        PowerSet union = set.union(set2);

        assertEquals(3, union.count());
        assertTrue(union.get("apple"));
        assertTrue(union.get("banana"));
        assertTrue(union.get("pineapple"));
    }

    @Test
    void union_with_empty_object_set() {
        PowerSet set2 = new PowerSet();
        set2.put("apple");
        set2.put("banana");
        set2.put("pineapple");

        PowerSet union = set.union(set2);

        assertEquals(3, union.count());
        assertTrue(union.get("apple"));
        assertTrue(union.get("banana"));
        assertTrue(union.get("pineapple"));
    }

    @Test
    void union_with_empty_argument_set() {
        set.put("apple");
        set.put("banana");
        set.put("pineapple");
        PowerSet set2 = new PowerSet();

        PowerSet union = set.union(set2);

        assertEquals(3, union.count());
        assertTrue(union.get("apple"));
        assertTrue(union.get("banana"));
        assertTrue(union.get("pineapple"));
    }

    @Test
    void difference_non_empty_sets() {
        set.put("apple");
        set.put("banana");
        set.put("pineapple");
        PowerSet set2 = new PowerSet();
        set2.put("apple");
        set2.put("pineapple");

        PowerSet difference = set.difference(set2);

        assertEquals(1, difference.count());
        assertTrue(difference.get("banana"));
    }

    @Test
    void difference_with_empty_object_set() {
        PowerSet set2 = new PowerSet();
        set2.put("apple");
        set2.put("banana");
        set2.put("pineapple");

        PowerSet difference = set.difference(set2);

        assertEquals(0, difference.count());
    }

    @Test
    void difference_with_empty_argument_set() {
        set.put("apple");
        set.put("banana");
        set.put("pineapple");
        PowerSet set2 = new PowerSet();

        PowerSet difference = set.difference(set2);

        assertEquals(3, difference.count());
        assertTrue(difference.get("apple"));
        assertTrue(difference.get("banana"));
        assertTrue(difference.get("pineapple"));
    }

    //(все элементы параметра входят в текущее множество,
    @Test
    void isSubset_parameter_is_subset_of_object() {
        set.put("apple");
        set.put("banana");
        set.put("pineapple");
        PowerSet set2 = new PowerSet();
        set2.put("apple");
        set2.put("pineapple");

        boolean isSubset = set.isSubset(set2);

        assertTrue(isSubset);
    }

    //все элементы текущего множества входят в параметр,
    @Test
    void isSubset_object_is_parameter_subset() {
        set.put("apple");
        set.put("pineapple");
        PowerSet set2 = new PowerSet();
        set2.put("apple");
        set2.put("pineapple");
        set2.put("banana");

        boolean isSubset = set.isSubset(set2);

        assertFalse(isSubset);
    }

    // не все элементы параметра входят в текущее множество);
    @Test
    void isSubset_fail() {
        set.put("apple");
        set.put("pineapple");
        PowerSet set2 = new PowerSet();
        set2.put("apple");
        set2.put("pineapple");
        set2.put("banana");

        boolean isSubset = set.isSubset(set2);

        assertFalse(isSubset);
    }
}