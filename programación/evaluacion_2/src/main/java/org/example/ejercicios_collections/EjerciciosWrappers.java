package org.example.ejercicios_collections;

import java.util.*;

public class EjerciciosWrappers {

    /* =========================================================
       ===================== INTEGER ===========================
       ========================================================= */

    // 1) Autoboxing
    public static Integer autoBoxing(int value) {
        Integer obj = value;
        return obj;
    }

    // 2) Unboxing
    public static int unBoxing(Integer value) {
        return value;
    }

    // 3) Parsear String a int
    public static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    // 4) Convertir Integer a String
    public static String integerToString(Integer num) {
        return num.toString();
    }

    // 5) Comparar Integer correctamente
    public static boolean compareIntegers(Integer a, Integer b) {
        return a.equals(b);
    }

    // 6) Comparar con compare()
    public static int compareUsingCompare(Integer a, Integer b) {
        return Integer.compare(a, b);
    }

    // 7) Obtener valor máximo posible
    public static int getMaxInt() {
        return Integer.MAX_VALUE;
    }

    // 8) Obtener valor mínimo posible
    public static int getMinInt() {
        return Integer.MIN_VALUE;
    }

    // 9) Convertir a binario
    public static String toBinary(int value) {
        return Integer.toBinaryString(value);
    }

    // 10) Convertir a hexadecimal
    public static String toHex(int value) {
        return Integer.toHexString(value);
    }

    // 11) Contar bits en 1
    public static int countBits(int value) {
        return Integer.bitCount(value);
    }

    // 12) Rotar bits a la izquierda
    public static int rotateLeft(int value, int positions) {
        return Integer.rotateLeft(value, positions);
    }

    // 13) Sumar de forma segura
    public static int safeSum(int a, int b) {
        return Integer.sum(a, b);
    }

    // 14) Convertir String en base diferente
    public static int parseBase(String s, int base) {
        return Integer.parseInt(s, base);
    }

    /* =========================================================
       ====================== DOUBLE ===========================
       ========================================================= */

    // 15) Parsear String a Double
    public static double parseStringToDouble(String s) {
        return Double.parseDouble(s);
    }

    // 16) Verificar si es NaN
    public static boolean isNaN(double value) {
        return Double.isNaN(value);
    }

    // 17) Verificar infinito
    public static boolean isInfinite(double value) {
        return Double.isInfinite(value);
    }

    // 18) Comparar Double correctamente
    public static int compareDouble(Double a, Double b) {
        return Double.compare(a, b);
    }

    /* =========================================================
       ====================== BOOLEAN ==========================
       ========================================================= */

    // 19) Parsear String a Boolean
    public static boolean parseBoolean(String s) {
        return Boolean.parseBoolean(s);
    }

    // 20) Convertir Boolean a String
    public static String booleanToString(Boolean b) {
        return b.toString();
    }

    // 21) Operación lógica AND
    public static boolean logicalAnd(Boolean a, Boolean b) {
        return Boolean.logicalAnd(a, b);
    }

    // 22) Operación lógica OR
    public static boolean logicalOr(Boolean a, Boolean b) {
        return Boolean.logicalOr(a, b);
    }

    /* =========================================================
       ===================== CHARACTER =========================
       ========================================================= */

    // 23) Verificar si es letra
    public static boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    // 24) Verificar si es dígito
    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    // 25) Convertir a mayúscula
    public static char toUpper(char c) {
        return Character.toUpperCase(c);
    }

    // 26) Convertir a minúscula
    public static char toLower(char c) {
        return Character.toLowerCase(c);
    }

    // 27) Obtener valor numérico de un char
    public static int getNumericValue(char c) {
        return Character.getNumericValue(c);
    }

    // 28) Verificar si es espacio
    public static boolean isWhitespace(char c) {
        return Character.isWhitespace(c);
    }

    /* =========================================================
       ======================= LONG ============================
       ========================================================= */

    // 29) Parsear String a Long
    public static long parseStringToLong(String s) {
        return Long.parseLong(s);
    }

    // 30) Convertir Long a String
    public static String longToString(Long value) {
        return value.toString();
    }

    // 31) Comparar Long
    public static int compareLong(Long a, Long b) {
        return Long.compare(a, b);
    }

    /* =========================================================
       ==================== SHORT / BYTE =======================
       ========================================================= */

    // 32) Parsear Short
    public static short parseShort(String s) {
        return Short.parseShort(s);
    }

    // 33) Parsear Byte
    public static byte parseByte(String s) {
        return Byte.parseByte(s);
    }

    /* =========================================================
       =================== NULL SAFETY =========================
       ========================================================= */

    // 34) Evitar NullPointerException
    public static int safeUnbox(Integer value) {
        return (value != null) ? value : 0;
    }

    // 35) Comparar evitando null
    public static boolean safeEquals(Integer a, Integer b) {
        return Objects.equals(a, b);
    }

    /* =========================================================
       ======================= OPTIONAL ========================
       ========================================================= */

    // 36) Crear Optional
    public static Optional<Integer> createOptional(Integer value) {
        return Optional.ofNullable(value);
    }

    // 37) Obtener valor con default
    public static int getOrDefault(Optional<Integer> opt) {
        return opt.orElse(0);
    }

    /* =========================================================
       ==================== CACHE INTEGER ======================
       ========================================================= */

    // 38) Demostrar caché de Integer (-128 a 127)
    public static boolean integerCacheTest() {
        Integer a = 100;
        Integer b = 100;
        return a == b; // true por caché
    }

    // 39) Comparación fuera de caché
    public static boolean integerNoCacheTest() {
        Integer a = 200;
        Integer b = 200;
        return a == b; // false
    }

    /* =========================================================
       ==================== VALUEOF vs NEW =====================
       ========================================================= */

    // 40) Usar valueOf (recomendado)
    public static Integer useValueOf(int value) {
        return Integer.valueOf(value);
    }

    // 41) Usar new (no recomendado)
    public static Integer useNew(int value) {
        return new Integer(value);
    }

}
