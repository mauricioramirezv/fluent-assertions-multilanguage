# JavaScript: Mocha y Chai

Este módulo utiliza Mocha para ejecutar las pruebas y Chai para escribir
aserciones fluidas sobre valores, colecciones, objetos, textos y excepciones.

## Preparación

```powershell
npm install
```

## Ejecutar

Toda la suite:

```powershell
npm test
```

Solo la calculadora:

```powershell
npm run test:calculadora
```

Solo los pedidos:

```powershell
npm run test:pedido
```

Una prueba individual:

```powershell
npx mocha test/pedido.test.js --grep "aplica el descuento"
```

## Ejemplo

```javascript
expect(total, 'total después del descuento')
  .to.be.closeTo(90, 0.001);
```

Chai permite encadenar expresiones y agregar un mensaje que proporciona
contexto cuando la verificación falla.
