public class AdvancedMathUtils {

    public static int power(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent cannot be negative");
        }
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Square root is not defined for negative numbers");
        }
        return Math.sqrt(x);
    }

    public static double log(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Logarithm is not defined for non-positive numbers");
        }
        return Math.log10(x);
    }
}