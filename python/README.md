# Python: Pytest y PyHamcrest

Este módulo utiliza Pytest para ejecutar las pruebas y PyHamcrest para escribir
aserciones expresivas sobre valores, colecciones, objetos, textos y excepciones.

## Preparación en Windows PowerShell

```powershell
py -m venv .venv
& ".\.venv\Scripts\python.exe" -m pip install -r requirements.txt
```

## Ejecutar

Toda la suite:

```powershell
& ".\.venv\Scripts\python.exe" -m pytest -v
```

Solo la calculadora:

```powershell
& ".\.venv\Scripts\python.exe" -m pytest tests/test_calculadora.py -v
```

Solo los pedidos:

```powershell
& ".\.venv\Scripts\python.exe" -m pytest tests/test_pedido.py -v
```

Una prueba individual:

```powershell
& ".\.venv\Scripts\python.exe" -m pytest "tests/test_pedido.py::test_total_aplica_el_descuento" -v
```

Listar las pruebas disponibles:

```powershell
& ".\.venv\Scripts\python.exe" -m pytest --collect-only -q
```

## Ejemplo

```python
assert_that(
    total,
    close_to(90, 0.001),
    "total después del descuento",
)
```

La prueba incluye el valor real, el matcher que describe lo esperado y un
mensaje que proporciona contexto si la verificación falla.
