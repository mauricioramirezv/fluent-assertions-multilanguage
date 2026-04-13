from hamcrest import assert_that, equal_to
import pytest

from app.calculadora import (
    sumar, restar, multiplicar, dividir, modulo, potencia
)

def test_sumar():
    assert_that(sumar(2, 3), equal_to(5))

def test_restar():
    assert_that(restar(10, 4), equal_to(6))

def test_multiplicar():
    assert_that(multiplicar(4, 5), equal_to(20))

def test_dividir():
    assert_that(dividir(20, 4), equal_to(5))

def test_dividir_por_cero():
    with pytest.raises(ValueError):
        dividir(10, 0)

def test_modulo():
    assert_that(modulo(10, 3), equal_to(1))

def test_modulo_por_cero():
    with pytest.raises(ValueError):
        modulo(10, 0)

def test_potencia():
    assert_that(potencia(2, 3), equal_to(8))
