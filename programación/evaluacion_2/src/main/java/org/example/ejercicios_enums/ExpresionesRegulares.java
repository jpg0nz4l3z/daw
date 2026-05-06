package org.example.ejercicios_enums;

public class ExpresionesRegulares {
    /*

    ============================================================
MEGA ARCHIVO DE EJEMPLOS DE EXPRESIONES REGULARES (REGEX)
============================================================

------------------------------------------------------------
1. BÁSICOS
------------------------------------------------------------

a
Coincide con la letra "a"

abc
Coincide exactamente con "abc"

.
Cualquier carácter excepto salto de línea

\.
Un punto literal

\d
Un dígito (0-9)

\D
No dígito

\w
Letra, número o guión bajo

\W
No alfanumérico

\s
Espacio en blanco

\S
No espacio

\t
Tabulador

\n
Salto de línea

\r
Retorno de carro


------------------------------------------------------------
2. CUANTIFICADORES
------------------------------------------------------------

a*
0 o más "a"

a+
1 o más "a"

a?
0 o 1 "a"

a{3}
Exactamente 3 "a"

a{2,5}
Entre 2 y 5 "a"

a{2,}
2 o más "a"

.*
Cualquier cosa (greedy)

.*?
Cualquier cosa (lazy)


------------------------------------------------------------
3. ANCLAS
------------------------------------------------------------

^abc
Empieza con "abc"

abc$
Termina con "abc"

^abc$
Exactamente "abc"

\bword\b
Palabra exacta

\Bword\B
No límite de palabra


------------------------------------------------------------
4. CLASES DE CARACTERES
------------------------------------------------------------

[abc]
a, b o c

[a-z]
Minúsculas

[A-Z]
Mayúsculas

[0-9]
Dígitos

[a-zA-Z0-9]
Alfanumérico

[^abc]
Cualquier cosa excepto a, b o c

[^0-9]
No dígito


------------------------------------------------------------
5. GRUPOS
------------------------------------------------------------

(abc)
Grupo capturador

(?:abc)
Grupo no capturador

(a|b)
a o b

(abc)+
Una o más veces el grupo abc

(\d{3})-(\d{2})
Captura 2 grupos numéricos


------------------------------------------------------------
6. LOOKAHEAD / LOOKBEHIND
------------------------------------------------------------

\d(?=€)
Número seguido de €

\d(?!€)
Número NO seguido de €

(?<=\$)\d+
Número precedido por $

(?<!\$)\d+
Número NO precedido por $


------------------------------------------------------------
7. VALIDACIONES COMUNES
------------------------------------------------------------

Email simple:
^[\w.-]+@[\w.-]+\.\w+$

Email más estricto:
^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$

URL:
^https?:\/\/[\w.-]+\.[a-z]{2,}.*$

IPv4:
^(\d{1,3}\.){3}\d{1,3}$

Número entero:
^-?\d+$

Número decimal:
^-?\d+(\.\d+)?$

Contraseña (mín 8 chars, 1 mayúscula, 1 número):
^(?=.*[A-Z])(?=.*\d).{8,}$

Solo letras:
^[A-Za-z]+$

Solo números:
^\d+$

Código postal (5 dígitos):
^\d{5}$

DNI español (básico):
^\d{8}[A-Za-z]$

Teléfono (9 dígitos):
^\d{9}$


------------------------------------------------------------
8. EJEMPLOS AVANZADOS
------------------------------------------------------------

Eliminar espacios al inicio y final:
^\s+|\s+$

Repeticiones consecutivas:
(.)\1+

HTML tag:
<([A-Za-z][A-Za-z0-9]*)\b[^>]*>(.*?)</\1>

Extraer números:
\d+

Fechas (dd/mm/yyyy):
^\d{2}\/\d{2}\/\d{4}$

Hora (HH:MM 24h):
^([01]\d|2[0-3]):([0-5]\d)$

Hexadecimal:
^#?([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$

UUID:
^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$

Eliminar comentarios JS:
\/\/.*$

Eliminar comentarios multilínea:
\/\*[\s\S]*?\*\/

Extraer texto entre comillas:
"([^"]*)"

Extraer etiquetas HTML:
<\/?[a-z][\s\S]*?>

Duplicados consecutivos de palabra:
\b(\w+)\s+\1\b


------------------------------------------------------------
9. MODIFICADORES (FLAGS)
------------------------------------------------------------

/abc/i
Ignore case

/abc/g
Global

/abc/m
Multiline

/abc/s
Dot incluye salto de línea

/abc/u
Unicode


------------------------------------------------------------
10. REEMPLAZO (BACKREFERENCES)
------------------------------------------------------------

(\w+), (\w+)
Reemplazo:
$2 $1

Ejemplo:
"Gonzalez, Juan"
→ "Juan Gonzalez"


------------------------------------------------------------
11. EJEMPLOS PARA PROGRAMACIÓN
------------------------------------------------------------

JavaScript variable válida:
^[a-zA-Z_$][a-zA-Z0-9_$]*$

Slug:
^[a-z0-9]+(?:-[a-z0-9]+)*$

JSON string simple:
^".*"$

Número binario:
^[01]+$

Número octal:
^[0-7]+$

Número hexadecimal:
^[0-9A-Fa-f]+$


------------------------------------------------------------
12. COMBINACIONES COMPLEJAS
------------------------------------------------------------

Contraseña fuerte:
^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{8,}$

No espacios dobles:
^(?!.*\s{2}).*$

No empezar con número:
^[^\d].*$

Texto entre paréntesis:
\(([^)]*)\)

Eliminar líneas vacías:
^\s*$

Buscar palabras repetidas en texto:
\b(\w+)\b(?=.*\b\1\b)


============================================================
FIN DEL ARCHIVO
============================================================


     */
}
