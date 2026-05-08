import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    void sumTest() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(15, ArrayUtils.sum(array));

        int[] emptyArray = {};
        assertEquals(0, ArrayUtils.sum(emptyArray));
    }

    @Test
    void averageTest() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(3.0, ArrayUtils.average(array));

        int[] emptyArray = {};
        assertEquals(0.0, ArrayUtils.average(emptyArray));
    }

    @Test
    void maxTest() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(5, ArrayUtils.max(array));

        int[] negativeArray = {-5, -3, -1};
        assertEquals(-1, ArrayUtils.max(negativeArray));

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.max(new int[]{});
        });
    }

    @Test
    void minTest() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(1, ArrayUtils.min(array));

        int[] negativeArray = {-5, -3, -1};
        assertEquals(-5, ArrayUtils.min(negativeArray));

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.min(new int[]{});
        });
    }
}