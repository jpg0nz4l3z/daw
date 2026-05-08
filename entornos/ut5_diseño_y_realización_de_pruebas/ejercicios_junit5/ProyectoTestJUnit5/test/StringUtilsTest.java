import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void isEmptyTest() {
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty("hello"));
    }

    @Test
    void reverseTest() {
        assertEquals("olleh", StringUtils.reverse("hello"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    void concatTest() {
        assertEquals("hello world", StringUtils.concat("hello ", "world"));
        assertEquals("hello", StringUtils.concat("hello", null));
        assertEquals("", StringUtils.concat(null, null));
    }

    @Test
    void countOccurrencesTest() {
        assertEquals(3, StringUtils.countOccurrences("hello", 'l'));
        assertEquals(0, StringUtils.countOccurrences("", 'a'));
        assertEquals(0, StringUtils.countOccurrences(null, 'a'));
    }
}