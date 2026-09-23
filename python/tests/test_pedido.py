from hamcrest import (
    assert_that,
    calling,
    close_to,
    contains_exactly,
    contains_string,
    equal_to,
    has_properties,
    is_not,
    raises,
    starts_with,
)

from app.pedido import Pedido


def test_productos_conservan_el_orden():
    # Arrange
    pedido = Pedido("Ana", ("Libro", "Cuaderno", "Lápiz"), 100, 10)

    # Act
    productos = pedido.productos

    # Assert: colección expresiva
    assert_that(productos, contains_exactly("Libro", "Cuaderno", "Lápiz"))


def test_pedido_expone_sus_propiedades():
    # Arrange
    pedido = Pedido("Luis", ("Teclado",), 200, 5)

    # Act & Assert: propiedades del objeto
    assert_that(
        pedido,
        has_properties(cliente="Luis", subtotal=200, descuento=5),
    )


def test_total_aplica_el_descuento():
    # Arrange
    pedido = Pedido("Sara", ("Monitor",), 100, 10)

    # Act
    total = pedido.calcular_total()

    # Assert: comparación numérica con tolerancia
    assert_that(total, close_to(90, 0.001), "total después del descuento")


def test_resumen_es_legible():
    # Arrange
    pedido = Pedido("Mario", ("Mouse", "Base",), 80)

    # Act
    resumen = pedido.generar_resumen()

    # Assert: texto expresivo
    assert_that(resumen, starts_with("Pedido de Mario"))
    assert_that(resumen, contains_string("2 producto(s)"))
    assert_that(resumen, is_not(contains_string("None")))


def test_descuento_invalido_explica_el_problema():
    # Arrange
    crear_pedido = calling(Pedido).with_args(
        "Laura", ("Agenda",), 50, 110
    )

    # Act & Assert: tipo y mensaje de la excepción
    assert_that(
        crear_pedido,
        raises(ValueError, pattern="El descuento debe estar entre 0 y 100"),
    )


def test_total_sin_descuento_es_igual_al_subtotal():
    # Arrange
    pedido = Pedido("Carlos", ("Cable",), 25)

    # Act
    total = pedido.calcular_total()

    # Assert
    assert_that(total, equal_to(25))
