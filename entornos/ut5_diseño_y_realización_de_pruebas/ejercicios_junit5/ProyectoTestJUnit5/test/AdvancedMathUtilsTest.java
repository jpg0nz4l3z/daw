import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedMathUtilsTest {
    private int a, b;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each test");
        a = 10;
        b = 5;
    }

    @Test
    void powerTest() {
        assertEquals(8, AdvancedMathUtils.power(2, 3));
        assertEquals(1, AdvancedMathUtils.power(5, 0));
        assertEquals(1, AdvancedMathUtils.power(1, 10));
        assertThrows(IllegalArgumentException.class, () -> AdvancedMathUtils.power(2, -3));

    }

    @Test
    void factorialTest() {
        assertEquals(120, AdvancedMathUtils.factorial(5));
        assertEquals(1, AdvancedMathUtils.factorial(0));
        assertEquals(1, AdvancedMathUtils.factorial(1));
        assertThrows(IllegalArgumentException.class, () -> AdvancedMathUtils.factorial(-3));
    }

    @Test
    void sqrtTest() {
        assertEquals(5, AdvancedMathUtils.sqrt(25));
        assertEquals(0, AdvancedMathUtils.sqrt(0));
        assertEquals(1, AdvancedMathUtils.sqrt(1));
        assertThrows(IllegalArgumentException.class, () -> AdvancedMathUtils.sqrt(-25));
    }

    @Test
    void logTest() {
        assertEquals(2, AdvancedMathUtils.log(100));
        assertEquals(1, AdvancedMathUtils.log(Math.E));
        assertThrows(IllegalArgumentException.class, () -> AdvancedMathUtils.log(-100));
        assertThrows(IllegalArgumentException.class, () -> AdvancedMathUtils.log(0));
    }


    @AfterEach
    public void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all tests");
    }
}