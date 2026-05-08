import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GeometricShapesTest {

    @Nested //Para agrupar los test coincidentes por algún criterio.
    @DisplayName("Rectangle Tests")
    class RectangleTests {
        @Test
        @DisplayName("Test Rectangle Area Equality")
        void testRectangleAreaEquality() {
            Shape rectangle = new Rectangulo(5, 4);
            assertEquals(20.0, rectangle.area());
        }

        @Test
        @DisplayName("Test Rectangle Area Array Equality")
        void testRectangleAreaArrayEquality() {
            Shape rectangle = new Rectangulo(5, 4);
            double[] expected = {20.0};
            double[] actual = {rectangle.area()};
            assertArrayEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Circle Tests")
    class CircleTests {
        @Test
        @DisplayName("Test Circle Area Identity")
        void testCircleAreaIdentity() {
            Shape circle = new Circulo(3);
            assertSame(circle.area(), circle.area());
        }

        @Test
        @DisplayName("Test Circle Area Array Content Equality")
        void testCircleAreaArrayContentEquality() {
            Shape circle = new Circulo(3);
            double[] expected = {28.274333882308138};
            double[] actual = {circle.area()};
            assertArrayEquals(expected, actual, 0.0001, "Arrays should have the same elements");
        }
    }

    @Nested
    @DisplayName("Triangle Tests")
    class TriangleTests {
        @Test
        @DisplayName("Test Triangle Area Nullness")
        void testTriangleAreaNullness() {
            Shape triangle = new Triangulo(6, 4);
            assertNotNull(triangle.area());
        }

        @Test
        @DisplayName("Test Triangle Area Exception")
        void testTriangleAreaException() {
            assertThrows(IllegalArgumentException.class, () -> {
                Shape triangle = new Triangulo(-1, 4);
                triangle.area();
            });
        }

        @Test
        @DisplayName("Test Triangle Area Group Assertions")
        void testTriangleAreaGroupAssertions() {
            int[] base = {3, 4, 5};
            int[] height = {4, 5, 6};
            assertAll("triangle",
                    () -> assertEquals(6.0, new Triangle(base[0], height[0]).area()),
                    () -> assertEquals(10.0, new Triangle(base[1], height[1]).area()),
                    () -> assertEquals(15.0, new Triangle(base[2], height[2]).area())
            );
        }
    }
}