function sumar(a, b) {
  return a + b;
}

function restar(a, b) {
  return a - b;
}

function multiplicar(a, b) {
  return a * b;
}

function dividir(a, b) {
  if (b === 0) {
    throw new Error('No se puede dividir entre cero');
  }
  return a / b;
}

function modulo(a, b) {
  if (b === 0) {
    throw new Error('No se puede calcular el módulo con divisor cero');
  }
  return a % b;
}

function potencia(a, b) {
  return a ** b;
}

module.exports = {
  sumar,
  restar,
  multiplicar,
  dividir,
  modulo,
  potencia,
};
