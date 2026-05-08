

abstract class Shape {
    // Método abstracto para calcular el área de la figura
    public abstract double area();
}

class Rectangulo extends Shape {
    private double width;
    private double height;

    // Constructor para inicializar las propiedades del rectángulo
    public Rectangulo(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Método para calcular el área del rectángulo
    @Override
    public double area() {
        return width * height;
    }
}


class Circulo extends Shape {
    private double radius;

    // Constructor para inicializar el radio del círculo
    public Circulo(double radius) {
        this.radius = radius;
    }

    // Método para calcular el área del círculo
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}


class Triangulo extends Shape {
    private double base;
    private double height;

    // Constructor para inicializar la base y la altura del triángulo
    public Triangulo(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("La base y la altura deben ser positivos");
        }
        this.base = base;
        this.height = height;
    }

    // Método para calcular el área del triángulo
    @Override
    public double area() {
        return 0.5 * base * height;
    }
}