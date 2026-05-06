package org.example.ejercicios_cadenas;

import java.text.Normalizer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Ejercicios de Cadenas en Java (uno por método).
 * - String, StringBuilder, StringBuffer, char[], regex, unicode, streams...
 */
public class EjerciciosCadenas {

    // 01) Longitud segura (null -> 0)
    public static int lengthSafe(String s) {
        return (s == null) ? 0 : s.length();
    }

    // 02) ¿Está vacía o en blanco? (null cuenta como "vacía")
    public static boolean isBlankSafe(String s) {
        return s == null || s.isBlank();
    }

    // 03) Trim seguro
    public static String trimSafe(String s) {
        return (s == null) ? "" : s.trim();
    }

    // 04) Mayúsculas/minúsculas con Locale (evita bugs tipo turco)
    public static String toUpperLocale(String s, Locale locale) {
        if (s == null) return "";
        Locale loc = (locale == null) ? Locale.ROOT : locale;
        return s.toUpperCase(loc);
    }

    // 05) Comparación ignoreCase segura
    public static boolean equalsIgnoreCaseSafe(String a, String b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.equalsIgnoreCase(b);
    }

    // 06) Reverso usando StringBuilder
    public static String reverseSB(String s) {
        if (s == null) return "";
        return new StringBuilder(s).reverse().toString();
    }

