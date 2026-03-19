package com.calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    // ── Soma ──────────────────────────────────────────────
    @Test
    void testSomarPositivos() {
        assertEquals(10.0, calc.somar(3, 7));
    }

    @Test
    void testSomarNegativos() {
        assertEquals(-5.0, calc.somar(-3, -2));
    }

    @Test
    void testSomarComZero() {
        assertEquals(42.0, calc.somar(42, 0));
    }

    // ── Subtração ─────────────────────────────────────────
    @Test
    void testSubtrairPositivos() {
        assertEquals(3.0, calc.subtrair(10, 7));
    }

    @Test
    void testSubtrairResultadoNegativo() {
        assertEquals(-4.0, calc.subtrair(1, 5));
    }

    // ── Multiplicação ─────────────────────────────────────
    @Test
    void testMultiplicarPositivos() {
        assertEquals(20.0, calc.multiplicar(4, 5));
    }

    @Test
    void testMultiplicarPorZero() {
        assertEquals(0.0, calc.multiplicar(999, 0));
    }

    @Test
    void testMultiplicarNegativos() {
        assertEquals(6.0, calc.multiplicar(-2, -3));
    }

    // ── Divisão ───────────────────────────────────────────
    @Test
    void testDividirExato() {
        assertEquals(4.0, calc.dividir(20, 5));
    }

    @Test
    void testDividirFracionado() {
        assertEquals(2.5, calc.dividir(5, 2));
    }

    @Test
    void testDividirPorZeroLancaExcecao() {
        assertThrows(ArithmeticException.class, () -> calc.dividir(10, 0));
    }

    // ── Limite de 8 dígitos ───────────────────────────────
    @Test
    void testResultadoAcimaDoLimiteLancaExcecao() {
        assertThrows(ArithmeticException.class, () -> calc.somar(99999999, 1));
    }

    @Test
    void testResultadoNoLimiteMaximo() {
        assertDoesNotThrow(() -> calc.somar(99999998, 1));
    }

    @Test
    void testFormatarInteiroSemDecimais() {
        assertEquals("42", calc.formatar(42.0));
    }
}
