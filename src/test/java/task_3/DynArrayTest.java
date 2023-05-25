package task_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DynArrayTest {
    private final DynArray array = new DynArray(Integer.class);

    @Test
    void insert_without_allocation_success() {
        array.insert(Integer.valueOf(1),0);
        assertEquals(1, array.count);
        assertEquals(Integer.valueOf(1), (Integer) array.array[0]);
        assertEquals(16, array.capacity);
    }
    @Test
    void insert_with_allocation() {
        for(int i = 0; i < 16; i++) {
            array.insert(Integer.valueOf(i), i);
        }
        array.insert(Integer.valueOf(16),16);
        assertEquals(16, array.array[16]);
        assertEquals(17, array.count );
        assertEquals(32, array.capacity);
    }

    @Test
    void insert_illegal_index_negative() {
        for(int i = 0; i < 16; i++) {
            array.insert(Integer.valueOf(i), i);
        }
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
        array.insert(Integer.valueOf(16),-1);
        });
        assertNotNull(exception);
        assertEquals(16, array.count );
        assertEquals(16, array.capacity);
    }

    @Test
    void insert_illegal_index_greater_than_count() {
        for(int i = 0; i < 16; i++) {
            array.insert(Integer.valueOf(i), i);
        }
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            array.insert(Integer.valueOf(16),17);
        });
        assertNotNull(exception);
        assertEquals(16, array.count );
        assertEquals(16, array.capacity);
    }

    @Test
    void insert_in_middle() {
        for(int i = 0; i < 16; i++) {
            array.insert(Integer.valueOf(i), i);
        }
        array.insert(Integer.valueOf(16), 8);
        assertEquals(16, array.array[8] );
        assertEquals(17, array.count );
        assertEquals(32, array.capacity);
    }

    @Test
    void remove_without_deallocation() {
        for(int i = 0; i < 16; i++) {
            array.append(Integer.valueOf(i));
        }
        array.remove(6);
        assertEquals(15, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    void remove_from_middle() {
        for(int i = 0; i < 3; i++) {
            array.append(Integer.valueOf(i));
        }
        array.remove(1);
        assertEquals(2, array.count);
        assertEquals(0, array.array[0]);
        assertEquals(2, array.array[1]);
        assertEquals(16, array.capacity);
    }

    @Test
    void remove_with_deallocation_to_min_capacity() {
        for(int i = 0; i < 8; i++) {
            array.append(Integer.valueOf(i));
        }
        array.remove(6);
        assertEquals(7, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    void remove_with_deallocation() {
        for(int i = 0; i < 18; i++) {
            array.append(Integer.valueOf(i));
        }
        assertEquals(32, array.capacity);
        assertEquals(18, array.count);
        for(int i = 0; i < 3; i++) {
            array.remove(i);
        }
        assertEquals(15, array.count);
        assertEquals(21,array.capacity );
    }

    @Test
    void remove_illegal_index_negative() {
        for(int i = 0; i < 3; i++) {
            array.append(Integer.valueOf(i));
        }
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            array.remove(-1);
        });
        assertEquals( 3, array.count);
        assertEquals(16, array.capacity);
        assertNotNull(exception);
    }
    @Test
    void remove_illegal_index_greater_than_count() {
        for(int i = 0; i < 3; i++) {
            array.append(Integer.valueOf(i));
        }
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            array.remove(3);
        });
        assertEquals(3, array.count);
        assertEquals(16, array.capacity);
        assertNotNull(exception);
    }

    @Test
    void makeArray_non_empty() {
        for(int i = 0; i < 3; i++) {
            array.append(Integer.valueOf(i));
        }
        array.makeArray(6);
        assertEquals(3, array.count);
        assertEquals(0, array.array[0]);
        assertEquals(1, array.array[1]);
        assertEquals(2, array.array[2]);
        assertEquals(6, array.capacity);
    }
}
