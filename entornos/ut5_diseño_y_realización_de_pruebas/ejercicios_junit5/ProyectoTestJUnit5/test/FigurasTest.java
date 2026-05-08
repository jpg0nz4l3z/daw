import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FigurasTest {

    private static Rectangle staticRectangle;
    private static Circle staticCircle;
    private static Triangle staticTriangle;

    private Rectangle rectangle;
    private Circle circle;
    private Triangle triangle;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Antes de todos los métodos");
        staticRectangle = new Rectangle(10, 8); // Inicialización de una instancia estática de Rectangle
        staticCircle = new Circle(5); // Inicialización de una instancia estática de Circle
        staticTriangle = new Triangle(8, 6); // Inicialización de una instancia estática de Triangle
    }

    @BeforeEach
    public void beforeEach() {
        rectangle = new Rectangle(5, 4);
        circle = new Circle(3);
        triangle = new Triangle(6, 4);
    }

    @Test
    @Order(4)
    public void testRectangleArea() {
        assertEquals(20.0, rectangle.area());
        System.out.println("AreaRectángulo: " + rectangle.area());
    }

    @Test
    @Order(5)
    public void testCircleArea() {
        assertEquals(Math.PI * 9, circle.area());
        System.out.println("AreaCírculo: " + circle.area());
    }

    @Test
    @Order(2)
    public void testTriangleArea() {
        assertEquals(12.0, triangle.area());
        System.out.println("AreaTriángulo: " + triangle.area());
    }

    @Test
    @Order(1)
    public void testStaticRectangleArea() {
        assertEquals(80.0, staticRectangle.area()); // Prueba con la instancia estática de Rectangle
        System.out.println("AreaRectánguloEstático: " + staticRectangle.area());
    }

    @Test
    @Order(3)
    public void testStaticCircleArea() {
        assertEquals(Math.PI * 25, staticCircle.area()); // Prueba con la instancia estática de Circle
        System.out.println("AreaCículoEstático: " + staticCircle.area());
    }

    @Test
    @Order(6)
    public void testStaticTriangleArea() {
        assertEquals(24.0, staticTriangle.area()); // Prueba con la instancia estática de Triangle
        System.out.println("AreaTriánguloEstático: " + staticTriangle.area());
    }

    @Test
    @Order(8)
    public void testRectangleNegativeDimensions() {
        Rectangle negativeRectangle = new Rectangle(-5, -4);
        assertEquals(20.0, negativeRectangle.area());
        System.out.println("AreaRectánguloNegativo: " + negativeRectangle.area());
    }

    @Test
    @Order(7)
    public void testCircleZeroRadius() {
        Circle zeroRadiusCircle = new Circle(0);
        assertEquals(0.0, zeroRadiusCircle.area());
        System.out.println("Radio: " + zeroRadiusCircle.area());
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Después de cada método");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Después de todos los métodos");
    }
}