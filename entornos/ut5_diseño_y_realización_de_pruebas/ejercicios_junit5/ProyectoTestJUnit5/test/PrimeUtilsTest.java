import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PrimeUtilsTest {

    @Test
    void isPrimeTest() {
        assertTrue(PrimeUtils.isPrime(2));
        assertTrue(PrimeUtils.isPrime(3));
        assertTrue(PrimeUtils.isPrime(5));
        assertTrue(PrimeUtils.isPrime(7));
        assertTrue(PrimeUtils.isPrime(11));
        assertFalse(PrimeUtils.isPrime(1));
        assertFalse(PrimeUtils.isPrime(4));
        assertFalse(PrimeUtils.isPrime(6));
        assertFalse(PrimeUtils.isPrime(8));
        assertFalse(PrimeUtils.isPrime(9));
        assertFalse(PrimeUtils.isPrime(10));
    }

    @Test
    void generatePrimesTest() {
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7, 11);
        assertEquals(expectedPrimes, PrimeUtils.generatePrimes(5));

        List<Integer> emptyList = Arrays.asList();
        assertEquals(emptyList, PrimeUtils.generatePrimes(0));
    }

    @Test
    void countPrimesInRangeTest() {
        assertEquals(4, PrimeUtils.countPrimesInRange(1, 10));
        assertEquals(0, PrimeUtils.countPrimesInRange(20, 30));
        assertEquals(1, PrimeUtils.countPrimesInRange(23, 23));
    }
}