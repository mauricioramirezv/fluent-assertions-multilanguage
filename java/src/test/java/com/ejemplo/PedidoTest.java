package com.ejemplo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

import java.util.List;
import org.junit.jupiter.api.Test;

class PedidoTest {

    @Test
    void productos_deberianConservarElOrden() {
        // Arrange
        Pedido pedido = new Pedido(
            "Ana",
            List.of("Libro", "Cuaderno", "Lápiz"),
            100.0,
            10.0
        );

        // Act
        List<String> productos = pedido.getProductos();

        // Assert: colección fluida
        assertThat(productos)
            .as("productos del pedido de Ana")
            .containsExactly("Libro", "Cuaderno", "Lápiz")
            .doesNotContain("Borrador");
    }

    @Test
    void pedido_deberiaExponerSusPropiedades() {
        // Arrange
        Pedido pedido = new Pedido("Luis", List.of("Teclado"), 200.0, 5.0);

        // Act & Assert: propiedades del objeto
        assertThat(pedido)
            .extracting("cliente", "subtotal", "descuento")
            .containsExactly("Luis", 200.0, 5.0);
    }

    @Test
    void total_deberiaAplicarElDescuento() {
        // Arrange
        Pedido pedido = new Pedido("Sara", List.of("Monitor"), 100.0, 10.0);

        // Act
        double total = pedido.calcularTotal();

        // Assert: comparación numérica con tolerancia
        assertThat(total)
            .as("total después del descuento")
            .isCloseTo(90.0, within(0.001));
    }

    @Test
    void resumen_deberiaSerLegible() {
        // Arrange
        Pedido pedido = new Pedido("Mario", List.of("Mouse", "Base"), 80.0, 0.0);

        // Act
        String resumen = pedido.generarResumen();

        // Assert: texto fluido
        assertThat(resumen)
            .startsWith("Pedido de Mario")
            .contains("2 producto(s)")
            .doesNotContain("null");
    }

    @Test
    void descuentoInvalido_deberiaExplicarElProblema() {
        // Act & Assert: excepción, tipo y mensaje
        assertThatThrownBy(
            () -> new Pedido("Laura", List.of("Agenda"), 50.0, 110.0)
        )
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("El descuento debe estar entre 0 y 100");
    }
}
