package co.edu.javeriana;

/**
 * Clase simple de calculadora para demostrar CI/CD
 * Métodos: suma, resta, multiplicación, división, módulo, potencia, raíz cuadrada, factorial, MCD.
 * @author Tu Nombre
 */
public class Calculadora {

    /**
     * Suma dos números enteros
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números enteros
     * @throws IllegalArgumentException si b es cero
     */
    public double dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return (double) a / b;
    }

    /**
     * Calcula el módulo de dos números
     * @throws IllegalArgumentException si b es cero
     */
    public int modulo(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede calcular módulo con divisor cero");
        }
        return a % b;
    }

    // ------------------ NUEVOS MÉTODOS ------------------

    /**
     * Potencia entera: base^exponente para exponente >= 0.
     * Usa exponenciación rápida (O(log n)).
     * @throws IllegalArgumentException si exponente < 0
     */
    public long potencia(int base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente debe ser no negativo");
        }
        long resultado = 1;
        long b = base;
        int e = exponente;
        while (e > 0) {
            if ((e & 1) == 1) {
                resultado *= b;
            }
            b *= b;
            e >>= 1;
        }
        return resultado;
    }

    /**
     * Raíz cuadrada para x >= 0.
     * @return Math.sqrt(x)
     * @throws IllegalArgumentException si x < 0
     */
    public double raizCuadrada(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("No existe raíz real de números negativos");
        }
        return Math.sqrt(x);
    }

    /**
     * Factorial de n (n!) para n >= 0 usando long.
     * Lanza ArithmeticException si hay overflow de long.
     * @throws IllegalArgumentException si n < 0
     * @throws ArithmeticException si el resultado excede Long.MAX_VALUE
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para negativos");
        }
        long res = 1L;
        for (int i = 2; i <= n; i++) {
            // Verificación de overflow: res * i > Long.MAX_VALUE
            if (res > Long.MAX_VALUE / i) {
                throw new ArithmeticException("Overflow de long en factorial(" + n + ")");
            }
            res *= i;
        }
        return res;
    }

    /**
     * Máximo Común Divisor (MCD) usando el algoritmo de Euclides.
     * Define MCD(0,0) = 0 por conveniencia.
     */
    public int mcd(int a, int b) {
        // Normalizamos a valores no negativos
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 && b == 0) return 0;
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