    // 07) Reverso "manual" con char[]
    public static String reverseCharArray(String s) {
        if (s == null) return "";
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }
        return new String(arr);
    }

    // 08) Cuenta ocurrencias de un carácter
    public static int countChar(String s, char c) {
        if (s == null) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
        }
        return count;
    }

    // 09) Cuenta ocurrencias de un substring (no solapadas)
    public static int countSubstringNonOverlapping(String s, String sub) {
        if (s == null || sub == null || sub.isEmpty()) return 0;
        int count = 0;
        int idx = 0;
        while ((idx = s.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        return count;
    }

    // 10) Cuenta ocurrencias de un substring (solapadas)
    public static int countSubstringOverlapping(String s, String sub) {
        if (s == null || sub == null || sub.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i <= s.length() - sub.length(); i++) {
            if (s.regionMatches(i, sub, 0, sub.length())) count++;
        }
        return count;
    }

    // 11) Elimina espacios extra: "  hola   mundo " -> "hola mundo"
    public static String collapseSpaces(String s) {
        if (s == null) return "";
        return s.trim().replaceAll("\\s+", " ");
    }

    // 12) Capitaliza cada palabra (simple)
    public static String titleCase(String s) {
        if (s == null) return "";
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String w = parts[i];
            if (!w.isEmpty()) {
                sb.append(Character.toUpperCase(w.charAt(0)));
                if (w.length() > 1) sb.append(w.substring(1).toLowerCase(Locale.ROOT));
            }
            if (i < parts.length - 1) sb.append(' ');
        }
        return sb.toString();
    }

    // 13) ¿Es palíndromo? (ignorando espacios y signos, y case)
    public static boolean isPalindromeLoose(String s) {
        if (s == null) return false;
        String cleaned = s.toLowerCase(Locale.ROOT).replaceAll("[^\\p{L}\\p{N}]+", "");
        int i = 0, j = cleaned.length() - 1;
        while (i < j) {
            if (cleaned.charAt(i) != cleaned.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    // 14) Anagrama (ignorando espacios y case)
    public static boolean isAnagramLoose(String a, String b) {
        if (a == null || b == null) return false;
        String ca = a.toLowerCase(Locale.ROOT).replaceAll("[^\\p{L}\\p{N}]+", "");
        String cb = b.toLowerCase(Locale.ROOT).replaceAll("[^\\p{L}\\p{N}]+", "");
        if (ca.length() != cb.length()) return false;
        int[] freq = new int[Character.MAX_VALUE + 1]; // amplio (char)
        for (int i = 0; i < ca.length(); i++) freq[ca.charAt(i)]++;
        for (int i = 0; i < cb.length(); i++) {
            if (--freq[cb.charAt(i)] < 0) return false;
        }
        return true;
    }

    // 15) Substring seguro (sin exceptions)
    public static String substringSafe(String s, int start, int end) {
        if (s == null) return "";
        int n = s.length();
        int a = Math.max(0, Math.min(start, n));
        int b = Math.max(0, Math.min(end, n));
        if (a > b) { int tmp = a; a = b; b = tmp; }
        return s.substring(a, b);
    }

    // 16) Reemplaza solo la primera coincidencia literal (no regex)
    public static String replaceFirstLiteral(String s, String target, String replacement) {
        if (s == null) return "";
        if (target == null || target.isEmpty()) return s;
        int idx = s.indexOf(target);
        if (idx < 0) return s;
        return s.substring(0, idx) + (replacement == null ? "" : replacement) + s.substring(idx + target.length());
    }

    // 17) Enmascara email: "juan.perez@dom.com" -> "j***z@dom.com" (simple)
    public static String maskEmail(String email) {
        if (email == null) return "";
        int at = email.indexOf('@');
        if (at <= 0) return email;
        String user = email.substring(0, at);
        String domain = email.substring(at);
        if (user.length() <= 2) return user.charAt(0) + "*" + domain;
        return user.charAt(0) + "***" + user.charAt(user.length() - 1) + domain;
    }

    // 18) Extrae dígitos de una cadena
    public static String extractDigits(String s) {
        if (s == null) return "";
        return s.replaceAll("\\D+", "");
    }

    // 19) Valida si es un entero con signo (regex)
    public static boolean isSignedInteger(String s) {
        if (s == null) return false;
        return s.matches("[+-]?\\d+");
    }

    // 20) Normaliza acentos: "canción" -> "cancion"
    public static String removeDiacritics(String s) {
        if (s == null) return "";
        String norm = Normalizer.normalize(s, Normalizer.Form.NFD);
        return norm.replaceAll("\\p{M}+", "");
    }

    // 21) Cuenta palabras (usando regex de letras/números)
    public static int countWords(String s) {
        if (s == null) return 0;
        Matcher m = Pattern.compile("[\\p{L}\\p{N}]+").matcher(s);
        int c = 0;
        while (m.find()) c++;
        return c;
    }

    // 22) Devuelve la palabra más larga (primera si empata)
    public static String longestWord(String s) {
        if (s == null) return "";
        Matcher m = Pattern.compile("[\\p{L}\\p{N}]+").matcher(s);
        String best = "";
        while (m.find()) {
            String w = m.group();
            if (w.length() > best.length()) best = w;
        }
        return best;
    }

    // 23) Divide CSV "simple" (sin comillas escapadas)
    public static List<String> splitCsvSimple(String s) {
        if (s == null || s.isEmpty()) return List.of();
        return Arrays.stream(s.split("\\s*,\\s*"))
                .collect(Collectors.toList());
    }

    // 24) Join con StringJoiner
    public static String joinWithComma(Collection<String> items) {
        if (items == null) return "";
        StringJoiner sj = new StringJoiner(", ");
        for (String it : items) sj.add(it == null ? "" : it);
        return sj.toString();
    }

    // 25) Join con streams + filtrado de nulos/vacíos
    public static String joinNonEmpty(Collection<String> items, String delimiter) {
        if (items == null) return "";
        String del = (delimiter == null) ? "" : delimiter;
        return items.stream()
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(x -> !x.isEmpty())
                .collect(Collectors.joining(del));
    }

    // 26) Construye texto grande con StringBuilder (demo)
    public static String buildReport(String title, List<String> lines) {
        StringBuilder sb = new StringBuilder(256);
        sb.append("== ").append(title == null ? "SIN TITULO" : title).append(" ==\n");
        if (lines != null) {
            for (int i = 0; i < lines.size(); i++) {
                sb.append(String.format(Locale.ROOT, "%02d) %s%n", i + 1, lines.get(i)));
            }
        }
        return sb.toString();
    }

    // 27) Versión thread-safe con StringBuffer (demo)
    public static StringBuffer appendThreadSafe(StringBuffer sb, String s) {
        if (sb == null) sb = new StringBuffer();
        sb.append(s == null ? "" : s);
        return sb;
    }

    // 28) Encuentra todas las coincidencias de un regex y devuelve grupos
    public static List<String> findAllMatches(String s, String regex) {
        if (s == null || regex == null) return List.of();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        List<String> out = new ArrayList<>();
        while (m.find()) out.add(m.group());
        return out;
    }

    // 29) Reemplazo con regex usando Matcher.quoteReplacement (seguro)
    public static String regexReplaceSafe(String s, String regex, String replacement) {
        if (s == null) return "";
        if (regex == null || regex.isEmpty()) return s;
        String rep = Matcher.quoteReplacement(replacement == null ? "" : replacement);
        return s.replaceAll(regex, rep);
    }

    // 30) Comprueba prefijo/sufijo ignorando mayúsculas
    public static boolean startsWithIgnoreCase(String s, String prefix) {
        if (s == null || prefix == null) return false;
        if (prefix.length() > s.length()) return false;
        return s.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public static boolean endsWithIgnoreCase(String s, String suffix) {
        if (s == null || suffix == null) return false;
        if (suffix.length() > s.length()) return false;
        int start = s.length() - suffix.length();
        return s.regionMatches(true, start, suffix, 0, suffix.length());
    }

    // 31) Índices de todas las apariciones de un substring
    public static List<Integer> allIndicesOf(String s, String sub) {
        if (s == null || sub == null || sub.isEmpty()) return List.of();
        List<Integer> idxs = new ArrayList<>();
        int idx = 0;
        while ((idx = s.indexOf(sub, idx)) != -1) {
            idxs.add(idx);
            idx += sub.length();
        }
        return idxs;
    }

    // 32) Elimina caracteres no imprimibles (control)
    public static String removeControlChars(String s) {
        if (s == null) return "";
        return s.replaceAll("\\p{Cntrl}", "");
    }

    // 33) Cuenta code points (Unicode real, emojis cuentan bien)
    public static int unicodeCodePointCount(String s) {
        if (s == null) return 0;
        return s.codePointCount(0, s.length());
    }

    // 34) Recorta a N code points (no rompe emojis)
    public static String truncateByCodePoints(String s, int maxCodePoints) {
        if (s == null) return "";
        if (maxCodePoints <= 0) return "";
        int total = s.codePointCount(0, s.length());
        if (maxCodePoints >= total) return s;
        int endIndex = s.offsetByCodePoints(0, maxCodePoints);
        return s.substring(0, endIndex);
    }

    // 35) Repite N veces (Java 11 String::repeat)
    public static String repeat(String s, int times) {
        if (s == null) s = "";
        if (times <= 0) return "";
        return s.repeat(times);
    }

    // 36) Left pad con un char
    public static String leftPad(String s, int width, char pad) {
        if (s == null) s = "";
        if (s.length() >= width) return s;
        StringBuilder sb = new StringBuilder(width);
        for (int i = 0; i < width - s.length(); i++) sb.append(pad);
        sb.append(s);
        return sb.toString();
    }

    // 37) Right pad con un char
    public static String rightPad(String s, int width, char pad) {
        if (s == null) s = "";
        if (s.length() >= width) return s;
        StringBuilder sb = new StringBuilder(width);
        sb.append(s);
        for (int i = 0; i < width - s.length(); i++) sb.append(pad);
        return sb.toString();
    }

    // 38) Formatea con Formatter (alternativa a String.format)
    public static String formatPrice(String product, double price) {
        StringBuilder sb = new StringBuilder();
        try (Formatter fmt = new Formatter(sb, Locale.ROOT)) {
            fmt.format("Producto: %s | Precio: %.2f €", product == null ? "N/A" : product, price);
        }
        return sb.toString();
    }

    // 39) Escapa para JSON básico (no completo, pero útil)
    public static String escapeJsonBasic(String s) {
        if (s == null) return "";
        StringBuilder sb = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '\\' -> sb.append("\\\\");
                case '"'  -> sb.append("\\\"");
                case '\n' -> sb.append("\\n");
                case '\r' -> sb.append("\\r");
                case '\t' -> sb.append("\\t");
                default -> {
                    if (ch < 0x20) sb.append(String.format(Locale.ROOT, "\\u%04x", (int) ch));
                    else sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    // 40) "Rot13" (clásico) para letras A-Z/a-z
    public static String rot13(String s) {
        if (s == null) return "";
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ('a' + (c - 'a' + 13) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' + 13) % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 41) Frecuencia de caracteres (Map)
    public static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        if (s == null) return map;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    // 42) Frecuencia de palabras (streams)
    public static Map<String, Long> wordFrequency(String s) {
        if (s == null) return Map.of();
        Matcher m = Pattern.compile("[\\p{L}\\p{N}]+").matcher(s.toLowerCase(Locale.ROOT));
        List<String> words = new ArrayList<>();
        while (m.find()) words.add(m.group());
        return words.stream()
                .collect(Collectors.groupingBy(w -> w, LinkedHashMap::new, Collectors.counting()));
    }

    // 43) Elimina duplicados de palabras manteniendo orden
    public static String uniqueWordsPreserveOrder(String s) {
        if (s == null) return "";
        Matcher m = Pattern.compile("[\\p{L}\\p{N}]+").matcher(s);
        LinkedHashSet<String> set = new LinkedHashSet<>();
        while (m.find()) set.add(m.group());
        return String.join(" ", set);
    }

    // 44) Detecta si contiene solo ASCII
    public static boolean isAscii(String s) {
        if (s == null) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 127) return false;
        }
        return true;
    }

    // 45) Encuentra el "primer no repetido"
    public static Optional<Character> firstNonRepeatedChar(String s) {
        if (s == null || s.isEmpty()) return Optional.empty();
        Map<Character, Integer> freq = charFrequency(s);
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() == 1) return Optional.of(e.getKey());
        }
        return Optional.empty();
    }

    // 46) Valida contraseña simple (mín 8, 1 mayús, 1 minús, 1 dígito)
    public static boolean validatePasswordSimple(String s) {
        if (s == null) return false;
        return s.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}");
    }

    // 47) Convierte camelCase a snake_case
    public static String camelToSnake(String s) {
        if (s == null) return "";
        // "miVariableHTTP" -> "mi_variable_http"
        return s.replaceAll("([a-z0-9])([A-Z])", "$1_$2")
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
                .toLowerCase(Locale.ROOT);
    }

    // 48) Convierte snake_case a camelCase
    public static String snakeToCamel(String s) {
        if (s == null) return "";
        String[] parts = s.toLowerCase(Locale.ROOT).split("_+");
        if (parts.length == 0) return "";
        StringBuilder sb = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            String p = parts[i];
            if (p.isEmpty()) continue;
            sb.append(Character.toUpperCase(p.charAt(0))).append(p.substring(1));
        }
        return sb.toString();
    }

    // 49) Comprueba si dos strings son iguales por contenido (demostración de equals vs ==)
    public static boolean contentEqualsDemo(String a, String b) {
        // (Solo devuelve equals; el "demo" es conceptual)
        return Objects.equals(a, b);
    }

    // 50) Busca y resalta un término (case-insensitive) envolviendo con []
    public static String highlightTerm(String text, String term) {
        if (text == null) return "";
        if (term == null || term.isEmpty()) return text;
        Pattern p = Pattern.compile(Pattern.quote(term), Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "[" + Matcher.quoteReplacement(m.group()) + "]");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static boolean esLetraAscii(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static boolean esLetraAsciiNumerico(char c) {
        int codigo = (int) c;
        return (codigo >= 65 && codigo <= 90) || (codigo >= 97 && codigo <= 122);
    }

    // MAIN de prueba rápida
    public static void main(String[] args) {
        String s = "  Hola,   mundo!  Esto es una canción 😊  ";
        System.out.println("collapseSpaces: " + collapseSpaces(s));
        System.out.println("titleCase: " + titleCase("hOLa mUNdo DESDE java"));
        System.out.println("reverseSB: " + reverseSB("abcdef"));
        System.out.println("palindrome: " + isPalindromeLoose("La ruta nos aporto otro paso natural"));
        System.out.println("anagram: " + isAnagramLoose("Roma", "Amor"));
        System.out.println("digits: " + extractDigits("Tel: +34 600-12-34-56"));
        System.out.println("words: " + countWords(s));
        System.out.println("longest: " + longestWord(s));
        System.out.println("unicodeCount: " + unicodeCodePointCount("a😊b"));
        System.out.println("truncateCP(2): " + truncateByCodePoints("a😊b", 2));
        System.out.println("camelToSnake: " + camelToSnake("miVariableHTTPServer"));
        System.out.println("snakeToCamel: " + snakeToCamel("mi_variable_http_server"));
        System.out.println("highlight: " + highlightTerm("Aprender Java es divertido. java JAVA!", "java"));
        System.out.println(formatPrice("Café", 1.5));
    }
}
