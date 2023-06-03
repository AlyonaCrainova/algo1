package task_8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    private final HashTable hashTable = new HashTable(17, 3);

    @Test
    void hashFun_single_result_for_equal_values() {
        int result_1 = hashTable.hashFun("fuzzy");
        int result_2 = hashTable.hashFun("fuzzy");

        assertEquals(result_1, result_2);
    }

    @Test
    void hashFun_different_result_for_different_values() {
        int result_1 = hashTable.hashFun("fail");
        int result_2 = hashTable.hashFun("success");

        assertNotEquals(result_1, result_2);
    }

    @Test
    void hashFun_different_result_for_different_case() {
        int result_1 = hashTable.hashFun("fail");
        int result_2 = hashTable.hashFun("Fail");

        assertNotEquals(result_1, result_2);
    }

    @Test
    void seekSlot_in_empty_table() {
        int hashFunResult = hashTable.hashFun("f");

        int slot = hashTable.seekSlot("f");

        assertEquals(hashFunResult, slot);
    }

    @Test
    void seekSlot_base_slot_is_occupied() {
        int hashFunResult = hashTable.hashFun("f");
        hashTable.put("f");

        int slot = hashTable.seekSlot("f");

        assertEquals(hashFunResult + hashTable.step, slot);
    }

    @Test
    void seekSlot_slots_till_end_are_occupied() {
        hashTable.put("+");
        hashTable.put("+");
        hashTable.put("+");

        String[] expected = new String[hashTable.size];
        expected[11] = "+";
        expected[14] = "+";
        expected[0] = "+";

        assertArrayEquals(expected, hashTable.slots);
    }

    @Test
    void seekSlot_table_is_full() {
        for(int i = 0; i < hashTable.size; i++){
            hashTable.slots[i] = String.valueOf(i);
        }

        int result = hashTable.seekSlot("abc");

        assertEquals(-1, result);
    }

    @Test
    void put_base_slot_is_empty() {
        int hashFunResult = hashTable.hashFun("f");

        int slotIndex = hashTable.seekSlot("f");

        assertEquals(hashFunResult , slotIndex);
    }

    @Test
    void put_success() {
        int hashFunResult = hashTable.hashFun("f");

        int slotIndex = hashTable.seekSlot("f");

        assertEquals(hashFunResult , slotIndex);
    }

    @Test
    void put_fail() {
        for(int i = 0; i < hashTable.size; i++){
            hashTable.slots[i] = String.valueOf(i);
        }

        int result = hashTable.put("abc");

        assertEquals(-1, result);
    }

    @Test
    void find_success() {
        int slotIndex = hashTable.put("zip");

        int found = hashTable.find("zip");

        assertEquals(slotIndex , found);
        assertEquals("zip" , hashTable.slots[found]);
    }

    @Test
    void find_with_collision_success() {
        hashTable.put("A");
        int result2 = hashTable.put("R");

        int found = hashTable.find("R");

        assertEquals(result2 , found);
        assertEquals("R" , hashTable.slots[found]);
    }
    
    @Test
    void find_fail() {
        hashTable.put("z");

        int found = hashTable.find("lll");

        assertEquals(-1 , found);
    }
}
