package com.calculadora;

/**
 * Calculadora simples de 8 dígitos.
 * Suporta operações básicas: soma, subtração, multiplicação e divisão.
 */
public class Calculadora {

    private static final int MAX_DIGITOS = 8;
    private static final double MAX_VALOR = 99999999.0;
    private static final double MIN_VALOR = -9999999.0;

    /**
     * Valida se o número está dentro do limite de 8 dígitos.
     */
    private void validar(double valor) {
        if (valor > MAX_VALOR || valor < MIN_VALOR) {
            throw new ArithmeticException("Erro: Resultado excede o limite de " + MAX_DIGITOS + " dígitos.");
        }
    }

    /**
     * Formata o resultado para no máximo 8 dígitos.
     */
    public String formatar(double valor) {
        validar(valor);
        if (valor == (long) valor) {
            String intStr = String.valueOf((long) valor);
            if (intStr.replace("-", "").length() > MAX_DIGITOS) {
                throw new ArithmeticException("Erro: Resultado excede o limite de " + MAX_DIGITOS + " dígitos.");
            }
            return intStr;
        } else {
            String formatado = String.format("%.8g", valor);
            return formatado;
        }
    }

    /**
     * Soma dois números.
     */
    public double somar(double a, double b) {
        double resultado = a + b;
        validar(resultado);
        return resultado;
    }

    /**
     * Subtrai dois números.
     */
    public double subtrair(double a, double b) {
        double resultado = a - b;
        validar(resultado);
        return resultado;
    }

    /**
     * Multiplica dois números.
     */
    public double multiplicar(double a, double b) {
        double resultado = a * b;
        validar(resultado);
        return resultado;
    }

    /**
     * Divide dois números.
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Erro: Divisão por zero não é permitida.");
        }
        double resultado = a / b;
        validar(resultado);
        return resultado;
    }
}
