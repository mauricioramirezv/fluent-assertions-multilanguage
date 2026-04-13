const { expect } = require('chai');
const {
  sumar,
  restar,
  multiplicar,
  dividir,
  modulo,
  potencia,
} = require('../src/calculadora');

describe('Calculadora', () => {
  it('suma dos números', () => {
    expect(sumar(2, 3)).to.equal(5);
  });

  it('resta correctamente', () => {
    expect(restar(10, 4)).to.equal(6);
  });

  it('multiplica correctamente', () => {
    expect(multiplicar(4, 5)).to.equal(20);
  });

  it('divide correctamente', () => {
    expect(dividir(20, 4)).to.equal(5);
  });

  it('lanza error al dividir por cero', () => {
    expect(() => dividir(10, 0)).to.throw();
  });

  it('calcula módulo', () => {
    expect(modulo(10, 3)).to.equal(1);
  });

  it('lanza error en módulo con cero', () => {
    expect(() => modulo(10, 0)).to.throw();
  });

  it('calcula potencia', () => {
    expect(potencia(2, 3)).to.equal(8);
  });
});
