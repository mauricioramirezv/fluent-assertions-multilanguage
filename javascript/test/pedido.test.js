const { expect } = require('chai');
const { Pedido } = require('../src/pedido');

describe('Pedido con aserciones fluidas', () => {
  it('conserva el orden de los productos', () => {
    // Arrange
    const pedido = new Pedido(
      'Ana',
      ['Libro', 'Cuaderno', 'Lápiz'],
      100,
      10,
    );

    // Act
    const productos = pedido.productos;

    // Assert: colección fluida
    expect(productos, 'productos del pedido de Ana')
      .to.deep.equal(['Libro', 'Cuaderno', 'Lápiz'])
      .and.not.include('Borrador');
  });

  it('expone sus propiedades', () => {
    // Arrange
    const pedido = new Pedido('Luis', ['Teclado'], 200, 5);

    // Act & Assert: propiedades del objeto
    expect(pedido).to.include({
      cliente: 'Luis',
      subtotal: 200,
      descuento: 5,
    });
  });

  it('aplica el descuento al total', () => {
    // Arrange
    const pedido = new Pedido('Sara', ['Monitor'], 100, 10);

    // Act
    const total = pedido.calcularTotal();

    // Assert: comparación numérica con tolerancia
    expect(total, 'total después del descuento').to.be.closeTo(90, 0.001);
  });

  it('genera un resumen legible', () => {
    // Arrange
    const pedido = new Pedido('Mario', ['Mouse', 'Base'], 80);

    // Act
    const resumen = pedido.generarResumen();

    // Assert: texto fluido
    expect(resumen)
      .to.match(/^Pedido de Mario/)
      .and.include('2 producto(s)')
      .and.not.include('undefined');
  });

  it('explica el error cuando el descuento es inválido', () => {
    // Act & Assert: tipo y mensaje de la excepción
    expect(() => new Pedido('Laura', ['Agenda'], 50, 110))
      .to.throw(Error, 'El descuento debe estar entre 0 y 100');
  });
});
