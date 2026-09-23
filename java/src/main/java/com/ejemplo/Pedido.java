package com.ejemplo;

import java.util.List;

public class Pedido {

    private final String cliente;
    private final List<String> productos;
    private final double subtotal;
    private final double descuento;

    public Pedido(String cliente, List<String> productos, double subtotal, double descuento) {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("El cliente es obligatorio");
        }
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener productos");
        }
        if (subtotal < 0) {
            throw new IllegalArgumentException("El subtotal no puede ser negativo");
        }
        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
        }

        this.cliente = cliente;
        this.productos = List.copyOf(productos);
        this.subtotal = subtotal;
        this.descuento = descuento;
    }

    public String getCliente() {
        return cliente;
    }

    public List<String> getProductos() {
        return productos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public double calcularTotal() {
        return subtotal * (1 - descuento / 100);
    }

    public String generarResumen() {
        return "Pedido de " + cliente + ": " + productos.size() + " producto(s)";
    }
}
