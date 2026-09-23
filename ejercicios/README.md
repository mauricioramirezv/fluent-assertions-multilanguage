# Ejercicios de aserciones fluidas

Seleccione uno de los tres lenguajes y confirme primero que toda su suite pasa.
No es necesario resolver la práctica en los tres lenguajes.

## Ejercicio 1. De aserción básica a aserción expresiva

Localice una prueba de la calculadora y agregue una descripción que explique el
propósito de la verificación cuando esta falle.

- Java: utilice `.as("...")`.
- Python: utilice el tercer argumento de `assert_that`.
- JavaScript: utilice el segundo argumento de `expect`.

Cambie temporalmente el valor esperado, ejecute solo esa prueba y compare el
mensaje obtenido antes y después. Restaure el valor correcto al finalizar.

## Ejercicio 2. Verificar una colección

Agregue al pedido los productos `Monitor`, `Teclado` y `Mouse`. Escriba una
aserción que compruebe simultáneamente:

1. que los tres productos están presentes;
2. que conservan el orden de ingreso;
3. que `Impresora` no está presente.

## Ejercicio 3. Verificar un objeto

Cree un pedido para la cliente `Elena`, con subtotal `250` y descuento `20`.
Verifique sus propiedades sin escribir una aserción separada para cada valor.

## Ejercicio 4. Valores numéricos y tolerancia

Agregue un caso con subtotal `99.90` y descuento `15`. Compruebe el total
utilizando una tolerancia de `0.001` en lugar de igualdad exacta.

Explique por qué una tolerancia puede ser adecuada al comparar números
decimales.

## Ejercicio 5. Excepciones expresivas

Escriba una prueba para crear un pedido con subtotal negativo. La aserción debe
verificar tanto el tipo de excepción como el mensaje:

```text
El subtotal no puede ser negativo
```

## Cierre

Después de cada ejercicio:

1. ejecute primero la prueba modificada;
2. ejecute luego la suite completa del lenguaje elegido;
3. confirme que el mensaje de error explica qué se esperaba y qué se obtuvo;
4. revise que la prueba mantenga las secciones Arrange, Act y Assert.

No incluya en el commit final los cambios temporales utilizados para provocar
fallos.
