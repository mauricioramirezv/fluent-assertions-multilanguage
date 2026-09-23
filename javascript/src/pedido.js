class Pedido {
  constructor(cliente, productos, subtotal, descuento = 0) {
    if (!cliente || !cliente.trim()) {
      throw new Error('El cliente es obligatorio');
    }
    if (!Array.isArray(productos) || productos.length === 0) {
      throw new Error('El pedido debe tener productos');
    }
    if (subtotal < 0) {
      throw new Error('El subtotal no puede ser negativo');
    }
    if (descuento < 0 || descuento > 100) {
      throw new Error('El descuento debe estar entre 0 y 100');
    }

    this.cliente = cliente;
    this.productos = [...productos];
    this.subtotal = subtotal;
    this.descuento = descuento;
  }

  calcularTotal() {
    return this.subtotal * (1 - this.descuento / 100);
  }

  generarResumen() {
    return `Pedido de ${this.cliente}: ${this.productos.length} producto(s)`;
  }
}

module.exports = { Pedido };
