import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addTest() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(2, -3));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    void subtractTest() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(5, calculator.subtract(2, -3));
        assertEquals(0, calculator.subtract(0, 0));
    }

    @Test
    void multiplyTest() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-6, calculator.multiply(2, -3));
        assertEquals(0, calculator.multiply(0, 0));
    }

    @Test
    void divideTest() {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(-2.0, calculator.divide(6, -3));
        assertEquals(0.0, calculator.divide(0, 5));

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(6, 0);
        });
    }
}