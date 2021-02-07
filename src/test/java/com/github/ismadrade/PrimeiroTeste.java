package com.github.ismadrade;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class PrimeiroTeste {

    Calculadora calculadora;
    @Before
    public void SetUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar2Numeros(){
        //cenário
        int numero1 = 5 , numero2 = 10;

        //execução

        int soma = calculadora.somar(numero1, numero2);

        //verificações
        Assertions.assertThat(soma).isEqualTo(15);
    }
    @Test
    public void deveSubtrair2Numeros(){
        //cenário
        int numero1 = 5 , numero2 = 10;

        //execução

        int subtracao = calculadora.subtrair(numero1, numero2);

        //verificações
        Assertions.assertThat(subtracao).isEqualTo(-5);
    }
    @Test
    public void devemultiplicar2Numeros(){
        //cenário
        int numero1 = 5 , numero2 = 10;

        //execução

        int multiplicacao = calculadora.multiplicar(numero1, numero2);

        //verificações
        Assertions.assertThat(multiplicacao).isEqualTo(50);
    }
    @Test
    public void deveDividir2Numeros(){
        //cenário
        int numero1 = 10 , numero2 = 2;

        //execução

        int divisao = calculadora.dividir(numero1, numero2);

        //verificações
        Assertions.assertThat(divisao).isEqualTo(5);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSomarNumerosNegativos(){
        //cenario
        int num1 = -10, num2 = 5;

        //execução
        calculadora.somar(num1, num2);
    }
    @Test(expected = ArithmeticException.class)
    public void naoDeveDividirPorZero(){
        //cenario
        int num1 = 5, num2 = 0;

        //execução
        calculadora.dividir(num1, num2);
    }

}

class Calculadora{
    int somar(int num1, int num2){
        if(num1 < 0 || num2 < 0)
            throw new RuntimeException("Não é permitido soomar numeros negativos");
        return num1 + num2;
    }
    int subtrair(int num1, int num2){
        return num1 - num2;
    }
    int multiplicar(int num1, int num2){
        return num1 * num2;
    }
    int dividir(int num1, int num2){
        return  num1 / num2;
    }
}
