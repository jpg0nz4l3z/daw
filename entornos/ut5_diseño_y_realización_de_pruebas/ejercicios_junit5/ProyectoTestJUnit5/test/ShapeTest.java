import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    // Prueba de igualdad para el cálculo del área de un rectángulo
    @Test
    public void RectangleAreaEqualityTest() {
        Shape rectangulo = new Rectangulo(5, 4);
        assertEquals(20.0, rectangulo.area());
    }

    // Prueba de identidad para el cálculo del área de un círculo
    @Test
    public void CircleAreaIdentityTest() {
        Shape circulo = new Circulo(3);
        assertSame(circulo.area(), circulo.area());
    }

    // Prueba de nulidad para el cálculo del área de un triángulo
    @Test
    public void TriangleAreaNullnessTest() {
        Shape triangulo = new Triangulo(6, 4);
        assertNotNull(triangulo.area());
    }

    // Prueba de excepción para el cálculo del área de un triángulo con dimensiones no válidas
    @Test
    public void TriangleAreaExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Shape triangulo = new Triangulo(-1, 4);
            triangulo.area();
        });
    }

    // Prueba de tiempo de espera para el cálculo del área de un círculo
    @Test
    public void CircleAreaTimeoutTest() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Shape circulo = new Circulo(10);
            circulo.area();
        });
    }

    // Prueba de igualdad de arrays para el cálculo del área de un rectángulo
    @Test
    public void RectangleAreaArrayEqualityTest() {
        Shape rectangulo = new Rectangulo(5, 4);
        double[] expected = {20.0};
        double[] actual = {rectangulo.area()};
        assertArrayEquals(expected, actual);
    }

    // Prueba de igualdad de contenido de arrays para el cálculo del área de un círculo
    @Test
    public void CircleAreaArrayContentEqualityTest() {
        Shape circulo = new Circulo(3);
        double[] expected = {28.274333882308138};
        double[] actual = {circulo.area()};
        assertArrayEquals(expected, actual, 0.0001, "Arrays should have the same elements");
    }

    // Prueba de grupo para el cálculo del área de un triángulo
    @Test
    public void TriangleAreaGroupAssertionsTest() {
        int[] base = {3, 4, 5};
        int[] height = {4, 5, 6};
        assertAll("triángulo",
                () -> assertEquals(6.0, new Triangulo(base[0], height[0]).area()),
                () -> assertEquals(10.0, new Triangulo(base[1], height[1]).area()),
                () -> assertEquals(15.0, new Triangulo(base[2], height[2]).area())
        );
    }
}