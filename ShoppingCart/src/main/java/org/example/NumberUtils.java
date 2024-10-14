package org.example;

public class NumberUtils {

    /*
     * Verificar se um número é primo
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * Verificar se um número é par
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /*
     * Verificar se um número é múltiplo de outro
     */
    public static boolean isMultiple(int number, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Can't be divided by zero!");
        }
        return number % divisor == 0;
    }
}