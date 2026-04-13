package com.ejemplo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void sumar_con2y3_deberiaRetornar5() {
        //Arrange
        int a=2;
        int b=3;
        //Act
        int resultado = calculadora.sumar(a, b);
        //Assert
        assertThat(resultado).isEqualTo(5);
    }

    @Test
    void sumar_con3y4_deberiaRetornar7() {
        //Arrange
        int a=3;
        int b=4;
        //Act
        int resultado = calculadora.sumar(a, b);
        //Assert
        assertThat(resultado).isEqualTo(7);
    }

    @Test
    void restar_con3y2_deberiaRetornar1() {
        //Arrange
        int a=3;
        int b=2;
        //Act
        int resultado = calculadora.restar(a, b);
        //Assert
        assertThat(resultado).isEqualTo(1);
    }

    @Test
    void restar_con10y5_deberiaRetornar5() {
        //Arrange
        int a=10;
        int b=5;
        //Act
        int resultado = calculadora.restar(a, b);
        //Assert
        assertThat(resultado).isEqualTo(5);
    }

    @Test
    void multiplicar_con2y3_deberiaRetornar6() {
        //Arrange
        int a=2;
        int b=3;
        //Act
        int resultado = calculadora.multiplicar(a, b);
        //Assert
        assertThat(resultado).isEqualTo(6);
    }

    @Test
    void multiplicar_con6y2_deberiaRetornar12() {
        //Arrange
        int a=6;
        int b=2;
        //Act
        int resultado = calculadora.multiplicar(a, b);
        //Assert
        assertThat(resultado).isEqualTo(12);
    }

    @Test
    void dividir_con6y3_deberiaRetornar2() {
        //Arrange
        int a=6;
        int b=3;
        //Act
        int resultado = calculadora.dividir(a, b);
        //Assert
        assertThat(resultado).isEqualTo(2);
    }

    @Test
    void dividir_con8y2_deberiaRetornar4() {
        //Arrange
        int a=8;
        int b=2;
        //Act
        int resultado = calculadora.dividir(a, b);
        //Assert
        assertThat(resultado).isEqualTo(4);
    }

    @Test
    void dividir_con10y0_deberiaLanzarExcepcion() {
        //Arrange
        int a=10;
        int b=0;
        //Act & Assert
        assertThatThrownBy(() -> calculadora.dividir(a, b))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("No se puede dividir entre cero");
    }
}
