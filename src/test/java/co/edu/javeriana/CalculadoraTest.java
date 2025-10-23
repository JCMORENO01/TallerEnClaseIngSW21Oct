package co.edu.javeriana;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para la clase Calculadora
 */
@DisplayName("Tests de Calculadora")
public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }
    // Changes

    // ----------------- Tests existentes -----------------

    @Test
    @DisplayName("Test suma de números positivos")
    public void testSumarPositivos() {
        assertEquals(5, calculadora.sumar(2, 3),
                "2 + 3 debe ser 5");
        assertEquals(100, calculadora.sumar(50, 50),
                "50 + 50 debe ser 100");
    }

    @Test
    @DisplayName("Test suma con números negativos")
    public void testSumarNegativos() {
        assertEquals(0, calculadora.sumar(-1, 1),
                "-1 + 1 debe ser 0");
        assertEquals(-5, calculadora.sumar(-2, -3),
                "-2 + (-3) debe ser -5");
    }

    @Test
    @DisplayName("Test suma con cero")
    public void testSumarConCero() {
        assertEquals(5, calculadora.sumar(5, 0),
                "5 + 0 debe ser 5");
        assertEquals(0, calculadora.sumar(0, 0),
                "0 + 0 debe ser 0");
    }

    @Test
    @DisplayName("Test resta de números")
    public void testRestar() {
        assertEquals(2, calculadora.restar(5, 3),
                "5 - 3 debe ser 2");
        assertEquals(-2, calculadora.restar(3, 5),
                "3 - 5 debe ser -2");
        assertEquals(0, calculadora.restar(5, 5),
                "5 - 5 debe ser 0");
    }

    @Test
    @DisplayName("Test multiplicación")
    public void testMultiplicar() {
        assertEquals(12, calculadora.multiplicar(3, 4),
                "3 * 4 debe ser 12");
        assertEquals(0, calculadora.multiplicar(0, 5),
                "0 * 5 debe ser 0");
        assertEquals(-10, calculadora.multiplicar(-2, 5),
                "-2 * 5 debe ser -10");
    }

    @Test
    @DisplayName("Test división normal")
    public void testDividir() {
        assertEquals(2.0, calculadora.dividir(6, 3), 0.001,
                "6 / 3 debe ser 2.0");
        assertEquals(2.5, calculadora.dividir(5, 2), 0.001,
                "5 / 2 debe ser 2.5");
    }

    @Test
    @DisplayName("Test división por cero lanza excepción")
    public void testDividirPorCero() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.dividir(5, 0),
                "Dividir por cero debe lanzar IllegalArgumentException"
        );
        assertTrue(exception.getMessage().contains("cero"),
                "El mensaje debe mencionar 'cero'");
    }

    @Test
    @DisplayName("Test módulo")
    public void testModulo() {
        assertEquals(1, calculadora.modulo(5, 2),
                "5 % 2 debe ser 1");
        assertEquals(0, calculadora.modulo(10, 5),
                "10 % 5 debe ser 0");
    }

    // ----------------- Nuevos tests -----------------

    // Potencia
    @Test
    @DisplayName("Potencia: casos básicos")
    public void testPotenciaBasicos() {
        assertEquals(1L, calculadora.potencia(7, 0), "b^0 debe ser 1");
        assertEquals(1024L, calculadora.potencia(2, 10), "2^10 debe ser 1024");
        assertEquals(-27L, calculadora.potencia(-3, 3), "(-3)^3 debe ser -27");
        assertEquals(16L, calculadora.potencia(-2, 4), "(-2)^4 debe ser 16");
        assertEquals(0L, calculadora.potencia(0, 5), "0^5 debe ser 0");
    }

    @Test
    @DisplayName("Potencia: exponente negativo lanza excepción")
    public void testPotenciaExponenteNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.potencia(2, -1),
                "Exponente negativo debe lanzar IllegalArgumentException");
    }

    // Raíz cuadrada
    @Test
    @DisplayName("Raíz cuadrada: valores válidos")
    public void testRaizCuadradaValida() {
        assertEquals(3.0, calculadora.raizCuadrada(9.0), 1e-9,
                "sqrt(9) debe ser 3");
        assertEquals(Math.sqrt(2.0), calculadora.raizCuadrada(2.0), 1e-12,
                "sqrt(2) debe coincidir con Math.sqrt");
        assertEquals(0.0, calculadora.raizCuadrada(0.0), 1e-12,
                "sqrt(0) debe ser 0");
    }

    @Test
    @DisplayName("Raíz cuadrada: negativo lanza excepción")
    public void testRaizCuadradaNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.raizCuadrada(-0.01),
                "Raíz de negativo debe lanzar IllegalArgumentException");
    }

    // Factorial
    @Test
    @DisplayName("Factorial: valores base y medianos")
    public void testFactorialBasicos() {
        assertEquals(1L, calculadora.factorial(0), "0! debe ser 1");
        assertEquals(1L, calculadora.factorial(1), "1! debe ser 1");
        assertEquals(120L, calculadora.factorial(5), "5! debe ser 120");
        assertEquals(3628800L, calculadora.factorial(10), "10! debe ser 3628800");
    }

    @Test
    @DisplayName("Factorial: negativo lanza excepción")
    public void testFactorialNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> calculadora.factorial(-3),
                "Factorial de negativo debe lanzar IllegalArgumentException");
    }

    @Test
    @DisplayName("Factorial: overflow lanza excepción (p.ej., 21!)")
    public void testFactorialOverflow() {
        assertThrows(ArithmeticException.class,
                () -> calculadora.factorial(21),
                "21! excede long y debe lanzar ArithmeticException");
    }

    // MCD
    @Test
    @DisplayName("MCD: casos típicos")
    public void testMcdBasicos() {
        assertEquals(6, calculadora.mcd(54, 24), "mcd(54,24) debe ser 6");
        assertEquals(5, calculadora.mcd(0, 5), "mcd(0,5) debe ser 5");
        assertEquals(4, calculadora.mcd(-8, 12), "mcd(-8,12) debe ser 4");
    }

    @Test
    @DisplayName("MCD: ambos ceros definido como 0")
    public void testMcdCeros() {
        assertEquals(0, calculadora.mcd(0, 0),
                "mcd(0,0) se define como 0 en esta implementación");
    }
}
