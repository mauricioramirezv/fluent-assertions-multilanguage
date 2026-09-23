# Aserciones fluidas en Java, Python y JavaScript

Repositorio educativo para comparar aserciones expresivas en tres lenguajes.
Los ejemplos utilizan el mismo dominio de calculadora y pedidos, lo que permite
concentrarse en la forma de expresar las verificaciones y en la calidad de los
mensajes cuando una prueba falla.

## Objetivos de aprendizaje

Al finalizar la práctica, el estudiante podrá:

- diferenciar una aserción básica de una aserción fluida;
- comprobar valores, textos, colecciones, objetos y excepciones;
- agregar descripciones que faciliten el diagnóstico de un fallo;
- organizar las pruebas mediante Arrange, Act y Assert;
- ejecutar una suite, un archivo o una prueba individual;
- reconocer equivalencias entre AssertJ, PyHamcrest y Chai.

## Tecnologías

| Lenguaje | Framework de pruebas | Biblioteca de aserciones |
|---|---|---|
| Java 17 | JUnit 5 | AssertJ |
| Python 3.10 o superior | Pytest | PyHamcrest |
| JavaScript con Node.js | Mocha | Chai |

En este repositorio, *aserción fluida* se refiere a una verificación que se lee
de forma cercana al lenguaje natural, permite encadenar condiciones y produce
un mensaje útil cuando no se cumple lo esperado.

## Estructura

```text
fluent-assertions-multilanguage/
├── java/
│   ├── pom.xml
│   └── src/
├── python/
│   ├── app/
│   ├── tests/
│   └── requirements.txt
├── javascript/
│   ├── src/
│   ├── test/
│   └── package.json
└── ejercicios/
    └── README.md
```

No es necesario desarrollar la práctica en los tres lenguajes. El docente
puede presentar la comparación general y cada estudiante puede elegir uno.

## Equivalencias básicas

| Propósito | Java con AssertJ | Python con PyHamcrest | JavaScript con Chai |
|---|---|---|---|
| Igualdad | `assertThat(x).isEqualTo(y)` | `assert_that(x, equal_to(y))` | `expect(x).to.equal(y)` |
| Texto contenido | `.contains("texto")` | `contains_string("texto")` | `.include("texto")` |
| Orden de colección | `.containsExactly(...)` | `contains(...)` | `.deep.equal([...])` |
| Aproximación | `.isCloseTo(x, within(t))` | `close_to(x, t)` | `.closeTo(x, t)` |
| Excepción | `assertThatThrownBy(...)` | `calling(...), raises(...)` | `expect(...).to.throw(...)` |

## Opción 1. Ejecutar Java

Requisitos: JDK 17 y Maven.

```powershell
cd java
mvn test
```

Ejecutar solamente las pruebas de pedidos:

```powershell
mvn -Dtest=PedidoTest test
```

Ejecutar una prueba individual:

```powershell
mvn "-Dtest=PedidoTest#total_deberiaAplicarElDescuento" test
```

Consulte [`java/README.md`](java/README.md) para obtener más información.

## Opción 2. Ejecutar Python

Desde la raíz del repositorio:

```powershell
cd python
py -m venv .venv
& ".\.venv\Scripts\python.exe" -m pip install -r requirements.txt
& ".\.venv\Scripts\python.exe" -m pytest -v
```

Ejecutar solamente las pruebas de pedidos:

```powershell
& ".\.venv\Scripts\python.exe" -m pytest tests/test_pedido.py -v
```

Ejecutar una prueba individual:

```powershell
& ".\.venv\Scripts\python.exe" -m pytest "tests/test_pedido.py::test_total_aplica_el_descuento" -v
```

Consulte [`python/README.md`](python/README.md) para obtener más información.

## Opción 3. Ejecutar JavaScript

Requisitos: Node.js y npm.

```powershell
cd javascript
npm install
npm test
```

Ejecutar solamente las pruebas de pedidos:

```powershell
npm run test:pedido
```

Ejecutar una prueba individual:

```powershell
npx mocha test/pedido.test.js --grep "aplica el descuento"
```

Consulte [`javascript/README.md`](javascript/README.md) para obtener más
información.

## Tipos de aserciones incluidos

Los ejemplos muestran cómo verificar:

1. resultados exactos de operaciones;
2. contenido y orden de colecciones;
3. propiedades de un objeto;
4. números decimales con una tolerancia;
5. contenido y estructura de textos;
6. tipo y mensaje de una excepción;
7. condiciones encadenadas y descripciones personalizadas.

## Ruta sugerida para la clase

1. Ejecutar la suite del lenguaje seleccionado y establecer una línea base.
2. Comparar una aserción básica con una aserción fluida.
3. Cambiar temporalmente un valor esperado y analizar el mensaje de error.
4. Revisar ejemplos de valores, colecciones, objetos y excepciones.
5. Ejecutar una prueba individual.
6. Resolver la guía de [`ejercicios/README.md`](ejercicios/README.md).
7. Restaurar los cambios temporales y ejecutar nuevamente toda la suite.

## Resultado esperado

Todas las suites deben finalizar correctamente antes y después de cada cambio
válido. Los fallos provocados durante la práctica deben ser temporales y no
deben incluirse en el commit final.

Una buena aserción no solo indica que una prueba falló: también comunica qué se
estaba verificando, qué resultado se esperaba y qué valor se obtuvo.
