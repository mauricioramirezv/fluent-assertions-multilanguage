# Java: JUnit 5 y AssertJ

Este módulo utiliza JUnit 5 para ejecutar las pruebas y AssertJ para escribir
aserciones fluidas sobre valores, colecciones, objetos, textos y excepciones.

## Requisitos

- JDK 17.
- Maven 3.8 o superior.

## Ejecutar

Toda la suite:

```powershell
mvn test
```

Solo las pruebas de la calculadora:

```powershell
mvn -Dtest=CalculadoraTest test
```

Solo las pruebas de pedidos:

```powershell
mvn -Dtest=PedidoTest test
```

Una prueba individual en PowerShell:

```powershell
mvn "-Dtest=PedidoTest#total_deberiaAplicarElDescuento" test
```

## Ejemplo

```java
assertThat(total)
    .as("total después del descuento")
    .isCloseTo(90.0, within(0.001));
```

AssertJ permite encadenar condiciones y utilizar `.as(...)` para explicar el
contexto de la verificación cuando la prueba falla.
