package org.example.ejercicios_ficheros;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * TEMA 6 - Lectura y escritura de datos
 * EJERCICIOS RESUELTOS (muchos) en una sola clase
 */
public class Tema6_EjerciciosLecturaEscritura_RESUELTOS {

    // ==========================
    // CONFIGURACIÓN
    // ==========================
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final Path DIR_DATOS = Paths.get("datos");

    private static final Path TXT_NOTAS = DIR_DATOS.resolve("notas.txt");
    private static final Path TXT_LOG = DIR_DATOS.resolve("log.txt");

    private static final Path BIN_DATOS = DIR_DATOS.resolve("datos.bin");

    private static final Path RAF_DEMO = DIR_DATOS.resolve("raf_demo.dat");
    private static final Path RAF_REGISTROS = DIR_DATOS.resolve("registros_fijos.dat");

    private static final Path SER_PERSONAS = DIR_DATOS.resolve("personas.ser");

    private static final Path JSON_PERSONA = DIR_DATOS.resolve("persona.json");
    private static final Path JSON_PERSONAS = DIR_DATOS.resolve("personas.json");

    public static void main(String[] args) {
        asegurarDirectorioDatos();

        // Ejecuta una demo rápida (puedes comentar/activar lo que quieras)
        ej01_crearEstructuraDirectorios();
        ej02_crearRutaPortable();

        ej03_escribirTextoConFiles_writeString();
        ej04_leerTextoConFiles_readString();

        ej05_escribirLineasConFiles_write();
        ej06_leerLineasConFiles_readAllLines();

        ej07_appendConStandardOpenOption();
        ej08_gestionarIOException();

        ej20_escribirBytesConFileOutputStream();
        ej21_leerBytesConFileInputStream();

        ej22_escribirTextoConBufferedWriterUTF8();
        ej23_leerTextoConBufferedReaderUTF8();

        ej24_appendConFileWriterModoConcatena();
        ej25_convertirCodificaciones();

        ej30_escribirBinarioTipado();
        ej31_leerBinarioTipadoMismoOrden();
        ej32_validarOrdenLecturaEscritura();

        ej40_escribirEnPosiciones();
        ej41_leerDesdePosiciones();

        ej42_registrosTamanoFijo_insertar();
        ej43_registrosTamanoFijo_leerPorIndice();
        ej44_registrosTamanoFijo_actualizarCampo();

        ej50_serializarObjeto();
        ej51_deserializarObjeto();
        ej52_serializarListaObjetos();

        ej60_jsonManual_guardarPersona();
        ej61_jsonManual_leerPersona();

        ej62_gson_guardarPersona();   // opcional
        ej63_gson_leerPersona();      // opcional
        ej64_jackson_guardarPersona(); // opcional
        ej65_jackson_leerPersona();    // opcional

        reto90_gestorNotas_txt();
        reto91_exportarImportar_csv();
        reto92_miniBD_randomAccessFile();
        reto93_migracion_ser_a_json();

        System.out.println("\n✅ Fin demo. Revisa la carpeta: " + DIR_DATOS.toAbsolutePath());
    }

    // ==========================
    // UTILIDADES
    // ==========================
    private static void asegurarDirectorioDatos() {
        try {
            Files.createDirectories(DIR_DATOS);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo crear el directorio datos/: " + e.getMessage(), e);
        }
    }

    private static void log(String msg) {
        System.out.println(msg);
    }

    private static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    // ============================================================
    // BLOQUE A: SISTEMA DE ARCHIVOS + RUTAS + NIO (java.nio.file)
    // ============================================================

