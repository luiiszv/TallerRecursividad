package org.example;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    // 1. Factorial.
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("No existe factorial de números negativos");
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    // 2. Invertir un  número
    public static int invertirNumero(int n, int invertido) {
        return n == 0 ? invertido : invertirNumero(n / 10, invertido * 10 + n % 10);
    }

    // 3. Sumatoria 1/n
    public static double sumatoriaFracc(int n) {
        if (n <= 0) throw new IllegalArgumentException("n debe ser positivo");
        return n == 1 ? 1.0 : 1.0 / n + sumatoriaFracc(n - 1);
    }

    // 4. Suma de dígitos
    public static int sumaDigitos(int n) {
        n = Math.abs(n);
        return n == 0 ? 0 : n % 10 + sumaDigitos(n / 10);
    }

    // 5. Sumatoria hasta n
    public static int sumatoriaHastaN(int n) {
        return n <= 0 ? 0 : n + sumatoriaHastaN(n - 1);
    }

    // 6. Potencia
    public static int potencia(int base, int exponente) {
        if (exponente < 0) throw new IllegalArgumentException("Exponente no puede ser negativo");
        return exponente == 0 ? 1 : base * potencia(base, exponente - 1);
    }

    // 7. Maximo comun divisiors (Algoritmo de Euclides)
    public static int mcd(int m, int n) {
        if (n < 0 || m < 0) throw new IllegalArgumentException("Los números deben ser positivos");
        return n == 0 ? m : mcd(n, m % n);
    }

    // 8. Copiar cadena
    public static String copiarCadena(String original, int index) {
        return index == original.length() ? "" : original.charAt(index) + copiarCadena(original, index + 1);
    }

    // 9. Cociente por restas sucesivas
    public static int cociente(int dividendo, int divisor) {
        if (divisor == 0) throw new ArithmeticException("No se pude realizar una división por cero");
        return dividendo < divisor ? 0 : 1 + cociente(dividendo - divisor, divisor);
    }

    // 10. Multiplicación por sumas sucesivas
    public static int multiplicacion(int a, int b) {
        if (b < 0) return -multiplicacion(a, -b);
        return b == 0 ? 0 : a + multiplicacion(a, b - 1);
    }

    // 11. Suma de elementos de un vector
    public static int sumaVector(int[] vector, int index) {
        return index == vector.length ? 0 : vector[index] + sumaVector(vector, index + 1);
    }

    // 12. Suma de elementos de matriz
    public static int sumaMatriz(int[][] matriz, int fila, int col) {
        if (fila == matriz.length) return 0;
        if (col == matriz[fila].length) return sumaMatriz(matriz, fila + 1, 0);
        return matriz[fila][col] + sumaMatriz(matriz, fila, col + 1);
    }

    // 13. Fibonacci hasta límite
    public static void fibonacciHastaLimite(int a, int b, int limite) {
        if (a > limite) return;
        System.out.print(a + " ");
        fibonacciHastaLimite(b, a + b, limite);
    }

    // 14. Fun de Ackerman
    public static int ackerman(int m, int n) {
        if (m < 0 || n < 0) throw new IllegalArgumentException("Los parámetros no pueden ser negativos");
        if (m == 0) return n + 1;
        if (n == 0) return ackerman(m - 1, 1);
        return ackerman(m - 1, ackerman(m, n - 1));
    }

    // Metodos auxiliares para entrada de datos
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        sc.nextLine(); // Limpiar buffer
        return sc.nextLine();
    }


    //fun vector
    private static int[] leerVector() {
        int n = leerEntero("Ingrese tamaño del vector: ");
        int[] vector = new int[n];
        for (int i = 0; i < n; i++) {
            vector[i] = leerEntero("Ingrese elemento " + (i + 1) + ": ");
        }
        return vector;
    }

    //fun matriz
    private static int[][] leerMatriz() {
        int filas = leerEntero("Ingrese número de filas: ");
        int cols = leerEntero("Ingrese número de columnas: ");
        int[][] matriz = new int[filas][cols];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                matriz[i][j] = leerEntero("Ingrese elemento [" + i + "][" + j + "]: ");
            }
        }
        return matriz;
    }

    public static void main(String[] args) {

        System.out.println("\n=== TALLER DE RECURSIVIDAD === :/");
        System.out.println("1. Factorial de un numero");
        System.out.println("2. Invertir numero");
        System.out.println("3. Sumatoria 1 + 1/2 + ... + 1/n");
        System.out.println("4. Suma de digitos");
        System.out.println("5. Sumatoria hasta n");
        System.out.println("6. Potencia");
        System.out.println("7. Maximo Común Divisor");
        System.out.println("8. Copiar cadena");
        System.out.println("9. Cociente por restas");
        System.out.println("10. Multiplicacion por sumas");
        System.out.println("11. Suma de elementos de vector");
        System.out.println("12. Suma de elementos de matriz");
        System.out.println("13. Serie Fibonacci hasta limite");
        System.out.println("14. Funcion de Ackerman");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");

        int opcion = sc.nextInt();

        try {
            switch (opcion) {
                case 1:
                    int num = leerEntero("Ingrese un numero: ");
                    System.out.println("Factorial: " + factorial(num));
                    break;
                case 2:
                    num = leerEntero("Ingrese un numero: ");
                    System.out.println("Número invertido: " + invertirNumero(num, 0));
                    break;
                case 3:
                    num = leerEntero("Ingrese n: ");
                    System.out.printf("Sumatoria: %.4f%n", sumatoriaFracc(num));
                    break;
                case 4:
                    num = leerEntero("Ingrese un numero: ");
                    System.out.println("Suma de dígitos: " + sumaDigitos(num));
                    break;
                case 5:
                    num = leerEntero("Ingrese n: ");
                    System.out.println("Sumatoria: " + sumatoriaHastaN(num));
                    break;
                case 6:
                    int base = leerEntero("Ingrese base: ");
                    int exp = leerEntero("Ingrese exponente: ");
                    System.out.println("Potencia: " + potencia(base, exp));
                    break;
                case 7:
                    int m = leerEntero("Ingrese M: ");
                    int n = leerEntero("Ingrese N: ");
                    System.out.println("MCD: " + mcd(m, n));
                    break;
                case 8:
                    String cadena = leerCadena("Ingrese cadena: ");
                    System.out.println("Copia: " + copiarCadena(cadena, 0));
                    break;
                case 9:
                    int dividendo = leerEntero("Ingrese dividendo: ");
                    int divisor = leerEntero("Ingrese divisor: ");
                    System.out.println("Cociente: " + cociente(dividendo, divisor));
                    break;
                case 10:
                    int a = leerEntero("Ingrese primer número: ");
                    int b = leerEntero("Ingrese segundo número: ");
                    System.out.println("Multiplicación: " + multiplicacion(a, b));
                    break;
                case 11:
                    int[] vector = leerVector();
                    System.out.println("Suma del vector: " + sumaVector(vector, 0));
                    break;
                case 12:
                    int[][] matriz = leerMatriz();
                    System.out.println("Suma de la matriz: " + sumaMatriz(matriz, 0, 0));
                    break;
                case 13:
                    int limite = leerEntero("Ingrese limite para Fibonacci: ");
                    System.out.print("Serie Fibonacci: ");
                    fibonacciHastaLimite(0, 1, limite);
                    System.out.println();
                    break;
                case 14:
                    m = leerEntero("Ingrese m: ");
                    n = leerEntero("Ingrese n: ");
                    System.out.println("Ackerman(" + m + "," + n + "): " + ackerman(m, n));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opcion no valida");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}