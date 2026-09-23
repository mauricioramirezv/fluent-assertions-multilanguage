from dataclasses import dataclass


@dataclass(frozen=True)
class Pedido:
    cliente: str
    productos: tuple[str, ...]
    subtotal: float
    descuento: float = 0

    def __post_init__(self) -> None:
        if not self.cliente.strip():
            raise ValueError("El cliente es obligatorio")
        if not self.productos:
            raise ValueError("El pedido debe tener productos")
        if self.subtotal < 0:
            raise ValueError("El subtotal no puede ser negativo")
        if not 0 <= self.descuento <= 100:
            raise ValueError("El descuento debe estar entre 0 y 100")

    def calcular_total(self) -> float:
        return self.subtotal * (1 - self.descuento / 100)

    def generar_resumen(self) -> str:
        return f"Pedido de {self.cliente}: {len(self.productos)} producto(s)"