    /** Ej01: Crear datos/in y datos/out */
    private static void ej01_crearEstructuraDirectorios() {
        Path in = DIR_DATOS.resolve("in");
        Path out = DIR_DATOS.resolve("out");
        try {
            Files.createDirectories(in);
            Files.createDirectories(out);

            log("Ej01 OK:");
            log(" - in  existe? " + Files.exists(in) + " -> " + in.toAbsolutePath());
            log(" - out existe? " + Files.exists(out) + " -> " + out.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Ej01 error: " + e.getMessage(), e);
        }
    }

    /** Ej02: Construir rutas portables sin concatenar strings */
    private static void ej02_crearRutaPortable() {
        Path p = Paths.get("datos", "config", "app.txt");
        log("Ej02 ruta: " + p);
        log(" - filename: " + p.getFileName());
        log(" - absoluta? " + p.isAbsolute());
        log(" - absoluta: " + p.toAbsolutePath());
        try {
            Files.createDirectories(p.getParent());
            Files.writeString(p, "config=true\n", UTF8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Ej02 error: " + e.getMessage(), e);
        }
    }

    /** Ej03: Files.writeString sobrescribe */
    private static void ej03_escribirTextoConFiles_writeString() {
        String texto = "NOTAS\n"
                + "-----\n"
                + "1) Esto es una línea\n"
                + "2) Esto es otra línea\n"
                + "3) Última línea\n";
        try {
            Files.writeString(TXT_NOTAS, texto, UTF8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            log("Ej03 escrito: " + TXT_NOTAS.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Ej03 error: " + e.getMessage(), e);
        }
    }

    /** Ej04: Files.readString */
    private static void ej04_leerTextoConFiles_readString() {
        try {
            if (!Files.exists(TXT_NOTAS)) {
                log("Ej04: No existe " + TXT_NOTAS);
                return;
            }
            String contenido = Files.readString(TXT_NOTAS, UTF8);
            log("Ej04 leído:\n" + contenido);
        } catch (IOException e) {
            throw new RuntimeException("Ej04 error: " + e.getMessage(), e);
        }
    }

    /** Ej05: Files.write con lista de líneas */
    private static void ej05_escribirLineasConFiles_write() {
        List<String> lineas = List.of(
                "Línea A",
                "Línea B",
                "Línea C",
                "Línea D",
                "Línea E"
        );
        try {
            Files.write(TXT_NOTAS, lineas, UTF8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            long size = Files.size(TXT_NOTAS);
            log("Ej05 OK. Tamaño bytes: " + size);
        } catch (IOException e) {
            throw new RuntimeException("Ej05 error: " + e.getMessage(), e);
        }
    }

    /** Ej06: Files.readAllLines y filtrar */
    private static void ej06_leerLineasConFiles_readAllLines() {
        try {
            List<String> lineas = Files.readAllLines(TXT_NOTAS, UTF8);
            log("Ej06 líneas: " + lineas.size());
            for (String s : lineas) {
                if (s.toLowerCase().contains("línea")) {
                    log(" - contiene 'línea': " + s);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ej06 error: " + e.getMessage(), e);
        }
    }

    /** Ej07: Append con StandardOpenOption.CREATE y APPEND */
    private static void ej07_appendConStandardOpenOption() {
        try {
            for (int i = 1; i <= 3; i++) {
                String linea = now() + " | log #" + i + System.lineSeparator();
                Files.writeString(TXT_LOG, linea, UTF8,
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
            log("Ej07 OK. Appends a " + TXT_LOG.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Ej07 error: " + e.getMessage(), e);
        }
    }

    /** Ej08: Manejo de IO cuando no existe */
    private static void ej08_gestionarIOException() {
        Path p = DIR_DATOS.resolve("no_existe.txt");
        try {
            if (!Files.exists(p)) {
                log("Ej08: Archivo no existe (controlado): " + p);
                return;
            }
            log(Files.readString(p, UTF8));
        } catch (IOException e) {
            log("Ej08: Error de lectura: " + e.getMessage());
        }
    }

    // ============================================================
    // BLOQUE B: FLUJOS java.io: BYTES, CARACTERES, BUFFER, UTF-8
    // ============================================================

    /** Ej20: Escribir bytes crudos */
    private static void ej20_escribirBytesConFileOutputStream() {
        Path destino = DIR_DATOS.resolve("bytes.bin");
        byte[] bytes = new byte[] {65, 66, 67, 10, 68, 69}; // ABC\nDE
        try (FileOutputStream fos = new FileOutputStream(destino.toFile())) {
            fos.write(bytes);
            log("Ej20 OK -> " + destino.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Ej20 error: " + e.getMessage(), e);
        }
    }

    /** Ej21: Leer bytes crudos */
    private static void ej21_leerBytesConFileInputStream() {
        Path origen = DIR_DATOS.resolve("bytes.bin");
        try (FileInputStream fis = new FileInputStream(origen.toFile())) {
            log("Ej21 leyendo bytes:");
            int b;
            while ((b = fis.read()) != -1) {
                char c = (b >= 32 && b <= 126) ? (char) b : '.';
                log(" - byte=" + b + " char=" + c);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ej21 error: " + e.getMessage(), e);
        }
    }

    /** Ej22: Escribir texto con UTF-8 correctamente (OutputStreamWriter + BufferedWriter) */
    private static void ej22_escribirTextoConBufferedWriterUTF8() {
        Path archivo = DIR_DATOS.resolve("utf8.txt");
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(archivo.toFile()), UTF8))) {
            bw.write("Primera línea con acentos: á é í ó ú");
            bw.newLine();
            bw.write("Segunda con ñ y €: niño, 10€");
            bw.newLine();
            bw.write("Tercera con emoji: 🙂");
            bw.newLine();
            log("Ej22 OK -> " + archivo.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Ej22 error: " + e.getMessage(), e);
        }
    }

    /** Ej23: Leer texto con UTF-8 correctamente (InputStreamReader + BufferedReader) */
    private static void ej23_leerTextoConBufferedReaderUTF8() {
        Path archivo = DIR_DATOS.resolve("utf8.txt");
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo.toFile()), UTF8))) {
            log("Ej23 leyendo líneas:");
            String line;
            while ((line = br.readLine()) != null) {
                log(" - " + line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ej23 error: " + e.getMessage(), e);
        }
    }

    /** Ej24: Append con FileWriter(..., true) (usa charset por defecto del sistema) */
    private static void ej24_appendConFileWriterModoConcatena() {
        Path archivo = DIR_DATOS.resolve("append_filewriter.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo.toFile(), true))) {
            bw.write(now() + " | append con FileWriter (charset por defecto)");
            bw.newLine();
            log("Ej24 OK -> " + archivo.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Ej24 error: " + e.getMessage(), e);
        }
    }

    /** Ej25: Comparar lecturas con distinta codificación */
    private static void ej25_convertirCodificaciones() {
        Path archivo = DIR_DATOS.resolve("utf8.txt");
        log("Ej25 (UTF-8 correcto):");
        try (BufferedReader br = Files.newBufferedReader(archivo, UTF8)) {
            br.lines().forEach(s -> log(" - " + s));
        } catch (IOException e) {
            throw new RuntimeException("Ej25 UTF-8 error: " + e.getMessage(), e);
        }

        // Intento ISO-8859-1 (verás caracteres raros en emoji y algunos símbolos)
        log("Ej25 (leyendo como ISO-8859-1 a propósito):");
        try (BufferedReader br = Files.newBufferedReader(archivo, Charset.forName("ISO-8859-1"))) {
            br.lines().forEach(s -> log(" - " + s));
        } catch (IOException e) {
            log("Ej25 ISO error: " + e.getMessage());
        }
    }

    // ============================================================
    // BLOQUE C: BINARIO ESTRUCTURADO (DataOutputStream / DataInputStream)
    // ============================================================

    /** Ej30: Escribir int, double, UTF (String) en binario */
    private static void ej30_escribirBinarioTipado() {
        int edad = 25;
        double salario = 1850.75;
        String nombre = "Juan";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(BIN_DATOS.toFile()))) {
            dos.writeInt(edad);
            dos.writeDouble(salario);
            dos.writeUTF(nombre);
            log("Ej30 OK -> " + BIN_DATOS.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Ej30 error: " + e.getMessage(), e);
        }
    }

    /** Ej31: Leer en el mismo orden */
    private static void ej31_leerBinarioTipadoMismoOrden() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(BIN_DATOS.toFile()))) {
            int edad = dis.readInt();
            double salario = dis.readDouble();
            String nombre = dis.readUTF();
            log("Ej31 leído -> edad=" + edad + " salario=" + salario + " nombre=" + nombre);
        } catch (IOException e) {
            throw new RuntimeException("Ej31 error: " + e.getMessage(), e);
        }
    }

    /** Ej32: Orden incorrecto */
    private static void ej32_validarOrdenLecturaEscritura() {
        log("Ej32 intentando leer en orden incorrecto (espera valores raros o error):");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(BIN_DATOS.toFile()))) {
            // MAL: se escribió int primero, aquí intentamos double primero
            double d = dis.readDouble();
            int i = dis.readInt();
            log(" - resultado raro -> double=" + d + " int=" + i);
            log("Explicación: el formato binario depende del ORDEN. Leer tipos distintos interpreta bytes mal.");
        } catch (IOException e) {
            log(" - Excepción esperable: " + e.getClass().getSimpleName() + " -> " + e.getMessage());
            log("Explicación: al romper el orden/tamaño de lectura, el stream queda desalineado.");
        }
    }

    // ============================================================
    // BLOQUE D: RandomAccessFile (acceso directo)
    // ============================================================

    /** Ej40: Escribir en posiciones concretas */
    private static void ej40_escribirEnPosiciones() {
        try (RandomAccessFile raf = new RandomAccessFile(RAF_DEMO.toFile(), "rw")) {
            raf.setLength(0); // reiniciar demo

            raf.seek(0);
            raf.writeInt(123456);        // bytes 0..3

            raf.seek(4);
            raf.writeDouble(3.14159);    // bytes 4..11

            raf.seek(12);
            raf.writeUTF("HolaRAF");     // a partir de 12 (variable por UTF)

            log("Ej40 OK -> " + RAF_DEMO.toAbsolutePath() + " (len=" + raf.length() + ")");
        } catch (IOException e) {
            throw new RuntimeException("Ej40 error: " + e.getMessage(), e);
        }
    }

    /** Ej41: Leer desde posiciones */
    private static void ej41_leerDesdePosiciones() {
        try (RandomAccessFile raf = new RandomAccessFile(RAF_DEMO.toFile(), "r")) {
            raf.seek(0);
            int n = raf.readInt();

            raf.seek(4);
            double pi = raf.readDouble();

            raf.seek(12);
            String s = raf.readUTF();

            log("Ej41 leído -> int=" + n + " double=" + pi + " utf=" + s);
        } catch (IOException e) {
            throw new RuntimeException("Ej41 error: " + e.getMessage(), e);
        }
    }

    // ----------------------------
    // RandomAccessFile: registros de tamaño FIJO
    // ----------------------------
    /**
     * Registro fijo: (total 64 bytes)
     * - int id              (4)
     * - char[20] nombre     (40)  (2 bytes c/u)
     * - double saldo        (8)
     * - boolean activo      (1)
     * - padding             (11)  para redondear a 64
     */
    private static final int REG_BYTES = 64;
    private static final int NOMBRE_CHARS = 20;

    private static void writeFixedString(RandomAccessFile raf, String s, int chars) throws IOException {
        String rec = (s == null) ? "" : s;
        if (rec.length() > chars) rec = rec.substring(0, chars);
        // rellenar con espacios
        StringBuilder sb = new StringBuilder(rec);
        while (sb.length() < chars) sb.append(' ');
        for (int i = 0; i < chars; i++) {
            raf.writeChar(sb.charAt(i));
        }
    }

    private static String readFixedString(RandomAccessFile raf, int chars) throws IOException {
        StringBuilder sb = new StringBuilder(chars);
        for (int i = 0; i < chars; i++) sb.append(raf.readChar());
        return sb.toString().trim();
    }

    private static long offsetRegistro(int index) {
        return (long) index * REG_BYTES;
    }

    /** Ej42: Insertar 5 registros fijos */
    private static void ej42_registrosTamanoFijo_insertar() {
        try (RandomAccessFile raf = new RandomAccessFile(RAF_REGISTROS.toFile(), "rw")) {
            raf.setLength(0); // reiniciar fichero

            List<Cuenta> cuentas = List.of(
                    new Cuenta(1, "Ana", 100.50, true),
                    new Cuenta(2, "Luis", 2500.00, true),
                    new Cuenta(3, "Marta", 0.0, false),
                    new Cuenta(4, "Óscar", 99.99, true),
                    new Cuenta(5, "Zoé", 777.77, true)
            );

            for (int i = 0; i < cuentas.size(); i++) {
                writeCuentaAt(raf, i, cuentas.get(i));
            }

            log("Ej42 OK -> insertados " + cuentas.size() + " registros. Size=" + raf.length());
        } catch (IOException e) {
            throw new RuntimeException("Ej42 error: " + e.getMessage(), e);
        }
    }

    private static void writeCuentaAt(RandomAccessFile raf, int index, Cuenta c) throws IOException {
        raf.seek(offsetRegistro(index));
        raf.writeInt(c.id);
        writeFixedString(raf, c.nombre, NOMBRE_CHARS);
        raf.writeDouble(c.saldo);
        raf.writeBoolean(c.activo);

        // padding hasta 64
        int escritos = 4 + (2 * NOMBRE_CHARS) + 8 + 1; // 53
        int padding = REG_BYTES - escritos; // 11
        for (int i = 0; i < padding; i++) raf.writeByte(0);
    }

    private static Cuenta readCuentaAt(RandomAccessFile raf, int index) throws IOException {
        raf.seek(offsetRegistro(index));
        int id = raf.readInt();
        String nombre = readFixedString(raf, NOMBRE_CHARS);
        double saldo = raf.readDouble();
        boolean activo = raf.readBoolean();
        return new Cuenta(id, nombre, saldo, activo);
    }

    /** Ej43: Leer por índice (ejemplo: 0, 2, 4) */
    private static void ej43_registrosTamanoFijo_leerPorIndice() {
        try (RandomAccessFile raf = new RandomAccessFile(RAF_REGISTROS.toFile(), "r")) {
            int[] indices = {0, 2, 4};
            for (int idx : indices) {
                Cuenta c = readCuentaAt(raf, idx);
                log("Ej43 idx=" + idx + " -> " + c);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ej43 error: " + e.getMessage(), e);
        }
    }

    /** Ej44: Actualizar campo (saldo) en un registro concreto */
    private static void ej44_registrosTamanoFijo_actualizarCampo() {
        int index = 1; // actualizar el 2º registro
        double nuevoSaldo = 9999.99;

        try (RandomAccessFile raf = new RandomAccessFile(RAF_REGISTROS.toFile(), "rw")) {
            long base = offsetRegistro(index);

            // posición del saldo dentro del registro:
            // int(4) + nombre(40) => 44 bytes. saldo empieza en 44
            raf.seek(base + 4 + (2L * NOMBRE_CHARS));
            raf.writeDouble(nuevoSaldo);

            // Verificación
            Cuenta c = readCuentaAt(raf, index);
            log("Ej44 actualizado idx=" + index + " -> " + c);
        } catch (IOException e) {
            throw new RuntimeException("Ej44 error: " + e.getMessage(), e);
        }
    }

    // ============================================================
    // BLOQUE E: SERIALIZACIÓN JAVA (ObjectOutputStream/ObjectInputStream)
    // ============================================================

    /** Ej50: Serializar un objeto */
    private static void ej50_serializarObjeto() {
        Persona p = new Persona(10, "Juan", 25);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SER_PERSONAS.toFile()))) {
            oos.writeObject(p);
            log("Ej50 OK -> serializado: " + p + " en " + SER_PERSONAS.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Ej50 error: " + e.getMessage(), e);
        }
    }

    /** Ej51: Deserializar un objeto */
    private static void ej51_deserializarObjeto() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SER_PERSONAS.toFile()))) {
            Persona p = (Persona) ois.readObject();
            log("Ej51 OK -> deserializado: " + p);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Ej51 error: " + e.getMessage(), e);
        }
    }

    /** Ej52: Serializar lista de objetos */
    private static void ej52_serializarListaObjetos() {
        List<Persona> lista = new ArrayList<>();
        lista.add(new Persona(1, "Ana", 20));
        lista.add(new Persona(2, "Luis", 30));
        lista.add(new Persona(3, "Marta", 40));

        Path archivo = DIR_DATOS.resolve("lista_personas.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo.toFile()))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            throw new RuntimeException("Ej52 error: " + e.getMessage(), e);
        }

        // verificación leyendo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo.toFile()))) {
            @SuppressWarnings("unchecked")
            List<Persona> leida = (List<Persona>) ois.readObject();
            log("Ej52 OK -> lista leída (" + leida.size() + "): " + leida);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Ej52 verificación error: " + e.getMessage(), e);
        }
    }

    // ============================================================
    // BLOQUE F: JSON
    //  - Manual (sin librerías)
    //  - Gson (opcional)
    //  - Jackson (opcional)
    // ============================================================

    // ------------ JSON MANUAL ------------

    /** Ej60: Guardar una persona en JSON manual */
    private static void ej60_jsonManual_guardarPersona() {
        Persona p = new Persona(99, "Pepe \"El Grande\"", 33);
        String json = "{\n"
                + "  \"id\": " + p.id + ",\n"
                + "  \"nombre\": " + quoteJson(p.nombre) + ",\n"
                + "  \"edad\": " + p.edad + "\n"
                + "}\n";

        try {
            Files.writeString(JSON_PERSONA, json, UTF8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            log("Ej60 OK -> " + JSON_PERSONA.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Ej60 error: " + e.getMessage(), e);
        }
    }

    /** Ej61: Leer una persona desde JSON manual (parsing simple) */
    private static void ej61_jsonManual_leerPersona() {
        try {
            String json = Files.readString(JSON_PERSONA, UTF8);
            Persona p = parsePersonaJsonSimple(json);
            log("Ej61 OK -> leída: " + p);
        } catch (IOException e) {
            throw new RuntimeException("Ej61 error: " + e.getMessage(), e);
        }
    }

    private static String quoteJson(String s) {
        if (s == null) return "null";
        // escapado mínimo
        return "\"" + s.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    private static Persona parsePersonaJsonSimple(String json) {
        // Parser SIMPLE por ejercicios (no robusto para todos los JSON)
        // Busca "id":, "nombre":, "edad":
        int id = (int) extractNumber(json, "\"id\"");
        int edad = (int) extractNumber(json, "\"edad\"");
        String nombre = extractString(json, "\"nombre\"");
        return new Persona(id, nombre, edad);
    }

    private static long extractNumber(String json, String key) {
        int k = json.indexOf(key);
        if (k < 0) throw new IllegalArgumentException("No se encontró clave " + key);
        int colon = json.indexOf(':', k);
        int i = colon + 1;
        while (i < json.length() && Character.isWhitespace(json.charAt(i))) i++;
        int j = i;
        while (j < json.length() && (Character.isDigit(json.charAt(j)) || json.charAt(j) == '-')) j++;
        return Long.parseLong(json.substring(i, j).trim());
    }

    private static String extractString(String json, String key) {
        int k = json.indexOf(key);
        if (k < 0) throw new IllegalArgumentException("No se encontró clave " + key);
        int colon = json.indexOf(':', k);
        int i = colon + 1;
        while (i < json.length() && Character.isWhitespace(json.charAt(i))) i++;
        if (json.startsWith("null", i)) return null;
        if (json.charAt(i) != '"') throw new IllegalArgumentException("Se esperaba comillas en " + key);
        int j = i + 1;
        StringBuilder sb = new StringBuilder();
        while (j < json.length()) {
            char c = json.charAt(j);
            if (c == '\\') {
                char next = json.charAt(j + 1);
                if (next == '"' || next == '\\') sb.append(next);
                else sb.append(next); // escapados mínimos
                j += 2;
                continue;
            }
            if (c == '"') break;
            sb.append(c);
            j++;
        }
        return sb.toString();
    }

    // ------------ GSON (OPCIONAL) ------------

    /** Ej62: Guardar persona con Gson (si está disponible) */
    private static void ej62_gson_guardarPersona() {
        if (!isClassPresent("com.google.gson.Gson")) {
            log("Ej62 (Gson) saltado: no está en el classpath.");
            return;
        }
        try {
            // usar reflexión para evitar dependencia de compilación
            Object gson = Class.forName("com.google.gson.Gson").getConstructor().newInstance();
            Persona p = new Persona(7, "GsonUser", 27);
            String json = (String) gson.getClass().getMethod("toJson", Object.class).invoke(gson, p);
            Files.writeString(JSON_PERSONA, json, UTF8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            log("Ej62 OK (Gson) -> " + JSON_PERSONA.toAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("Ej62 error Gson: " + e.getMessage(), e);
        }
    }

    /** Ej63: Leer persona con Gson (si está disponible) */
    private static void ej63_gson_leerPersona() {
        if (!isClassPresent("com.google.gson.Gson")) {
            log("Ej63 (Gson) saltado: no está en el classpath.");
            return;
        }
        try {
            Object gson = Class.forName("com.google.gson.Gson").getConstructor().newInstance();
            String json = Files.readString(JSON_PERSONA, UTF8);
            Object personaObj = gson.getClass()
                    .getMethod("fromJson", String.class, Class.class)
                    .invoke(gson, json, Persona.class);
            Persona p = (Persona) personaObj;
            log("Ej63 OK (Gson) -> " + p);
        } catch (Exception e) {
            throw new RuntimeException("Ej63 error Gson: " + e.getMessage(), e);
        }
    }

    // ------------ JACKSON (OPCIONAL) ------------

    /** Ej64: Guardar persona con Jackson (si está disponible) */
    private static void ej64_jackson_guardarPersona() {
        if (!isClassPresent("com.fasterxml.jackson.databind.ObjectMapper")) {
            log("Ej64 (Jackson) saltado: no está en el classpath.");
            return;
        }
        try {
            Object mapper = Class.forName("com.fasterxml.jackson.databind.ObjectMapper")
                    .getConstructor().newInstance();
            Persona p = new Persona(8, "JacksonUser", 28);

            // String json = mapper.writeValueAsString(p)
            String json = (String) mapper.getClass().getMethod("writeValueAsString", Object.class).invoke(mapper, p);
            Files.writeString(JSON_PERSONA, json, UTF8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            log("Ej64 OK (Jackson) -> " + JSON_PERSONA.toAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException("Ej64 error Jackson: " + e.getMessage(), e);
        }
    }

    /** Ej65: Leer persona con Jackson (si está disponible) */
    private static void ej65_jackson_leerPersona() {
        if (!isClassPresent("com.fasterxml.jackson.databind.ObjectMapper")) {
            log("Ej65 (Jackson) saltado: no está en el classpath.");
            return;
        }
        try {
            Object mapper = Class.forName("com.fasterxml.jackson.databind.ObjectMapper")
                    .getConstructor().newInstance();
            String json = Files.readString(JSON_PERSONA, UTF8);

            // Persona p = mapper.readValue(json, Persona.class)
            Object personaObj = mapper.getClass()
                    .getMethod("readValue", String.class, Class.class)
                    .invoke(mapper, json, Persona.class);
            Persona p = (Persona) personaObj;
            log("Ej65 OK (Jackson) -> " + p);
        } catch (Exception e) {
            throw new RuntimeException("Ej65 error Jackson: " + e.getMessage(), e);
        }
    }

    private static boolean isClassPresent(String fqcn) {
        try {
            Class.forName(fqcn);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    // ============================================================
    // RETOS INTEGRADORES (resueltos)
    // ============================================================

    /**
     * Reto 90: Gestor de notas en TXT
     * - Añade una nota (append)
     * - Lista notas numeradas
     * - Busca por palabra
     */
    private static void reto90_gestorNotas_txt() {
        Path archivo = DIR_DATOS.resolve("gestor_notas.txt");

        // 1) Append 3 notas
        try {
            Files.writeString(archivo, now() + " | Nota: estudiar NIO\n", UTF8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(archivo, now() + " | Nota: practicar DataInputStream\n", UTF8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.writeString(archivo, now() + " | Nota: hacer registros fijos RAF\n", UTF8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Reto90 append error: " + e.getMessage(), e);
        }

        // 2) Listar numeradas
        try {
            List<String> lineas = Files.readAllLines(archivo, UTF8);
            log("Reto90: listado notas (" + lineas.size() + "):");
            for (int i = 0; i < lineas.size(); i++) {
                log("  " + (i + 1) + ") " + lineas.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException("Reto90 leer error: " + e.getMessage(), e);
        }

        // 3) Buscar palabra
        String palabra = "RAF";
        try {
            log("Reto90: búsqueda '" + palabra + "':");
            Files.lines(archivo, UTF8)
                    .filter(s -> s.toLowerCase().contains(palabra.toLowerCase()))
                    .forEach(s -> log("  - " + s));
        } catch (IOException e) {
            throw new RuntimeException("Reto90 buscar error: " + e.getMessage(), e);
        }
    }

    /**
     * Reto 91: Exportar/Importar CSV simple
     * - Exporta lista de personas a CSV
     * - Importa de CSV a lista
     */
    private static void reto91_exportarImportar_csv() {
        Path csv = DIR_DATOS.resolve("personas.csv");
        List<Persona> personas = List.of(
                new Persona(1, "Ana", 20),
                new Persona(2, "Luis", 30),
                new Persona(3, "Marta", 40)
        );

        // Exportar
        try (BufferedWriter bw = Files.newBufferedWriter(csv, UTF8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            bw.write("id,nombre,edad");
            bw.newLine();
            for (Persona p : personas) {
                bw.write(p.id + "," + escapeCsv(p.nombre) + "," + p.edad);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Reto91 export error: " + e.getMessage(), e);
        }

        // Importar
        List<Persona> leidas = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(csv, UTF8)) {
            String header = br.readLine(); // saltar cabecera
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = parseCsvLineSimple(line);
                int id = Integer.parseInt(parts[0]);
                String nombre = unescapeCsv(parts[1]);
                int edad = Integer.parseInt(parts[2]);
                leidas.add(new Persona(id, nombre, edad));
            }
        } catch (IOException e) {
            throw new RuntimeException("Reto91 import error: " + e.getMessage(), e);
        }

        log("Reto91 OK -> CSV=" + csv.toAbsolutePath() + " importadas=" + leidas);
    }

    private static String escapeCsv(String s) {
        if (s == null) return "";
        // escapado mínimo: si contiene coma o comillas, envolver en comillas y duplicar comillas
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }

    private static String unescapeCsv(String s) {
        if (s == null) return "";
        s = s.trim();
        if (s.startsWith("\"") && s.endsWith("\"")) {
            s = s.substring(1, s.length() - 1).replace("\"\"", "\"");
        }
        return s;
    }

    private static String[] parseCsvLineSimple(String line) {
        // parser mínimo para 3 columnas, con posibilidad de nombre entre comillas
        List<String> cols = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    cur.append('"'); // comilla escapada
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (ch == ',' && !inQuotes) {
                cols.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        cols.add(cur.toString());
        return cols.toArray(new String[0]);
    }

    /**
     * Reto 92: MiniBD con RandomAccessFile (registros fijos)
     * - Inserta (append) nuevos registros al final
     * - Permite "buscar por id" recorriendo registros
     */
    private static void reto92_miniBD_randomAccessFile() {
        Path archivo = RAF_REGISTROS; // reutilizamos el de registros fijos

        try (RandomAccessFile raf = new RandomAccessFile(archivo.toFile(), "rw")) {
            long registrosExistentes = raf.length() / REG_BYTES;
            log("Reto92: registros existentes=" + registrosExistentes);

            // Insertar 2 más al final (append)
            Cuenta c1 = new Cuenta(100, "Nueva1", 10.0, true);
            Cuenta c2 = new Cuenta(101, "Nueva2", 20.0, false);

            writeCuentaAt(raf, (int) registrosExistentes, c1);
            writeCuentaAt(raf, (int) registrosExistentes + 1, c2);

            log("Reto92: insertados 2 al final. Total ahora=" + (raf.length() / REG_BYTES));

            // Buscar por id (recorriendo)
            int buscarId = 4;
            Cuenta encontrada = buscarCuentaPorId(raf, buscarId);
            log("Reto92: buscar id=" + buscarId + " -> " + encontrada);

        } catch (IOException e) {
            throw new RuntimeException("Reto92 error: " + e.getMessage(), e);
        }
    }

    private static Cuenta buscarCuentaPorId(RandomAccessFile raf, int id) throws IOException {
        long total = raf.length() / REG_BYTES;
        for (int i = 0; i < total; i++) {
            Cuenta c = readCuentaAt(raf, i);
            if (c.id == id) return c;
        }
        return null;
    }

    /**
     * Reto 93: Migración de serialización .ser -> JSON
     * - Lee persona serializada (si existe)
     * - La guarda a JSON manual
     */
    private static void reto93_migracion_ser_a_json() {
        if (!Files.exists(SER_PERSONAS)) {
            log("Reto93: no existe " + SER_PERSONAS + " (primero ejecuta ej50).");
            return;
        }

        Persona p;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SER_PERSONAS.toFile()))) {
            p = (Persona) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Reto93 leer .ser error: " + e.getMessage(), e);
        }

        String json = "{\n"
                + "  \"id\": " + p.id + ",\n"
                + "  \"nombre\": " + quoteJson(p.nombre) + ",\n"
                + "  \"edad\": " + p.edad + "\n"
                + "}\n";

        try {
            Files.writeString(JSON_PERSONA, json, UTF8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            log("Reto93 OK: migrado " + p + " -> " + JSON_PERSONA.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Reto93 escribir JSON error: " + e.getMessage(), e);
        }
    }

    // ============================================================
    // MODELOS
    // ============================================================

    private static class Cuenta {
        final int id;
        final String nombre;
        final double saldo;
        final boolean activo;

        Cuenta(int id, String nombre, double saldo, boolean activo) {
            this.id = id;
            this.nombre = nombre;
            this.saldo = saldo;
            this.activo = activo;
        }

        @Override
        public String toString() {
            return "Cuenta{id=" + id + ", nombre='" + nombre + "', saldo=" + saldo + ", activo=" + activo + "}";
        }
    }

    private static class Persona implements Serializable {
        private static final long serialVersionUID = 1L;

        final int id;
        final String nombre;
        final int edad;

        Persona(int id, String nombre, int edad) {
            this.id = id;
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public String toString() {
            return "Persona{id=" + id + ", nombre='" + nombre + "', edad=" + edad + "}";
        }
    }
}
